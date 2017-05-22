//package coursefeedback.data;
//
//import coursefeedback.db.DBConnector;
//import coursefeedback.db.DBQuery;
//import java.sql.SQLException;
//
///**
// *
// * @author Pawat Nakpiphatkul
// */
//public class FeedbackControl extends DBQuery{
//    
//    private Feedback view;
//    private FeedbackModel model;
//    private final int QUESTIONS;
//    
//    public FeedbackControl(Feedback view,FeedbackModel model) {
//        this.model = model;
//        this.view = view;
//        QUESTIONS = Integer.parseInt(FeedbackInfo.QUESTIONS.toString());
//    }
//    
//    public void summit() throws SQLException, ClassNotFoundException {
//        String command = "INSERT INTO feedback (";
//        for(int i=1 ; i<=QUESTIONS ;i++) command = command+"q"+i+",";
//        command = command+"comment) VALUES (";
//        for(int i=0 ; i<QUESTIONS ; i++) {
//            if(i != 0) command = command + ",";
//            command = command + "?";
//        }
//        super.setPreparedCommand(command+")");
//        for(int score : model.getScores()) super.addBindValue(score);
//        super.addBindValue(model.getComment());
//        DBConnector conn = new DBConnector();
//        conn.excute(this);
//        clearQuery();
//    }
//}
