/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DATA;

import CLASSES.UserDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yoshy
 */
public interface UserDAO {
    
    public int insertUser(UserDTO user) throws SQLException;
    
    public int updateUser(UserDTO user) throws SQLException;
    
    public int deleteUser(UserDTO user) throws SQLException;
    
    public List<UserDTO> selectUser() throws SQLException; 
    
}
