package coursefeedback.data;

/**
 * Model for Feedback GUI.
 * @author Pawat Nakpiphatkul
 */
public class FeedbackModel {

    private User student;
    private Course course;

    /**
     * Constructor for initialize FeedbackModel.
     * @param s is a user of student.
     * @param c is a course to send feedback.
     */
    public FeedbackModel(User s, Course c) {
        student = s;
        course = c;
    }

    /**
     * Get the user object of student.
     * @return the student.
     */
    public User getStudent() {
        return student;
    }

    /**
     * Get the course object.
     * @return the course.
     */
    public Course getCourse() {
        return course;
    }
}
