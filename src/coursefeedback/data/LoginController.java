package coursefeedback.data;

import coursefeedback.gui.Login;
import coursefeedback.gui.Student;
import coursefeedback.gui.Teacher;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

/**
 *
 * @author Pawat Nakpiphatkul
 */
public class LoginController {
    
    Login view;
    LoginModel model;
    
    public LoginController(Login view,LoginModel model) {
        this.view = view;
        this.model = model;
    }
    
    public void loginControl() throws SQLException, ClassNotFoundException {
        if(model.verifyUser()) {
            User user = new User(model.getUsername());
            if(user.getUserStatus() == 1) {
                new Student(user);
                view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
            }
            else if(user.getUserStatus() == 3) {
                new Teacher(user);
                view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
            }
            else {
                //TODO
            }
        }
        else {
            // TODO
        }
    }
    
}
