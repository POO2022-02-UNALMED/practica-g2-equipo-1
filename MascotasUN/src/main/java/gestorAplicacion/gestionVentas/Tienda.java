package gestorAplicacion.gestionVentas;

import gestorAplicacion.gestionPersonas.CuentaBancaria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tienda implements Serializable {
	//Serializador clase tienda
	private static ArrayList<Tienda> tienda = new ArrayList<>();
	private static ArrayList<Factura> cantidadDeVentas = new ArrayList<Factura>();
	private ArrayList<Producto> catalogo = new ArrayList<Producto>();
	private HashMap<Producto, Integer> inventario = new HashMap<>();
	private CuentaBancaria cuenta;



	public Tienda() {}

	public Tienda(ArrayList<Factura> cantidadDeVentas, ArrayList<Producto> catalogo, HashMap<Producto, Integer> inventario) {
		this.catalogo = catalogo;
		this.inventario = inventario;
	}

	//Getters y Setters
	public static ArrayList<Tienda> getTienda() {
		return tienda;
	}

	public static void setTienda(ArrayList<Tienda> tienda) {
		Tienda.tienda=tienda;
	}



	public void aumentarStock(Factura factura){
		for (Map.Entry<Producto, Integer> fact : factura.getProductos().entrySet()) {
			Producto k = fact.getKey();
			Integer v = fact.getValue();
			Integer ch = inventario.get(k);
			inventario.put(k, ch + v);
		}

	}
	public void reducirStock(Factura factura){

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
	public void agregarVenta(Factura f){
		cantidadDeVentas.add(f);
	}
	public static int getCantidadDeVentas() {
		return cantidadDeVentas.size();
	}

	public ArrayList<Producto> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(ArrayList<Producto> catalogo) {
		this.catalogo = catalogo;
	}

	public HashMap<Producto, Integer> getInventario() {
		return inventario;
	}

	public void setInventario(HashMap<Producto, Integer> inventario) {
		this.inventario = inventario;
	}

	public static void setCantidadDeVentas(ArrayList<Factura> cantidadDeVentas) {
		Tienda.cantidadDeVentas = cantidadDeVentas;
	}

	public CuentaBancaria getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaBancaria cuenta) {
		this.cuenta = cuenta;
	}
}
