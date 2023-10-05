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

    public Ejemplar(Libro libro, EstadoEjemplar estado, int cantidad) {
        this.libro = libro;
        this.estado = estado;
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public EstadoEjemplar getEstado() {
        return estado;
    }
    public int getEstadoInteger() {
        return estado.ordinal();
    }

    public void setEstado(EstadoEjemplar estado) {
        this.estado = estado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    
    
    
}
