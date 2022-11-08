/*Esta clase se encarga de gestionar las clases que sirven para agregar, eliminar o ver un usuario*/

package uiMain.gestion.gestionUsuarios;

import java.util.Scanner;

public class GestionUsuarios {
    private static int opcion;
    public static void gestionarUsuarios() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Estas a punto de gestionar tus usuarios");
            System.out.println("Que deseas hacer?");
            System.out.println(" 1. Ver usuarios");
            System.out.println(" 2. Agregar nuevo usuario");
            System.out.println(" 3. Eliminar usuario");
            System.out.println(" 4. Regresar");
            opcion = input.nextInt();

            switch (opcion) {
                case 1: ; VerUsuario.verUsuario(); break;
                case 2: ; CrearUsuario.crearUsuario(); break;
                case 3: ; EliminarUsuario.eliminarUsuario(); break;
                case 4: break;
            }
        } while (opcion != 4);
    }
}
