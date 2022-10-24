package gestorAplicacion.gestionVentas;

import gestorAplicacion.gestionPersonas.CuentaBancaria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Map.Entry;

public class Tienda implements Serializable {
	//Serializador clase tienda
	private static final long serialVersionUID = 1L;
	private static ArrayList<Tienda> tienda = new ArrayList<>();
	// Atributos
	private static ArrayList<Factura> cantidadDeVentas = new ArrayList<Factura>();
	private static ArrayList<Producto> catalogo = new ArrayList<Producto>();
	private static HashMap<Producto, Integer> inventario = new HashMap<>();
	private static HashMap<String, Integer> inventarioProductos = new HashMap<>();
	private static CuentaBancaria cuenta;
	private final float PGANANCIAS = 0.12f;
	
	// Métodos
	public static void agregarProductoCatalogo(Producto producto){
		catalogo.add(producto);
	}
	public static Producto encontrarProducto(long id) {
		for (Producto p : getCatalogo()) {
			if (p.getProductoID() == id) {
				return p;
			}
		}
		return null;
	}
	public float obtenerGanancias(){
		float f = 0.0f;
		for (Factura fact : cantidadDeVentas) {
			for (Map.Entry<Producto, Integer> entry : fact.getProductos().entrySet()) {
				Producto k = entry.getKey();
				Integer v = entry.getValue();
				f =+ k.getPrecioVenta() * v;
			}
		}
		return f*PGANANCIAS;
	}

	public static void aumentarStock(Factura factura){
		for (Map.Entry<Producto, Integer> fact : factura.getProductos().entrySet()) {
			Producto k = fact.getKey();
			Integer v = fact.getValue();
			Integer ch = inventario.get(k);
			inventario.put(k, ch + v);
		}

	}
	public static void reducirStock(Factura factura){
		for (Map.Entry<Producto, Integer> fact : factura.getProductos().entrySet()) {
			Producto k = fact.getKey();
			Integer v = fact.getValue();
			Integer ch = inventario.get(k);
			inventario.put(k, ch - v);
			inventario.put(k, ch-v);

			//metodo que hace el total del precio de la compra tomando el precio del producto por
			//la cantidad y los suma
		}
	}
	
	public static void agregarVenta(Factura f){
		cantidadDeVentas.add(f);
	}
	
	public static void imprimirOrdenado(SortedSet<Integer> valores, HashMap<String, Integer> inventarioProductos) {
		for(Integer i : valores) {
			for(Entry<String, Integer> j : inventarioProductos.entrySet()){
				if(j.getValue().equals(i)) {
					System.out.println("Producto: " + j.getKey() + ". Cantidad: "+ j.getValue());
				}
			}
		}
	}
	
	public static void imprimirCatalogo(ArrayList<Producto> catalogo) {
		for(Producto i : catalogo) {
			System.out.println("ID: "+ i.getProductoID() + ". Producto: " + i.getNombre());
		}
		
	}
	
	public static void imprimirRiesgo(SortedSet<Integer> valores, HashMap<String, Integer> inventarioProductos) {
		for(Integer i : valores) {
			for(Entry<String, Integer> j : inventarioProductos.entrySet()){
				if(j.getValue().equals(i) & (i <= 2)) {
					System.out.println("Producto: " + j.getKey() + ". Cantidad: "+ j.getValue());
				}
			}
		}
	}
	
	public static Boolean validarID(Long opcion){
		for (Producto i : getCatalogo()) {
    		if (opcion.equals((Long)i.getProductoID())) {
    			return true;
            }
        } return false;
    }
	
	public static SortedSet<Integer> getValoresOrdenados() {
        SortedSet<Integer> valores = new TreeSet<Integer>(inventarioProductos.values());
        return valores; // [1, 2, 3, 4, 5, 7]
    }
	
	//Getters y Setters
		// Creamos el getter y setter de Tienda para el serializador
	public static ArrayList<Tienda> getTienda() {
		return tienda;
	}

	public static void setTienda(ArrayList<Tienda> tienda) {
		Tienda.tienda=tienda;
	}

	public static int getCantidadDeVentas() {
		return cantidadDeVentas.size();
	}
	
	public static void setCantidadDeVentas(ArrayList<Factura> cantidadDeVentas) {
		Tienda.cantidadDeVentas = cantidadDeVentas;
	}

	public static ArrayList<Producto> getCatalogo() {
		return catalogo;
	}
	
	public static void setCatalogo(ArrayList<Producto> catalogo) {
		Tienda.catalogo = catalogo;
	}

	public static HashMap<Producto, Integer> getInventario() {
		return inventario;
	}

	public static void setInventario(HashMap<Producto, Integer> inventario) {
		Tienda.inventario = inventario;
	}
	

	public static HashMap<String, Integer> getInventarioProductos() {
		return inventarioProductos;
	}

	public static void setInventarioProductos(HashMap<String, Integer> inventarioProductos) {
		Tienda.inventarioProductos = inventarioProductos;
	}

	public static CuentaBancaria getCuenta() {
		return cuenta;
	}
	
	public static void setCuenta(CuentaBancaria cuenta) {
		Tienda.cuenta = cuenta;
	}

	public float getPGANANCIAS() {
		return PGANANCIAS;
	}
}
