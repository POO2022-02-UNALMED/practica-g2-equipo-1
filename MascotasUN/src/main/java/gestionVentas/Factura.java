package gestionVentas;
//Librerías
import gestionPersonas.*;
import java.util.HashMap;
import java.util.Date;
import java.util.Map;

public class Factura {
    //Atributos
    private long facturaID;
    private Usuario cliente;
    private Date fechaFactura;
    private int cantidadProductos;
    private static HashMap<Producto, Integer> productos = new HashMap<>();
    private String metodoPago;
    private  float total;
    //Constructor
    public Factura(long facturaID, Usuario cliente, Date fechaFactura, int cantidadProductos, String metodoPago, float total) {
    this.facturaID=facturaID;
    this.cliente=cliente;
    this.fechaFactura= fechaFactura;
    this.cantidadProductos= cantidadProductos;

    this.metodoPago=metodoPago;
    this.total=total;
    }
    //En este metodo falta pensar la forma en que se deben descontar del inventario los productos vendidos
    public float realizarCompra(Usuario cliente){
        float tot= 0.0f;
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            Producto k = entry.getKey();
            Integer v = entry.getValue();
            tot=+ k.getPrecioCompra()*v;

            //metodo que hace el total del precio de la compra tomando el precio del producto por
            //la cantidad y los suma
        }
        cliente.setSaldoCliente((int) (cliente.getSaldoCliente()-tot)) ;
        productos=new HashMap<Producto, Integer>();
        return tot;
        //Ademas se descuenta al cliente el valor de la compra
    }
    public void eliminarCompra(Usuario cliente, float precioCompra){
        cliente.setSaldoCliente(cliente.getSaldoCliente()+precioCompra);
        //Aqui también hay que pensar la manera de reintegrar los productos al inventario

    }
    //se añade un producto al hashmap de la compra con su respectiva cantidad
    public static void agregarProducto(Producto producto, int cantidad){
        productos.put(producto, cantidad);
    }
    public void eliminarProducto(Producto p){
        productos.remove(p);

    }
    //Inicio getters y setters
    public long getFacturaID() {
        return facturaID;
    }

    public void setFacturaID(long facturaID) {
        this.facturaID = facturaID;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public HashMap<Producto, Integer> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<Producto, Integer> productos) {
        this.productos = productos;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    //Final getters y setters
}
