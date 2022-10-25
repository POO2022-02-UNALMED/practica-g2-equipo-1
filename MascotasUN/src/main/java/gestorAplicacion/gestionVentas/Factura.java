/*Clase utilizada para la gestión de las facturas generadas al momento de realizar una venta de un producto,
 * permitiendo realizar las transacciones asociadas a la venta del mismo*/

package gestorAplicacion.gestionVentas;

import gestorAplicacion.gestionPersonas.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Factura implements Serializable {
    
	//Serializador factura
	private static final long serialVersionUID = 1L;
    private static ArrayList<Factura> facturas = new ArrayList<>();

    //Atributos
    private static long facturaID = 38040000;
    private Usuario cliente;
    private String fechaFactura;
    private HashMap<Producto, Integer> productos = new HashMap<>();
    private static float total = 0.0f;
    private Vendedor vendedor;
    private final float IVA = 1.16f;
    
    //Constructores
    
    public Factura(){
    	facturaID=+1; // El ID de la factura se va incrementando a medida que se crea una nueva
    };
    
    public Factura(Usuario cliente, String fechaFactura, Vendedor vendedor) {
	    facturaID=+1;
	    this.cliente=cliente;
	    this.fechaFactura= fechaFactura;
	    this.vendedor=vendedor;
    }
    
    // Métodos
    
    // Método toString() sobreescrito
    @Override
	public String toString() {
        return  "~ Factura #"+ facturaID + "\n"+
                "~ Fecha = " + fechaFactura +"\n"+
                "~ Cliente = " + cliente.getNombre() + '\n' +
                "~ Cantidad a pagar = " +total+ "\n";
    }
    
    /*Metodo que realiza la compra, cuando el usuario utiliza como método de pago una cuenta bancaria.
    Retorna el total del precio de la compra tomando el precio del producto por la cantidad y los suma*/
    public float realizarCompra(Usuario cliente, short pswd){

        //Primero se calcula el total de la compra con este for
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            Producto k = entry.getKey();
            Integer v = entry.getValue();
            total += k.getPrecioVenta()*v;
        }
        
        // se reduce el stock de la tienda, se resta el saldo al cliente y se le agrega a la tienda
        total = total*IVA;
        Tienda.reducirStock(this);
        Tienda.getCuenta().tranferir(cliente.getCuenta(),total,pswd);
        cliente.agregarFactura(this);
        Tienda.agregarVenta(this);
        return total;
    }
    
    //Metodo sobrecargado que realiza la compra, cuando el usuario utiliza como método de pago efectivo
    public float realizarCompra(Usuario cliente){

        //Primero se calcula el total de la compra con este for
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            Producto k = entry.getKey();
            Integer v = entry.getValue();
            total += k.getPrecioVenta()*v;
        }
        // se reduce el stock de la tienda, se resta el saldo al cliente y se le agrega a la tienda
        total = total*IVA;
        Tienda.reducirStock(this);
        Tienda.getCuenta().depositar(total);
        cliente.agregarFactura(this);
        Tienda.agregarVenta(this);
        return total;
    }
  
    // Método sobrecargado que realizar la compra de la tienda al proveedor
    public float realizarCompra(Proveedor proveedor, HashMap<Producto, Integer> productos, int pin, float total){
        
    	//Primero se calcula el total de la compra con este for
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            Producto k = entry.getKey();
            Integer v = entry.getValue();
            total += k.getPrecioCompra()*v;
        }
        // se aumenta el stock de la tienda, se resta el saldo a la tienda y se aumenta al proveedor
        total = total*IVA;
        Tienda.aumentarStock(this); // Le entra una factura
        Tienda.getCuenta().tranferir(proveedor.getCuenta(),total,pin);
        return total;
    }
    
    //Método que añade un producto al hashmap de la compra con su respectiva cantidad
    public void agregarProducto(Producto producto, int cantidad){
        productos.put(producto, cantidad);
    }
    
    // Método que elimina un producto al hashmap de la compra
    public void eliminarProducto(Producto p){
        productos.remove(p);
    }
    
    //Getters y setters
    
    public static ArrayList<Factura> getFacturas() {
        return facturas;
    }
    
    public static void setFacturas(ArrayList<Factura> facturas) {
        Factura.facturas=facturas;
    }
    
    public long getFacturaID() {
        return facturaID;
    }
    
    public Usuario getCliente() {
        return cliente;
    }
 
    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public HashMap<Producto, Integer> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<Producto, Integer> productos) {
        this.productos = productos;
    }

    public float getTotal() {
        return total;
    }
    
    public static void setTotal(float total) {
        Factura.total = total;
    }

    public static void setFacturaID(long facturaID) {
        Factura.facturaID = facturaID;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}