package proyectofinal.clases;

import java.util.Date;

public class Prestamo {
    private Date fechainicio;
    private Date fechafin;
    private Ejemplar ejemplar;
    private Lector lector;
    private boolean estado;

    public Prestamo(Date fechainicio, Date fechafin, Ejemplar ejemplar, Lector lector, boolean estado) {
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.ejemplar = ejemplar;
        this.lector = lector;
        this.estado = estado;
    }
    
    
}
