/*Esta clase se encarga de registrar un nuevo objeto de la clase producto y agregarlo al catalogo de
la tienda
 */

package uiMain.gestion.gestionProductos;

import gestorAplicacion.gestionVentas.Producto;
import gestorAplicacion.gestionVentas.Tienda;

import java.util.Scanner;


public class CrearProducto {
    public static void registrarProducto(){
        Scanner input = new Scanner(System.in);
        System.out.println("Estas a punto de agregar un nuevo producto \n");
        System.out.println("Ingresa el nombre del producto");
        String nombre = input.nextLine();
        System.out.println("Ingresa el ID del producto");
        long productoID= input.nextLong();
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
        //Se crea el nuevo objeto de la clase producto
        Producto producto= new Producto(productoID,nombre,fechaV,descripcion,precioCompra,precioVenta,cantidadComprada);
        //Se agrega el producto creado a la lista de productos existente en catalogo
        Tienda.agregarProductoCatalogo(producto);
        Producto.agregarProducto(producto);
        System.out.println("El producto se agrego de manera exitosa");
        //Se hace el toString para imprimir los atributos del objeto y no la referencia
        System.out.println(producto.toString());
    }
}
ca
