package gestorAplicacion.gestionVentas;
//Librerías
import gestorAplicacion.gestionPersonas.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Factura implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Serializador factura
    private static ArrayList<Factura> facturas = new ArrayList<>();

    //Atributos
    private static long facturaID = 38040000;
    private Usuario cliente;
    private String fechaFactura;
    private HashMap<Producto, Integer> productos = new HashMap<>();
    private static float total = 0.0f;
    private  Vendedor vendedor;
    
    //Constructor
    public Factura(){};
    
    public Factura(Usuario cliente, String fechaFactura, Vendedor vendedor) {
    facturaID=+1; // El ID de la factura se va incrementando a medida que se va creando, con numero base 38040000
    this.cliente=cliente;
    this.fechaFactura= fechaFactura;
    this.vendedor=vendedor;
    }
    @Override
	public String toString() {
        return  "~ Factura #"+ facturaID + "\n"+
                "~ Fecha = " + fechaFactura +"\n"+
                "~ Cliente = " + cliente + '\n' +
                "~ Cantidad a pagar = " +total+ "\n";
    }
    
   //Metodo que realiza la compra
    public float realizarCompra(Usuario cliente, short pswd){

        //Primero se calcula el total de la compra con este for
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            Producto k = entry.getKey();
            Integer v = entry.getValue();
            total=+ k.getPrecio()*v;
        }
        // se reduce el stock de la tienda, se resta el saldo al cliente y se le agrega a la tienda
        Tienda.reducirStock(this);
        Tienda.getCuenta().tranferir(cliente.getCuenta(),total,pswd);
        cliente.agregarFactura(this);
        Tienda.agregarVenta(this);
        return total;
        //Ademas se descuenta al cliente el valor de la compra
    }
    public float realizarCompra(Usuario cliente){

        //Primero se calcula el total de la compra con este for
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            Producto k = entry.getKey();
            Integer v = entry.getValue();
            total=+ k.getPrecio()*v;
        }
        // se reduce el stock de la tienda, se resta el saldo al cliente y se le agrega a la tienda
        Tienda.reducirStock(this);
        Tienda.getCuenta().depositar(total);
        cliente.agregarFactura(this);
        Tienda.agregarVenta(this);
        return total;
        //Ademas se descuenta al cliente el valor de la compra
    }
    
    //se añade un producto al hashmap de la compra con su respectiva cantidad
    public void agregarProducto(Producto producto, int cantidad){
        productos.put(producto, cantidad);
    }
    
    public void eliminarProducto(Producto p){
        productos.remove(p);
    }
    
    //Inicio getters y setters
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

    public static void setFacturaID(long facturaID) {
        Factura.facturaID = facturaID;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public static void setTotal(float total) {
        Factura.total = total;
    }
}
