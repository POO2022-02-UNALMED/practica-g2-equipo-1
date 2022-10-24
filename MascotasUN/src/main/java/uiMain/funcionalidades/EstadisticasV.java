package uiMain.funcionalidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.Map.Entry;

import gestorAplicacion.gestionPersonas.CuentaBancaria;
import gestorAplicacion.gestionPersonas.Proveedor;
import gestorAplicacion.gestionPersonas.Vendedor;
import gestorAplicacion.gestionVentas.Factura;
import gestorAplicacion.gestionVentas.Producto;
import gestorAplicacion.gestionVentas.Tienda;
import uiMain.Principal;

public class EstadisticasV {
    public static void funcionalidad(){
    	// Se le pregunta al vendedor si desea ver las estadísticas generales desea observar
    			System.out.println("¿Qué estadísticas generales desea observar?\n");
    			Scanner input1 = new Scanner(System.in);
    	        int opcion;
    	        do {
    	        	System.out.println("	1. Número de ventas por vendedor");
    	            System.out.println("	2. Producto más vendidos");
    	            System.out.println("	3. Clientes destacados");
    	            System.out.println("	4. Ganancias actuales de la tienda");
    	            System.out.print("Indique su eleccion : ");
    	            opcion = input1.nextInt();
    	            switch (opcion) {
    	            
    	            // Se le muestra al vendedor las ventas por vendedor, ordenados de mmayor a menor
    	            case 1:
    	            	System.out.println("Estas son las ventas por vendedor");
    	            	imprimirVentas(Vendedor.getValoresOrdenados(), Vendedor.getCantidadVentas());
    	            	break;
    	            	
    	            // Se le muestra al vendedor los productos más vendidos, ordenados de mayor a menor
    	            case 2:
    	            	System.out.println("Estos son los productos más vendidos");

    	            	break;
    	            // Se le muestra al vendedor los clientes destacados, ordenado de mmayor a menor
    	            case 3:
    	            	System.out.println("Estos son los clientes destacados");

    	            	break;
    	            	
    	            // Se le muestra al vendedor los productos que están por agotarse, ordenado por cantidad
    	            case 4:
    	            	System.out.println("Estoas son las ganancias actuales de la tienda");

    	            	break;
    	            }
    	        }  while(opcion != 1 & opcion != 2 & opcion != 3 & opcion != 4);
    		}
    public static void imprimirVentas(SortedSet<Integer> valores, HashMap<String, Integer> ventas) {
		for(Integer i : valores) {
			for(Entry<String, Integer> j : ventas.entrySet()){
				if(j.getValue().equals(i)) {
					System.out.println("Vendedor: " + j.getKey() + ". Cantidad: "+ j.getValue());
				}
			}
		}
		
	}
    
}

