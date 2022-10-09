import java.util.ArrayList;
import java.util.List;

public class Tienda {
	private List<Factura> cantidadDeVentas = new ArrayList<Factura>();
	private List<Producto> catalogo = new ArrayList<Producto>();
	private List<Producto> inventario = new ArrayList<Producto>();
	
	public Tienda() {}

	public Tienda(List<Factura> cantidadDeVentas, List<Producto> catalogo, List<Producto> inventario) {
		this.cantidadDeVentas = cantidadDeVentas;
		this.catalogo = catalogo;
		this.inventario = inventario;
	}

	public List<Factura> getCantidadDeVentas() {
		return cantidadDeVentas;
	}

	public void setCantidadDeVentas(List<Factura> cantidadDeVentas) {
		this.cantidadDeVentas = cantidadDeVentas;
	}

	public List<Producto> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(List<Producto> catalogo) {
		this.catalogo = catalogo;
	}

	public List<Producto> getInventario() {
		return inventario;
	}

	public void setInventario(List<Producto> inventario) {
		this.inventario = inventario;
	}
	
	
	
}
