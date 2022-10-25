package uiMain.gestion.gestionProductos;

import gestorAplicacion.gestionVentas.Producto;
import gestorAplicacion.gestionVentas.Tienda;

import java.util.ArrayList;
import java.util.Scanner;

public class VerProducto {
    private static int opcion;
    private static int id;
    public static void verProducto(){
        Scanner input =new Scanner(System.in);
        do {
            System.out.println("Estas a punto de ver tus productos ");
            System.out.println("1. Para ver un producto en especifico");
            System.out.println("2. Para ver la lista completa de tus productos");
            System.out.println("3. Volver");
            opcion= input.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Cuantos productos desea ver");
                    int cantidad=input.nextInt();
                    for(int i=1;i<=cantidad;i++){
                        System.out.println("Ingrese el codigo del producto que quiere ver: ");
                        id=input.nextInt();
                        Producto producto=Tienda.encontrarProducto(id);
                        System.out.println(producto.toString());
                        }
                    break;
                case 2:
                    System.out.println("Esta es la lista completa de tus productos");
                    imprimirCatalogo(Tienda.getCatalogo());
                    break;
                case 3:
                    break;
            }
        } while(opcion != 3);
    }
    public static void imprimirCatalogo(ArrayList<Producto> catalogo) {
        for(Producto i : catalogo) {
            System.out.println("ID: "+ i.getProductoID() + ". Producto: " + i.getNombre() + ". Cantidad: " + i.getCantidadComprada());
        }
    }
}

