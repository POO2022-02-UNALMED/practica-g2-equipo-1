/*Interfaz de tipo Mascota a ser implementada en las clases Perro y Gato*/

package gestorAplicacion.gestionPersonas;

import java.util.ArrayList;

import gestorAplicacion.gestionVentas.Producto;

public interface Mascota {
    // Métodos

	/* Este metodo dependiendo de la clase que lo implemente retornara una lista de los productos recomendados*/
    ArrayList<Producto> tipoAlimento();

    /* Dependiendo de la clase que lo implemente retornara en que tipo de etapa de desarrollo se encuentra la mascota*/
    String calcularEdad();
}