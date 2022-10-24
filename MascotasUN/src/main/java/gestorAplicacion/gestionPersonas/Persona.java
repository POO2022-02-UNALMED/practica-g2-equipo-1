package gestorAplicacion.gestionPersonas;
import java.util.ArrayList;

import gestorAplicacion.gestionVentas.Factura;

//import java.util.ArrayList;
//import java.util.Date;

public abstract class Persona {
    /* Esta clase se encarga de darle atributos y metodos basicos a las diferentes personas
    que interactuan con nuestra interfaz */

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
    
    // Sobrecarga de constructor
    public Persona(long personaId, String nombre, String email, int telefono, CuentaBancaria cuenta){
        this(personaId,nombre,email,telefono);
        this.cuenta = cuenta;
    }
    
    
    //getters y setters
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

    //Metodos
	protected abstract void agregarFactura(Factura f);
}
