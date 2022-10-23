package gestorAplicacion.gestionPersonas;

import java.util.ArrayList;
import java.util.HashMap;

public class CuentaBancaria {
	//Clase para la gestion de las cuentas bancarias de las personas.

	//Serializador clase tienda
	private static ArrayList<CuentaBancaria> cuentasBancarias = new ArrayList<>();
	
	//Atributos
	private Persona titular;
	private long nroCuenta;
	private float saldo;
	private int pin;
	static private HashMap<Long,Integer> credenciales = new HashMap<>();

	//Constructor
	public CuentaBancaria(Persona titular, long nroCuenta, float saldo, int pin) {
		super();
		this.titular = titular;
		this.nroCuenta = nroCuenta;
		this.saldo = saldo;
		this.pin = pin;
		credenciales.put(nroCuenta, pin);
	}

	//Getters y setters
	public static ArrayList<CuentaBancaria> getCuentasBancarias() {
		return cuentasBancarias;
	}
	public static void setCuentasBancarias(ArrayList<CuentaBancaria> cuentasBancarias) {
		CuentaBancaria.cuentasBancarias=cuentasBancarias;
	}
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

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public int getPin() {
		return pin;
	}

	public void setPin(short contrasena) {
		this.pin = contrasena;
	}
	//Final getters y setters
	
	//Metodo para retirar dinero de la cuenta
	public void retirar(float monto, int pin) {
		if (monto <= saldo & validarCredenciales(pin)==true ) {
			setSaldo(getSaldo() - monto);
		}
	}
	
	//Metodo para depositar dinero en la cuenta propia
	public void depositar(float monto) {
		setSaldo(monto + getSaldo());
	}
	

	//Metodo para tranferirle dinero a otra cuenta. Requiere ingresar la cuenta a la que se depositar� el dinero, el monto a depositar, y el pin de la cuenta
	public void tranferir(CuentaBancaria cuenta, float monto, int pin) {
		if (monto <= this.getSaldo() & validarCredenciales(pin)== true) {
			this.retirar(monto, pin);
			cuenta.depositar(monto);
		}
	}
	
	//Metodo para la seguridad al acceso del dinero
	public boolean validarCredenciales(int pin){
        if (credenciales.get(this) == pin){
            return true;
        } else {
        	return false;
        }
	}
}
