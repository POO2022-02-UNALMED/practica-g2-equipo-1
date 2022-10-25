/*Clase que crea y gestiona objetos de tipo Perro*/

package gestorAplicacion.gestionPersonas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import gestorAplicacion.gestionVentas.Producto;
import gestorAplicacion.gestionVentas.Tienda;

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
        perros.add(this);
    }

    // Métodos
    
    // Método que dependiendo de la edad del perro (ingresada en años) retornará si es Cachorro o Adulto
    @Override
    public String calcularEdad() {
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
		for (int i = 0; i < Tienda.getCatalogo().size(); i++) {
			Producto p = Tienda.getCatalogo().get(i);
			if (p.getEtapa() == calcularEdad() & p.getRaza() == raza & p.getEspecie() == "Perro") {
				ListAux.add(p);
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