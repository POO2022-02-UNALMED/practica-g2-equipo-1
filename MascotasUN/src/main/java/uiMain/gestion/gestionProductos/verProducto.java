package uiMain.gestion.gestionProductos;

import gestorAplicacion.gestionVentas.Producto;
import gestorAplicacion.gestionVentas.Tienda;

import java.util.Scanner;

public class verProducto {
    private static int opcion;
    private static int id;
    public static void verProducto(){
        Scanner input =new Scanner(System.in);
        do {
            System.out.println("Estas a punto de ver tus productos ");
            System.out.println("1. Para ver un producto en especifico");
            System.out.println("2. Para ver la lista completa de tus productos");
            opcion=Integer.parseInt(input.nextLine());
            switch (opcion){
                case 1:
                    System.out.println("Cuantos productos desea ver");
                    int cantidad=input.nextInt();
                    while(true){
                        System.out.println("Ingrese el codigo del producto que quiere ver: ");
                        id=input.nextInt();
                        Producto producto=Tienda.encontrarProducto(id);
                        System.out.println(producto.toString());
                        }

                    }


            }
        }
    }
}
