package coursefeedback.db;

import java.net.URL;
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
    
    public int excuteUpdate(DBQuery query) throws SQLException {
        statement = connect.prepareStatement(query.getPreparedCommand());
        setBindValue(statement, query.getBindValues());
        return statement.executeUpdate();
    }
    
    public ResultSet excuteQuery(DBQuery control) throws SQLException {
        statement = connect.prepareStatement(control.getPreparedCommand());
        setBindValue(statement, control.getBindValues());
        return statement.executeQuery();
    }
    
    public boolean excute(DBQuery control) throws SQLException {
        statement = connect.prepareStatement(control.getPreparedCommand());
        setBindValue(statement, control.getBindValues());
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
    
    private void setBindValue(PreparedStatement statement,Object[] values) throws SQLException {
        for(int i=0 ; i<values.length ; i++) {
            if(values[i] instanceof Boolean) statement.setBoolean(i+1,(Boolean)values[i]);
            else if(values[i] instanceof Byte) statement.setByte(i+1,(Byte)values[i]);
            else if(values[i] instanceof Date) statement.setDate(i+1,(Date)values[i]);
            else if(values[i] instanceof Double) statement.setDouble(i+1,(Double)values[i]);
            else if(values[i] instanceof Float) statement.setFloat(i+1,(Float)values[i]);
            else if(values[i] instanceof Integer) statement.setInt(i+1,(Integer)values[i]);
            else if(values[i] instanceof Long) statement.setLong(i+1,(Long)values[i]);
            else if(values[i] instanceof String) statement.setString(i+1,(String)values[i]);
            else if(values[i] instanceof Time) statement.setTime(i+1,(Time)values[i]);
            else if(values[i] instanceof Timestamp) statement.setTimestamp(i+1,(Timestamp)values[i]);
            else if(values[i] instanceof URL) statement.setURL(i+1,(URL)values[i]);
            else statement.setObject(i+1,values[i]);
        }
    }
}
