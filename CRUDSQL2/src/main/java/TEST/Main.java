/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TEST;

import CLASSES.UserDTO;
import DATA.UserDaoJDBC;
import DATA.ConnectDB;
import DATA.UserDAO;
import java.sql.*;
import java.util.List;

/**
 *
 * @author yoshy
 */
public class Main {

    public static void main(String[] args) {
        Connection conexion = null;
        try {
            //UserDAO userDAO = new UserDaoJDBC();
            //User user = new UserDTO("liliam", "123456");
            //userDAO.insertUser(user);
            //7User user = new UserDTO(2,"liliam cruz", "11111");
            //userDAO.UpdateUser(user);

            /*List<User> users = userDAO.selectUser();
            
            users.forEach(user -> {
            System.out.println("usuario  = " + user);
            });*/
            conexion = ConnectDB.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            
            UserDAO userDAO = new UserDaoJDBC(conexion);
            
            List<UserDTO> users = userDAO.selectUser();
            
            users.forEach(element -> {
                System.out.println("Uuarios: "+element);
            });

            conexion.commit();
            System.out.println("Se ha efectuado el commit!");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al RollBack");
            try {
               conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
}
