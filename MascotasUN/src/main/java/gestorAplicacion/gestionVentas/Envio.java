package gestorAplicacion.gestionVentas;

public class Envio{
    private long envioID;
    private String destino;;
    private String estadoEnvio;
    private int periodicidad;

    
    public Envio(long envioID, String destino, String estadoEnvio, int periodicidad) {
        this.envioID = envioID;
        this.destino = destino;
        this.estadoEnvio = estadoEnvio;
        this.periodicidad = periodicidad;
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
