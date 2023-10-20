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
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Libro "+ex.getMessage());
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
    
}
