/*Clase que crea y gestiona los objetos tipo Usuario, los cuales interactúan con la tienda comprando productos.
 * Hereda de la clase abstracta Persona*/

package gestorAplicacion.gestionPersonas;

import gestorAplicacion.gestionVentas.Factura; // Importamos la clase Factura para el método agregarFactura() y el atributo de la lista de compras que ha hecho un usuario
import gestorAplicacion.gestionVentas.Mascota; // Importamos la clase Mascota para el atributo de la lista de Mascotas que tiene un usuario

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario extends Persona implements Serializable {
	
	//Serializador Usuarios
	private static final long serialVersionUID = 1L;
	private static ArrayList<Usuario> usuarios = new ArrayList<>();
	
	// Atributos
	private String direccion;
	private ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
	private ArrayList<Factura> compras = new ArrayList<Factura>();

	// Constructor
	public Usuario(long personaId, String nombre, String email, int telefono, CuentaBancaria cuenta, String direccion, ArrayList<Mascota> mascotas) {
		super(personaId, nombre, email, telefono, cuenta);
		this.direccion = direccion;
		this.mascotas = mascotas;
	}
		// Sobrecarga de constructor, cuando el usuario no posee cuenta bancaria
	public Usuario(long personaId, String nombre, String email, int telefono, String direccion, ArrayList<Mascota> mascotas) {
		this(personaId, nombre, email, telefono, null, direccion, mascotas);
	}
	
	// Métodos
	
	// Método toString() sobreescrito
	@Override
	public String toString() {
		return  "~ ID #"+ personaId + "\n"+
				"~ Nombre = " + nombre +"\n"+
				"~ Email = " + email + "\n"+
				"~ Telefono = " +telefono+ "\n"+
				"~ Direccion = " +direccion+ "\n"+
				"~ Mascotas = " +mascotas+ "\n"+
				"~ Compras = " +compras+ "\n";
	}
	
	// Método que agrega una factura al usuario dentro de la lista de compras realizadas
	@Override
	public void agregarFactura(Factura f){
		compras.add(f);
	}
	
	// Método que registra una nueva mascota en la lista de mascotas pertenecientes al usuario
	public void registrarMascota(Mascota mascota) {
		mascotas.add(mascota);
	}

	// Método que permite eliminar un usuario desde la gestión de usuarios de la tienda
	public static boolean eliminarUsuario(Usuario usuario){
		Usuario.getUsuarios().remove(usuario);
		return true;
	}

	// Método que encuentra al usuario en la lista de usuarios existentes y lo retorna, dado su ID
	public static Usuario encontrarPersona(long personaId){
		for(Usuario p: usuarios){
			if(p.getPersonaId()== personaId){
				return p;
			}
		}
		return null;
	}

	//Getters y setters
	
	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public static void setUsuarios(ArrayList<Usuario> usuarios) {
		Usuario.usuarios=usuarios;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Mascota> getMascotas() {
		return mascotas;
	}
	
	public void setMascotas(ArrayList<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public ArrayList<Factura> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Factura> compras) {
		this.compras = compras;
	}
}