package uiMain.gestion.gestionVendedores;

import java.util.Scanner;

public class GestionVendedores {
    private static int opcion;
    public static void gestionarVendedores() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Estas a punto de acceder a la gestion de tus companeros de trabajo");
            System.out.println("Que deseas hacer?");
            System.out.println(" 1. Ver vendedor");
            System.out.println(" 2. Agregar nuevo vendedor");
            System.out.println(" 3. Regresar");
            opcion = input.nextInt();

            switch (opcion) {
                case 1: ; VerVendedor.verVendedor(); break;
                case 2: ; CrearVendedor.agregarVendedor(); break;
                case 3: break;
            }
        } while (opcion != 3);
    }
}
