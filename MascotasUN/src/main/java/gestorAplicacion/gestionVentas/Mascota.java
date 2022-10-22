//Importando paquete
package gestorAplicacion.gestionVentas;

//Importando librerías
import java.io.Serializable;
import java.util.ArrayList;

//Creando la interfaz
public interface Mascota {
    
	
    // Métodos
    ArrayList tipoAlimento(String tipo, String raza);
    String calcularEdad(int edad);
    void anadirProductos();
    void eliminarProductos();
    
    
}

