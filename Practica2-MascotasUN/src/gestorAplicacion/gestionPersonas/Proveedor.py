"""Clase que crea los objetos tipo Proveedor, los cuales interactúan con la tienda
vendiéndole el inventario requerido"""

from src.gestorAplicacion.gestionPersonas import CuentaBancaria
from src.gestorAplicacion.gestionPersonas.Vendedor import Persona
from src.gestorAplicacion.gestionVentas.Producto import Producto
from random import randint

class Proveedor(Persona):
    # Diccionario para almacenar las instancias de tipo proveedor
    proveedores = {}
    personaId = randint(1,1000000)
    """
       public Proveedor() {
    }"""

    # Constructor de la clase
    def __init__(self,nombre: str, email: str, telefono: int, stock: bool, nroCuenta:int,saldo:int,pin:int) -> None:
        variable= CuentaBancaria.CuentaBancaria()
        variable.setSaldo(saldo)
        variable.setPin(pin)
        variable.setNroCuenta(nroCuenta)
        # Hacemos referencia al construtor de la clase padre
        super().__init__(nombre, email, telefono, variable)
        # Atributos
        pedidos = None
        factura = None
        self.stock = stock
        Proveedor.personaId+=1
        self.personaId=Proveedor.personaId
        # Se guarda el objeto en un diccionario con su id como key
        Proveedor.proveedores[self.personaId] = self

        # Metodos

    # Método que agrega una factura al proveedor a la lista de pedidos enviados
    def agregarFactura(self, factura):
        if self.factura == None:
            self.pedidos = None
        self.pedidos.append(factura)

        # Metodo toString() que se encarga de mostrar atributos determinados de la clase proveedor

    def __str__(self) -> str:
        return "~ ID # " + str(self.personaId) + "\n" \
               + "~ Nombre: " + str(self.nombre) + "\n" \
               + "~ Email: " + str(self.email) + "\n" \
               + "~ Telefono: " + str(self.telefono) + "\n" \
               + "~ Stock: " + str(self.stock) + "\n" \
               + "" + str(self.cuenta) + "\n"

        # Método que encuentra al proveedor en la lista de proveedores existentes y lo retorna, dado su ID

    def encontrarPersona(self):
        for p in self.proveedores:
            if p.getPersonaId() == self.personaId:
                return p
        return None

    # Metodo que elimina a un proveedor de la lista de provedores
    def eliminarProveedor(cls):
        for p in cls.proveedores:
            if p.getPersonaId() == cls.personaId:
                cls.proveedores.pop(cls.personaId)
                return cls.proveedores
        return None

    @staticmethod
    def crearObjeto(nombre: str, email: str, telefono: int, stock: bool, nroCuenta:int,saldo:int,pin:int):
        try:
            telefono = int(telefono)
            nroCuenta = int(nroCuenta)
            saldo = int(saldo)
            pin = int(pin)
            if(stock=="True"):
                stock=True
            else:
                stock=False
            Proveedor(nombre, email, telefono,stock, nroCuenta, saldo, pin)
            return True
        except ValueError:
            return False

        # Metodos de clase
    @classmethod
    def getPersonaId(cls):
        return cls.personaId

    @classmethod
    def setPersonaId(cls, personaId):
        cls.personaId = personaId

    @classmethod
    def getProveedores(cls):
        return cls.proveedores

    @classmethod
    def setProveedores(cls, proveedores):
        cls.proveedores = proveedores

    # Getters y setters
    def getFactura(self):
        return self.factura

    def setFactura(self, factura):
        self.factura = factura

    def getPedidos(self):
        return self.pedidos

    def setPedidos(self, pedidos):
        self.pedidos = pedidos

    def isStock(self):
        return self.stock

    def setStock(self, stock):
        self.stock = stock
