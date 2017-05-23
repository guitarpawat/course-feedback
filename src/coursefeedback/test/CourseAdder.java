package coursefeedback.test;

import coursefeedback.db.DBConnector;
import coursefeedback.db.DBQuery;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Pawat Nakpiphatkul
 * @version 1.0
 * @since May 23, 2017
 */
public class CourseAdder {

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
                System.out.print("Course ID : ");
                String id = in.nextLine();
                System.out.print("Course Name : ");
                String name = in.nextLine();
                System.out.print("Section : ");
                int sec = Integer.parseInt(in.nextLine());
                System.out.print("Teacher ID : ");
                String teacher = in.nextLine();
                System.out.print("Students ID (comma separated) : ");
                String students = in.nextLine();
                AddCourse bridge = new AddCourse(id,name,sec,teacher,students);
                bridge.execute();
                bridge.close();
            }
        }
    }

}

class AddCourse extends DBQuery {
    
    private DBConnector conn;
    
    public AddCourse(Object... args) {
        super.setPreparedCommand("INSERT INTO courseinfo (courseid,name,section,teacher,students,sentfeedback) VALUES (?,?,?,?,?,"+"''"+")");
        super.setBindValues(Arrays.asList(args));
        conn = new DBConnector();
    }
    
    public boolean execute() throws SQLException {
        return conn.excute(this);
    }
    
    public void close() {
        conn.close();
    }
    
}
