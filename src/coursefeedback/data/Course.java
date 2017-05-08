package coursefeedback.data;

import coursefeedback.db.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Pawat Nakpiphatkul
 */
public class Course extends DBQuery {

    private String courseID;
    private String courseName;
    private int section;
    private int teacherID;
    private Integer[] studentsID;
    private Integer[] sentFeedback;

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

    public Course(String id, String name, int sec, int cteacher, String studentString, String feedbackString) {
        courseID = id;
        courseName = name;
        teacherID = cteacher;
        String[] students = studentString.split(",");
        studentsID = new Integer[students.length];
        try {
            for (int i = 0; i < students.length; i++) {
                studentsID[i] = Integer.parseInt(students[i]);
            }
        } catch (NumberFormatException e) {
            studentsID = new Integer[0];
        }
        String[] sent = feedbackString.split(",");
        sentFeedback = new Integer[sent.length];
        try {
            for (int i = 0; i < sent.length; i++) {
                sentFeedback[i] = Integer.parseInt(sent[i]);
            }
        } catch (NumberFormatException e) {
            sentFeedback = new Integer[0];
        }
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
     * @return the teacherID
     */
    public int getTeacherID() {
        return teacherID;
    }

    /**
     * @return the studentsID
     */
    public Integer[] getStudentsID() {
        return studentsID;
    }

    /**
     * @return the sentFeedback
     */
    public Integer[] getSentFeedback() {
        return sentFeedback;
    }

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
     * @return the section
     */
    public int getSection() {
        return section;
    }

    public User getTeacherObject() throws SQLException, ClassNotFoundException {
        return new User(teacherID);
    }

    public User[] getStudentsObject() throws SQLException, ClassNotFoundException {
        User[] studentArr = new User[studentsID.length];
        for (int i = 0; i < studentsID.length; i++) {
            studentArr[i] = new User(studentsID[i]);
        }
        return studentArr;
    }
}
