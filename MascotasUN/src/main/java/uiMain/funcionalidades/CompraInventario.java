package uiMain.funcionalidades;

import java.util.HashMap;
import java.util.Scanner;

import gestorAplicacion.gestionPersonas.CuentaBancaria;
import gestorAplicacion.gestionPersonas.Proveedor;
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
            	compraProducto();
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
	static void compraProducto() {
		// Se pide el ID del producto a comprar
		Scanner ID = new Scanner(System.in);
        Long opcion;
        System.out.print("¿A cuál proveedor desea comprar?");
        int j = 0;
        for (Proveedor i : Proveedor.getProveedores()) {
        	++j;
        	System.out.println(j + ". " + i.getNombre());
        }
        
        
    	System.out.print("Indique el ID del producto a comprar: ");
    	opcion = ID.nextLong(); // En opcion se guarda el ID
    	HashMap<Producto, Integer> productos = new HashMap<>(); // Se crea el HashMap que guardará los productos a comprar
    	// Se valida que el producto exista
    	if (Tienda.validarID(opcion).equals(true)) {
    		// Se pide la cantidad de productos por producto
    		Scanner num = new Scanner(System.in);
    		int cantidad;
    		System.out.print("¿Cuántos desea comprar?");
    		cantidad = num.nextInt();
    		productos.put(Tienda.encontrarProducto(opcion), cantidad); // Se guarda en el HashMap
    		// Se pregunta si desea comprar más productos
    		Scanner num_extra = new Scanner(System.in);
    		int seleccion;
    		System.out.print("¿Desea comprar más productos?");
    		do {
                System.out.println(" 1. Sí");
                System.out.println(" 2. No");
                System.out.print("Indique su eleccion : ");
                seleccion = num_extra.nextInt();

                switch (seleccion) {
                    case 1:
                    	break;
                    case 2:
                    	//////realizarCompra(proveedor, productos, Tienda.getCuenta().getPin());
                    	break;
                }
            } while (seleccion != 1 & seleccion != 2);
    		
    		
    		
    		// Indique cuántos del ID quiere comprar. Se guarda en un HashMap
    		// ¿Quiere más? Si sí, en el hashmap creado. Si no, solo calcula con uno solito
    		
    		// Guardar el objeto
    		// Preguntar a qué proveedor (aunque haya uno) para seleccionar el objeto
    		// Preguntar el número de cantidad a comprar y calcular el monto multiplicandoo = monto
    		//////realizarCompra(proveedor, HashMap<Producto, Integer> productos, Tienda.getCuenta().getPin());
    		// Se realiza la compra:
    		// 	1. Quitarle plata a la tienda
    		//	2. Aumentarle plata al proveedor
    		//	3. Aumentar la cantidad del producto seleccionado
    		//	print: Plata tienda, Plata proveedor, inventario
    		// Preguntar si quiere comprar más.
    	} else {
    		System.err.println("El producto no existe\n");
			compraProducto();
    	}
	}
}