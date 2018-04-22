/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timecontroller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author tuandung
 */
public class MySQLConnUtils {
    public static Connection getMySQLConnection()
        throws ClassNotFoundException, SQLException {
    String hostName = "localhost";
    String dbName = "TimeController";
    String userName = "root";
    String password = "Ltd1571997";
    return getMySQLConnection(hostName, dbName, userName, password);
}
 
public static Connection getMySQLConnection(String hostName, String dbName,
        String userName, String password) throws SQLException,
        ClassNotFoundException {
    // Khai báo class Driver cho DB MySQL
    // Việc này cần thiết với Java 5
    // Java6 trở lên tự động tìm kiếm Driver thích hợp.
    // Nếu bạn dùng Java > 5, thì ko cần dòng này cũng được.
    //Class.forName("com.mysql.cj.jdbc.Driver");
 
    // Cấu trúc URL Connection dành cho MySQL
    // Ví dụ: jdbc:mysql://localhost:3306/simplehr
    String connectionURL = "jdbc:mysql://localhost:3306/timecontroller?zeroDateTimeBehavior=convertToNull&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
 
    Connection conn = DriverManager.getConnection(connectionURL, userName,
            password);
    return conn;
}
}
