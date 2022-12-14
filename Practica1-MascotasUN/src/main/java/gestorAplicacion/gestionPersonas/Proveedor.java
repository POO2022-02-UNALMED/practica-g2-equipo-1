/*Clase que crea los objetos tipo Proveedor, los cuales interactúan con la tienda vendiéndole el inventario
 * requerido*/

package gestorAplicacion.gestionPersonas;

import gestorAplicacion.gestionVentas.Factura;
import gestorAplicacion.gestionVentas.Producto;

import java.io.Serializable;
import java.util.ArrayList;

public class Proveedor extends Persona implements Serializable {

	//Serializador Proveedores
	private static final long serialVersionUID = 1L;
    private static ArrayList<Proveedor> proveedores = new ArrayList<>();
    
    //Atributos
    private ArrayList<Producto> producto = new ArrayList<Producto>();
    private ArrayList<Factura> pedidos = new ArrayList<Factura>();
    private boolean stock; //Pueden haber proveedores con y si stock
    
    //Constructores
    
    public Proveedor() {
    }
    
    public Proveedor(long personaId, String nombre, String email, int telefono, CuentaBancaria cuenta, ArrayList<Producto> producto, boolean stock) {
        super(personaId, nombre, email, telefono, cuenta);
        this.producto = producto;
        this.stock = stock;
        proveedores.add(this);
    }

    //Métodos
    
    // Método que agrega una factura al proveedor a la lista de pedidos enviados
    @Override
    public void agregarFactura(Factura f){
        pedidos.add(f);
    }

    //Metodo toString() sobreescrito que se encarga de mostrar atributos determinados de la clase proveedor
    @Override
    public String toString() {
        return  "~ ID #"+ personaId + "\n"+
                "~ Nombre = " + nombre +"\n"+
                "~ Email = " + email + "\n"+
                "~ Telefono = " +telefono+ "\n"+
                "~ Productos = " +producto.size()+ "\n"+
                "~ Stock = " +stock+ "\n";
    }
    
    // Método que encuentra al proveedor en la lista de proveedores existentes y lo retorna, dado su ID
    public static Proveedor encontrarPersona(long personaId){
        for(Proveedor p: proveedores){
            if(p.getPersonaId()== personaId){
                return p;
            }
        }
        return null;
    }

    // Metodo que elimina a un proveedor de la lista de provedores y retorna un booleano
    public static boolean eliminarProveedor(Proveedor proveedor){
        Proveedor.getProveedores().remove(proveedor);
        return true;
    }

    //getter y setter del serializador y deserializador
    public static ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public static void setProveedores(ArrayList<Proveedor> proveedores) {
        Proveedor.proveedores = proveedores;
    }

    //Getters y setters
    public ArrayList<Producto> getProducto() {
        return producto;
    }

    public void setProducto(ArrayList<Producto> producto) {
        this.producto = producto;
    }
    
    public ArrayList<Factura> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Factura> pedidos) {
		this.pedidos = pedidos;
	}

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }
}