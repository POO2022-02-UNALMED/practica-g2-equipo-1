package gestorAplicacion.gestionPersonas;
import gestorAplicacion.gestionVentas.Factura;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

public class Vendedor extends Persona implements Serializable {

    //Serializador vendedor
    private static ArrayList<Vendedor> vendedores = new ArrayList<>();
    // Atributos
    private ArrayList<Factura> ventas=new ArrayList<Factura>();
    private String usuario;
    private String contrasena;
    static HashMap<String, String> usuarios = new HashMap<String, String>();

    //Constructor
    public Vendedor(int personaId, String nombre, String email, int telefono, ArrayList<Factura> ventas, 
    		String usuario, String contrasena) {
        super(personaId, nombre, email, telefono);
        this.ventas = ventas;
        this.usuario = usuario;
        this.contrasena = contrasena;
        
    }
    public Vendedor(int personaId, String nombre, String email, int telefono,
            CuentaBancaria cuenta , String usuario, String contrasena) {
        super(personaId, nombre, email, telefono, cuenta);
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    //Getters y setters
    public static ArrayList<Vendedor> getVendedores() {
        return vendedores;
    }
    public static void setVendedores(ArrayList<Vendedor> vendedores) {
        Vendedor.vendedores=vendedores;
    }
    public ArrayList<Factura> getVentas() {
        return ventas;
    }
    public void setVentas(ArrayList<Factura> ventas) {
        this.ventas = ventas;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

	public static HashMap<String, String> getUsuarios() {
		return usuarios;
	}

	public static void setUsuarios(HashMap<String, String> usuarios) {
		Vendedor.usuarios = usuarios;
	}

	//Métodos

    public static boolean validarCredenciales(String usuario, String contrasena){
        for (Entry<String, String> entry : usuarios.entrySet()) {
            if (usuario==entry.getKey() & contrasena==entry.getValue()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void agregarFactura(Factura f){
        ventas.add(f);
    }
}
