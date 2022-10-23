package gestorAplicacion.gestionVentas;

//Importando librerías
//import java.io.Serializable;
import java.util.ArrayList;

//Creando la interfaz
public interface Mascota {
    // Métodos
    ArrayList<Producto> tipoAlimento(String raza);
    
    String calcularEdad(int edad);

    public enum Raza{
    	PEQUENA, GRANDE, MEDIANA
    }
}

