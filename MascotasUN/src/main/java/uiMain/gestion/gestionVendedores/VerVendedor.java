package uiMain.gestion.gestionVendedores;

import gestorAplicacion.gestionPersonas.Vendedor;
import gestorAplicacion.gestionVentas.Producto;
import gestorAplicacion.gestionVentas.Tienda;

import java.util.ArrayList;
import java.util.Scanner;

public class VerVendedor {
    private static int opcion;
    private static int id;
    public static void verVendedor(){
        Scanner input =new Scanner(System.in);
        do {
            System.out.println("Estas a punto de ver algunos datos de tus compañeros de laburo");
            System.out.println("1. Para ver un compañero en especifico");
            System.out.println("2. Para ver la lista completa de tus compañeros");
            System.out.println("3. Volver");
            opcion=input.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Cuantos compañeros desea ver");
                    int cantidad=input.nextInt();
                    for(int i=1;i<=cantidad;i++){
                        System.out.println("Ingrese el codigo del compañero que quiere ver: ");
                        id=input.nextInt();
                        Vendedor vendedor= Vendedor.encontrarPersona(id);
                        System.out.println(vendedor.toString());
                        }
                    break;
                case 2:
                    System.out.println("Esta es la lista completa de tus compañeros");
                    System.out.println(Vendedor.getVendedores().toString());
                    break;
                case 3:
                    break;
            }
        } while(opcion != 3);
    }
}

