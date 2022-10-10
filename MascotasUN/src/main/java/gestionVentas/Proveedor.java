package gestionVentas;

import java.util.ArrayList;
import java.util.Date;

public class Proveedor extends Persona{
    //Atributos
    private ArrayList<Producto> producto=new ArrayList<Producto>();
    private boolean stock;
    //Constructor
    public Proveedor(int personaId, String nombre, String email, int documento, Date fechaDeNacimiento, int telefono, int nroCuentaBancaria, ArrayList<Producto> producto, boolean stock) {
        super(personaId, nombre, email, documento, fechaDeNacimiento, telefono, nroCuentaBancaria);
        this.producto = producto;
        this.stock = stock;
    }
    //Getters y setters

    public ArrayList<Producto> getProducto() {
        return producto;
    }

    public void setProducto(ArrayList<Producto> producto) {
        this.producto = producto;
    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }
}
