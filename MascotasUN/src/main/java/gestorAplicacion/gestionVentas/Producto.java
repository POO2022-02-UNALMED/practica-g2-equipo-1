/**/

package gestorAplicacion.gestionVentas;

import java.io.Serializable;
import java.util.ArrayList;

public class Producto implements Serializable {

	//Serializador Productos
	private static final long serialVersionUID = 1L;
    private static ArrayList<Producto> productos = new ArrayList<>();
    
    //Atributos
    private long productoID;
    private String nombre;
    private String fechaVencimiento;
    private String descripcion;
    private float precioCompra;
    private float precioVenta;
    private int cantidadComprada;
    private String raza;
    private String etapa;
    //Lista para la recomendacion de concentrado, anadir tipo. y Sobrecarga de constructores.

    // Constructor
    public Producto(long productoID, String nombre, String fechaVencimiento, String descripcion, float precioCompra, float precioVenta, int cantidadComprada) {
	    this.productoID = productoID;
	    this.nombre = nombre;
	    this.fechaVencimiento = fechaVencimiento;
	    this.descripcion = descripcion;
	    this.precioCompra = precioCompra;
	    this.precioVenta = precioVenta;
	    this.cantidadComprada = cantidadComprada;
    }
    
    	//Sobreescritura de constructor para crear productos relacionados con gatos
    public Producto(long productoID, String nombre, String fechaVencimiento, String descripcion, float precioCompra,
			float precioVenta, int cantidadComprada, String etapa) {
		this.productoID = productoID;
		this.nombre = nombre;
		this.fechaVencimiento = fechaVencimiento;
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.cantidadComprada = cantidadComprada;
		this.etapa = etapa;
	}
    
    	//Sobreescritura de constructor para crear productos relacionados con perros
    public Producto(long productoID, String nombre, String fechaVencimiento, String descripcion, float precioCompra,
			float precioVenta, int cantidadComprada, String raza, String etapa) {
		this.productoID = productoID;
		this.nombre = nombre;
		this.fechaVencimiento = fechaVencimiento;
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.cantidadComprada = cantidadComprada;
		this.raza = raza;
		this.etapa = etapa;
	}

    // Métodos
    
    // Metodo sobrecargado toString() para generar el string que se imprimira al implementar la UI
    @Override
    public String toString() {
        return "~ Código = " + productoID +"\n"+
                "~ Producto = " + nombre + '\n' +
                "~ fechaDeVencimiento =" + fechaVencimiento +"\n"+
                "~ Descripcion = " + descripcion+ "\n"+
                "~ Precio =" + precioVenta;
    }
    
    // Método encargado de editar los atributos de un producto
    public void editarProducto(long productoID,String nombre,int precio, int cantidadComprada){
        this.nombre=nombre;
        this.productoID=productoID;
        this.precioVenta = precio;
        this.cantidadComprada = cantidadComprada;
    }
    
    // Método
    public static boolean eliminarProducto(Producto producto){
        Tienda.getCatalogo().remove(producto);
        Producto.getProductos().remove(producto);
        return true;
    }
    
    // Método
    public static void agregarProducto(Producto producto){
        Producto.productos.add(producto);
    }


    // Getters y setters
    
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
    
    public float getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
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

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}
}