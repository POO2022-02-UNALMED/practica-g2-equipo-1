#Clase que crea y gestiona los objetos tipo Vendedor, los cuales interactúan directamente con las funcionalidades
 #de la aplicación. Hereda de la clase abstracta Persona. Existen dos diccionarios, el primero (usuarios) se encarga de
 #obtener usuarios con usuario y contrasena, el segundo (cantidadVentas) muestra el string del usuario y las ventas
 #del mismo

from src.gestorAplicacion.gestionPersonas.CuentaBancaria import CuentaBancaria
from src.gestorAplicacion.gestionPersonas import *
#from src.gestorAplicacion.gestionPersonas import Persona
# Clase abstracta Padre de las clases Usuario, Proveedor y Vendedor encarga de darle atributos y metodos basicos
# a los objetos creados a partir de estas clases*/

from src.gestorAplicacion.gestionVentas import  Factura  # Importamos la clase Factura para el método de agregarFactura()


class Persona:
    personas = []

    # Constructor
    def __init__(self, nombre, email, telefono, cuenta):
        self.nombre = nombre
        self.email = email
        self.telefono = telefono
        self.cuenta = cuenta
        Persona.personas.append(self)

    # // Sobrecarga de constructor, que incluye la cuenta bancaria de la persona
    # public Persona(long personaId, String nombre, String email, int telefono, CuentaBancaria cuenta){
    #    this(personaId,nombre,email,telefono);
    #    this.cuenta = cuenta;

    # Métodos

    # Método abstracto que se hereda a las clases Usuario, Proveedor y Vendedor,
    # que recibe como parámetro un objeto tipo Factura y retorna un void */
    def agregarFacturaf(self):  # Método abstracto
        pass

    # Método que recorre la lista de personas y las imprime, retornando un String.
    # Se resuelve el metodo toString() más específico de Usuario, Proveedor o Vendedor
    # por medio de la ligadura dinámica en tiempo de ejecucion*/
    @classmethod
    def verPersona(cls):
        resultado_nombre = ""
        for i in range(len(cls.personas)):
            resultado_nombre += (i + 1) + ". " + cls.personas[i] + "\n"
        return resultado_nombre

    # Método que encuentra a la persona en la lista de personas existentes y la retorna, dado su ID
    @classmethod
    def encontrarPersona(cls, personaId):
        for p in cls.personas:
            if (p.getPersonaId() == personaId):
                return p
        return None

    # Método que dado el ID de la persona, retorna un String con su respectiva bienvenida.
    # El método encontrarPersona() se resuelve por ligadura dinámica
    def bienvenidaPersona(self, ID):
        bienvenida = "Bienvenido, " + self.encontrarPersona(ID).getNombre()
        return bienvenida

    # Getters y setters

    def getVendedores(cls):
        return cls._vendedores

    def setVendedores(cls, vendedores):
        cls._vendedores = vendedores

    def setPersonaId(self, personaId):
        self.personaId = personaId

    def setNombre(self, nombre):
        self.nombre = nombre

    def setEmail(self, email):
        self.email = email

    def setTelefono(self, telefono):
        self.telefono = telefono

    def setCuenta(self, cuenta):
        self.cuenta = cuenta

    def getPersonaId(self):
        return self.personaId

    def getNombre(self):
        return self.nombre

    def getEmail(self):
        return self.email

    def getTelefono(self):
        return self.telefono

    def getCuenta(self):
        return self.cuenta

    def getPersonas(cls):
        return cls.personas


class Vendedor(Persona):
    _comision=0.05
    vendedores={}
    usuarios={}
    cantidadVentas={}
    personaId=0
    
    #Constructor
    def __init__(self,nombre, email, telefono, usuario,contrasena,nroCuenta,saldo,pin):
        super().__init__(nombre, email, telefono,self.cuentaBancaria)
        self.cuentaBancaria = CuentaBancaria(nroCuenta, saldo, pin)
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
