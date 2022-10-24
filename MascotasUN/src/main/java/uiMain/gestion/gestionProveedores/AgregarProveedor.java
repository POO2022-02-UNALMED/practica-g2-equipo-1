package uiMain.gestion.gestionProveedores;

import gestorAplicacion.gestionPersonas.*;
import gestorAplicacion.gestionVentas.Factura;
import gestorAplicacion.gestionVentas.Producto;

import java.util.ArrayList;
import java.util.Scanner;

public class AgregarProveedor {
    public static void agregarProveedor(){
        Scanner input = new Scanner(System.in);
        System.out.println("Estas a punto de agregar un nuevo proveedor \n");
        System.out.println("Ingresa el nombre del proveedor");
        String nombre = input.next();
        System.out.println("Ingresa el ID del proveedor");
        int proveedorID= input.nextInt();
        System.out.println("Ingrese el email del proveedor");
        String email= input.next();
        System.out.println("Ingrese el telefono del proveedor");
        int telefono= input.nextInt();
        System.out.println("Ingrese el numero de la cuenta bancaria del proveedor: ");
        long nro = input.nextLong();
        System.out.println("Ingrese el saldo de la cuenta bancaria del proveedor: ");
        float saldo = input.nextFloat();
        System.out.println("Ingrese el stock del proveedor: ");
        boolean stock= input.nextBoolean();
        System.out.println("Ingrese el numero de productos que desea agregar :");
        int mas = input.nextInt();
        ArrayList<Producto> productos = new ArrayList<>();
        for (int i = 0; i <= mas; i++) {
            System.out.println("Ingrese el Id del producto");
            long mId = input.nextLong();
            System.out.println("Ingrese el nombre del producto: ");
            String nombrep = input.next();
            System.out.println("Ingrese la fecha de vencimiento del producto: ");
            String fechav = input.next();
            System.out.println("Ingrese la descripcion del producto: ");
            String descripcion = input.next();
            System.out.println("Ingrese el precio de compra: ");
            float precioc = input.nextFloat();
            System.out.println("Ingrese el precio de venta: ");
            float preciov = input.nextFloat();
            System.out.println("Ingrese la cantidad comprada: ");
            int cantidad = input.nextInt();
            System.out.println("Ingrese para que raza esta orientado el producto: ");
            String raza = input.next();
            System.out.println("Ingrese para que etapa esta orientado el producto: ");
            String etapa = input.next();
            Producto producto = new Producto(mId,nombrep,fechav,descripcion,precioc,preciov,cantidad,raza,etapa);
            productos.add(producto);
        }
        Proveedor proveedor= new Proveedor(proveedorID,nombre,email,telefono,new CuentaBancaria(nro,saldo),productos,stock);
        System.out.println("El proveedor se agrego de manera exitosa");
        proveedor.toString();
        System.out.println(proveedor);
    }
}

