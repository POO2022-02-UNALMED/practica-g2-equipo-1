package gestorAplicacion.gestionVentas;

import java.io.Serializable;
import java.util.ArrayList;

public class Gato implements Mascota, Serializable {
    //Serializador Gato
    private static ArrayList<Gato> gatos = new ArrayList<>();

    private long mascotaID;
    private String nombre;
    private int edad;
    private String tipo;
    private String raza;
    // Constructor
    public Gato(long mascotaID, String nombre, int edad, String tipo, String raza) {
        this.mascotaID = mascotaID;
        this.nombre = nombre;
        this.edad = edad;
        this.tipo = tipo;
        this.raza = raza;
    }
    //Metodos

    // Setters y Getters
    public static ArrayList<Gato> getGatos() {
        return gatos;
    }
    public static void setGatos(ArrayList<Gato> gatos) {
        Gato.gatos=gatos;
    }
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


}
