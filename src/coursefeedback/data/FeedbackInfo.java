package coursefeedback.data;

/**
 *
 * @author Pawat Nakpiphatkul
 */
public enum FeedbackInfo {

    QUESTIONS(5);
    
    Object info;
    
    private FeedbackInfo(Object data) {
        info = data;
    }
    
    public Object getInfo() {
        return info;
    }
    
    public String toString() {
        return getInfo().toString();
    }
}
