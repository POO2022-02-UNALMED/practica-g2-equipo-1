/**/

package gestorAplicacion.gestionVentas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class Perro implements Mascota, Serializable {

	// Serializador Perro
	private static final long serialVersionUID = 1L;
    private static ArrayList<Perro> perros = new ArrayList<>();
    
    // Atributos
    private long mascotaID;
    private String nombre;
    private int edad;
    private String raza;
    
    // Constructor
    public Perro(long mascotaID, String nombre, int edad, String raza) {
        this.mascotaID = mascotaID;
    	this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
    }
    
    // Métodos
    
    // Método que dependiendo de la edad del perro (ingresada en años) retornará si es Cachorro o Adulto
    @Override
    public String calcularEdad(int edad) {
    	if (edad <= 1) {
    		return "Cachorro";
    	}
    	
    	else {
    		return "Adulto";
    	}
    }
    
    // Método que dependiendo de la edad y la raza del perro, retornará una lista de productos recomendados
    @Override
    public ArrayList<Producto> tipoAlimento(){
    	ArrayList<Producto> ListAux = new ArrayList<Producto>();
		for (Map.Entry<Producto, Integer> entry : Tienda.getInventario().entrySet()) {
			if (entry.getKey().getRaza() == getRaza() & entry.getKey().getEtapa() == calcularEdad(getEdad())) {
				ListAux.add(entry.getKey());
			}
		}
		return ListAux;
     }
    
    
    // Getters y setters
    public static ArrayList<Perro> getPerros() {
        return perros;
    }
    
    public static void setPerros(ArrayList<Perro> perros) {
        Perro.perros=perros;
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

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}