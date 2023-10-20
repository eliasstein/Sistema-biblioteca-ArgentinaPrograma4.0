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
                + "INNER JOIN libro l ON e.idLibro_isbn = l.idLibro_isbn "
                + "WHERE e.estado=3 "
                + "ORDER BY idEjemplar";

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
    
    public Ejemplar buscarEjemplar(Ejemplar ej) {
        Ejemplar ejemplar = null;
        String sql = "SELECT * "
                    +"FROM ejemplar e "
                    +"INNER JOIN libro l ON e.idLibro_isbn=l.IdLibro_isbn "
                    +"WHERE e.idLibro_isbn=? and e.estado=? ";
        try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setLong(1, ej.getLibro().getIsbn());
             ps.setInt(2,ej.getEstado().ordinal());
             ResultSet rs = ps.executeQuery();


            if (rs.next()) {
                int codigo = rs.getInt("idEjemplar"); // Cambiado de "codigo" a "idEjemplar"
                long isbn = rs.getLong("idLibro_isbn");
                EstadoEjemplar estado = EstadoEjemplar.values()[rs.getInt("estado")];
                int cantidad = rs.getInt("cantidad");

                String titulo = rs.getString("titulo");
                String tipo = rs.getString("tipo");
                String editorial = rs.getString("editorial");
                String autor = rs.getString("autor");
                boolean libroEstado = rs.getBoolean("l.estado");

                Libro libro = new Libro(isbn, titulo, tipo, editorial, autor, libroEstado);
                ejemplar = new Ejemplar(codigo, libro, estado, cantidad);
            }
        } catch (SQLException ex) {
            //System.out.println("Entre aca");
            // Manejar excepciones, como SQLException
            ex.printStackTrace();
        }
        //System.out.println("Cantidad de ejemplares: " + ejemplares.size());
        return ejemplar;

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
            if (exito != 1) {
                JOptionPane.showMessageDialog(null, "El Ejemplar no existe");
            } 
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ejemplar "+ex.getMessage());
        }
    }
    
    public Ejemplar buscarEjemplarPorid(int idEjemplar) {
            Ejemplar ejemplar=null;
            String sql = "SELECT * FROM ejemplar WHERE idEjemplar=?";
            PreparedStatement ps = null;
            try {
                ps = con.prepareStatement(sql);
                ps.setInt(1,idEjemplar);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    ejemplar = new Ejemplar();
                    ejemplar.setCodigo(rs.getInt("idEjemplar"));
                    ejemplar.setLibro(new Libro());
                    ejemplar.getLibro().setIsbn(rs.getLong("idLibro_isbn"));
                    ejemplar.setEstado(EstadoEjemplar.values()[rs.getInt("estado")]);
                    ejemplar.setCantidad(rs.getInt("cantidad"));
                } 
                else {
                    JOptionPane.showMessageDialog(null, "No existe el ejemplar");
                }
                ps.close();
            } 
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplar "+ex.getMessage());
            }
            return ejemplar;
        }
    
    
    

}
