package coursefeedback;

import coursefeedback.db.*;

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

        int i = 3;
        Object c = (Integer)i;
        System.out.println(c instanceof Integer);
        System.out.println(c instanceof Boolean);
    }

}
