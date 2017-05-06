package coursefeedback.test;

import coursefeedback.data.Course;
import coursefeedback.data.User;

/**
 *
 * @author Pawat Nakpiphatkul
 * @version 1.0
 * @since May 5, 2017
 */
public class Test{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, Exception {
//        DBQuery dbc = new DBQuery();
//        dbc.setPreparedCommand("INSERT INTO test (name) VALUES (?)");
//        dbc.addBindValue("punpun");
//        DBConnector conn = new DBConnector();
//        conn.excuteUpdate(dbc);
//        conn.close();

        Course c = new Course("ENG101",1);
        for(int i : c.getStudentsID()) System.out.println(i);
    }

}
