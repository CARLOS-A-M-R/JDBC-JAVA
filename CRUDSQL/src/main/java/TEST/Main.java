/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TEST;

import CLASSES.User;
import DATA.UserDAO;
import DATA.ConnectDB;
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
            //UserDAO userDAO = new UserDAO();
            //User user = new User("liliam", "123456");
            //userDAO.insertUser(user);
            //7User user = new User(2,"liliam cruz", "11111");
            //userDAO.UpdateUser(user);

            /*List<User> users = userDAO.selectUser();
            
            users.forEach(user -> {
            System.out.println("usuario  = " + user);
            });*/
            conexion = ConnectDB.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            UserDAO userDAO = new UserDAO(conexion);
            //Puede ser una forma
            //User user = new User(2, "Lily Cruz", "6666");
            User user = new User();
            user.setIdUser(2);
            user.setNombreUser("Editando");
            user.setPasswordUser("Editando..");
            userDAO.UpdateUser(user);
            //Puede ser otra forma
            //User userdos = new User("Caros", "carlpage");
            User usertwo = new User();
            usertwo.setNombreUser("LILIAM");
            //usertwo.setPasswordUser("nuevapassppppppppppppppppppppppppppppppppppppppppppppppppppp");
            usertwo.setPasswordUser("pass2021");

            userDAO.insertUser(usertwo);

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
