package hospital.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConection {

    private  static final String URL ="jdbc:mysql://localhost:3306/hospitaldb";
    private  static final String USERNAME="root";
    private  static final String PASSWORD="root@123";

    private DBConection(){}

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
}
