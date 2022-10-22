package gestorAplicacion.gestionPersonas;

public class CuentaBancaria {
	private Persona titular;
	private int nroCuenta;
	private double saldo;
	
	public CuentaBancaria () {
	}

	public CuentaBancaria(Persona titular, int nroCuenta, double saldo) {
		super();
		this.titular = titular;
		this.nroCuenta = nroCuenta;
		this.saldo = saldo;
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
}
