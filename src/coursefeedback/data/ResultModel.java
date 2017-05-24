package coursefeedback.data;

import coursefeedback.db.DBConnector;
import coursefeedback.db.DBQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Model for result GUI.
 * @author Pawat Nakpiphatkul
 */
public class ResultModel extends DBQuery {

    private ResultSet result;
    private Course course;
    private int rows;

    private final int QUESTIONS = 5;

    /**
     * Constructor for initialize ResultModel.
     * @param course is a course to see result.
     * @throws SQLException if there is a SQL connection problem.
     * @throws ClassNotFoundException if SQL driver is not found.
     */
    public ResultModel(Course course) throws SQLException, ClassNotFoundException {
        this.course = course;
        execute();
    }

    private void execute() throws SQLException, ClassNotFoundException {
        super.setPreparedCommand("SELECT q1,q2,q3,q4,q5,comment FROM feedback WHERE courseid=? AND section=?");
        super.addBindValue(course.getCourseID());
        super.addBindValue(course.getSection());
        DBConnector connect = new DBConnector();
        result = connect.excuteQuery(this);
        super.clearQuery();
    }

    /**
     * Get raw score count from each questions and choices.
     * @return array of question and score count.
     * @throws SQLException if there is a SQL connection problem.
     */
    public int[][] getRawScore() throws SQLException {
        int[][] scores = new int[QUESTIONS][6];
        result.beforeFirst();
        rows = 0;
        while (result.next()) {
            rows++;
            for (int i = 0; i < QUESTIONS; i++) {
                scores[i][result.getInt("q" + (i + 1))]++;
            }
        }
        return scores;
    }

    /**
     * Calculate the average score for each question.
     * @return an array of average score in each question.
     * @throws SQLException if there is a SQL connection problem.
     */
    public double[] getAvgScore() throws SQLException {
        int[][] scores = getRawScore();
        double[] avg = new double[QUESTIONS];
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                avg[i] = avg[i] + scores[i][j] * (double) j;
            }
            if (rows == 0) {
                avg[i] = 0;
            } else {
                avg[i] = avg[i] / rows;
            }
        }
        return avg;
    }

    /**
     * Get all comments in this course.
     * @return list of string of comment.
     * @throws SQLException if there is a SQL connection problem.
     */
    public List<String> getComments() throws SQLException {
        List<String> comments = new ArrayList<>();
        result.beforeFirst();
        rows = 0;
        while (result.next()) {
            rows++;
            if (!result.getString("comment").isEmpty()) {
                comments.add(result.getString("comment"));
            }
        }
        return comments;
    }
}
