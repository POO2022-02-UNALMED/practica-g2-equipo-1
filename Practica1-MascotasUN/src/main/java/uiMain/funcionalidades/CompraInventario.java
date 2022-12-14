package uiMain.funcionalidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.Map.Entry;

import gestorAplicacion.gestionPersonas.CuentaBancaria;
import gestorAplicacion.gestionPersonas.Proveedor;
import gestorAplicacion.gestionVentas.Factura;
import gestorAplicacion.gestionVentas.Producto;
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
            	imprimirOrdenado(Tienda.getValoresOrdenados(), Tienda.getInventario());
            	compraInventario(); // Va al menú para comprar el inventario
            	break;
            	
            // Se le muestra al vendedor los productos que están por agotarse, ordenado por cantidad
            case 2:
            	System.out.println("Estos son los productos en riesgo de agotarse");
            	imprimirRiesgo(Tienda.getValoresOrdenados(), Tienda.getInventario());
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
        		Factura facturita = new Factura();

            	// Se pregunta por el proveedor
        		System.out.print("¿A cuál proveedor desea comprar?\n");
                for (Proveedor i : Proveedor.getProveedores()) {
                	System.out.println("ID: " + i.getPersonaId() + ". Nombre: " + i.getNombre());
                }

					Scanner p = new Scanner(System.in);
					int opcionp;
					System.out.print("Indique el ID del proveedor a comprar: ");
					opcionp = p.nextInt(); // En opcionp se guarda el ID del proveedor
					Proveedor proveedorcito = Proveedor.encontrarPersona(opcionp);

					System.out.println("¿Qué producto desea comprar?");
					imprimirCatalogo(Tienda.getCatalogo());

					HashMap<Producto, Integer> productos = new HashMap<>(); // Se crea el HashMap que guardará los productos a comprar

					compraProducto(proveedorcito, productos, facturita);
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
	
	// Contiene el case donde se ingresan los ID y se realiza la compra
	static void compraProducto(Proveedor proveedorcito, HashMap<Producto, Integer> productos, Factura facturita) {
		// Se pide el ID del producto a comprar
		Scanner ID = new Scanner(System.in);
        Long opcion;
    	System.out.print("Indique el ID del producto a comprar: ");
    	opcion = ID.nextLong(); // En opcion se guarda el ID
    	// Se valida que el producto exista
    	if (Tienda.validarID(opcion).equals(true)) {
    		// Se pide la cantidad de productos por producto
    		Scanner num = new Scanner(System.in);
    		int cantidad;
    		System.out.print("¿Cuántos desea comprar?\n");
    		System.out.print("Indique su eleccion : ");
    		cantidad = num.nextInt();
    		productos.put(Tienda.encontrarProducto(opcion), cantidad); // Se guarda en el HashMap
    		
    		// Se pregunta si desea comprar más productos
    		Scanner num_extra = new Scanner(System.in);
    		int seleccion;
    		System.out.print("¿Desea comprar más productos?\n");
    		System.out.print("Indique su eleccion : \n");
    		do {
                System.out.println(" 1. Sí");
                System.out.println(" 2. No");
                System.out.print("Indique su eleccion : \n");
                seleccion = num_extra.nextInt();

                switch (seleccion) {
                    case 1:
                    	compraProducto(proveedorcito, productos, facturita);
                    	break;
                    case 2:
                    	//System.out.println("Proveedor: "+proveedorcito+"\n");
                    	//System.out.println("Lista productos: "+productos+"\n");
                    	//System.out.println("Pin tienda: "+Tienda.getCuenta().getPin()+"\n");
                    	int total = 0;
                    	facturita.realizarCompra(proveedorcito, productos, Tienda.getCuenta().getPin(),total);
                    	System.out.println("¡Su compra ha sido realizada con éxito!");
                    	System.out.println("Saldo actual Tienda: " + Tienda.getCuenta().getSaldo() + "\n");
                    	// Llamar al menú principal
                    	System.out.println("¿Qué desea hacer?");
                    	Scanner num_menu = new Scanner(System.in);
                		int seleccion_menu;
                		do {
                            System.out.println(" 1. Volver al menú principal");
                            System.out.println(" 2. Salir del programa");
                            System.out.print("Indique su eleccion : \n");
                            seleccion_menu = num_menu.nextInt();

                            switch (seleccion_menu) {
                                case 1:
                                	Principal.menuPrincipal();
                                	break;
                                case 2:
                                	Principal.salirDelSistema();
                                	break;
                            }
                        } while (seleccion_menu != 1 & seleccion_menu != 2);
                    	break;
                }
            } while (seleccion != 1 & seleccion != 2);
    		

    	} else {
    		System.err.println("El producto no existe\n");
    		compraProducto(proveedorcito, productos, facturita);
    	}
	}
	
	public static void imprimirOrdenado(SortedSet<Integer> valores, HashMap<Producto, Integer> inventario) {
		for(Integer i : valores) {
			for(Entry<Producto, Integer> j : inventario.entrySet()){
				if(j.getValue().equals(i)) {
					System.out.println("Producto: " + j.getKey().getNombre() + ". Cantidad: "+ j.getValue());
				}
			}
		}
	}
	
	public static void imprimirCatalogo(ArrayList<Producto> catalogo) {
		for(Producto i : catalogo) {
			System.out.println("ID: "+ i.getProductoID() + ". Producto: " + i.getNombre());
		}
		
	}
	
	public static void imprimirRiesgo(SortedSet<Integer> valores, HashMap<Producto, Integer> inventario) {
		for(Integer i : valores) {
			for(Entry<Producto, Integer> j : inventario.entrySet()){
				if(j.getValue().equals(i) & (i <= 2)) {
					System.out.println("Producto: " + j.getKey().getNombre() + ". Cantidad: "+ j.getValue());
				}
			}
		}
	}
	
}
// Saldo inicial:
// 	Tienda: 10.889.457
//	Proveedor: 20.858.968

// Dio caso de prueba:
//	Tienda: 10.193.457
//	Proveedor: 21.554.968