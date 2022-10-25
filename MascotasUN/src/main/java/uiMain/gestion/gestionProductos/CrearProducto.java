package uiMain.gestion.gestionProductos;

import gestorAplicacion.gestionVentas.Producto;
import gestorAplicacion.gestionVentas.Tienda;

import java.util.Scanner;

public class CrearProducto {
    public static void registrarProducto(){
        Scanner input = new Scanner(System.in);
        System.out.println("Estas a punto de agregar un nuevo producto \n");
        System.out.println("Ingresa el nombre del producto");
        String nombre = input.next();
        System.out.println("Ingresa el ID del producto");
        int productoID= input.nextInt();
        System.out.println("Ingrese la fecha del vencimiento");
        String fechaV= input.next();
        System.out.println("Ingrese la descripcion del producto");
        String descripcion= input.next();
        System.out.println("Ingrese la cantidad de productos que se han comprado");
        int cantidadComprada=input.nextInt();
        System.out.println("Ingrese el precio de compra");
        float precioCompra= input.nextFloat();
        System.out.println("Ingrese el precio de venta del producto");
        float precioVenta= input.nextFloat();
        Producto producto= new Producto(productoID,nombre,fechaV,descripcion,precioCompra,precioVenta,cantidadComprada);
        Tienda.agregarProductoCatalogo(producto);
        System.out.println("El producto se agrego de manera exitosa");
        System.out.println(producto.toString());
    }
}
