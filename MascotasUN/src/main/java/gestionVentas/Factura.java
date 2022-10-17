package gestionVentas;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Factura {
    private long facturaID;
    private Usuario cliente;
    private Date fechaFactura;
    private int cantidadProductos;
    private List<Producto> productos=new ArrayList<Producto>();
    private String metodoPago;
    private  float total;

    public Factura(long facturaID, Usuario cliente, Date fechaFactura, int cantidadProductos, ArrayList<Producto> productos, String metodoPago, float total) {
    this.facturaID=facturaID;
    this.cliente=cliente;
    this.fechaFactura= fechaFactura;
    this.cantidadProductos= cantidadProductos;
    this.productos=productos;
    this.metodoPago=metodoPago;
    this.total=total;
    }
    public void realizarCompra(){

    }
    public void eliminarCompra(){

    }
    public void agregarProducto(Producto p){
        productos.add(p);
        return;
    }
    public void eliminarProducto(Producto p){
        int ind =productos.indexOf(p);
        productos.remove(ind);
    }

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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
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
}
