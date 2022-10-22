package gestorAplicacion.gestionPersonas;

import gestorAplicacion.gestionVentas.Mascota;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class Usuario extends Persona implements Serializable {
	//Serializador Usuarios
	private static ArrayList<Usuario> usuarios = new ArrayList<>();
	private String formaPago;
	private String direccion;
	private String envioCompra;
	private float saldoCliente;
	private boolean esPremium;
	private ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

	//constructor
	public Usuario(int personaId, String nombre, String email, int documento, Date fechaDeNacimiento, int telefono, int nroCuentaBancaria, String formaPago, String direccion, String envioCompra, int saldoCliente, boolean esPremium, ArrayList<Mascota> mascotas) {
		super(personaId, nombre, email, documento, fechaDeNacimiento, telefono, nroCuentaBancaria);
		this.formaPago = formaPago;
		this.direccion = direccion;
		this.envioCompra = envioCompra;
		this.saldoCliente = saldoCliente;
		this.esPremium = esPremium;
		this.mascotas = mascotas;
	}

	//getters y setters
	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
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
	
	public float getSaldoCliente() {
		return saldoCliente;
	}
	
	public void setSaldoCliente(float saldoCliente) {
		this.saldoCliente = saldoCliente;
	}
	
	public boolean isEsPremium() {
		return esPremium;
	}
	
	public void setEsPremium(boolean esPremium) {
		this.esPremium = esPremium;
	}
	
	public ArrayList<Mascota> getMascotas() {
		return mascotas;
	}
	
	public void setMascotas(ArrayList<Mascota> mascotas) {
		this.mascotas = mascotas;
	}
	
	//metodos
	
	public void registrarMascota(Mascota mascota) {
		mascotas.add(mascota);
	}
	
	public void eliminarMascota(){}

	@Override
	public void agregarCuentaBancaria() {

	}

	@Override
	public void eliminarCuentaBancaria() {

	}
}
