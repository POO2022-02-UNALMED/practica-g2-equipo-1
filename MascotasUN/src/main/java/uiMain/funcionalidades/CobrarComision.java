package uiMain.funcionalidades;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.Map.Entry;

import baseDatos.Serializador;
import gestorAplicacion.gestionPersonas.CuentaBancaria;
import gestorAplicacion.gestionPersonas.Persona;
import gestorAplicacion.gestionPersonas.Proveedor;
import gestorAplicacion.gestionPersonas.Usuario;
import gestorAplicacion.gestionPersonas.Vendedor;
import gestorAplicacion.gestionVentas.Envio;
import gestorAplicacion.gestionVentas.Factura;
import gestorAplicacion.gestionPersonas.Mascota;
import gestorAplicacion.gestionPersonas.Gato;
import gestorAplicacion.gestionPersonas.Perro;
import gestorAplicacion.gestionVentas.Producto;
import gestorAplicacion.gestionVentas.Tienda;
import uiMain.Principal;
import uiMain.funcionalidades.CompraInventario;
import uiMain.funcionalidades.EstadisticasV;
import uiMain.funcionalidades.RealizarVenta;
import uiMain.gestion.gestionProductos.CrearProducto;
import uiMain.gestion.gestionProductos.EditarProducto;
import uiMain.gestion.gestionProductos.EliminarProducto;
import uiMain.gestion.gestionProductos.GestionProductos;
import uiMain.gestion.gestionProveedores.EliminarProveedor;
import uiMain.gestion.gestionProveedores.GestionProveedor;
import uiMain.gestion.gestionProveedores.VerProveedor;
import uiMain.gestion.gestionUsuarios.AgregarUsuario;

public class CobrarComision {
    public static void funcionalidad(){
	// Se le pregunta al vendedor si desea cobrar su comisión por las ventas realizadas
	System.out.println("¿Desea cobrar su comisión por las ventas realizadas?\n");
	Scanner input1 = new Scanner(System.in);
    int opcion;
    do {
    	System.out.println("	1. Si");
        System.out.println("	2. No, Salir \n");
        System.out.print("Indique su eleccion : ");
        opcion = input1.nextInt();
        switch (opcion) {
        
        // Se calcula y se cobra la comision
        case 1:
        	long cedula;
    		Scanner sc_cedula = new Scanner(System.in);
            System.out.println("Ingrese su cedula:" );
            cedula = sc_cedula.nextLong(); 
            Vendedor vendedorcito =Vendedor.encontrarPersona(cedula);
            if (vendedorcito==null) {
            	System.out.println("Ingresó mal su cedula, vuelva a intentarlo");
            	funcionalidad();
            }
            ArrayList<Factura> fact= vendedorcito.getVentas(); //lista de facturas del vendedor
            double a=calcularProductoMasVendido(fact);
            double b= a*Vendedor.getComision();
            System.out.println("Tus ventas totales fueron: "+a);
            System.out.println("Por lo que tus comisiones son: "+b);  
            Tienda.getCuenta().tranferir(vendedorcito.getCuenta(), (float) b , Tienda.getCuenta().getPin());
            System.out.println("Tu dinero ha sido transferido exitosamente ");
        // Se sale de la funcionalidad
        case 2:
        	Principal.salirDelSistema();
        	break;
        }
        
    }  while(opcion != 1 & opcion != 2 );
    
    
}
    public static double calcularProductoMasVendido(ArrayList<Factura> facturas) {
    	//dict donde se añade la suma de productos vendidos
    	double a=0;
		for(Factura i : facturas) {  // lista de diccionarios de facturas
			a+=i.calcularTotal();
			}
		return a;
		}

}
