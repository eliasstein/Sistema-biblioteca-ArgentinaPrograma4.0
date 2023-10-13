package proyectofinal.conexiones;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import proyectofinal.clases.Prestamo;
import proyectofinal.clases.Lector;
import proyectofinal.clases.Libro;
import proyectofinal.clases.Ejemplar;
import proyectofinal.clases.EstadoEjemplar;



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
    
    
    /*
SELECT pre.idPrestamo,pre.FechaInicio,pre.FechaFin,lib.titulo,lib.autor,
lib.tipo,ej.estado,lec.nombre,lec.dni,COUNT(pre.idEjemplar) cantidad
FROM prestamo pre
INNER JOIN ejemplar ej ON pre.idEjemplar = ej.idEjemplar
INNER JOIN libro lib ON ej.idLibro_isbn = lib.IdLibro_isbn
INNER JOIN lector lec ON pre.idLector = lec.nroSocio
GROUP BY pre.idEjemplar,pre.idLector
    */
    
    /*
    SELECT pre.idPrestamo,pre.FechaInicio,pre.FechaFin,pre.idEjemplar,pre.idLector,pre.estado estado_prestamo,
    ej.idEjemplar,ej.idLibro_isbn idLibro_isbn_ejemplar,ej.estado estado_ejemplar, ej.cantidad cantidad_ejemplar,
    lib.IdLibro_isbn idLibro_isbn_libro, lib.titulo, lib.autor, lib.tipo, lib.editorial, lib.estado estado_libro,
    lec.nroSocio, lec.nombre, lec.domicilio, lec.telefono, lec.estado estado_lector, lec.dni
    ,COUNT(pre.idEjemplar) cantidad_prestamo
    FROM prestamo pre
    INNER JOIN ejemplar ej ON pre.idEjemplar = ej.idEjemplar
    INNER JOIN libro lib ON ej.idLibro_isbn = lib.IdLibro_isbn
    INNER JOIN lector lec ON pre.idLector = lec.nroSocio
    GROUP BY pre.idEjemplar,pre.idLector
    */

    public ArrayList<Prestamo> buscarPrestamos() {
        ArrayList<Prestamo> prestamos = new ArrayList();
        String sql = "SELECT pre.idPrestamo,pre.FechaInicio,pre.FechaFin,pre.idEjemplar,pre.idLector,pre.estado estado_prestamo,"
                    +"ej.idEjemplar,ej.idLibro_isbn idLibro_isbn_ejemplar,ej.estado estado_ejemplar, ej.cantidad cantidad_ejemplar,"
                    +"lib.IdLibro_isbn idLibro_isbn_libro, lib.titulo, lib.autor, lib.tipo, lib.editorial, lib.estado estado_libro,"
                    +"lec.nroSocio, lec.nombre, lec.domicilio, lec.telefono, lec.estado estado_lector, lec.dni,COUNT(pre.idEjemplar) cantidad_prestamo "
                    +"FROM prestamo pre "
                    +"INNER JOIN ejemplar ej ON pre.idEjemplar = ej.idEjemplar "
                    +"INNER JOIN libro lib ON ej.idLibro_isbn = lib.IdLibro_isbn "
                    +"INNER JOIN lector lec ON pre.idLector = lec.nroSocio "
                    +"GROUP BY pre.idEjemplar,pre.idLector ";

        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                //Libro
                //Long isbn, String titulo, String tipo, String editorial, String autor, boolean estado
                Long isbn = rs.getLong("idLibro_isbn_libro");
                String titulo = rs.getString("titulo"); 
                String tipo = rs.getString("tipo");
                String editorial = rs.getString("editorial");
                String autor = rs.getString("autor");
                boolean estadoLib = rs.getBoolean("estado_libro");
                Libro libro = new Libro(isbn,titulo,tipo,editorial,autor,estadoLib);
                //Lector
                //int nmroSocio, String nombre, Long dni, String domicilio, Long telefono, boolean estado
                int nmroSocio = rs.getInt("nroSocio");
                String nombre = rs.getString("nombre");
                Long dni = rs.getLong("dni");
                String domicilio = rs.getString("domicilio");
                Long telefono = rs.getLong("telefono");
                boolean estadoLec = rs.getBoolean("estado_lector");
                Lector lector = new Lector(nmroSocio,nombre,dni,domicilio,telefono,estadoLec);
                //Ejemplar
                //int codigo, Libro libro, EstadoEjemplar estado, int cantidad
                int codigo = rs.getInt("idEjemplar");
                //libro declarado arriba
                EstadoEjemplar estadoEjemplar = EstadoEjemplar.values()[rs.getInt("estado_ejemplar")];
                int cantidadEj = rs.getInt("cantidad_ejemplar");
                Ejemplar ejemplar = new Ejemplar(codigo,libro,estadoEjemplar,cantidadEj);
                //Prestamo
                //LocalDate fechainicio, LocalDate fechafin, Ejemplar ejemplar, Lector lector, boolean estado
                int idPrestamo = rs.getInt("idPrestamo");
                LocalDate fechaInicio = rs.getDate("FechaInicio").toLocalDate();
                LocalDate fechaFin = rs.getDate("FechaFin").toLocalDate();
                boolean estadoPrestamo = rs.getBoolean("estado_prestamo");
                Prestamo prestamo = new Prestamo(idPrestamo,fechaInicio,fechaFin,ejemplar,lector,estadoPrestamo);
                prestamo.setCantidad(rs.getInt("cantidad_prestamo"));
                prestamos.add(prestamo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return prestamos;

    }
    
    
    public ArrayList<Prestamo> BuscarPrestamoPorIds(int idLector, int idEjemplar) {
        ArrayList<Prestamo> prestamos = new ArrayList();
        String sql = "SELECT pre.idPrestamo,pre.FechaInicio,pre.FechaFin,pre.idEjemplar,pre.idLector,pre.estado estado_prestamo, "
                    +"ej.idEjemplar,ej.idLibro_isbn idLibro_isbn_ejemplar,ej.estado estado_ejemplar, ej.cantidad cantidad_ejemplar, "
                    +"lib.IdLibro_isbn idLibro_isbn_libro, lib.titulo, lib.autor, lib.tipo, lib.editorial, lib.estado estado_libro, "
                    +"lec.nroSocio, lec.nombre, lec.domicilio, lec.telefono, lec.estado estado_lector, lec.dni "
                    +"FROM prestamo pre "
                    +"INNER JOIN ejemplar ej ON pre.idEjemplar = ej.idEjemplar "
                    +"INNER JOIN libro lib ON ej.idLibro_isbn = lib.IdLibro_isbn " 
                    +"INNER JOIN lector lec ON pre.idLector = lec.nroSocio " 
                    +"WHERE pre.idLector=? and pre.idEjemplar=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,idLector);
            ps.setInt(2,idEjemplar);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                //Libro
                //Long isbn, String titulo, String tipo, String editorial, String autor, boolean estado
                Long isbn = rs.getLong("idLibro_isbn_libro");
                String titulo = rs.getString("titulo"); 
                String tipo = rs.getString("tipo");
                String editorial = rs.getString("editorial");
                String autor = rs.getString("autor");
                boolean estadoLib = rs.getBoolean("estado_libro");
                Libro libro = new Libro(isbn,titulo,tipo,editorial,autor,estadoLib);
                //Lector
                //int nmroSocio, String nombre, Long dni, String domicilio, Long telefono, boolean estado
                int nmroSocio = rs.getInt("nroSocio");
                String nombre = rs.getString("nombre");
                Long dni = rs.getLong("dni");
                String domicilio = rs.getString("domicilio");
                Long telefono = rs.getLong("telefono");
                boolean estadoLec = rs.getBoolean("estado_lector");
                Lector lector = new Lector(nmroSocio,nombre,dni,domicilio,telefono,estadoLec);
                //Ejemplar
                //int codigo, Libro libro, EstadoEjemplar estado, int cantidad
                int codigo = rs.getInt("idEjemplar");
                //libro declarado arriba
                EstadoEjemplar estadoEjemplar = EstadoEjemplar.values()[rs.getInt("estado_ejemplar")];
                int cantidadEj = rs.getInt("cantidad_ejemplar");
                Ejemplar ejemplar = new Ejemplar(codigo,libro,estadoEjemplar,cantidadEj);
                //Prestamo
                //LocalDate fechainicio, LocalDate fechafin, Ejemplar ejemplar, Lector lector, boolean estado
                int idPrestamo = rs.getInt("idPrestamo");
                LocalDate fechaInicio = rs.getDate("FechaInicio").toLocalDate();
                LocalDate fechaFin = rs.getDate("FechaFin").toLocalDate();
                boolean estadoPrestamo = rs.getBoolean("estado_prestamo");
                Prestamo prestamo = new Prestamo(idPrestamo,fechaInicio,fechaFin,ejemplar,lector,estadoPrestamo);
                
                prestamos.add(prestamo);
            }
            ps.close();
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno "+ex.getMessage());
        }
        return prestamos;
    }
    
    public void EliminarPrestamo(int id){
        
        String sql ="DELETE FROM prestamo "
                    +"WHERE idPrestamo = ?";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Prestamo eliminado con éxito.");
                    }
                }
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
}
