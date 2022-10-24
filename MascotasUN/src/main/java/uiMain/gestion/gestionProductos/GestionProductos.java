package uiMain.gestion.gestionProductos;

import java.util.Scanner;

public class GestionProductos {
    private static int opcion;
    public static void GestionarProductos() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Estas a punto de gestionar tus productos");
            System.out.println("¿Que deseas hacer?");
            System.out.println(" 1. Ver productos");
            System.out.println(" 2. Agregar nuevo producto");
            System.out.println(" 3. Eliminar producto");
            System.out.println(" 4. Editar producto existente");
            System.out.println(" 5. Regresar");
            opcion = input.nextInt();

            switch (opcion) {
                case 1: ; VerProducto.verProducto(); break;
                case 2: ; AgregarProducto.registrarProducto(); break;
                case 3: ; EliminarProducto.eliminarProducto(); break;
                case 4: ; EditarProducto.editarProducto(); break;
                case 5: break;
            }
        } while (opcion != 5);
    }
}
