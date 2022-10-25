/*Clase desde la cual se gestiona la inteligencia de negocio de la tienda, desde la parte económica y 
 * de inventario, hasta las estadísticas relacionadas con ello*/

package gestorAplicacion.gestionVentas;

import gestorAplicacion.gestionPersonas.CuentaBancaria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

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
	
	// Métodos
	
	// Método que agrega un producto nuevo al catálogo de productos ofrecido por la tienda
	public static void agregarProductoCatalogo(Producto producto){
		catalogo.add(producto);
	}
	
	// Método que encuentra y retorna un producto del catálogo de la tienda dado su ID
	public static Producto encontrarProducto(long id) {
		for (Producto p : getCatalogo()) {
			if (p.getProductoID() == id) {
				return p;
			}
		}
		return null;
	}


	// Método que aumenta la cantidad de productos de un producto de la tienda
	public static void aumentarStock(Factura factura){
		for (Map.Entry<Producto, Integer> fact : factura.getProductos().entrySet()) {
			Producto k = fact.getKey();
			Integer v = fact.getValue();
			Integer ch = inventario.get(k);
			inventario.put(k, ch + v);
		}

	}
	
	// Método que reduce la cantidad de productos de un producto de la tienda
	public static void reducirStock(Factura factura){
		for (Map.Entry<Producto, Integer> fact : factura.getProductos().entrySet()) {
			Producto k = fact.getKey();
			Integer v = fact.getValue();
			Integer ch = inventario.get(k);
			inventario.put(k, ch - v);
			inventario.put(k, ch - v);
		}
	}
	
	// Método que agrega una venta a la lista de ventas realizadas por la tienda
	public static void agregarVenta(Factura f){
		cantidadDeVentas.add(f);
	}
	
	// Método que valida el ID ingresado con el ID correspondiente del catálogo
	public static Boolean validarID(Long opcion){
		for (Producto i : getCatalogo()) {
    		if (opcion.equals((Long)i.getProductoID())) {
    			return true;
            }
        } return false;
    }
	
	// Método para ordenar el HashMap del inventario por su valor
	public static SortedSet<Integer> getValoresOrdenados() {
        SortedSet<Integer> valores = new TreeSet<Integer>(inventarioProductos.values());
        return valores; // Retorna una lista como [1, 2, 3, 4, 5, 7], que se utiliza en la funcionalidad
    }
	
	//Getters y setters
	
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
}