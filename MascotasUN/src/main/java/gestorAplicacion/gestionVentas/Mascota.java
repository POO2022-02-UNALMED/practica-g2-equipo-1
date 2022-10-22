//Importando paquete
package gestorAplicacion.gestionVentas;

//Importando librerías
import java.io.Serializable;
import java.util.ArrayList;

//Creando la interfaz
public interface Mascota {
    
	
    // Métodos
    ArrayList tipoAlimento(String raza, String tamano, String calcularEdad));
    String calcularEdad(edad);
    void anadirProductos();
    void eliminarProductos();
    
    
}