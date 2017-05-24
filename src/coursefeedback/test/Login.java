package coursefeedback.test;

import coursefeedback.data.LoginModel;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Class for checking that login is working properly.
 * @author Pawat Nakpiphatkul
 * @version 1.0
 * @since May 5, 2017
 */
public class Login {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.print("Username : ");
        String user = in.nextLine();
        System.out.print("Password : ");
        String pass = in.nextLine();
        LoginModel model = new LoginModel(user, pass);
        System.out.println(model.verifyUser());
    }

}
