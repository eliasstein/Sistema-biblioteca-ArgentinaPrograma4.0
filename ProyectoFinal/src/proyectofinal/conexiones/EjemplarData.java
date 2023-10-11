package proyectofinal.conexiones;

import proyectofinal.clases.Ejemplar;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import proyectofinal.clases.EstadoEjemplar;
import proyectofinal.clases.Libro;

public class EjemplarData {

    private Connection con = null;

    public EjemplarData() {
        con = Conexion.getConexion();
    }

    public void RegistrarEjemplar(Ejemplar ejemplar) {
        String sql = "INSERT INTO ejemplar (idLibro_isbn,estado,cantidad) "
                + "VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setLong(1, ejemplar.getLibro().getIsbn());
            ps.setInt(2, ejemplar.getEstadoInteger());
            ps.setLong(3, ejemplar.getCantidad());

            int filasAfectadas = ps.executeUpdate();
            System.out.println(filasAfectadas);
            if (filasAfectadas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Ejemplar añadido con éxito.");
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ejemplar: " + ex.getMessage());
        }
    }

    public ArrayList<Ejemplar> buscarEjemplares() {

        ArrayList<Ejemplar> ejemplares = new ArrayList<>();
        String sql = "SELECT e.idEjemplar, e.idLibro_isbn, e.cantidad, e.estado, "
                + "l.titulo, l.tipo, l.editorial, l.autor, l.estado AS libro_estado "
                + "FROM ejemplar e "
                + "INNER JOIN libro l ON e.idLibro_isbn = l.idLibro_isbn";

        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int codigo = rs.getInt("idEjemplar"); // Cambiado de "codigo" a "idEjemplar"
                long isbn = rs.getLong("idLibro_isbn");
                EstadoEjemplar estado = EstadoEjemplar.values()[rs.getInt("estado")];
                int cantidad = rs.getInt("cantidad");

                String titulo = rs.getString("titulo");
                String tipo = rs.getString("tipo");
                String editorial = rs.getString("editorial");
                String autor = rs.getString("autor");
                boolean libroEstado = rs.getBoolean("libro_estado");

                Libro libro = new Libro(isbn, titulo, tipo, editorial, autor, libroEstado);
                Ejemplar ejemplar = new Ejemplar(codigo, libro, estado, cantidad);
                ejemplares.add(ejemplar);
            }
        } catch (SQLException ex) {
            //System.out.println("Entre aca");
            // Manejar excepciones, como SQLException
            ex.printStackTrace();
        }
        //System.out.println("Cantidad de ejemplares: " + ejemplares.size());
        return ejemplares;

    }

    public void modificarEjemplar(Ejemplar ejemplar){
        String sql = "UPDATE ejemplar SET idLibro_isbn = ?, estado = ?, cantidad= ? WHERE idEjemplar = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, ejemplar.getLibro().getIsbn());
            ps.setInt(2, ejemplar.getEstadoInteger());
            ps.setInt(3, ejemplar.getCantidad());
            ps.setInt(4, ejemplar.getCodigo());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El Ejemplar fue Modificado Exitosamente.");
            } 
            else {
                JOptionPane.showMessageDialog(null, "El Ejemplar no existe");
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ejemplar "+ex.getMessage());
        }
    }
    
    
    
    

}
/*   public Alumno buscarAlumnoPorDni(int dni) {
        Alumno alumno = null;
        String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE dni=? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,dni );
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alumno=new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
            } 
            else {
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }
            ps.close();
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno "+ex.getMessage());
        }
        return alumno;
    }

    public List<Alumno> listarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM alumno WHERE estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                alumnos.add(alumno);
            }
            ps.close();


        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno "+ex.getMessage());
        }
        return alumnos;
    }

    public void modificarAlumno(Alumno alumno){
        String sql = "UPDATE alumno SET dni = ? , apellido = ?, nombre = ?, fechaNacimiento = ? WHERE idAlumno = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setInt(5, alumno.getIdalumno());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El Alumno fue Modificado Exitosamente.");
            } 
            else {
                JOptionPane.showMessageDialog(null, "El alumno no existe");
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno "+ex.getMessage());
        }
    }

    public void eliminarAlumno(int dni) {
        try {
            String sql = "UPDATE alumno SET estado = 0 WHERE dni = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            int fila=ps.executeUpdate();

            if(fila==1){
                JOptionPane.showMessageDialog(null, " Se eliminó el alumno.");
            }
            ps.close();
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno");
        }
    }
    
    public void eliminarAlumnoPorID(int id) {
        try {
            String sql = "UPDATE alumno SET estado = 0 WHERE idAlumno = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila=ps.executeUpdate();

            if(fila==1){
                JOptionPane.showMessageDialog(null, " Se eliminó el alumno.");
            }
            ps.close();
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno");
        }
    }
 */
