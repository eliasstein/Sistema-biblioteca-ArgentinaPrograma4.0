package proyectofinal.conexiones;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import javax.swing.JOptionPane;
import proyectofinal.clases.Prestamo;

public class PrestamoData {
    
     private Connection con = null;

    public PrestamoData() {
        con = Conexion.getConexion();
    }
    
    /*
    SELECT prestamo.*, lector.*, ejemplar.*
    FROM prestamo
    JOIN lector on prestamo.idLector = lector.nroSocio
    JOIN ejemplar on prestamo.idEjemplar = ejemplar.idEjemplar
    */

    public void RegistrarPrestamo(Prestamo prestamo) {
        String sql = "INSERT INTO prestamo (FechaInicio, FechaFin, idEjemplar, idLector, estado) "
                    +"VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setDate(1, Date.valueOf(prestamo.getFechainicio()));
            ps.setDate(2, Date.valueOf(prestamo.getFechafin()));
            ps.setInt(3, prestamo.getEjemplar().getCodigo());
            ps.setInt(4, prestamo.getLector().getNmroSocio());
            ps.setBoolean(5,prestamo.isEstado());

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Prestamo añadido con éxito.");
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la prestamo alumno: " + ex.getMessage());
        }
    }

    
    
    
    
}
