/*Interfaz de tipo Mascota a ser implementada en las clases Perro y Gato*/

package gestorAplicacion.gestionPersonas;

import java.util.ArrayList;

import gestorAplicacion.gestionVentas.Producto;

public interface Mascota {
	
    // Métodos
	
    ArrayList<Producto> tipoAlimento();
    
    String calcularEdad(int edad);
    
    public enum TipoEdad{
        CACHORRO, ADULTO;
    }
}