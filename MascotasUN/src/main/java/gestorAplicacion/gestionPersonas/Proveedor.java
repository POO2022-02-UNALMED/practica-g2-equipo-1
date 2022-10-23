package gestorAplicacion.gestionPersonas;

import gestorAplicacion.gestionVentas.Factura;
import gestorAplicacion.gestionVentas.Producto;

import java.io.Serializable;
import java.util.ArrayList;


public class Proveedor extends Persona implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Serializador Proveedores
    private static ArrayList<Proveedor> proveedores = new ArrayList<>();
    //Atributos
    private ArrayList<Producto> producto=new ArrayList<Producto>();

    private ArrayList<Factura> pedidos= new ArrayList<Factura>();
    
    private boolean stock;
    
    
    //Constructor
    public Proveedor(long personaId, String nombre, String email, int telefono, CuentaBancaria cuenta, ArrayList<Producto> producto, boolean stock) {
        super(personaId, nombre, email, telefono, cuenta);
        this.producto = producto;
        this.stock = stock;
    }

    //Métodos
    @Override
    public void agregarFactura(Factura f){
        pedidos.add(f);
    }

    //Getters y setters
    public static ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }
    
    public static void setProveedores(ArrayList<Proveedor> proveedores) {
        Proveedor.proveedores = proveedores;
    }
    
    public ArrayList<Producto> getProducto() {
        return producto;
    }

    public void setProducto(ArrayList<Producto> producto) {
        this.producto = producto;
    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

	public ArrayList<Factura> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Factura> pedidos) {
		this.pedidos = pedidos;
	}
  
}