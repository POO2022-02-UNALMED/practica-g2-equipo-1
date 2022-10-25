package uiMain.funcionalidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Map.Entry;

import gestorAplicacion.gestionPersonas.CuentaBancaria;
import gestorAplicacion.gestionPersonas.Proveedor;
import gestorAplicacion.gestionPersonas.Vendedor;
import gestorAplicacion.gestionPersonas.Usuario;
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
    	            System.out.println("	5. Salir");
    	            System.out.print("Indique su eleccion : ");
    	            opcion = input1.nextInt();
    	            switch (opcion) {
    	            
    	            // Se le muestra al vendedor las ventas por vendedor, ordenados de mmayor a menor
    	            case 1:
    	            	System.out.println("Estas son las ventas por vendedor");
    	            	imprimirVentas(Vendedor.getValoresOrdenados(), Vendedor.getCantidadVentas());
    	            	
    	            // Se le muestra al vendedor los productos más vendidos, ordenados de mayor a menor
    	            case 2:
    	            	System.out.println("Estos son los productos más vendidos");
    	            	Tienda.getVentas(); //lista de facturas de la tienda
    	               	HashMap<Producto, Integer> ventas = new HashMap<Producto, Integer>();
    	               	Producto productoprueba = new Producto(1, "P", "18/01/2024", "Comida seca para gato adulto", 7000, 10000, 2, "Adulto", "Gato");;
    	               	ventas.put(productoprueba,1);
    	               	HashMap<Producto, Integer> ventas2 = calcularProductoMasVendido(Tienda.getVentas(), ventas);
    	               	SortedSet<Integer> valores= getValoresOrdenados(ventas2);
    	               	imprimirProductos(valores, ventas2);
    	            	break;
    	            // Se le muestra al vendedor los clientes destacados, ordenado de mmayor a menor
    	            case 3:
    	            	System.out.println("Estos son los clientes destacados");
    	            	imprimirClientes(Usuario.getUsuarios());
    	            	break;
    	            	
    	            // Se le muestra al vendedor los productos que están por agotarse, ordenado por cantidad
    	            case 4:
    	            	System.out.println("Estoas son las ganancias actuales de la tienda");

    	            	break;
    	            
		            case 5:
		           		Principal.salirDelSistema();
		            	break;
		            }
    	            
    	        }  while(opcion != 1 & opcion != 2 & opcion != 3 & opcion != 4 & opcion != 5);
    		}
    
    
    public static void imprimirVentas(SortedSet<Integer> valores, HashMap<String, Integer> ventas) {
		for(Integer i : valores) {
			for(Entry<String, Integer> j : ventas.entrySet()){
				if(j.getValue().equals(i)) {
					System.out.println("Vendedor: " + j.getKey() + ". Cantidad: "+ j.getValue());
				}
			}
		}
		System.out.println("");
		funcionalidad();
	}
    
    public static HashMap<Producto, Integer> calcularProductoMasVendido(ArrayList<Factura> facturas, HashMap<Producto, Integer> ventas ) {
    	//dict donde se añade la suma de productos vendidos
		for(Factura i : facturas) {  // lista de diccionarios de facturas
			for(Entry<Producto, Integer> k : i.getProductos().entrySet()){//dict de productos vendidos
				for(Entry<Producto, Integer> j :  ventas.entrySet()){  //dict de productos totales
					if(k.getKey().getNombre().equals(j.getKey().getNombre())) {
						Integer a=k.getValue();
						Integer b=j.getValue();
						Integer c=b+a+5;
						System.out.println("esta es a: "+ a+"\n");
						System.out.println("esta es b: "+ b+"\n");
						System.out.println("esta es c: "+ c+"\n");
						
						ventas.put(k.getKey(),c);
						 
					}
					
					} ventas.put(k.getKey(), k.getValue());

					ventas.keySet().removeIf(key -> key.getNombre() =="P");
					
				} 
			
			}
		return ventas;
		}
	public static void imprimirProductos(SortedSet<Integer> valores, HashMap<Producto, Integer> inventarioProductos) {
		for(Integer i : valores) {
			for(Entry<Producto, Integer> j : inventarioProductos.entrySet()){
				if(j.getValue().equals(i)) {
					System.out.println("Producto: " + j.getKey().getProductoID() + ". Cantidad: "+ j.getValue());
				}
			}
		}
	}
	
	public static void imprimirClientes(ArrayList<Usuario> clientes ) {
		for(Usuario i : clientes) {
			int a=i.getCompras().size();
			System.out.println("Cliente: " + i.getNombre() + ". Cantidad: "+ a) ;
			}
		}
    
	public static SortedSet<Integer> getValoresOrdenados(HashMap<Producto, Integer> inventarioProductos) {
        SortedSet<Integer> valores = new TreeSet<Integer>(inventarioProductos.values());
        return valores; // Retorna una lista como [1, 2, 3, 4, 5, 7], que se utiliza en la funcionalidad
    }
	
	public static void impresionPrueba(HashMap<Producto, Integer> inventarioProductos) {
		for(Entry<Producto, Integer> j : inventarioProductos.entrySet()){
				System.out.println("Producto: " + j.getKey().getNombre() + ". Cantidad: "+ j.getValue());
		}
	}
	

    
}

