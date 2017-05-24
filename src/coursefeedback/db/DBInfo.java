package coursefeedback.db;

/**
 * Information required for connecting to the database.
 * @author Pawat Nakpiphatkul
 */
enum DBInfo {

    JDBC_DRIVER("com.mysql.jdbc.Driver"),
    DB_URL("jdbc:mysql://103.253.73.172/guitarpa_feedback"),
    USERNAME("guitarpa_oop"),
    PASSWORD("SKAoPApm5LMMvo8N");

    private String info;

    private DBInfo(String s) {
        info = s;
    }

    protected String getInfo() {
        return info;
    }

}
