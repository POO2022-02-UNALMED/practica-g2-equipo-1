package gestorAplicacion.gestionVentas;

import gestorAplicacion.gestionPersonas.CuentaBancaria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tienda implements Serializable {
	//Serializador clase tienda
	private static final long serialVersionUID = 1L;
	private static ArrayList<Tienda> tienda = new ArrayList<>();
	// Atributos
	private static ArrayList<Factura> cantidadDeVentas = new ArrayList<Factura>();
	private static ArrayList<Producto> catalogo = new ArrayList<Producto>();
	private static HashMap<Producto, Integer> inventario = new HashMap<>();
	private static CuentaBancaria cuenta;
	private final float PGANANCIAS = 0.12f;

	//Getters y Setters
	// Creamos el getter y setter de Tienda para el serializador
	public static ArrayList<Tienda> getTienda() {
		return tienda;
	}

	public static void setTienda(ArrayList<Tienda> tienda) {
		Tienda.tienda=tienda;
	}
	
	// Métodos
	public float obtenerGanancias(){
		float f = 0.0f;
		for (Factura fact : cantidadDeVentas) {
			for (Map.Entry<Producto, Integer> entry : fact.getProductos().entrySet()) {
				Producto k = entry.getKey();
				Integer v = entry.getValue();
				f =+ k.getPrecio() * v;
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
	public static int getCantidadDeVentas() {
		return cantidadDeVentas.size();
	}

	public ArrayList<Producto> getCatalogo() {
		return catalogo;
	}

	public HashMap<Producto, Integer> getInventario() {
		return inventario;
	}

	public static void setCantidadDeVentas(ArrayList<Factura> cantidadDeVentas) {
		Tienda.cantidadDeVentas = cantidadDeVentas;
	}

	public static CuentaBancaria getCuenta() {
		return cuenta;
	}
}
