package uiMain.gestion.gestionProveedores;

import gestorAplicacion.gestionPersonas.Proveedor;
import gestorAplicacion.gestionPersonas.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class VerProveedor {
    private static int opcion;
    private static int id;
    public static void verProveedor(){
        Scanner input =new Scanner(System.in);
        do {
            System.out.println("Estas a punto de ver tus proveedores");
            System.out.println("1. Para ver un proveedor en especifico");
            System.out.println("2. Para ver la lista completa de tus proveedores");
            System.out.println("3. Volver");
            opcion=input.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Cuantos proveedores desea ver");
                    int cantidad=input.nextInt();
                    for(int i=1;i<=cantidad;i++){
                        System.out.println("Ingrese el codigo del proveedor que quiere ver: ");
                        id=input.nextInt();
                        Proveedor proveedor= Proveedor.encontrarPersona(id);
                        System.out.println(proveedor.toString());
                        }
                    break;
                case 2:
                    System.out.println("Esta es la lista completa de tus proveedores");
                    System.out.println(Proveedor.getProveedores().toString());;
                    break;
                case 3:
                    break;
            }
        } while(opcion != 3);
    }
}

