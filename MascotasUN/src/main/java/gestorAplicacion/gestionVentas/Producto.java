package gestorAplicacion.gestionVentas;
import java.util.ArrayList;
import java.util.Date;

public class Producto {
    //Serializador Productos
    private static ArrayList<Producto> productos = new ArrayList<>();
    private long productoID;
    private String nombre;
    private Date fechaVencimiento;
    private String descripcion;
    private float precioCompra; //¿Se conecta con Proveedor?
    private float precioVenta;
    private int cantidadComprada; // Revisar diagrama de clase

    // Constructor

    public Producto(long productoID, String nombre, Date fechaVencimiento, String descripcion, float precioCompra, float precioVenta, int cantidadComprada) {
    this.productoID = productoID;
    this.nombre = nombre;
    this.fechaVencimiento = fechaVencimiento;
    this.descripcion = descripcion;
    this.precioCompra = precioCompra;
    this.precioVenta = precioVenta;
    this.cantidadComprada = cantidadComprada;
    }

    // Métodos
    public void editarProducto(Producto p){
        // ¿Sería como un setter? Revisar
    }

    // Setters y Getters
    public static ArrayList<Producto> getProductos() {
        return productos;
    }
    public long getProductoID() {
        return productoID;
    }

    public void setProductoID(long productoID) {
        this.productoID = productoID;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public float getPrecioCompra() {
        return precioCompra;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }
    
    
}
