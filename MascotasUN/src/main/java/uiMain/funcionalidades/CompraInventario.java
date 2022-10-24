package uiMain.funcionalidades;

import java.util.Scanner;

import gestorAplicacion.gestionVentas.Tienda;

public class CompraInventario {
	public static void funcionalidad() {
		System.out.println("¿Quieres ver el inventario completo o los productos en riesgo?");
		Scanner input1 = new Scanner(System.in);
        int opcion;
        do {
        	System.out.println("	1. Ver inventario completo");
            System.out.println("	2. Ver productos con bajo stock");
            System.out.print("Indique su eleccion : ");
            opcion = input1.nextInt();
            
            switch (opcion) {
            case 1:
            	System.out.println("Este es su inventario actual");
            	Tienda.imprimirOrdenado(Tienda.getValoresOrdenados(), Tienda.getInventarioProductos()); break;
            case 2: 
            	//funcionalidades.CompraInventario.funcionalidad() ; break;
            }
        }  while (opcion != 2);
 
		
		// Imprimir lista de inventario ordenado por cantidadComprada
		System.out.println("¿Desea comprar inventario?");
	}
}