package coursefeedback.data;

import coursefeedback.db.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Pawat Nakpiphatkul
 */
public class Course extends DBQuery{
    
    private String courseID;
    private String courseName;
    private int section;
    private String teacher;
    private String[] students;
    private String[] sentFeedback;
    
    public Course(String id,int sec) throws SQLException, ClassNotFoundException {
        super.setPreparedCommand("SELECT name,teacher,students,sentfeedback FROM courseinfo WHERE courseid=? AND section=?");
        super.addBindValue(id);
        super.addBindValue(sec);
        ResultSet info = new DBConnector().excuteQuery(this);
        if(info.wasNull()) throw new IllegalArgumentException();
        for(int i=0 ; info.next() ; i++) {
            if(i > 0) throw new IllegalArgumentException();
        }
        if(info.first()) {
            courseID = id;
            courseName = info.getString("name");
            section = sec;
            teacher = info.getString("teacher");
            students = info.getString("students").split(",");
            sentFeedback = info.getString("sentfeedback").split(",");
        }
        else throw new IllegalArgumentException();
    }
    
    public Course(String id,String name,int sec,String cteacher,String studentString,String feedbackString) {
        courseID = id;
        courseName = name;
        teacher = cteacher;
        students = studentString.split(",");
        sentFeedback = feedbackString.split(",");
        section = sec;
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
    public String getTeacher() {
        return teacher;
    }

    /**
     * @return the students
     */
    public String[] getStudents() {
        return students;
    }

    /**
     * @return the sentFeedback
     */
    public String[] getSentFeedback() {
        return sentFeedback;
    }
    
    public void addSentFeedback() {
        List<String> temp = Arrays.asList(sentFeedback);
        sentFeedback = temp.toArray(new String[0]);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != this.getClass()) return false;
        Course other = (Course) obj;
        return other.getCourseID().equals(this.getCourseID()) && other.getSentFeedback().equals(this.sentFeedback) && other.getSection()==this.section;
    }

    /**
     * @return the section
     */
    public int getSection() {
        return section;
    }
}
