package uiMain.gestion.gestionProveedores;

import java.util.Scanner;

public class GestionProveedor {
    private static int opcion;
    public static void GestionarUsuarios() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Estas a punto de gestionar tus proveedores");
            System.out.println("¿Que deseas hacer?");
            System.out.println(" 1. Ver proveedores");
            System.out.println(" 2. Agregar nuevo proveedor");
            System.out.println(" 3. Eliminar proveedor");
            System.out.println(" 4. Regresar");
            opcion = input.nextInt();

            switch (opcion) {
                case 1: ; VerProveedor.verProveedor(); break;
                case 2: ; AgregarProveedor.agregarProveedor(); break;
                case 3: ; EliminarProveedor.eliminarProveedor(); break;
                case 4: break;
            }
        } while (opcion != 4);
    }
}
