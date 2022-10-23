package gestorAplicacion.gestionPersonas;
import gestorAplicacion.gestionVentas.Factura;

import java.util.ArrayList;
import java.util.Date;

public abstract class Persona {
    /* Esta clase se encarga de darle atributos y metodos basicos a las diferentes personas
    que interactuan con nuestra interfas */

   //Atributos (protected para utilizarlos dentro del paquete)
    protected long personaId;
    protected String nombre;
    protected String email;
    protected Date fechaDeNacimiento;
    protected int telefono;
    protected CuentaBancaria cuenta;

    //Constructor
    public Persona(long personaId, String nombre, String email, Date fechaDeNacimiento, int telefono, CuentaBancaria cuenta){
        this.personaId=personaId;
        this.nombre=nombre;
        this.email=email;
        this.fechaDeNacimiento=fechaDeNacimiento;
        this.telefono=telefono;
        this.cuenta = cuenta;
    }
    
    //Sobrecarga de Constructores
    public Persona(long personaId, String nombre, String email, int documento, Date fechaDeNacimiento, int telefono){
        this(personaId,nombre,email,fechaDeNacimiento,telefono, null); 	
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

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
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

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public int getTelefono() {
		return telefono;
	}

	public CuentaBancaria getCuenta() {
		return cuenta;
	}

	abstract void agregarFactura(Factura f);
}
