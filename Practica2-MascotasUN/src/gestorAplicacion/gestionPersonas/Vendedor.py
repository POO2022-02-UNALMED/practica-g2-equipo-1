#Clase que crea y gestiona los objetos tipo Vendedor, los cuales interactúan directamente con las funcionalidades
 #de la aplicación. Hereda de la clase abstracta Persona. Existen dos diccionarios, el primero (usuarios) se encarga de
 #obtener usuarios con usuario y contrasena, el segundo (cantidadVentas) muestra el string del usuario y las ventas
 #del mismo

from src.gestorAplicacion.gestionPersonas import CuentaBancaria
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

    def setNombre(self, nombre):
        self.nombre = nombre

    def setEmail(self, email):
        self.email = email

    def setTelefono(self, telefono):
        self.telefono = telefono

    def setCuenta(self, cuenta):
        self.cuenta = cuenta

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
        variable= CuentaBancaria.CuentaBancaria()
        variable.setSaldo(saldo)
        variable.setPin(pin)
        variable.setNroCuenta(nroCuenta)
        # Hacemos referencia al construtor de la clase padre
        super().__init__(nombre, email, telefono, variable)
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


        # Metodo toString() sobreescrito que se encarga de mostrar atributos
        #   determinados de la clase usuario

    def __str__(self) -> str:
        return "~ ID # " + str(self.personaId) + "\n" \
               + "~ Nombre: " + str(self.nombre) + "\n" \
               + "~ Email: " + str(self.email) + "\n" \
               + "~ Telefono: " + str(self.telefono) + "\n" \
               + "~ Usuario: " + str(self._usuario) + "\n" \
               + "" + str(self.cuenta) + "\n" \

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

    @staticmethod
    def crearObjeto(nombre, email, telefono, usuario,contrasena,nroCuenta,saldo,pin):
        try:
            telefono = int(telefono)
            nroCuenta=int(nroCuenta)
            saldo = int(saldo)
            pin=int(pin)
            Vendedor(nombre, email, telefono, usuario,contrasena,nroCuenta,saldo,pin)
            return True
        except ValueError:
            return False

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

class Usuario(Persona):
    usuarios = {}
    personaId = 0
    # Constructor de la clase

    def __init__(self, nombre: str, email: str, telefono: int, direccion: str, nroCuenta: int, saldo: int, pin: int) -> None:
        variable= CuentaBancaria.CuentaBancaria()
        variable.setSaldo(saldo)
        variable.setPin(pin)
        variable.setNroCuenta(nroCuenta)
        # Hacemos referencia al construtor de la clase padre
        super().__init__(nombre, email, telefono, variable)
        # Atributos
        mascotas = None
        compras = None
        factura = None
        Usuario.personaId += 1
        self.direccion = direccion
        # Se guarda el objeto en un diccionario con su id como key
        Usuario.usuarios[self.personaId] = self

    """Revisar sobrecarga de constructor"""

    # Métodos

    # Metodo toString() sobreescrito que se encarga de mostrar atributos
    #   determinados de la clase usuario

    def __str__(self) -> str:
        return "~ ID # " + str(self.personaId) + "\n" \
               + "~ Nombre: " + str(self.nombre) + "\n" \
               + "~ Email: " + str(self.email) + "\n" \
               + "~ Telefono: " + str(self.telefono) + "\n" \
               + "~ Direccion: " + str(self.direccion) + "\n" \
               + "" + str(self.cuenta) + "\n" \
        # Método que encuentra al usuario en la lista de usuarios existentes y lo retorna, dado su ID


    @classmethod
    def encontrarPersona(cls):
        for u in cls.usuarios:
            if u.getPersonaId() == cls.personaId:
                return u
        return None


    # Método que agrega una factura al usuario dentro de la lista de compras realizadas
    def agregarFactura(self, factura):
        if self.factura == None:
            self.compras = None
        self.compras.append(factura)

        # Método que registra una nueva mascota en la lista de mascotas pertenecientes al usuario

    def agregarMascota(self, mascota):
        if mascota != None:
            self.mascotas.append(mascota)

    # Método que permite eliminar un usuario desde la gestión de usuarios de la tienda
    @staticmethod
    def crearObjeto(nombre: str, email: str, telefono: int, direccion: str, nroCuenta: int, saldo: int, pin: int):
        try:
            telefono = int(telefono)
            nroCuenta=int(nroCuenta)
            saldo = int(saldo)
            pin=int(pin)
            Usuario(nombre, email, telefono, direccion, nroCuenta, saldo, pin)
            return True
        except ValueError:
            return False
    @classmethod
    def eliminarUsuario(cls):
        for usuario in cls.usuarios:
            if usuario.getPersonaId() == cls.personaId:
                cls.usuarios.pop(cls.personaId)
                return cls.usuarios
        return None

    # Metodos de clase
    @classmethod
    def getUsuarios(cls):
        return cls.usuarios

    @classmethod
    def setUsuarios(cls, usuarios):
        cls.usuarios = usuarios


    @classmethod
    def getPersonaId(cls):
        return cls.personaId

    @classmethod
    def setPersonaId(cls, personaId):
        cls.personaId = personaId

    # Getters y setters
    def getDireccion(self):
        return self.direccion

    def setDireccion(self, direccion):
        self.direccion = direccion

    def getMascotas(self):
        return self.mascotas

    def setMascotas(self, mascotas):
        self.mascotas = mascotas

    def getnroCuenta(self):
        return self.nroCuenta

    def setnroCuenta(self,nroCuenta):
        self.nroCuenta =nroCuenta

    def getCompras(self):
        return self.compras

    def setCompras(self, compras):
        self.compras = compras

    def getFactura(self):
        return self.factura

    def setFactura(self, factura):
        self.factura = factura
