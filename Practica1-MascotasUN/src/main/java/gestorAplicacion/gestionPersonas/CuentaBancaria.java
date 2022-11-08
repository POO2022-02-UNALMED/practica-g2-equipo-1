	/* Esta clase se encarga de crear las cuentas bancarias para los objetos de tipo
	 * persona y tienda. El atributo credenciales es un hashmap que como key recibe el id
	 * de la cuenta y como value el pin*/

package gestorAplicacion.gestionPersonas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class CuentaBancaria implements Serializable{

	//Atributo para el serializador
	private static final long serialVersionUID = 1L;
	private static ArrayList<CuentaBancaria> cuentasBancarias = new ArrayList<>();
	
	//Atributos
	private long nroCuenta;
	private float saldo;
	private int pin;
	static private HashMap<Long,Integer> credenciales = new HashMap<>();

	//Constructor

	public CuentaBancaria(long nroCuenta, float saldo, int pin) {
		this(nroCuenta,saldo);
		this.pin = pin;
		credenciales.put(nroCuenta, pin);
		cuentasBancarias.add(this);
	}
	//Sobrecarga de constructores que se utiliza para la clase vendedores
	public CuentaBancaria(long nroCuenta, float saldo){
		this.nroCuenta= nroCuenta;
		this.saldo=saldo;
		cuentasBancarias.add(this);
	}
	
	// Métodos
	
		/* Metodo para retirar dinero de la cuenta propia. Ingresamos el monto a retirar y el pin de la cuenta. 
		 * Se utiliza en el método transferir() */
		void retirar(float monto, int pin) {
			if (monto <= saldo & validarCredenciales(pin)==true) {
				setSaldo(getSaldo() - monto);
			}
		}
		
		/*Metodo para depositar dinero en la cuenta propia. Ingresamos el monto a depositar.
		 * Se utiliza en el método transferir() de la clase actual y en realizarCompra() de la clase Factura*/
		public void depositar(float monto) {
			setSaldo(monto + getSaldo());
		}

		/*Metodo para tranferir dinero a otra cuenta. Requiere ingresar la cuenta a la que se depositará 
		 * el dinero, el monto a depositar, y el pin de la cuenta*/
		public void tranferir(CuentaBancaria cuenta, float monto, int pin) {
			if (monto <= this.getSaldo() & validarCredenciales(pin)== true) {
				this.retirar(monto, pin);
				cuenta.depositar(monto);
			}
		}
		
		//Metodo para la seguridad al acceso del dinero de la cuenta
		public boolean validarCredenciales(int pin){
	        if (getPin() == pin){
	            return true;
	        } else {
	        	return false;
	        }
		}

	//Getter y setter utilizados para la serializacion y deserializacion de objetos
	public static ArrayList<CuentaBancaria> getCuentasBancarias() {
		return cuentasBancarias;
	}
	public static void setCuentasBancarias(ArrayList<CuentaBancaria> cuentasBancarias) {
		CuentaBancaria.cuentasBancarias=cuentasBancarias;
	}

	//Getters y setters
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
	
	public void setPin(int pin) {
		this.pin = pin;
	}

	public static HashMap<Long, Integer> getCredenciales() {
		return credenciales;
	}

	public static void setCredenciales(HashMap<Long, Integer> credenciales) {
		CuentaBancaria.credenciales = credenciales;
	}
}