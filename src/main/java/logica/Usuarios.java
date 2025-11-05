/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author amaur
 */
public class Usuarios {
    private int idUsuario;
    private String username;
    private String pswd;
    
    public Usuarios(){
    }
    
   public Usuarios(int idUsuario, String username, String pswd){
       this.idUsuario = idUsuario;
       this.username = username;
       this.pswd = pswd;
   }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
   
   
    
}
