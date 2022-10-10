package gestionVentas;
import java.util.Date;

public abstract class Persona {
   //Atributos
    private int personaId;
    private String nombre;
    private String email;
    private int documento;
    private Date fechaDeNacimiento;
    private int telefono;
    private int nroCuentaBancaria;
    //Constructor
    public Persona(int personaId, String nombre, String email, int documento, Date fechaDeNacimiento, int telefono, int nroCuentaBancaria){
        this.personaId=personaId;
        this.nombre=nombre;
        this.email=email;
        this.documento=documento;
        this.fechaDeNacimiento=fechaDeNacimiento;
        this.telefono=telefono;
        this.nroCuentaBancaria=nroCuentaBancaria;
    }
    //getters y setters
    public void setPersonaId(int personaId) {
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
    public void agregarCuentaBancaria(){
        //
    }
    public void eliminarCuentaBancaria(){
        //
    }
}
