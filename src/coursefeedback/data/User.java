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
    private String[] courses;
    
    public User(int id) throws SQLException, ClassNotFoundException {
        super.setPreparedCommand("SELECT username,firstname,lastname,status,courses FROM userinfo WHERE id=?");
        super.addBindValue(id);
        ResultSet info = new DBConnector().excuteQuery(this);
        if(info.wasNull()) throw new IllegalArgumentException();
        for(int i=0 ; info.next() ; i++) {
            if(i > 0) throw new IllegalArgumentException();
        }
        if(info.first()) {
            userID = id;
            firstName = info.getString("firstname");
            lastName = info.getString("lastname");
            username = info.getString("username");
            userStatus = info.getInt("status");
            courses = info.getString("courses").split(",");
        }
        else throw new IllegalArgumentException();
    }
    
    public User(String user) throws SQLException, ClassNotFoundException {
        super.setPreparedCommand("SELECT id,firstname,lastname,status,courses FROM userinfo WHERE username=?");
        super.addBindValue(user);
        ResultSet info = new DBConnector().excuteQuery(this);
        if(info.wasNull()) throw new IllegalArgumentException();
        for(int i=0 ; info.next() ; i++) {
            if(i > 0) throw new IllegalArgumentException();
        }
        if(info.first()) {
            userID = info.getInt("id");
            firstName = info.getString("firstname");
            lastName = info.getString("lastname");
            username = user;
            userStatus = info.getInt("status");
            courses = info.getString("courses").split(",");
        }
        else throw new IllegalArgumentException();
    }
    
    public User(int id,String first,String last,String user,int status,String courseString) {
        userID = id;
        firstName = first;
        lastName = last;
        username = user;
        userStatus = status;
        courses = courseString.split(",");
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
    
    public String[] getCourses() {
        return courses;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != this.getClass()) return false;
        User other = (User) obj;
        return other.getUserID() == this.userID;
    }
}
