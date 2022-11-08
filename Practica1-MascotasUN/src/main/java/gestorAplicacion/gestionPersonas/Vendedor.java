/*Clase que crea y gestiona los objetos tipo Vendedor, los cuales interactúan directamente con las funcionalidades
 * de la aplicación. Hereda de la clase abstracta Persona. Existen dos hashmap, el primero (usuarios) se encarga de
 * obtener usuarios con usuario y contrasena, el segundo (cantidadVentas) muestra el string del usuario y las ventas
 * del mismo*/

package gestorAplicacion.gestionPersonas;


import gestorAplicacion.gestionVentas.Factura; // Importamos la clase Factura para el método agregarFactura() y el atributo de la lista de ventas realizadas

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

public class Vendedor extends Persona implements Serializable {

	//Serializador vendedor
	private static final long serialVersionUID = 1L;
	private static final double comision = 0.05;
	private static ArrayList<Vendedor> vendedores = new ArrayList<>();
    
    // Atributos
    private ArrayList<Factura> ventas=new ArrayList<Factura>();
    private String usuario;
    private String contrasena;
    public static HashMap<String, String> usuarios = new HashMap<String, String>(); // Diccionario vendedores usuario:contraseña
    public static HashMap<String, Integer> cantidadVentas = new HashMap<String, Integer>(); // Diccionario vendedores usuario:ventas

    //Constructor
    public Vendedor(long personaId, String nombre, String email, int telefono, ArrayList<Factura> ventas,
    		String usuario, String contrasena, CuentaBancaria cuenta) {
        super(personaId, nombre, email, telefono,cuenta);
        this.ventas = ventas;
        this.usuario = usuario;
        this.contrasena = contrasena;
        vendedores.add(this);
    }

    //Métodos
    
	// Método para ordenar el HashMap del vendedor por la cantidad de ventas 
	public static SortedSet<Integer> getValoresOrdenados() {
        SortedSet<Integer> valores = new TreeSet<Integer>(cantidadVentas.values());
        return valores; 
    }

    // Método sobreescrito toString()
    @Override
    public String toString() {
        return  "~ ID #"+ personaId + "\n"+
                "~ Nombre = " + nombre +"\n"+
                "~ Email = " + email + "\n"+
                "~ Telefono = " +telefono+ "\n"+
                "~ Usuario = " +usuario+ "\n"+
                "~ Ventas = " +ventas+ "\n";
    }
    
    // Método que agrega al vendedor a la lista de vendedores
    public static void agregarVendedor(Vendedor vendedor){
        vendedores.add(vendedor);
    }

    // Método que agrega una factura al vendedor dentro de la lista de ventas realizadas
    @Override
    public void agregarFactura(Factura f){
        ventas.add(f);
    }

    // Método que permite validar que las credenciales ingresadas por el vendedor al iniciar sesión sean correctas
    public static boolean validarCredenciales(String usuario, String contrasena){
        for (Entry<String, String> entry : usuarios.entrySet()) {
            if (usuario.equals(entry.getKey()) & contrasena.equals(entry.getValue())){
                return true;
            }
        }
        return false;
    }
    // Método que encuentra al vendedor en la lista de vendedores existentes y lo retorna, dado su ID
    public static Vendedor encontrarPersona(long personaId){
        for(Vendedor p: vendedores){
            if(p.getPersonaId()== personaId){
                return p;
            }
        }
        return null;
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

	public static HashMap<String, Integer> getCantidadVentas() {
		return cantidadVentas;
	}

	public static void setCantidadVentas(HashMap<String, Integer> cantidadVentas) {
		Vendedor.cantidadVentas = cantidadVentas;
	}
	
    public static double getComision() {
		return comision;
	}
	
}

