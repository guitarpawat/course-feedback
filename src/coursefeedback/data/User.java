package coursefeedback.data;

import coursefeedback.db.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pawat Nakpiphatkul
 */
public class User extends DBQuery {

    private int userID;
    private String firstName;
    private String lastName;
    private String username;
    private int userStatus;
    private String[] coursesID;
    private int[] sections;

    public User(int id) throws SQLException, ClassNotFoundException {
        super.setPreparedCommand("SELECT username,firstname,lastname,status,courses,sections FROM userinfo WHERE id=?");
        super.addBindValue(id);
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
            userID = id;
            firstName = info.getString("firstname");
            lastName = info.getString("lastname");
            username = info.getString("username");
            userStatus = info.getInt("status");
            coursesID = info.getString("courses").split(",");
            String[] sec = info.getString("sections").split(",");
            sections = new int[sec.length];
            try {
                for (int i = 0; i < sec.length; i++) {
                    sections[i] = Integer.parseInt(sec[i]);
                }
            } catch (NumberFormatException e) {
                sections = new int[0];
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public User(String user) throws SQLException, ClassNotFoundException {
        super.setPreparedCommand("SELECT id,firstname,lastname,status,courses,sections FROM userinfo WHERE username=?");
        super.addBindValue(user);
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
            userID = info.getInt("id");
            firstName = info.getString("firstname");
            lastName = info.getString("lastname");
            username = user;
            userStatus = info.getInt("status");
            coursesID = info.getString("courses").split(",");
            String[] sec = info.getString("sections").split(",");
            sections = new int[sec.length];
            try {
                for (int i = 0; i < sec.length; i++) {
                    sections[i] = Integer.parseInt(sec[i]);
                }
            } catch (NumberFormatException e) {
                sections = new int[0];
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public User(int id, String first, String last, String user, int status, String courseString, String sectionString) {
        userID = id;
        firstName = first;
        lastName = last;
        username = user;
        userStatus = status;
        coursesID = courseString.split(",");
        String[] sec = sectionString.split(",");
        sections = new int[sec.length];
        try {
            for (int i = 0; i < sec.length; i++) {
                sections[i] = Integer.parseInt(sec[i]);
            }
        } catch (NumberFormatException e) {
            sections = new int[0];
        }
    }

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the userStatus
     */
    public int getUserStatus() {
        return userStatus;
    }

    public String[] getCoursesID() {
        return coursesID;
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
        User other = (User) obj;
        return other.getUserID() == this.userID;
    }

    public Course[] getCoursesObject() throws SQLException, ClassNotFoundException {
        Course[] courseArr = new Course[coursesID.length];
        for (int i = 0; i < coursesID.length; i++) {
            courseArr[i] = new Course(coursesID[i], sections[i]);
        }
        super.clearQuery();
        return courseArr;
    }

    /**
     * @return the sections
     */
    public int[] getSections() {
        return sections;
    }
}
