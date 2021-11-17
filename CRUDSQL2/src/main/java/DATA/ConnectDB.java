/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATA;

import java.sql.*;

/**
 *
 * @author yoshy
 */
public class ConnectDB {

    private static final String JDBC_URL = "jdbc:mariadb://192.168.1.186:3306/db_java?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "carl";
    private static final String JDBC_PASS = "seguridad2021";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }

    public static void close(ResultSet result) {
        try {
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement stm) {
        try {
            stm.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
