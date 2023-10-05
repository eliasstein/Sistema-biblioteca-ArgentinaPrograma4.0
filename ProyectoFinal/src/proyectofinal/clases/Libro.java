package proyectofinal.clases;

public class Libro {

    private Long isbn;
    private String titulo;
    private String tipo;
    private String editorial;
    private String autor;
    private boolean estado;

    public Libro(Long isbn, String titulo, String tipo, String editorial, String autor, boolean estado) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.tipo = tipo;
        this.editorial = editorial;
        this.autor = autor;
        this.estado = estado;
    }

    public Libro() {
    }
    

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
       
}
