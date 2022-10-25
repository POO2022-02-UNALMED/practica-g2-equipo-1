package uiMain.funcionalidades;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedSet;

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
        
        // Se le muestra al vendedor las ventas por vendedor, ordenados de mmayor a menor
        case 1:

        	
        // Se le muestra al vendedor los productos más vendidos, ordenados de mayor a menor
        case 2:

        	break;
   
        }
        
    }  while(opcion != 1 & opcion != 2 );
}

}
