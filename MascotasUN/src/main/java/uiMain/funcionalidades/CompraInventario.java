package uiMain.funcionalidades;

import java.util.Scanner;

import gestorAplicacion.gestionVentas.Tienda;
import uiMain.Principal;

public class CompraInventario {
	public static void funcionalidad() {
		
		// Se le pregunta al vendedor si desea ver el inventario completo o solo los productos que se van a agotar
		System.out.println("¿Quieres ver el inventario completo o los productos en riesgo de agotarse?");
		Scanner input1 = new Scanner(System.in);
        int opcion;
        do {
        	System.out.println("	1. Ver inventario completo");
            System.out.println("	2. Ver productos en riesgo de agotarse");
            System.out.print("Indique su eleccion : ");
            opcion = input1.nextInt();
            switch (opcion) {
            
            // Se le muestra al vendedor el inventario completo, ordenado por cantidad
            case 1:
            	System.out.println("Este es su inventario actual");
            	Tienda.imprimirOrdenado(Tienda.getValoresOrdenados(), Tienda.getInventarioProductos());
            	compraInventario(); // Va al menú para comprar el inventario
            	break;
            	
            // Se le muestra al vendedor los productos que están por agotarse, ordenado por cantidad
            case 2:
            	System.out.println("Estos son los productos en riesgo de agotarse");
            	Tienda.imprimirRiesgo(Tienda.getValoresOrdenados(), Tienda.getInventarioProductos());
            	compraInventario(); // Va al menú para comprar el inventario
            	break;
            }
        }  while(opcion != 1 & opcion != 2);
	}
	
	/* Menú para el vendedor comprar inventario */
	static void compraInventario(){
		System.out.println("¿Desea comprar inventario?");
		Scanner input2 = new Scanner(System.in);
        int opcion;
        do {
        	System.out.println("	1. Sí");
            System.out.println("	2. No");
            System.out.println("	3. Volver");
            System.out.print("Indique su eleccion : ");
            opcion = input2.nextInt();
            switch (opcion) {
            
            // Funcionalidad como tal con método
            case 1:
            	System.out.println("¿Qué producto desea comprar?");
            	Tienda.imprimirCatalogo(Tienda.getCatalogo());
            	System.out.print("Indique el ID del producto a comprar: ");
            	compraProducto();
            	// Pedir al vendedor que ingrese el ID
            	// Hacer una lista de IDs, si el que ingresa la persona está en la lista, hace la compra
            	// Pedir la cantidad del producto que se va a comprar
            	// Realizar la compra
            	// ¿Quiere hacer otra compra? Si no: Thanks. Si sí: Volver a llamar.
            	break;
            	
            // Devuelve al vendedor al menú principal
            case 2:
            	Principal.menuPrincipal();
            	break;
            	
            // Devuelve al vendedor al menú anterior
            case 3:
            	funcionalidad();
            	break;
            }
        }  while(opcion != 1 & opcion != 2 & opcion != 3);	
	}
	
	// Contiene el case donde se ingresa el ID y se realiza la compra
	static void compraProducto() {
		
	}
}