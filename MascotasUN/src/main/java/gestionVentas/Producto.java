package gestionVentas;
import java.util.Date;

public class Producto {
    private long productoID;
    private String nombre;
    private Date fechaVencimiento;
    private String descripcion;
    private float precioCompra;
    private float precioVenta;
    private int cantidadComprada; // Revisar diagrama de clase

    // Constructor

    public Producto(long facturaID, Cliente cliente, Date fechaFactura, int cantidadProductos, ArrayList<Producto> productos, String metodoPago, float total) {
    this.facturaID=facturaID;
    this.cliente=cliente;
    this.fechaFactura= fechaFactura;
    this.cantidadProductos= cantidadProductos;
    this.productos=productos;
    this.metodoPago=metodoPago;
    this.total=total;
    }

    // Métodos
    public void realizarCompra(){ // Revisar porque está también en Factura

    }
    public void eliminarCompra(){ // Revisar porque está también en Factura

    }

    public void editarProducto(Producto p){
        // ¿Sería como un setter? Revisar
    }

    // Setters y Getters (me falta el resto)

    public long getProductoID() {
        return productoID;
    }

    public void setProductoID(long productoID) {
        this.productoID = productoID;
    }
}
