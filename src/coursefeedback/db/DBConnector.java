package coursefeedback.db;

import java.sql.*;

/**
 *
 * @author Pawat Nakpiphatkul
 */
public class DBConnector {
    
    private Connection connect;
    private PreparedStatement statement;
    
    public DBConnector() throws SQLException,ClassNotFoundException {
        Class.forName(DBInfo.JDBC_DRIVER.getInfo());
        connect = DriverManager.getConnection(DBInfo.DB_URL.getInfo(),DBInfo.USERNAME.getInfo(),DBInfo.PASSWORD.getInfo());
    }
    
    public int excuteUpdate(DBQuery control) throws SQLException {
        statement = connect.prepareStatement(control.getPreparedCommand());
        String[] values = control.getBindValues();
        for(int i=0 ; i<values.length ; i++) {
            statement.setString(i+1,values[i]);
        }
        return statement.executeUpdate();
    }
    
    public ResultSet excuteQuery(DBQuery control) throws SQLException {
        statement = connect.prepareStatement(control.getPreparedCommand());
        String[] values = control.getBindValues();
        for(int i=0 ; i<values.length ; i++) {
            statement.setString(i+1,values[i]);
        }
        return statement.executeQuery();
    }
    
    public boolean excute(DBQuery control) throws SQLException {
        statement = connect.prepareStatement(control.getPreparedCommand());
        String[] values = control.getBindValues();
        for(int i=0 ; i<values.length ; i++) {
            statement.setString(i+1,values[i]);
        }
        return statement.execute();
    }
    
    public void close() {
        try {
            statement.close();
        }
        catch(SQLException e) {}
        try {
            connect.close();
        }
        catch(SQLException e) {};
        
    }
}
