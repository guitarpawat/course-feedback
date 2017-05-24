package coursefeedback.db;

import java.sql.*;

/**
 * The only class for connecting to database.
 * @author Pawat Nakpiphatkul
 */
public class DBConnector {

    private Connection connect;
    private PreparedStatement statement;

    /**
     * Constructor for initialize DBConnector.
     */
    public DBConnector() {
        try {
            Class.forName(DBInfo.JDBC_DRIVER.getInfo());
            connect = DriverManager.getConnection(DBInfo.DB_URL.getInfo(), DBInfo.USERNAME.getInfo(), DBInfo.PASSWORD.getInfo());
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("WARNING : " + e.getMessage());
        }
    }

    /**
     * @see java.sql.Statement#executeUpdate(java.lang.String) 
     * @param query is a query command
     * @throws SQLException if there is a SQL connection problem.
     */
    public int excuteUpdate(DBQuery query) throws SQLException {
        statement = connect.prepareStatement(query.getPreparedCommand());
        setBindValue(statement, query.getBindValues());
        return statement.executeUpdate();
    }

    /**
     * @see java.sql.Statement#executeQuery(java.lang.String) 
     * @param query is a query command
     * @throws SQLException if there is a SQL connection problem.
     */
    public ResultSet excuteQuery(DBQuery control) throws SQLException {
        statement = connect.prepareStatement(control.getPreparedCommand());
        setBindValue(statement, control.getBindValues());
        return statement.executeQuery();
    }

    /**
     * @see java.sql.Statement#execute(java.lang.String) 
     * @param query is a query command
     * @throws SQLException if there is a SQL connection problem.
     */
    public boolean excute(DBQuery control) throws SQLException {
        statement = connect.prepareStatement(control.getPreparedCommand());
        setBindValue(statement, control.getBindValues());
        return statement.execute();
    }

    /**
     * Close the statement and conection.
     */
    public void close() {
        try {
            statement.close();
        } catch (SQLException e) {
        }
        try {
            connect.close();
        } catch (SQLException e) {
        };
    }

    private void setBindValue(PreparedStatement statement, Object[] values) throws SQLException {
        for (int i = 0; i < values.length; i++) {
            statement.setObject(i + 1, values[i]);
        }
    }
}
