package uiMain.gestion.gestionVendedores;

import gestorAplicacion.gestionPersonas.CuentaBancaria;
import gestorAplicacion.gestionPersonas.Vendedor;
import gestorAplicacion.gestionVentas.Factura;

import java.util.ArrayList;
import java.util.Scanner;

public class CrearVendedor {
    public static void agregarVendedor(){
        Scanner input = new Scanner(System.in);
        System.out.println("Estas a punto de agregar un nuevo vendedor \n");
        System.out.println("Ingresa el nombre del vendedor");
        String nombre = input.next();
        System.out.println("Ingresa el ID del vendedor");
        int vendedorID= input.nextInt();
        System.out.println("Ingrese el email del vendedor");
        String email= input.next();
        System.out.println("Ingrese el telefono del vendedor");
        int telefono= input.nextInt();
        System.out.println("Ingrese el numero de la cuenta bancaria del vendedor: ");
        long nro = input.nextLong();
        System.out.println("Ingrese el saldo de la cuenta bancaria del vendedor: ");
        float saldo = input.nextFloat();
        System.out.println("Ingrese el usuario del vendedor");
        String usuario= input.next();
        System.out.println("Ingrese el contraseña del vendedor");
        String contrasena= input.next();
        Vendedor vendedor= new Vendedor(vendedorID,nombre,email,telefono,new ArrayList<Factura>(),usuario,contrasena,new CuentaBancaria(nro,saldo));
        Vendedor.agregarVendedor(vendedor);
        System.out.println("El vendedor se registro de manera exitosa");
        vendedor.toString();
        System.out.println(vendedor);
    }
}
