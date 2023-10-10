package proyectofinal.clases;

import java.time.LocalDate;
import java.util.Date;

public class Prestamo {
    private LocalDate fechainicio;
    private LocalDate fechafin;
    private Ejemplar ejemplar;
    private Lector lector;
    private boolean estado;

    public Prestamo(LocalDate fechainicio, LocalDate fechafin, Ejemplar ejemplar, Lector lector, boolean estado) {
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.ejemplar = ejemplar;
        this.lector = lector;
        this.estado = estado;
    }

    public LocalDate getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(LocalDate fechainicio) {
        this.fechainicio = fechainicio;
    }

    public LocalDate getFechafin() {
        return fechafin;
    }

    public void setFechafin(LocalDate fechafin) {
        this.fechafin = fechafin;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
}
