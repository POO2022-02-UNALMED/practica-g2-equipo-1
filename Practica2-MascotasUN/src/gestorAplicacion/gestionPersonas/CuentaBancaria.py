class CuentaBancaria:
    
    _cuentasBancarias = []
    _credenciales = {}
    
    def __init__(self, nroCuenta=0, saldo=0, pin=0):
        self._nroCuenta = nroCuenta
        self._saldo = saldo
        self._pin = pin
        self._credenciales[nroCuenta] = pin
        self._cuentasBancarias.append(self)
        
    # Métodos
    
    # Metodo para retirar dinero de la cuenta propia. Ingresamos el monto a retirar y el pin de la cuenta. 
	# Se utiliza en el método transferir()
    def __str__(self) -> str:
        return  "~ NroCuenta: " + str(self._nroCuenta) + "\n" \
               + "~ Saldo: " + str(self._saldo) + "\n"
    def retirar(self, monto, pin):
        if monto <= self._saldo and self._validarCredenciales(pin) == True:
            self.setSaldo(self.getSaldo() - monto)
            
    # Metodo para depositar dinero en la cuenta propia. Ingresamos el monto a depositar.
	# Se utiliza en el método transferir() de la clase actual y en realizarCompra() de la clase Factura

    def depositar(self, monto):
        self.setSaldo(monto + self.getSaldo())
        
    # Metodo para tranferir dinero a otra cuenta. Requiere ingresar la cuenta a la que se depositará el dinero, 
    # el monto a depositar, y el pin de la cuenta
    
    def transferir(self, cuenta, monto, pin):
        if monto <= self.getSaldo() and self._validarCredenciales(pin) == True:
            self.retirar(monto, pin)
            if isinstance(cuenta, CuentaBancaria) == True:
                cuenta.depositar(monto)

    @staticmethod
    def crearObjeto(nroCuenta, saldo, pin):
        try:
            nroCuenta=int(nroCuenta)
            saldo = int(saldo)
            pin=int(pin)
            CuentaBancaria(nroCuenta, saldo, pin)
            return True
        except ValueError:
            return False

    # Getter y setter utilizados para la serializacion y deserializacion de objetos
    
    @classmethod
    def getCuentasBancarias(cls):
        return cls._cuentasBancarias
    
    @classmethod
    def setCuentasBancarias(cls, cuentasBancarias):
        cls._cuentasBancarias = cuentasBancarias
        
    # Getters y setters
        
    def getNroCuenta(self):
        return self._nroCuenta
    
    def setNroCuenta(self, nroCuenta):
        self._nroCuenta = nroCuenta
        
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
        cls._credenciales = credenciales