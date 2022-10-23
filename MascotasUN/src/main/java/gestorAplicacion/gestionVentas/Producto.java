package gestorAplicacion.gestionVentas;
import java.io.Serializable;
import java.util.ArrayList;

public class Producto implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Serializador Productos
    private static ArrayList<Producto> productos = new ArrayList<>();
    //Atributos
    private long productoID;
    private String nombre;
    private String fechaVencimiento;
    private String descripcion;
    private float precio;
    private int cantidadComprada;
    //Lista para la recomendacion de concentrado, anadir tipo. y Sobrecarga de constructores.

    // Constructor
    public Producto(long productoID, String nombre, String fechaVencimiento, String descripcion, float precioCompra, float precioVenta, int cantidadComprada) {
    this.productoID = productoID;
    this.nombre = nombre;
    this.fechaVencimiento = fechaVencimiento;
    this.descripcion = descripcion;
    this.precio = precioCompra;
    this.cantidadComprada = cantidadComprada;
    }

    // Métodos
    //Este método se encarga de editar los atributos de un producto
    public void editarProducto(long productoID, float precio,  int cantidadComprada){
        this.productoID=productoID;
        this.precio = precio;
        this.cantidadComprada = cantidadComprada;
    }
    //Metodo para generar el string que se imprimira al implementar la UI
    @Override
    public String toString() {
        return "~ codigo= " + productoID +"\n"+
                "~ Producto= " + nombre + '\n' +
                "~ fechaDeVencimiento=" + fechaVencimiento +"\n"+
                "~ Descripcion= " + descripcion+ "\n"+
                "~ Precio=" + precio;
    }

    // Setters y Getters
    public static ArrayList<Producto> getProductos() {
        return productos;
    }
    public static void setProductos(ArrayList<Producto> productos) {
        Producto.productos=productos;
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
    
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }
    //Fin getters y setters
    
}
