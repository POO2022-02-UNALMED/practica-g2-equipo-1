package uiMain.gestion.gestionProveedores;

import gestorAplicacion.gestionPersonas.Proveedor;
import gestorAplicacion.gestionPersonas.Usuario;

import java.util.Scanner;

public class EliminarProveedor {
    private static int id;
    public static void eliminarProveedor(){
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("Ingrese el codigo del proveedor que se quiere eliminar: ");
            id=input.nextInt();

            boolean proveedorEliminado = Proveedor.eliminarProveedor(Proveedor.encontrarPersona(id));
            if (proveedorEliminado ==false){
                System.out.println("No se encontro el proveedor, intente nuevamente");
            } else {
                System.out.println("Proveedor Eliminado");
                //System.out.println(Proveedor.getProveedores()); Si quieren ver el uso de eliminar
                break;
            }
        }
    }
}
