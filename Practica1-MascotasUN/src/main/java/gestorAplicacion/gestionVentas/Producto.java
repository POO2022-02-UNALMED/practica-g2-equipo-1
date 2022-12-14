/*Clase que crea y gestiona los objetos de tipo Producto, los cuales son los productos que la aplicación vende*/

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
    private String especie;
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
        productos.add(this);
    }
    
  //Sobreescritura de constructor para crear productos relacionados con gatos
    public Producto(long productoID, String nombre, String fechaVencimiento, String descripcion, float precioCompra,
			float precioVenta, int cantidadComprada, String etapa, String especie) {
		this.productoID = productoID;
		this.nombre = nombre;
		this.fechaVencimiento = fechaVencimiento;
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.cantidadComprada = cantidadComprada;
		this.etapa = etapa;
		this.especie = especie;
        productos.add(this);
	}
    
    //Sobreescritura de constructor para crear productos relacionados con perros
    public Producto(long productoID, String nombre, String fechaVencimiento, String descripcion, float precioCompra,
			float precioVenta, int cantidadComprada, String raza, String etapa, String especie) {
		this.productoID = productoID;
		this.nombre = nombre;
		this.fechaVencimiento = fechaVencimiento;
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.cantidadComprada = cantidadComprada;
		this.raza = raza;
		this.etapa = etapa;
		this.especie = especie;
        productos.add(this);
	}

    // Métodos
    
    // Metodo sobrecargado toString() para generar el string que se imprimira al implementar la UI
    @Override
    public String toString() {
        return "~ Codigo = " + productoID +"\n"+
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
    
    // Método que elimina un producto de la lista de productos a comprar
    public static boolean eliminarProducto(Producto producto){
        Tienda.getCatalogo().remove(producto);
        Producto.getProductos().remove(producto);
        return true;
    }
    
    // Método que agrega un producto a la lista de productos a comprar
    public static void agregarProducto(Producto producto){
        Producto.productos.add(producto);
    }

    //getter y setter del serializador y deserializador
    public static ArrayList<Producto> getProductos() {
        return productos;
    }

    public static void setProductos(ArrayList<Producto> productos) {
        Producto.productos=productos;
    }

    // Getters y setters
    
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

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}
}