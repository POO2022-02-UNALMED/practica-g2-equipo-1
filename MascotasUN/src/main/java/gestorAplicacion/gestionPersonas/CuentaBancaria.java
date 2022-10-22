package gestorAplicacion.gestionPersonas;

import gestorAplicacion.gestionVentas.Tienda;

import java.util.ArrayList;

public class CuentaBancaria {
	//Serializador clase tienda
	private static ArrayList<CuentaBancaria> cuentasBancarias = new ArrayList<>();
	private Persona titular;
	private int nroCuenta;
	private double saldo;
	
	public CuentaBancaria () {
	}

	//Constructor
	public CuentaBancaria(Persona titular, int nroCuenta, double saldo) {
		super();
		this.titular = titular;
		this.nroCuenta = nroCuenta;
		this.saldo = saldo;
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

	public int getNroCuenta() {
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
	
	public void tranferir(CuentaBancaria cuenta, double monto) {
		if (monto <= this.getSaldo()) {
			cuenta.setSaldo(monto + cuenta.getSaldo());
			cuenta.setSaldo(this.getSaldo() - monto);
		}
	}
}
