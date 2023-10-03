package proyectofinal.clases;

public class Ejemplar {
    private int codigo;
    private Libro libro;
    private EstadoEjemplar estado;
    private int cantidad;

    public Ejemplar(int codigo, Libro libro, EstadoEjemplar estado, int cantidad) {
        this.codigo = codigo;
        this.libro = libro;
        this.estado = estado;
        this.cantidad = cantidad;
    }
    
    
}
