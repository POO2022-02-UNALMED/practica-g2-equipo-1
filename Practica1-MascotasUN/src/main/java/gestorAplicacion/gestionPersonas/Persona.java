/*Clase abstracta Padre de las clases Usuario, Proveedor y Vendedor encarga de darle atributos y metodos basicos
 * a los objetos creados a partir de estas clases*/

package gestorAplicacion.gestionPersonas;

import java.util.ArrayList;
import gestorAplicacion.gestionVentas.Factura; // Importamos la clase Factura para el método de agregarFactura()

public abstract class Persona {

	//Atributos (protected para utilizarlos dentro del paquete)
	protected static ArrayList<Persona> personas = new ArrayList<Persona>();
    protected long personaId;
    protected String nombre;
    protected String email;
    protected int telefono;
    protected CuentaBancaria cuenta;

    // Constructor por defecto
    
    public Persona() {
    }
    
    //Constructor
    public Persona(long personaId, String nombre, String email, int telefono){
        this.personaId=personaId;
        this.nombre=nombre;
        this.email=email;
        this.telefono=telefono;
    }
    
    // Sobrecarga de constructor, que incluye la cuenta bancaria de la persona
    public Persona(long personaId, String nombre, String email, int telefono, CuentaBancaria cuenta){
        this(personaId,nombre,email,telefono);
        this.cuenta = cuenta;
    }
    
    //Métodos
    
    /* Método abstracto que se hereda a las clases Usuario, Proveedor y Vendedor,
     * que recibe como parámetro un objeto tipo Factura y retorna un void */
  	protected abstract void agregarFactura(Factura f); // Método abstracto

  	
  	/*Método que recorre la lista de personas y las imprime, retornando un String.
  	 * Se resuelve el metodo toString() más específico de Usuario, Proveedor o Vendedor
  	 * por medio de la ligadura dinámica en tiempo de ejecucion*/
  	public static String verPersona() {
  		String resultado_nombre = "";
  		
  		for (int i=0; i < personas.size(); i++) {
  			resultado_nombre += (i+1) + ". " + personas.get(i) + "\n";
  		}
  		return resultado_nombre;
  	}
  	
  	// Método que encuentra a la persona en la lista de personas existentes y la retorna, dado su ID
 	public static Persona encontrarPersona(long personaId){
 		for(Persona p: personas){
 			if(p.getPersonaId()== personaId){
 				return p;
 			}
 		}
 		return null;
 	}
  	
 	// Método que dado el ID de la persona, retorna un String con su respectiva bienvenida.
 	// El método encontrarPersona() se resuelve por ligadura dinámica
  	public String bienvenidaPersona(long ID) {
  		String bienvenida = "Bienvenido, " + encontrarPersona(ID).getNombre();
  		
  		return bienvenida;
  	}
    
    //Getters y setters

       //Getters y setters

    public void setPersonaId(long personaId) {
        this.personaId = personaId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setNroCuentaBancaria(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    public long getPersonaId() {
		return personaId;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public int getTelefono() {
		return telefono;
	}

	public CuentaBancaria getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaBancaria cuenta) {
		this.cuenta = cuenta;
	}

	public static ArrayList<Persona> getPersonas() {
		return personas;
	}
}