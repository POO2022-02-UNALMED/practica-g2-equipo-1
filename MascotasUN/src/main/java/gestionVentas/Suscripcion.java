package gestionVentas;
import java.util.Date;
public class Suscripcion {
    private long suscripcionID;
    private Date fechaInicio; //revisar formato de la fecha
    private int tiempoSuscripcion;
    private int precioSus;

    public Suscripcion(long suscripcionID, Date fechaInicio, int tiempoSuscripcion,int  precioSus){
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

    public Date getFechaInicio() {
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

    public void setFechaInicio(Date fechaInicio) {
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
