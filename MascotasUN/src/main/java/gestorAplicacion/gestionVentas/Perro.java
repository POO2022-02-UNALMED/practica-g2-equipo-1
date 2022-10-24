package gestorAplicacion.gestionVentas;

// Importando librerías
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;


public class Perro implements Mascota, Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Serializador Perro
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
    
    public ArrayList<Producto> tipoAlimento(){
    	ArrayList<Producto> ListAux = new ArrayList<Producto>();
		for (Map.Entry<Producto, Integer> entry : Tienda.getInventario().entrySet()) {
			if (entry.getKey().getRaza() == getRaza() & entry.getKey().getEtapa() == calcularEdad(getEdad())) {
				ListAux.add(entry.getKey());
			}
		}
		return ListAux;
     }
    
    
    // Setters y Getters
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

    //Métodos
    /*@Override
    public ArrayList<Producto> tipoAlimento(String raza){
		if (raza==Raza.GRANDE){
			if calcularEdad() == "Cachorro"{
				return ArrayList;
			}
			else if calcularEdad() == "Adulto"{
				return ArrayList;
			}
		}
		else if raza==Raza.PEQUENA{
			if calcularEdad() == "Cachorro"{
				return ArrayList;
			}
			else if calcularEdad() == "Adulto"{
				return ArrayList;
			}
		}
		else if raza==Raza.MEDIANA{
			if calcularEdad() == "Cachorro"{
				return ArrayList;
			}
			else if calcularEdad() == "Adulto" {
				return ArrayList;	
			}
		}
     }*/
    
    @Override
    public String calcularEdad(int edad) {
    	if (edad <= 1) {
    		return "Cachorro";
    	}
    	
    	else {
    		return "Adulto";
    	}
    }
}
