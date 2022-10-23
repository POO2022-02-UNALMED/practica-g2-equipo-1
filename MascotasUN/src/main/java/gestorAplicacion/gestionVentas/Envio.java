package gestorAplicacion.gestionVentas;

import java.io.Serializable;
import java.util.ArrayList;

public class Envio implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Serializador vendedor
    private static ArrayList<Envio> envios = new ArrayList<>();
    private String destino;
    private Factura factura;
    private long idEnvio;
    private String estadoEnvio = "";
    private int periodicidad;
    public enum estadoEnvio{
        ENVIADO, CANCELADO, RECIBIDO;
    }

    //Constructor
    public Envio(long idEnvio, String destino, int periodicidad) {
        this.idEnvio= factura.getFacturaID();
        this.destino = destino;
        this.periodicidad = periodicidad;
    }

    //Getters y setters
    public static ArrayList<Envio> getEnvios() {
        return envios;
    }
    public static void setEnvios(ArrayList<Envio> envios) {
        Envio.envios=envios;
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
    
    //Métodos
    //Este método edita los atributos del envío
    public void editarEnvio(String destino, String estadoEnvio, int periodicidad) {
    	this.destino = destino;
        this.estadoEnvio = estadoEnvio;
        this.periodicidad = periodicidad;
    }
    
    //Este método cancela el envío
    public void cancelarEnvio(String estadoEnvio) {
    	this.estadoEnvio = estadoEnvio;
    }

}
