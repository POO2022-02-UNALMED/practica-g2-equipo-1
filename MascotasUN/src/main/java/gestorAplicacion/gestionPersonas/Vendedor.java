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
    private ArrayList<Factura> ventas=new ArrayList<Factura>();
    private String usuario;
    private long cuentaBancaria;
    private long contrasena;
    private boolean esAdmin;
    static HashMap<String, String> usuarios = new HashMap<String, String>();
 
    /*public static void dict(){
        usuarios.put("Juan Pablo Arcila", "holi12");
        usuarios.put("Roberto Barrientos", "adios13");
        usuarios.put("Laura Vanegas", "lau1245");
    }*/

    //Constructor
    public Vendedor(int personaId, String nombre, String email, Date fechaDeNacimiento, int telefono,
            int nroCuentaBancaria, ArrayList<Factura> ventas, String usuario, long contrasena, boolean esAdmin) {
        super(personaId, nombre, email, fechaDeNacimiento, telefono, nroCuentaBancaria);
        this.ventas = ventas;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.esAdmin = esAdmin;
    }

    //Getters y setters
    public static ArrayList<Vendedor> getVendedores() {
        return vendedores;
    }
    @Override
    public void agregarFactura(Factura f){
        ventas.add(f);
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
    public long getContrasena() {
        return contrasena;
    }
    public void setContrasena(long contrasena) {
        this.contrasena = contrasena;
    }
    public boolean getEsAdmin() {
        return esAdmin;
    }
    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }
    
    public long getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(long cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
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

}
