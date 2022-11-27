#Clase que crea y gestiona los objetos tipo Vendedor, los cuales interactúan directamente con las funcionalidades
 #de la aplicación. Hereda de la clase abstracta Persona. Existen dos diccionarios, el primero (usuarios) se encarga de
 #obtener usuarios con usuario y contrasena, el segundo (cantidadVentas) muestra el string del usuario y las ventas
 #del mismo
from src.gestorAplicacion.gestionPersonas.CuentaBancaria import CuentaBancaria
from src.gestorAplicacion.gestionPersonas import Persona
#from gestorAplicacion.gestionVentas.Factura import Factura


class Vendedor(Persona):
    _comision=0.05
    vendedores={}
    usuarios={}
    cantidadVentas={}
    personaId=0
    
    #Constructor
    def __init__(self,nombre, email, telefono, usuario,contrasena,nroCuenta,saldo,pin):
        self.cuentaBancaria = CuentaBancaria(nroCuenta, saldo, pin)
        super().__init__(nombre, email, telefono,self.cuentaBancaria)
        _ventas=None
        self._usuario = usuario
        self._contrasena = contrasena
        Vendedor.personaId+=1
        Vendedor.vendedores[self.personaId] = self

    #Métodos
    
	# Método para ordenar el HashMap del vendedor por la cantidad de ventas 
    @classmethod
    def getValoresOrdenados(cls):
        valores= sorted(cls.cantidadVentas.values())
        return  valores

    #Método sobreescrito toString()  
    def __str__(self):
        cadena="~ ID #"+ self.personaId + "\n", 
        "~ Nombre = " + self.nombre +"\n", 
        "~ Email = " + self.email + "\n",
        "~ Telefono = " + self.telefono+ "\n",
        "~ Usuario = " +self.usuario+ "\n",
        "~ Ventas = " +self.ventas+ "\n",
        return cadena
    
    #Método que agrega al vendedor a la lista de vendedores
    @classmethod
    def agregarVendedor(cls, vendedor):
        cls._vendedores.append(vendedor)

    #Método que agrega una factura al vendedor dentro de la lista de ventas realizadas
    def agregarFactura(self,f):
        self._ventas.append(f)

    #Método que permite validar que las credenciales ingresadas por el vendedor al iniciar sesión sean correctas

    @classmethod
    def validarCredenciales(cls,usuario, contrasena):
        for i in cls.usuarios.keys():
            if usuario==i and contrasena==cls.usuarios.get(i):
                return True
        return False
    
    #Método que encuentra al vendedor en la lista de vendedores existentes y lo retorna, dado su ID
    @classmethod
    def encontrarPersona(cls, personaId):
        for p in cls.vendedores:
            if(p.getPersonaId()== personaId):
                return p
        return None

    @classmethod
    def getId(cls):
        return cls.personaId

    @classmethod
    def setId(cls, personaId):
        cls.personaId = personaId

    #Getters y setters

    @classmethod
    def getVendedores(cls):
        return cls.vendedores

    @classmethod
    def setVendedores(cls,vendedores):
        cls.vendedores=vendedores
    
    def getVentas(self):
        return self._ventas

    def setVentas(self,ventas):
        self._ventas = ventas
        
    def getUsuario(self):
        return self._usuario

    def setUsuario(self,usuario):
        self._usuario = usuario
        
    def getContrasena(self):
        return self._contrasena

    def setContrasena(self,contrasena):
        self._contrasena = contrasena

    def getUsuarios(cls):
        return cls._usuarios
    
    def setUsuarios(cls,usuarios):
        cls._usuarios=usuarios
        
    def getCantidadVentas(cls):
        return cls.cantidadVentas
    
    def setCantidadVentas(cls,cantidadVentas):
        cls.cantidadVentas=cantidadVentas
        
    def getComision(cls):
        return cls._comision
