package uiMain.gestion.gestionUsuarios;

import gestorAplicacion.gestionVentas.Producto;
import gestorAplicacion.gestionVentas.Tienda;

import java.util.Scanner;

public class EliminarUsuario {
    private static int id;
    private static Tienda t;
    public static void eliminarProducto(){
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("Ingrese el codigo del producto que se quiere eliminar: ");
            id=input.nextInt();

            boolean productoEliminado =Producto.eliminarProducto(t.encontrarProducto(id));
            if (productoEliminado ==false){
                System.out.println("No se encontro el producto, intente nuevamente");
            } else {
                System.out.println("Producto eliminado");
                break;
            }
        }
    }
}
