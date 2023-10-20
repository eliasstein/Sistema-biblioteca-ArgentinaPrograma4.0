package proyectofinal.conexiones;

import proyectofinal.clases.Lector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LectorData {

    private Connection con = null;

    public LectorData() {
        con = Conexion.getConexion();
    }

    public void RegistrarLector(Lector lector) {
        String sql = "INSERT INTO lector (nombre,domicilio,telefono,estado,dni) "
                + "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, lector.getNombre());
            ps.setString(2, lector.getDomicilio());
            ps.setLong(3, lector.getTelefono());
            ps.setBoolean(4, lector.isEstado());
            ps.setLong(5,lector.getDni());

            int filasAfectadas = ps.executeUpdate();
            System.out.println(filasAfectadas);
            if (filasAfectadas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Lector añadido con éxito.");
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno: " + ex.getMessage());
        }
    }

    public ArrayList<Lector> buscarLectores() {
        ArrayList<Lector> lectores = new ArrayList();
        String sql = "SELECT * from lector WHERE estado = 1 ";

        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int nroSocio = rs.getInt("nroSocio");
                String nombre = rs.getString("nombre"); 
                long dni = rs.getLong("dni");
                String domicilio = rs.getString("domicilio");
                long telefono = rs.getLong("telefono");
                boolean estado = rs.getBoolean("estado");

                Lector lector = new Lector(nroSocio,nombre,dni,domicilio,telefono,estado);
                lectores.add(lector);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lectores;

    }

}
