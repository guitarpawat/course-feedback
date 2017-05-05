package coursefeedback.db;

/**
 *
 * @author Pawat Nakpiphatkul
 */
enum DBInfo {
    
    JDBC_DRIVER("com.mysql.jdbc.Driver"),
    DB_URL("jdbc:mysql://localhost/feedback"),
    USERNAME("coursefeedback"),
    PASSWORD("SKAoPApm5LMMvo8N");
    
    private String info;
    
    private DBInfo(String s) {
        info = s;
    }
    
    protected String getInfo() {
        return info;
    }
    
}
