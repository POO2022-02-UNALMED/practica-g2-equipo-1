package uiMain.funcionalidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.Collections;
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
    	            System.out.println("	2. Productos más vendidos");
    	            System.out.println("	3. Clientes destacados");
    	            System.out.println("	4. Salir \n");
    	            System.out.print("Indique su eleccion : ");
    	            opcion = input1.nextInt();
    	            switch (opcion) {
    	            
    	            // Se le muestra al vendedor las ventas por vendedor
    	            case 1:
    	            	System.out.println("Estas son las ventas por vendedor");
    	            	imprimirVentas(Vendedor.getValoresOrdenados(), Vendedor.getCantidadVentas());
    	            	
    	            // Se le muestra al vendedor los productos más vendidos
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
    	            // Se le muestra al vendedor los clientes destacados
    	            case 3:
    	            	System.out.println("Estos son los clientes destacados");
    	            	//imprimirClientes(Usuario.getUsuarios());
    	            	ArrayList<Integer> listita=lista(Usuario.getUsuarios());
    	            	//SortedSet<Integer> orden = getValoresOrdenados2(listita);
    	            	imprimirClientes2(listita,Usuario.getUsuarios());
    	            	
    	            	break;
    	            	
		            case 4:
		           		Principal.salirDelSistema();
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
		System.out.println("");
		funcionalidad();
	}
    
    public static HashMap<Producto, Integer> calcularProductoMasVendido(ArrayList<Factura> facturas, HashMap<Producto, Integer> ventas ) {
    	//dict donde se añade la suma de productos vendidos
		for(Factura i : facturas) {  // lista de diccionarios de facturas
			for(Entry<Producto, Integer> k : i.getProductos().entrySet()){//dict de productos vendidos
				int z=0;
				for(Entry<Producto, Integer> j :  ventas.entrySet()){  //dict de productos totales
					if(k.getKey().getNombre().equals(j.getKey().getNombre())) {
						Integer a=k.getValue();
						Integer b=j.getValue();
						Integer c=b+a;
						z=1;
						ventas.put(k.getKey(),c);
						 
					}
					
					} if (z!=1) {ventas.put(k.getKey(), k.getValue());

					ventas.keySet().removeIf(key -> key.getNombre() =="P");
					}
					
				} 
			
			}
		return ventas;
		}
    
    
	public static void imprimirProductos(SortedSet<Integer> valores, HashMap<Producto, Integer> inventarioProductos) {
		for(Integer i : valores) {
			for(Entry<Producto, Integer> j : inventarioProductos.entrySet()){
				if(j.getValue().equals(i)) {
					System.out.println("Producto: " + j.getKey().getNombre() + ". Cantidad: "+ j.getValue());
				}
			}
		}
		System.out.println("");
		funcionalidad();
	}
	
	
	public static ArrayList<Integer> lista(ArrayList<Usuario> clientes) {
		ArrayList<Integer> listita=new ArrayList<Integer>();
		for(Usuario i : clientes) {			
			int a=i.getCompras().size();
			if (listita.contains(a)) {}
			else{ listita.add(a);}
		}
		Collections.sort(listita, Collections.reverseOrder());
		return listita;
	}
	
	public static void imprimirClientes2(ArrayList<Integer> cant, ArrayList<Usuario> clientes) {
		for(Integer i : cant) {
			for(Usuario j : clientes){
				if((j.getCompras().size()==i)) {
					System.out.println("Cliente: " + j.getNombre() + ". Cantidad: "+ i);
				}
			}
		}
		System.out.println("");
		funcionalidad();
	}
    
	public static SortedSet<Integer> getValoresOrdenados(HashMap<Producto, Integer> inventarioProductos) {
        SortedSet<Integer> valores = new TreeSet<Integer>(inventarioProductos.values());
        return valores; // Retorna una lista como [1, 2, 3, 4, 5, 7], que se utiliza en la funcionalidad
    }
	

	
	

    
}

