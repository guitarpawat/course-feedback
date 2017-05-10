package coursefeedback.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Pawat Nakpiphatkul
 */
public class StudentModel {
    
    private User student;
    private Course[] courses;
    
    public StudentModel(int id) throws SQLException, ClassNotFoundException {
        student = new User(id);
        courses = student.getCoursesObject();
    }
    
    public StudentModel(User student) throws SQLException, ClassNotFoundException {
        this.student = student;
        courses = student.getCoursesObject();
    }
    
    public Course[] getSentFeesbackCourses() {
        List<Course> temp = new ArrayList<>();
        for(Course c : courses) {
            Integer[] sent = c.getSentFeedback();
            if(Arrays.asList(sent).contains(student.getUserID())) temp.add(c);
        }
        return temp.toArray(new Course[0]);
    }
    
    public Course[] getNotSentFeedbackCourse() {
        List<Course> temp = new ArrayList<>(Arrays.asList(courses));
        temp.removeAll(Arrays.asList(getSentFeesbackCourses()));
        return temp.toArray(new Course[0]);
    }
    
    public User getStudent() {
        return student;
    }
    
    public Course[] getCourses() {
        return courses;
    }
    
    public void updateAllCourses() throws SQLException, ClassNotFoundException {
        courses = student.getCoursesObject();
    }
}
