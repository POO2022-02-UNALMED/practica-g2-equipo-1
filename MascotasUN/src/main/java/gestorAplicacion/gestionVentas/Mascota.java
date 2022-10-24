/**/

package gestorAplicacion.gestionVentas;

import java.util.ArrayList;

public interface Mascota {
	
    // Métodos
    ArrayList<Producto> tipoAlimento();
    
    String calcularEdad(int edad);

    public enum Raza{
    	PEQUENA, GRANDE, MEDIANA
    }
}