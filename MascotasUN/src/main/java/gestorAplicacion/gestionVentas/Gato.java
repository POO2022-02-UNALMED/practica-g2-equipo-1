package gestorAplicacion.gestionVentas;

// Importando librerías
import java.io.Serializable;
import java.util.ArrayList;

public class Gato implements Mascota, Serializable {
    
	// Serializador Gato
    private static ArrayList<Gato> gatos = new ArrayList<>();
    

    // Atributos
    private long mascotaID;
    private String nombre;
    private int edad;
    private String raza;
    
    
    
    // Constructor
    public Gato(long mascotaID, String nombre, int edad, String raza) {
        this.mascotaID = mascotaID;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
    }
    //Metodos
    

    // Setters y Getters
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



    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
    
    
    //Métodos
    //@Override
    /*public ArrayList tipoAlimento(String raza){
    		if raza==Raza.GRANDE{
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
    	if (edad<=1 ){
    		return "Cachorro";
    	}
    	else {
    		return "Adulto";
    	}
    }
    
    
    
    

}
