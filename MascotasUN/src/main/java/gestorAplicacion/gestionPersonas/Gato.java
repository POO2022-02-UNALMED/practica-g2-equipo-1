/*Clase que crea y gestiona objetos de tipo Gato*/

package gestorAplicacion.gestionVentas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class Gato implements Mascota, Serializable {

	// Serializador Gato
	private static final long serialVersionUID = 1L;
    private static ArrayList<Gato> gatos = new ArrayList<>();

    // Atributos
    private long mascotaID;
    private String nombre;
    private int edad;

    // Constructor
    public Gato(long mascotaID, String nombre, int edad) {
        this.mascotaID = mascotaID;
    	this.nombre = nombre;
        this.edad = edad;
    }
    
    // Métodos
    
    // Método que dependiendo de la edad del gato (ingresada en años) retornará si es Cachorro o Adulto
    @Override
    public String calcularEdad(int edad) {
    	if (edad<=1 ){
    		return "Cachorro";
    	}
    	else {
    		return "Adulto";
    	}
    }
    
    // Método que dependiendo de la edad del gato, retornará una lista de productos recomendados
    @Override
    public ArrayList<Producto> tipoAlimento(){
     	ArrayList<Producto> ListAux = new ArrayList<Producto>();
 		for (Map.Entry<Producto, Integer> entry : Tienda.getInventario().entrySet()) {
 			if (entry.getKey().getEtapa() == calcularEdad(getEdad())) {
 				ListAux.add(entry.getKey());
 			}
 		}
 		return ListAux;
      }

    // Getters y setters
    
    public static ArrayList<Gato> getGatos() {
        return gatos;
    }
    
    public static void setGatos(ArrayList<Gato> gatos) {
        Gato.gatos=gatos;
    }
    
    public long getMascotaID() {
        return mascotaID;
    }
    
    public void setMascotaID(long mascotaID) {
        this.mascotaID = mascotaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}