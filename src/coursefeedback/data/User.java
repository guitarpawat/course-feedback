package coursefeedback.data;

import coursefeedback.db.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class for User object.
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

    /**
     * Constructor for initialize User.
     * @param id is a user id.
     * @throws SQLException if there is a SQL connection problem.
     * @throws ClassNotFoundException if SQL driver is not found.
     */
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

    /**
     * Constructor for initialize User.
     * @param user is a username.
     * @throws SQLException if there is a SQL connection problem.
     * @throws ClassNotFoundException if SQL driver is not found.
     */
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

    /**
     * Get the user id.
     * @return the userID.
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Get the firstname of user.
     * @return the firstName.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the lastname of user.
     * @return the lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get the username of user.
     * @return the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get the user status code of user.
     * @return the userStatus.
     */
    public int getUserStatus() {
        return userStatus;
    }

    /**
     * Get courses id of the user.
     * @return an array of Course.
     */
    public String[] getCoursesID() {
        return coursesID;
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
        User other = (User) obj;
        return other.getUserID() == this.userID;
    }

    /**
     * Get the course from the database.
     * @return an array of course.
     * @throws SQLException if there is a SQL connection problem.
     * @throws ClassNotFoundException if SQL driver is not found.
     */
    public Course[] getCoursesObject() throws SQLException, ClassNotFoundException {
        Course[] courseArr = new Course[coursesID.length];
        for (int i = 0; i < coursesID.length; i++) {
            courseArr[i] = new Course(coursesID[i], sections[i]);
        }
        super.clearQuery();
        return courseArr;
    }

    /**
     * Get all course section.
     * @return the sections.
     */
    public int[] getSections() {
        return sections;
    }
    
    /**
     * @see java.lang.Object#toString() 
     */
    @Override
    public String toString() {
        return firstName+" "+lastName;
    }
}
