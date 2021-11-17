/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATA;

import CLASSES.User;
import static DATA.ConnectDB.close;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yoshy
 */
public class UserDAO {
    
    private Connection connectionTransactional;

    private static final String SQL_INSERT = "INSERT INTO tbl_users(username, password)VALUES(?,?)";
    private static final String SQL_SELECT = "SELECT id_user, username, password FROM tbl_users";
    private static final String SQL_DELETE = "DELETE FROM tbl_users WHERE id_user = ?";
    private static final String SQL_UPDATE = "UPDATE tbl_users SET username = ?, password = ? WHERE id_user = ?";
    
    public UserDAO() {
    }
    
    public UserDAO(Connection connectionTransactional) {
        this.connectionTransactional = connectionTransactional;
    }
    
    public int insertUser(User user) throws SQLException {

        Connection conn = null;
        PreparedStatement stm = null;
        int registers = 0;

        try {
            conn = this.connectionTransactional != null ? this.connectionTransactional : ConnectDB.getConnection();
            stm = conn.prepareStatement(SQL_INSERT);
            stm.setString(1, user.getNombreUser());
            stm.setString(2, user.getPasswordUser());
            System.out.println("Ejecutando query... " + SQL_INSERT);
            registers = stm.executeUpdate();
            System.out.println("Registros afectados... " + registers);
        } finally {
            close(stm);
            if(this.connectionTransactional == null) {
                ConnectDB.close(conn);
            }
        }

        return registers;

    }
    
    public List<User> selectUser() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        List<User> users = new ArrayList<>();
        
        try {
            conn = this.connectionTransactional != null ? this.connectionTransactional : ConnectDB.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()) {
                int idUser = rs.getInt("id_user");
                String username = rs.getString("username");
                String passwd = rs.getString("password");
                user = new User();
                user.setIdUser(idUser);
                user.setNombreUser(username);
                user.setPasswordUser(passwd);
                
                users.add(user);
            }
        } finally {
            ConnectDB.close(rs);
            ConnectDB.close(stmt);
            if(this.connectionTransactional == null) {
                ConnectDB.close(conn);
            }
        }
        
        return users;
    }
    
    public int DeleteUser(User user) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ConnectDB.getConnection();
            System.out.println("Ejecutando query: " + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, user.getIdUser());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados = " + rows);
        } finally {
            ConnectDB.close(stmt);
            if(this.connectionTransactional == null) {
             ConnectDB.close(conn);   
            }
        }
        return rows;
    }
    
    public int UpdateUser(User user) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.connectionTransactional != null ? this.connectionTransactional : ConnectDB.getConnection();
            System.out.println("Ejecutando query: "+ SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
        
            stmt.setString(1, user.getNombreUser());
            stmt.setString(2, user.getPasswordUser());
            stmt.setInt(3, user.getIdUser());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados.!  = " + rows);
        } finally {
            ConnectDB.close(stmt);
            if(this.connectionTransactional == null) {
                ConnectDB.close(conn);
            }
        }
        return rows;
    }
}
