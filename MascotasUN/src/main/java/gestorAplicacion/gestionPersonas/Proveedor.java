package gestorAplicacion.gestionPersonas;

import gestorAplicacion.gestionVentas.Factura;
import gestorAplicacion.gestionVentas.Producto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Proveedor extends Persona implements Serializable {
    //Serializador Proveedores
    private static ArrayList<Proveedor> proveedores = new ArrayList<>();
    //Atributos
    private ArrayList<Producto> producto=new ArrayList<Producto>();

    private ArrayList<Factura> pedidos= new ArrayList<Factura>();
    
    private boolean stock;
    
    
    //Constructor
    
    public Proveedor(int personaId, String nombre, String email, Date fechaDeNacimiento, int telefono, CuentaBancaria cuenta, ArrayList<Producto> producto, boolean stock) {
        super(personaId, nombre, email, fechaDeNacimiento, telefono, cuenta);
        this.producto = producto;
        this.stock = stock;
    }
    
    //Sobrecarga Constructor
    public Proveedor(int personaId, String nombre, String email, Date fechaDeNacimiento, int telefono, ArrayList<Producto> producto, boolean stock) {
    	this(personaId,nombre,email,fechaDeNacimiento,telefono,null,producto,stock);
    }
    
    
    
    //Getters y setters
    
    //Métodos
    @Override
    public void agregarFactura(Factura f){
        pedidos.add(f);
    }
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
    
}