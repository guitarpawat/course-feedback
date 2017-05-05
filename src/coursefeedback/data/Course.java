package coursefeedback.data;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Pawat Nakpiphatkul
 */
public class Course {
    
    private String courseID;
    private String courseName;
    private User teacher;
    private User[] students;
    private User[] sentFeedback;
    
    public Course(String id,String name,User cteacher,User[] cstudents,User[] feedback) {
        courseID = id;
        courseName = name;
        teacher = cteacher;
        students = cstudents;
        sentFeedback = feedback;
    }

    /**
     * @return the courseID
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @return the teacher
     */
    public User getTeacher() {
        return teacher;
    }

    /**
     * @return the students
     */
    public User[] getStudents() {
        return students;
    }

    /**
     * @return the sentFeedback
     */
    public User[] getSentFeedback() {
        return sentFeedback;
    }
    
    public void addSentFeedback() {
        List<User> temp = Arrays.asList(sentFeedback);
        sentFeedback = temp.toArray(new User[0]);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != this.getClass()) return false;
        Course other = (Course) obj;
        return other.getCourseID().equals(this.getCourseID());
    }
}
