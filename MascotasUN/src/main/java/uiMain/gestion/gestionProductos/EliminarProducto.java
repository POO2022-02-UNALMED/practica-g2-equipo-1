/* Esta clase se encarga de borrar una instancia determinda de Producto*/

package uiMain.gestion.gestionProductos;

import gestorAplicacion.gestionVentas.Producto;
import gestorAplicacion.gestionVentas.Tienda;

import java.util.Scanner;

public class EliminarProducto {
    private static int id;
    public static void eliminarProducto(){
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("Ingrese el codigo del producto que se quiere eliminar: ");
            id=input.nextInt();

            //Haciendo uso del metodo de eliminar una instancia de la clase producto, se elimina el objeto con el id indicado
            boolean productoEliminado =Producto.eliminarProducto(Tienda.encontrarProducto(id));
            if (productoEliminado ==false){
                System.out.println("No se encontro el producto, intente nuevamente");
            } else {
                System.out.println("Producto eliminado"); //si quieren ver que se elimino el producto descomentar la linea que sigue
                //System.out.println(Producto.getProductos());
                break;
            }
        }
    }
}
