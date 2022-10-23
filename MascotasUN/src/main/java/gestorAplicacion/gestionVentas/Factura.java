package gestorAplicacion.gestionVentas;
//Librerías
import gestorAplicacion.gestionPersonas.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.util.Map;

public class Factura implements Serializable {
    //Serializador factura
    private static ArrayList<Factura> facturas = new ArrayList<>();


    //Atributos
    private static long facturaID = 38040000;
    private Usuario cliente;
    private Date fechaFactura;
    private int cantidadProductos;
    private Vendedor vendedor;

    private static HashMap<Producto, Integer> productos = new HashMap<>();
    private String metodoPago;
    private  float total = 0.0f;

    private Tienda tienda;
    //Constructor

    public Factura(Usuario cliente, Date fechaFactura, int cantidadProductos, String metodoPago, float total, Tienda tienda, Vendedor vendedor) {

    facturaID=+1;
    // El id de la factura se va incrementando a medida que se va creando, con numero base 38040000
    this.cliente=cliente;
    this.fechaFactura= fechaFactura;
    this.cantidadProductos= cantidadProductos;
    this.vendedor=vendedor;
    this.metodoPago=metodoPago;
    this.total=total;
    }

    public String toString() {
        return  "~ Factura#"+ facturaID + "\n"+
                "~ Fecha= " + fechaFactura +"\n"+
                "~ Cliente= " + cliente + '\n' +
                "~ Cantidad a pagar= " +total+ "\n"+
                "~ Metodo de Pago=" + metodoPago;
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
        tienda.reducirStock(this);
        cliente.cuenta.retirar(total, pswd);
        tienda.cuenta.depositar(total);
        cliente.agregarFactura(this);
        vendedor.agregarFactura(this);
        tienda.agregarVenta(this);
        return total;
        //Ademas se descuenta al cliente el valor de la compra
    }
    //se añade un producto al hashmap de la compra con su respectiva cantidad
    public static void agregarProducto(Producto producto, int cantidad){
        productos.put(producto, cantidad);
    }
    public void eliminarProducto(Producto p){
        productos.remove(p);

    }
    //Inicio getters y setters
    public static ArrayList<Factura> getFacturas() {

        return facturas;
    }
    //
    public static void setFacturas(ArrayList<Factura> facturas) {
        Factura.facturas=facturas;
    }
    //
    public long getFacturaID() {
        return facturaID;
    }
    //
    public void setFacturaID(long facturaID) {

        this.facturaID = facturaID;
    }
    //
    public Usuario getCliente() {

        return cliente;
    }
    //
    public void setCliente(Usuario cliente) {

        this.cliente = cliente;
    }
    //
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
