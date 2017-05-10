package coursefeedback.data;

import coursefeedback.db.DBConnector;
import coursefeedback.db.DBQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pawat Nakpiphatkul
 */
public class ResultList extends DBQuery {
    
    private ResultSet result;
    private Course course;
    
    private final int QUESTIONS;
    
    public ResultList(Course course) throws SQLException, ClassNotFoundException {
        this.course = course;
        QUESTIONS = Integer.parseInt(FeedbackInfo.QUESTIONS.toString());
        execute();
    }
    
    private void execute() throws SQLException, ClassNotFoundException {
        String command = "SELECT ";
        for(int i=1 ; i<=QUESTIONS ;i++) command = command+"q"+i+",";
        super.setPreparedCommand(command+"comment FROM feedback WHERE courseid=? AND section=?");
        super.addBindValue(course.getCourseID());
        super.addBindValue(course.getSection());
        DBConnector connect = new DBConnector();
        connect.excuteQuery(this);
    }
    
    public int[][] getRawScore() throws SQLException {
        int[][] scores = new int[QUESTIONS][11];
        while(result.next()) {
            for(int i=0 ; i<QUESTIONS ; i++) {
                scores[i][result.getInt("q"+(i+1))]++;
            }
        }
        return scores;
    }
    
    public double[] getAvgScore() throws SQLException {
        int[][] scores = getRawScore();
        double[] avg = new double[QUESTIONS];
        for(int i=0 ; i< QUESTIONS ; i++) {
            for(int j=0 ; j<scores[i].length ; j++) {
                avg[i] += scores[i][j];
            }
            avg[i] = avg[i]/scores[i].length;
        }
        return avg;
    }
    
    public List<String> getComments() throws SQLException {
        List<String> comments = new ArrayList<>();
        while(result.next()) {
            comments.add(result.getString("comment"));
        }
        return comments;
    }
}
