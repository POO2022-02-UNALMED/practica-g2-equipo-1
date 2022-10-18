package gestionVentas;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

public class Vendedor extends Persona{
    private ArrayList<Factura> ventas=new ArrayList<Factura>();
    private String usuario;
    private long cuentaBancaria;
    private long contrasena;
    private boolean esAdmin;
    HashMap<String, String> usuarios = new HashMap<String, String>();
 
    public void dict(){
        usuarios.put("Juan", "holi12");
        usuarios.put("Roberto", "adios13");
        usuarios.put("Laura", "lau1245");
    }


    public Vendedor(int personaId, String nombre, String email, int documento, Date fechaDeNacimiento, int telefono,
            int nroCuentaBancaria, ArrayList<Factura> ventas, String usuario, long contrasena, boolean esAdmin) {
        super(personaId, nombre, email, documento, fechaDeNacimiento, telefono, nroCuentaBancaria);
        this.ventas = ventas;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.esAdmin = esAdmin;
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
    public long getContrasena() {
        return contrasena;
    }
    public void setContrasena(long contrasena) {
        this.contrasena = contrasena;
    }
    public boolean getEsAdmin() {
        return esAdmin;
    }
    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public boolean validarCredenciales(String usuario, String contrasena){
        dict();
        for (Entry<String, String> entry : usuarios.entrySet()) {
            if (usuario==entry.getKey() & contrasena==entry.getValue()){
                return true;
            }
        }
        return false;
    }
    
}
