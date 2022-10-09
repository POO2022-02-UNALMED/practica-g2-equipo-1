package gestionVentas;
import java.time.*;
public class CuentaBancaria {
    private long cuentaBancariaID;
    private int numeroCuenta;
    private LocalDate fechaCaducidad;
    private String nombre;
    private int CVV;
    private boolean estado;
    private float saldo;
    public cuentaBancaria(long cuentaBancariaID, int numeroCuenta,LocalDate fechaCaducidad,String nombre,int CVV, boolean estado, float saldo){
        this.cuentaBancariaID=cuentaBancariaID;
        this.numeroCuenta=numeroCuenta;
        this.fechaCaducidad=fechaCaducidad;
        this.nombre=nombre;
        this.CVV=CVV;
        this.estado=estado;
        this.saldo=saldo;
    }
    public boolean validarSaldo(){
        if(saldo>=0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public long getCuentaBancariaID() {
        return cuentaBancariaID;
    }

    public void setCuentaBancariaID(long cuentaBancariaID) {
        this.cuentaBancariaID = cuentaBancariaID;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
