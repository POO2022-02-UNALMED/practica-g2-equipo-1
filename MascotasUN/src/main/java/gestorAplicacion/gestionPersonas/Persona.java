/*Clase abstracta Padre de las clases Usuario, Proveedor y Vendedor encarga de darle atributos y metodos basicos
 * a los objetos creados a partir de estas clases*/

package gestorAplicacion.gestionPersonas;

import gestorAplicacion.gestionVentas.Factura; // Importamos la clase Factura para el método de agregarFactura()

public abstract class Persona {

	//Atributos (protected para utilizarlos dentro del paquete)
    protected long personaId;
    protected String nombre;
    protected String email;
    protected int telefono;
    protected CuentaBancaria cuenta;

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
  	protected abstract void agregarFactura(Factura f); // Método abstracto
    
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
}
