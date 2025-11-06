/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import BDException.BDException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class Conexion {
    public static Connection getConnection() throws BDException {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/proyecto?zeroDateTimeBehavior=CONVERT_TO_NULL",
                "root",
                "BandalosChinos89"
            );
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new BDException("Error de conexion: " + e.getMessage());
        }
        return con;
    }
}

            
            
    
    
