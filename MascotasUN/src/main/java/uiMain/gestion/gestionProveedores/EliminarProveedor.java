package uiMain.gestion.gestionProveedores;

import gestorAplicacion.gestionPersonas.Usuario;

import java.util.Scanner;

public class EliminarProveedor {
    private static int id;
    public static void eliminarProveedor(){
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("Ingrese el codigo del usuario que se quiere eliminar: ");
            id=input.nextInt();

            boolean usuarioELiminado = Usuario.eliminarUsuario(Usuario.encontrarPersona(id));
            if (usuarioELiminado ==false){
                System.out.println("No se encontro el usuario, intente nuevamente");
            } else {
                System.out.println("Usuario Eliminado");
                break;
            }
        }
    }
}
