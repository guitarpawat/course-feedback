package coursefeedback.data;

/**
 *
 * @author Pawat Nakpiphatkul
 */
public class FeedbackModel {
    
    public FeedbackModel() {}
    
    public int[] getScores() {
        //TODO
        return new int[Integer.parseInt(FeedbackInfo.QUESTIONS.toString())];
    }
    
    public String getComment() {
        //TODO
        return "";
    }
}
