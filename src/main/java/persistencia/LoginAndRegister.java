/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Usuarios;

public class LoginAndRegister { 
    private static final String SQLogin=("SELECT * FROM Usuarios WHERE nombreUsuario = ? AND contrasenia = ?"); 
    private static final String SQLregister=("INSERT INTO Usuarios(nombreUsuario, contrasenia) VALUES (?, ?)");
    
    public boolean iniciarSesion(String nombreUsuario, String contrasenia)throws Exception{ 
        boolean valido = false;
        try(Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(SQLogin);)
        { ps.setString(1, nombreUsuario);
        ps.setString(2, contrasenia);
        ResultSet rs = ps.executeQuery();      
        if(rs.next())
        { 
            valido = true; } 
         }catch (SQLException e){throw new Exception("Error al iniciar sesion"); 
         } return valido; 
    } 
    public void registrar(Usuarios u) throws Exception{ try(Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(SQLregister)){ 
        ps.setString(1, u.getUsername());
        ps.setString(2, u.getPswd());
        
        ps.executeUpdate();
    } catch (SQLException e){ throw new Exception("Error al registrar usuario"); 
    
    }
    
    }
}
