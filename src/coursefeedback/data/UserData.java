package coursefeedback.data;

import java.sql.SQLException;

/**
 *
 * @author Pawat Nakpiphatkul
 */
public class UserData {
    
    private User user;
    private static UserData instance;
    
    private UserData() {}
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User u) {
        user = u;
    }
    
    public static UserData getInstance() {
        if(instance == null) instance = new UserData();
        return instance;
    }
    
    public StudentModel getStudentModel() throws SQLException, ClassNotFoundException {
        return new StudentModel(user);
    }
}
