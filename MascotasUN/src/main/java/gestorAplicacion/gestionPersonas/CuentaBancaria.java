package gestorAplicacion.gestionPersonas;

import java.util.HashMap;
import java.util.Map.Entry;

import gestorAplicacion.gestionVentas.Producto;

public class CuentaBancaria {
	
	//Clase para la gestión de las cuentas bancarias de las personas.
	
	//Atributos
	private Persona titular;
	private long nroCuenta;
	private double saldo;
	private short pin;
	static private HashMap<CuentaBancaria, Integer> credenciales = new HashMap<>();
	
	//Contructor por defecto
	public CuentaBancaria () {
	}

	//Constructor
	public CuentaBancaria(Persona titular, int nroCuenta, double saldo) {
		super();
		this.titular = titular;
		this.nroCuenta = nroCuenta;
		this.saldo = saldo;
	}

	 //Inicio getters y setters
	public Persona getTitular() {
		return titular;
	}

	public void setTitular(Persona titular) {
		this.titular = titular;
	}

	public long getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public short getPin() {
		return pin;
	}

	public void setPin(short contraseña) {
		this.pin = contraseña;
	}
	//Final getters y setters
	
	//Metodo para retirar dinero de la cuenta
	public void retirar(double monto, short pin) {
		if (monto <= saldo & validarCredenciales(pin)==true ) {
			setSaldo(getSaldo() - monto);
		}
	}
	
	//Metodo para depositar dinero en la cuenta propia
	public void depositar(double monto) {
		setSaldo(monto + getSaldo());
	}
	

	//Metodo para tranferirle dinero a otra cuenta. Requiere ingresar la cuenta a la que se depositará el dinero, el monto a depositar, y el pin de la cuenta
	public void tranferir(CuentaBancaria cuenta, double monto, short pin) {
		if ( monto <= this.getSaldo() & validarCredenciales(pin)== true ) {
			this.retirar(monto, pin);
			cuenta.depositar(monto);
		}
	}
	
	//Metodo para la seguridad al acceso del dinero
	public boolean validarCredenciales(short pin){
        if (credenciales.get(this) == pin){
            return true;
        } else {
        	return false;
        }
	}
}
