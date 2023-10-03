package proyectofinal.clases;

public class Libro {

    private int isbn;
    private String titulo;
    private String tipo;
    private String editorial;
    private String autor;
    private boolean estado;

    public Libro(int isbn, String titulo, String tipo, String editorial, String autor, boolean estado) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.tipo = tipo;
        this.editorial = editorial;
        this.autor = autor;
        this.estado = estado;
    }
    
       
}
