package coursefeedback.data;

import coursefeedback.db.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Model for login GUI.
 * @author Pawat Nakpiphatkul
 */
public class LoginModel extends DBQuery {

    private final String username;
    private final String password;

    /**
     * Constructor for initialize LoginModel.
     * @param user is a username.
     * @param pass is a password.
     */
    public LoginModel(String user, String pass) {
        username = user;
        password = pass;
    }

    /**
     * Get the username.
     * @return username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Verify the username and password.
     * @return true if it is a valid username and password, otherwise return false.
     * @throws SQLException if there is a SQL connection problem.
     * @throws ClassNotFoundException if SQL driver is not found.
     */
    public boolean verifyUser() throws SQLException, ClassNotFoundException {
        super.setPreparedCommand("SELECT hash FROM userinfo WHERE username=? ");
        super.addBindValue(username);
        ResultSet info = new DBConnector().excuteQuery(this);
        if (info.wasNull()) {
            return false;
        }
        for (int i = 0; info.next(); i++) {
            if (i > 0) {
                return false;
            }
        }
        super.clearQuery();
        if (info.first()) {
            String hash = info.getString("hash");
            return BCrypt.checkpw(password, hash);
        }
        return false;
    }
}
