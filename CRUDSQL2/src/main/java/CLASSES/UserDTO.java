/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASSES;

/**
 *
 * @author yoshy
 */
public class UserDTO {
    
    private int idUser;
    private String nombreUser;
    private String passwordUser;
   
    
    public UserDTO () {
        
    }

    public UserDTO(int idUser) {
        this.idUser = idUser;
    }

    public UserDTO(String nombreUser, String passwordUser) {
        this.nombreUser = nombreUser;
        this.passwordUser = passwordUser;
    }
    
            

    public UserDTO(int idUser, String nombreUser, String passwordUser) {
        this.idUser = idUser;
        this.nombreUser = nombreUser;
        this.passwordUser = passwordUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }



    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", nombreUser=" + nombreUser + ", passwordUser=" + passwordUser + '}';
    }
    
    
}
