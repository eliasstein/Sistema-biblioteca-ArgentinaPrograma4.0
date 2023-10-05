package proyectofinal.conexiones;

import proyectofinal.clases.Libro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LibroData {
    private Connection con = null;
    
    public LibroData(){
        con = Conexion.getConexion();
    }

    public void RegistrarLibro(Libro libro) {
    String sql = "INSERT INTO libro (IdLibro_isbn,titulo,autor,tipo,editorial,estado) " +
                 "VALUES (?,?, ?, ?, ?, ?)";
    try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        ps.setLong(1, libro.getIsbn());
        ps.setString(2, libro.getTitulo());
        ps.setString(3, libro.getAutor());
        ps.setString(4, libro.getTipo());
        ps.setString(5, libro.getEditorial());
        ps.setBoolean(6, libro.isEstado());
        
        int filasAfectadas = ps.executeUpdate();
        System.out.println(filasAfectadas);
        if (filasAfectadas > 0) {
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Libro añadido con éxito.");
                }
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla libro: " + ex.getMessage());
    }
}
    
    public List<Libro> listarLibros() {
        List<Libro> libros = new ArrayList<>();
        try {
            String sql = "SELECT IdLibro_isbn,titulo,autor,editorial FROM libro WHERE estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Libro libro = new Libro();
                libro.setIsbn(rs.getLong("IdLibro_isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setEditorial(rs.getString("editorial"));
                libros.add(libro);
            }
            ps.close();

        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno "+ex.getMessage());
        }
        return libros;
    }
    
    public boolean ExisteLibro(Long isbn){
        boolean existe=false;
        String sql ="SELECT IdLibro_isbn FROM libro WHERE IdLibro_isbn = ?";
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(sql);
            ps.setLong(1,isbn);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) 
                existe=true;    
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Libro"+ex.getMessage());
        }
    return existe;
    }
    
/*
    public Alumno buscarAlumno(int id){
        Alumno alumno = null;
        String sql ="SELECT dni, apellido, nombre, fechaNacimiento FROM alumno WHERE idAlumno = ? AND estado = 1";
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
            } 
            else {
                JOptionPane.showMessageDialog(null, "No existe el alumno");
                ps.close();
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno"+ex.getMessage());
        }
        return alumno;
    }
    
    public Alumno buscarAlumnoPorDni(int dni) {
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
}