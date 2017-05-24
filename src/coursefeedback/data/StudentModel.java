package coursefeedback.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Model for student GUI.
 * @author Pawat Nakpiphatkul
 */
public class StudentModel {

    private User student;
    private Course[] courses;

    /**
     * Constructor for initialize StudentModel.
     * @param id is an student id.
     * @throws SQLException if there is a SQL connection problem.
     * @throws ClassNotFoundException if SQL driver is not found.
     */
    public StudentModel(int id) throws SQLException, ClassNotFoundException {
        student = new User(id);
        courses = student.getCoursesObject();
    }

    /**
     * Constructor for initialize StudentModel.
     * @param student is an User object.
     * @throws SQLException if there is a SQL connection problem.
     * @throws ClassNotFoundException if SQL driver is not found.
     */
    public StudentModel(User student) throws SQLException, ClassNotFoundException {
        this.student = student;
        courses = student.getCoursesObject();
    }

    /**
     * Get the course that student enrolled and had send feedback.
     * @return the array of Course.
     */
    public Course[] getSentFeesbackCourses() {
        List<Course> temp = new ArrayList<>();
        for (Course c : courses) {
            Integer[] sent = c.getSentFeedback();
            if (Arrays.asList(sent).contains(student.getUserID())) {
                temp.add(c);
            }
        }
        return temp.toArray(new Course[0]);
    }

    /**
     * Get the course that student enrolled and had not send feedback.
     * @return the array of Course.
     */
    public Course[] getNotSentFeedbackCourse() {
        List<Course> temp = new ArrayList<>(Arrays.asList(courses));
        temp.removeAll(Arrays.asList(getSentFeesbackCourses()));
        return temp.toArray(new Course[0]);
    }

    /**
     * Get the student object.
     * @return User object of student.
     */
    public User getStudent() {
        return student;
    }

    /**
     * Get the course that student enrolled.
     * @return the array of Course.
     */
    public Course[] getCourses() {
        return courses;
    }

    /**
     * Update all course info from the database.
     * @throws SQLException if there is a SQL connection problem.
     * @throws ClassNotFoundException if SQL driver is not found.
     */
    public void updateAllCourses() throws SQLException, ClassNotFoundException {
        courses = student.getCoursesObject();
    }
}
