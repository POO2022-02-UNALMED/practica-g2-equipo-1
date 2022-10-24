package uiMain.gestion.gestionVendedores;

import java.util.Scanner;

public class GestionVendedores {
    private static int opcion;
    public static void GestionarVendedores() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Estas a punto de gestionar tus productos");
            System.out.println("¿Que deseas hacer?");
            System.out.println(" 1. Ver productos");
            System.out.println(" 2. Agregar nuevo producto");
            System.out.println(" 3. Editar producto existente");
            System.out.println(" 4. Regresar");
            opcion = input.nextInt();

            switch (opcion) {
                case 1: ; VerVendedor.verVendedor(); break;
                case 2: ; AgregarVendedor.agregarVendedor(); break;
                case 3: ; EditarVendedor.editarVendedor(); break;
                case 4: break;
            }
        } while (opcion != 4);
    }
}
