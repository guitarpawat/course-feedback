package coursefeedback.data;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Pawat Nakpiphatkul
 */
public class User {
    private String userID;
    private String firstName;
    private String lastName;
    private String username;
    private int userStatus;
    private List<String> courses;
    
    public User(String id,String first,String last,String user,int status,String courseString) {
        userID = id;
        firstName = first;
        lastName = last;
        username = user;
        userStatus = status;
        String[] courseArray = courseString.split(",");
        courses = Arrays.asList(courseArray);
    }

    /**
     * @return the userID
     */
    public String getUserID() {
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
    
    public List<String> getCourses() {
        return courses;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != this.getClass()) return false;
        User other = (User) obj;
        return other.getUserID().equals(this.getUserID());
    }
}
