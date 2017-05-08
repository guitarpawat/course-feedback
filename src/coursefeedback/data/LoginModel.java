package coursefeedback.data;

import coursefeedback.db.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Pawat Nakpiphatkul
 */
public class LoginModel extends DBQuery{
    private final String username;
    private final String password;
    
    public LoginModel(String user,String pass) {
        username = user;
        password = pass;
    }
    
    public String getUsername() {
        return username;
    }
    
    public boolean verifyUser() throws SQLException,ClassNotFoundException {
        super.setPreparedCommand("SELECT hash FROM userinfo WHERE username=? ");
        super.addBindValue(username);
        ResultSet info = new DBConnector().excuteQuery(this);
        if(info.wasNull()) return false;
        for(int i=0 ; info.next() ; i++) {
            if(i > 0) return false;
        }
        if(info.first()) {
            String hash = info.getString("hash");
            return BCrypt.checkpw(password, hash);
        }
        return false;
    }
}
