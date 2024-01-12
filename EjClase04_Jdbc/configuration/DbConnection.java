package configuration;

import java.sql.Connection;

public class DbConnection {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "";
    private static final String db = "";
    private static final String url = "jdbc:mysql://localhost/"+db+"";
}
