package gestorAplicacion.gestionVentas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Tienda implements Serializable {
	//Serializador clase tienda
	private static ArrayList<Tienda> tienda = new ArrayList<>();
	private ArrayList<Factura> cantidadDeVentas = new ArrayList<Factura>();
	private ArrayList<Producto> catalogo = new ArrayList<Producto>();
	private HashMap<Producto, Integer> inventario = new HashMap<>();
	
	public Tienda() {}

	public Tienda(ArrayList<Factura> cantidadDeVentas, ArrayList<Producto> catalogo, HashMap<Producto, Integer> inventario) {
		this.cantidadDeVentas = cantidadDeVentas;
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
	public ArrayList<Factura> getCantidadDeVentas() {
		return cantidadDeVentas;
	}

	public void setCantidadDeVentas(ArrayList<Factura> cantidadDeVentas) {
		this.cantidadDeVentas = cantidadDeVentas;
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
	
	
	
}
