package coursefeedback.test;

import coursefeedback.db.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Pawat Nakpiphatkul
 * @version 1.0
 * @since May 5, 2017
 */
public class StudentAdder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        String input = "";
        while(!input.equals("quit")) {
            System.out.print("add/quit : ");
            input = in.nextLine();
            if(input.equals("add")) {
                System.out.print("Username : ");
                String user = in.nextLine();
                System.out.print("Password : ");
                String pass = in.nextLine();
                pass = BCrypt.hashpw(pass,BCrypt.gensalt());
                System.out.print("Firstname : ");
                String first = in.nextLine();
                System.out.print("Lastname : ");
                String last = in.nextLine();
                System.out.print("Status : ");
                String status = in.nextLine();
                System.out.println("Registered courses (comma separated) : ");
                String courses = in.nextLine();
                Bridge bridge = new Bridge(user,pass,first,last,status,courses);
                bridge.execute();
                bridge.close();
            }
        }
    }
}

class Bridge extends DBQuery {
    
    private DBConnector conn;
    
    Bridge(String... args) throws SQLException, ClassNotFoundException {
        super.setPreparedCommand("INSERT INTO userinfo (username,hash,firstname,lastname,status,courses) VALUES (?,?,?,?,?,?)");
        super.setBindValues(Arrays.asList(args));
        conn = new DBConnector();
    }
    
    boolean execute() throws SQLException {
        return conn.excute(this);
    }
    
    void close() {
        conn.close();
    }
}
