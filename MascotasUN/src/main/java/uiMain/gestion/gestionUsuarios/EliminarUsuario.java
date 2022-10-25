package uiMain.gestion.gestionUsuarios;

import gestorAplicacion.gestionPersonas.Usuario;
import gestorAplicacion.gestionVentas.Producto;
import gestorAplicacion.gestionVentas.Tienda;

import java.util.Scanner;

public class EliminarUsuario {
    private static int id;
    public static void eliminarUsuario(){
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("Ingrese el codigo del usuario que se quiere eliminar: ");
            id=input.nextInt();

            //Haciendo uso del metodo de eliminar una instancia de la clase usuario, se elimina el objeto con el id indicado
            boolean usuarioELiminado = Usuario.eliminarUsuario(Usuario.encontrarPersona(id));
            if (usuarioELiminado ==false){
                System.out.println("No se encontro el usuario, intente nuevamente");
            } else {
                System.out.println("Usuario Eliminado");
                //System.out.println(Usuario.getUsuarios()); Si quieren ver el uso de eliminar
                break;
            }
        }
    }
}
