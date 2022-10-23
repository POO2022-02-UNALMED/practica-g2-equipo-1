package gestorAplicacion.gestionPersonas;

import gestorAplicacion.gestionVentas.Factura;
import gestorAplicacion.gestionVentas.Mascota;

import java.io.Serializable;
import java.util.ArrayList;


public class Usuario extends Persona implements Serializable {
	/*Esta clase hereda de la clase abstracta persona y se encarga de manejar a los usuarios de la tienda*/

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Serializador Usuarios
	private static ArrayList<Usuario> usuarios = new ArrayList<>();
	private String formaPago;
	private String direccion;
	private String envioCompra = "";
	private ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

	private ArrayList<Factura> compras = new ArrayList<Factura>();

	//constructor
	public Usuario(int personaId, String nombre, String email, int telefono, CuentaBancaria cuenta, String formaPago, String direccion, ArrayList<Mascota> mascotas) {
		super(personaId, nombre, email, telefono, cuenta);
		this.formaPago = formaPago;
		this.direccion = direccion;
		this.mascotas = mascotas;
	}
	public Usuario(int personaId, String nombre, String email, int telefono, String formaPago, String direccion, ArrayList<Mascota> mascotas) {
		super(personaId, nombre, email, telefono);
		this.formaPago = formaPago;
		this.direccion = direccion;
		this.mascotas = mascotas;
	}
	@Override
	public void agregarFactura(Factura f){
		compras.add(f);
	}

	//getters y setters
	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public static void setUsuarios(ArrayList<Usuario> usuarios) {
		Usuario.usuarios=usuarios;
	}
	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getEnvioCompra() {
		return envioCompra;
	}
	
	public void setEnvioCompra(String envioCompra) {
		this.envioCompra = envioCompra;
	}

	public ArrayList<Mascota> getMascotas() {
		return mascotas;
	}
	
	public void setMascotas(ArrayList<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public CuentaBancaria getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaBancaria cuenta) {
		this.cuenta = cuenta;
	}

	public ArrayList<Factura> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Factura> compras) {
		this.compras = compras;
	}

	//metodos
	public void registrarMascota(Mascota mascota) {
		mascotas.add(mascota);
	}

}
