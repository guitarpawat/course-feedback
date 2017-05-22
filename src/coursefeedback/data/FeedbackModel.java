package coursefeedback.data;

/**
 *
 * @author Pawat Nakpiphatkul
 */
public class FeedbackModel {
    
    private User student;
    private Course course;
    
    public FeedbackModel(User s,Course c) {
        student = s;
        course = c;
    }

    /**
     * @return the student
     */
    public User getStudent() {
        return student;
    }

    /**
     * @return the course
     */
    public Course getCourse() {
        return course;
    }
}
