package gestorAplicacion.gestionVentas;

import java.io.Serializable;
import java.util.ArrayList;

public class Envio implements Serializable {
    //Serializador vendedor
    private static ArrayList<Envio> envios = new ArrayList<>();
    private long envioID;
    private String destino;;
    private String estadoEnvio;
    private int periodicidad;

    //Constructor
    public Envio(long envioID, String destino, String estadoEnvio, int periodicidad) {
        this.envioID = envioID;
        this.destino = destino;
        this.estadoEnvio = estadoEnvio;
        this.periodicidad = periodicidad;
    }

    //Getters y setters
    public static ArrayList<Envio> getEnvios() {
        return envios;
    }
    public long getEnvioID() {
        return envioID;
    }
    public void setEnvioID(long envioID) {
        this.envioID = envioID;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public String getEstadoEnvio() {
        return estadoEnvio;
    }
    public void setEstadoEnvio(String estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }
    public int getPeriodicidad() {
        return periodicidad;
    }
    public void setPeriodicidad(int periodicidad) {
        this.periodicidad = periodicidad;
    }
    
    
}
