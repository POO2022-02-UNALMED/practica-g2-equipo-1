package gestionVentas;
//import java.util.ArrayList;

public class Mascota {
    private long mascotaID;
    private String nombre;
    private int edad;
    private String tipo;
    private String raza;
    private String tamano;

    // Constructor
    public Mascota(long mascotaID, String nombre, int edad, String tipo, String raza, String tamano) {
    this.mascotaID = mascotaID;
    this.nombre = nombre;
    this.edad = edad;
    this.tipo = tipo;
    this.raza = raza;
    this.tamano = tamano;
    }
    
    // Métodos
    //public Producto[] tipoAlimento() {
        //ArrayList<Producto> productos
        //ArrayList<Producto> productos=new ArrayList<Producto>()
    //}
    
    // Setters y Getters

    public long getMascotaID() {
        return mascotaID;
    }

    public void setMascotaID(long mascotaID) {
        this.mascotaID = mascotaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }
}