package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

        public static Connection getDBConnection() throws ClassNotFoundException {

                Connection con = null;
                Class.forName("oracle.jdbc.driver.OracleDriver");
                try {
                        con = DriverManager.getConnection(

                                       "jdbc:oracle:thin:@10.232.71.29:1521:INATP02", "shobana",

                                        "shobana");
                } catch (SQLException e) {

                        e.printStackTrace();

                }

                return con;

        }

}

