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
	private short pin;
	private static int cantidadcuentas = 100000;
	static private HashMap<CuentaBancaria, Short> credenciales = new HashMap<>();

	//Constructor
	public CuentaBancaria(Persona titular, float saldo, short pin) {
		super();
		this.titular = titular;
		this.nroCuenta = cantidadcuentas;
		this.saldo = saldo;
		this.pin = pin;
		credenciales.put(this, pin);
		CuentaBancaria.cantidadcuentas++;
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
	
	public short getPin() {
		return pin;
	}

	public void setPin(short contrasena) {

		this.pin = contrasena;
	}
	//Final getters y setters
	
	//Metodo para retirar dinero de la cuenta
	public void retirar(float monto, short pin) {
		if (monto <= saldo & validarCredenciales(pin)==true ) {
			setSaldo(getSaldo() - monto);
		}
	}
	
	//Metodo para depositar dinero en la cuenta propia
	public void depositar(float monto) {
		setSaldo(monto + getSaldo());
	}
	

	//Metodo para tranferirle dinero a otra cuenta. Requiere ingresar la cuenta a la que se depositar� el dinero, el monto a depositar, y el pin de la cuenta
	public void tranferir(CuentaBancaria cuenta, float monto, short pin) {
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
