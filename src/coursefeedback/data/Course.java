package coursefeedback.data;

import coursefeedback.db.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class for course object.
 * @author Pawat Nakpiphatkul
 */
public class Course extends DBQuery {

    private String courseID;
    private String courseName;
    private int section;
    private int teacherID;
    private Integer[] studentsID;
    private Integer[] sentFeedback;

    /**
     * Constructor for initialize Course.
     * @param id is a course id.
     * @param sec is a course section.
     * @throws SQLException if there is a SQL connection problem.
     * @throws ClassNotFoundException if SQL driver is not found.
     */
    public Course(String id, int sec) throws SQLException, ClassNotFoundException {
        super.setPreparedCommand("SELECT name,teacher,students,sentfeedback FROM courseinfo WHERE courseid=? AND section=?");
        super.addBindValue(id);
        super.addBindValue(sec);
        ResultSet info = new DBConnector().excuteQuery(this);
        super.clearQuery();
        if (info.wasNull()) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; info.next(); i++) {
            if (i > 0) {
                throw new IllegalArgumentException();
            }
        }
        if (info.first()) {
            courseID = id;
            courseName = info.getString("name");
            section = sec;
            teacherID = info.getInt("teacher");
            String[] students = info.getString("students").split(",");
            studentsID = new Integer[students.length];
            try {
                for (int i = 0; i < students.length; i++) {
                    studentsID[i] = Integer.parseInt(students[i]);
                }
            } catch (NumberFormatException e) {
                studentsID = new Integer[0];
            }
            String[] sent = info.getString("sentfeedback").split(",");
            sentFeedback = new Integer[sent.length];
            try {
                for (int i = 0; i < sent.length; i++) {
                    sentFeedback[i] = Integer.parseInt(sent[i]);
                }
            } catch (NumberFormatException e) {
                sentFeedback = new Integer[0];
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Get the course id.
     * @return the courseID.
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * Get the course name.
     * @return the courseName.
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * get the teacher id.
     * @return the teacherID.
     */
    public int getTeacherID() {
        return teacherID;
    }

    /**
     * Get the array of all student id.
     * @return the studentsID.
     */
    public Integer[] getStudentsID() {
        return studentsID;
    }

    /**
     * Get the array of student who sent feedback.
     * @return the sentFeedback.
     */
    public Integer[] getSentFeedback() {
        return sentFeedback;
    }

    /**
     * Add a student who sent feedback.
     * @param id is an id of student.
     * @throws SQLException if there is a SQL connection problem.
     * @throws ClassNotFoundException if SQL driver is not found.
     */
    public void addSentFeedback(Integer id) throws SQLException, ClassNotFoundException {
        List<Integer> temp = new ArrayList(Arrays.asList(sentFeedback));
        temp.add(id);
        sentFeedback = temp.toArray(new Integer[0]);
        String sentString = "";
        for (int i = 0; i < sentFeedback.length; i++) {
            if (i != 0) {
                sentString += ",";
            }
            sentString += sentFeedback[i] + "";
        }
        super.setPreparedCommand("UPDATE courseinfo SET sentfeedback=? WHERE courseid=? AND section=?");
        super.addBindValue(sentString);
        super.addBindValue(courseID);
        super.addBindValue(section);
        new DBConnector().excuteUpdate(this);
        super.clearQuery();
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object) 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Course other = (Course) obj;
        return other.getCourseID().equals(this.getCourseID()) && other.getSentFeedback().equals(this.sentFeedback) && other.getSection() == this.section;
    }

    /**
     * Get the course section.
     * @return the section.
     */
    public int getSection() {
        return section;
    }

    /**
     * Get an object of teacher in this course.
     * @return object of teacher.
     * @throws SQLException if there is a SQL connection problem.
     * @throws ClassNotFoundException if SQL driver is not found.
     */
    public User getTeacherObject() throws SQLException, ClassNotFoundException {
        return new User(teacherID);
    }

    /**
     * Get an array of object of students in this course.
     * @return array of student object.
     * @throws SQLException if there is a SQL connection problem.
     * @throws ClassNotFoundException if SQL driver is not found.
     */
    public User[] getStudentsObject() throws SQLException, ClassNotFoundException {
        User[] studentArr = new User[studentsID.length];
        for (int i = 0; i < studentsID.length; i++) {
            studentArr[i] = new User(studentsID[i]);
        }
        return studentArr;
    }
    
    /**
     * @see java.lang.Object#toString() 
     */
    @Override
    public String toString() {
        return "Course " + getCourseID() + " : " + getCourseName();
    }
}
