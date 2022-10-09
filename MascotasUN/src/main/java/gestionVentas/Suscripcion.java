package gestionVentas;
import java.time.*;
public class Suscripcion {
    private long suscripcionID;
    private LocalDate fechaInicio; //revisar formato de la fecha
    private int tiempoSuscripcion;
    private int precioSus;

    public Suscripcion(long suscripcionID, LocalDate fechaInicio, int tiempoSuscripcion,int  precioSus){
        this.suscripcionID=suscripcionID;
        this.fechaInicio=fechaInicio;
        this.tiempoSuscripcion=tiempoSuscripcion;
        this.precioSus=precioSus;
    }

    public void suscribirse(){

    }
    public Boolean estadoSuscripcion(){

    }
    public void generarBeneficio(){

    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public int getPrecioSus() {
        return precioSus;
    }

    public long getSuscripcionID() {
        return suscripcionID;
    }

    public int getTiempoSuscripcion() {
        return tiempoSuscripcion;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setPrecioSus(int precioSus) {
        this.precioSus = precioSus;
    }

    public void setSuscripcionID(long suscripcionID) {
        this.suscripcionID = suscripcionID;
    }

    public void setTiempoSuscripcion(int tiempoSuscripcion) {
        this.tiempoSuscripcion = tiempoSuscripcion;
    }
}
