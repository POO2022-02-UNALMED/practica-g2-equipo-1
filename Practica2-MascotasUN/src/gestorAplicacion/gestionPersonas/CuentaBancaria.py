
class CuentaBancaria:	
	
	_cuentasBancarias = []
	_credenciales = {}

	#Constructor
	def __init__(self, nroCuenta, saldo, pin = None):
		self._nroCuenta = nroCuenta
		self._saldo = saldo
		self._pin = pin
		CuentaBancaria._credenciales[nroCuenta] = pin
	
	#Métodos
	
	# Metodo para retirar dinero de la cuenta propia. Ingresamos el monto a retirar y el pin de la cuenta. 
	# Se utiliza en el método transferir()
	def retirar(self, monto, pin) :
		if (monto <= self._saldo & self._validarCredenciales(pin)==True):
			setSaldo(getSaldo() - monto)
		
	#Metodo para depositar dinero en la cuenta propia. Ingresamos el monto a depositar.
	#Se utiliza en el método transferir() de la clase actual y en realizarCompra() de la clase Factura*/
	def depositar(self, monto):
		self.setSaldo(monto + self.getSaldo())

	#Metodo para tranferir dinero a otra cuenta. Requiere ingresar la cuenta a la que se depositará el dinero, el monto a depositar, y el pin de la cuenta*/
	def tranferir(self, cuenta, monto, pin):
		if (monto <= self.getSaldo() & self.validarCredenciales(pin)== True):
			self.retirar(monto, pin)
			if (isinstance(cuenta, CuentaBancaria)):
			    cuenta.depositar(monto)	
    #Metodo para la seguridad al acceso del dinero de la cuenta
    def validarCredenciales(self, pin):
	    if (self.getPin() == pin):
	        return True
	    else:
		    return False

    #Getter y setter utilizados para la serializacion y deserializacion de objetos
    @classmethod
    def getCuentasBancarias(cls):
		return cls._cuentasBancarias

    @classmethod
	def setCuentasBancarias(cls, cuentasBancarias):
	    cls._cuentasBancarias=cuentasBancarias

    #Getters y setters
	def getNroCuenta(self) :
		return self._nroCuenta
	
	def setNroCuenta(self, nroCuenta):
		self._nroCuenta = nroCuenta;
	
	def getSaldo(self):
		return self._saldo

	def setSaldo(self, saldo):
		self._saldo = saldo
	
	def getPin(self):
		return self._pin
	
	def setPin(self, pin):
		self._pin = pin

	@classmethod
	def getCredenciales(cls):
		return cls._credenciales

    @classmethod
	def setCredenciales(cls, credenciales):
		cls.credenciales = credenciales