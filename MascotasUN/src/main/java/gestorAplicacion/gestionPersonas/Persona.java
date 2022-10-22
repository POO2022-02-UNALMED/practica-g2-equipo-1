package gestorAplicacion.gestionPersonas;
import java.util.ArrayList;
import java.util.Date;

public abstract class Persona {
    /* Esta clase se encarga de darle atributos y metodos basicos a las diferentes personas
    que interactuan con nuestra interfas */

   //Atributos (protected para utilizarlos dentro del paquete)
    protected long personaId;
    protected String nombre;
    protected String email;
    protected int documento;
    protected Date fechaDeNacimiento;
    protected int telefono;
    protected int nroCuentaBancaria;
    //Constructor
    public Persona(long personaId, String nombre, String email, int documento, Date fechaDeNacimiento, int telefono, int nroCuentaBancaria){
        this.personaId=personaId;
        this.nombre=nombre;
        this.email=email;
        this.documento=documento;
        this.fechaDeNacimiento=fechaDeNacimiento;
        this.telefono=telefono;
        this.nroCuentaBancaria=nroCuentaBancaria;
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

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setNroCuentaBancaria(int nroCuentaBancaria) {
        this.nroCuentaBancaria = nroCuentaBancaria;
    }

    //metodos
    public abstract void agregarCuentaBancaria();
    public abstract void eliminarCuentaBancaria();
}
