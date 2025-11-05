package persistencia;


import BDException.BDException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.ReporteInasistencia;
import persistencia.Conexion;
import java.sql.Date;
import java.util.ArrayList;

public class ReporteInasistenciaDao {
    private static final String guardarReporte=("INSERT INTO Inasistencia(Nombre,Apellido,Motivo,Grupo,FechaInicial,FechaFinal) VALUES (?,?,?,?,?,?)");
    private static final String consultaReporte=("SELECT * FROM Inasistencia");
    public static final String eliminarReporte=("DELETE FROM Inasistencia WHERE IdInasistencia= ?");
    public Conexion cone=new Conexion();
    public PreparedStatement ps;
    public ResultSet rs;
    public void guardarInasistencia(ReporteInasistencia RI)throws Exception,SQLException{
     try(Connection con = cone.getConnection(); 
             PreparedStatement ps = (PreparedStatement) con.prepareStatement(guardarReporte);){
         
        ps.setString(1, RI.getNombre());
        ps.setString(2, RI.getApellido());
        ps.setString(3, RI.getMotivo());
        ps.setString(4, RI.getGrupo());
        ps.setDate(5, RI.getFechaInicio());
        ps.setDate(6, RI.getFechaFin());
        
        ps.executeUpdate();
     }catch (SQLException e) {
    e.printStackTrace(); // muestra el error real en consola
    throw new Exception("No se guardó el reporte: " + e.getMessage());
}

        
        
    }
    public ArrayList<ReporteInasistencia> consultaInasistencia() throws Exception{
        ArrayList<ReporteInasistencia> lista = new ArrayList<>();
        try{
            Connection con;
            con = cone.getConnection();
            ps = (PreparedStatement) con.prepareStatement(consultaReporte);
            rs = ps.executeQuery();
            while(rs.next()){
            ReporteInasistencia ri = new ReporteInasistencia();
            ri.setNombre(rs.getString("Nombre"));
            ri.setApellido(rs.getString("Apellido"));
            ri.setMotivo(rs.getString("Motivo"));
            ri.setGrupo(rs.getString("Grupo"));
            ri.setFechaInicio(rs.getDate("FechaInicial"));
            ri.setFechaFin(rs.getDate("FechaFinal"));           
            lista.add(ri);
            }
            rs.close();
            ps.close();
            con.close();
        }catch (SQLException e) {
        throw new Exception("Error al consultar los reportes");
        }
           return lista;  
        }
    
    public void eliminarInasistencia(int IdInasistencia) throws Exception{
        try{
            Connection con = cone.getConnection();
            ps = con.prepareStatement(eliminarReporte);
            ps.setInt(1, IdInasistencia);
            ps.executeUpdate();
            
            
            
        }catch (Exception e){ throw new Exception ("Error al eliminar reporte");
        }
    }
    
        
    }

