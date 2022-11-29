
from src.gestorAplicacion.gestionVentas import Producto
from src.gestorAplicacion.gestionVentas.Tienda import Tienda
from src.gestorAplicacion.gestionPersonas.Vendedor import Usuario
from src.gestorAplicacion.gestionPersonas import Mascota
from random import randint

class Mascota:
    _mascotas = []
    mascotaID = randint(1, 1000000)
    # Metodo para identificar una mascota con su id.


class Gato(Mascota):


    gatos = {}
    #Constructor
    def __init__(self, nombre, edad,id):

        self.mascotaID=Gato.mascotaID
        self._nombre = nombre
        self._edad = edad
        Mascota._mascotas.append(self)
        self.usuario=self.encontrarUsuario(id)
        Gato.gatos[self.mascotaID] = self

    #Metodos

    # Metodo que dependiendo de la edad del gato (ingresada en anos) retornara si es Cachorro o Adulto
    def calcularEdad(self):
        if (self._edad <= 1):
            return "Cachorro"
        else:
            return "Adulto"
    def __str__(self) -> str:
        return "~ ID # " + str(self.mascotaID) + "\n" \
               + "~ Nombre: " + str(self._nombre) + "\n" \
               + "~ Edad: " + str(self._edad) + "\n" \
               + "~ Dueño: " + str(self.usuario) + "\n"
    def encontrarMascota(cls, id):
        if id in Gato.getGatos().keys():
            return Gato.getGatos().values()
        else:
            return None
    def encontrarUsuario(self,id):
        if id in Usuario.getUsuarios():
            return Usuario.getUsuarios()[id]
        else:
            return None
    # Metodo que dependiendo de la edad del gato, retornara una lista de productos recomendados
    def tipoAlimento(self):
        LAux = []
        for i in Tienda.getCatalogo():
            if isinstance(i, Producto):
                if ((i.getEspecie == "Gato") & (i.getEtapa == self.calcularEdad)):
                    LAux.append(i)

    @staticmethod
    def crearObjeto(nombre, edad,idUsuario):
        try:
            edad = int(edad)
            idUsuario=int(idUsuario)
            Gato(nombre,edad,idUsuario)
            return True
        except ValueError:
            return False

    #Getters & Setters
    @classmethod
    def getId(cls):
        return cls.mascotaID

    @classmethod
    def setMascotaId(cls, mascotaID):
        cls.mascotaID = mascotaID

    #Getters y setters

    @classmethod
    def getGatos(cls):
        return cls.gatos

    @classmethod
    def setGatos(cls,gatos):
        cls.gatos=gatos

    def getNombre(self):
        return self._nombre

    def setNombre(self, nombre):
        self._nombre = nombre

    def getEdad(self):
        return self._edad

    def setEdad(self, edad):
        self._edad = edad


from src.gestorAplicacion.gestionVentas import Producto
from src.gestorAplicacion.gestionVentas.Tienda import Tienda
from src.gestorAplicacion.gestionPersonas.Vendedor import Usuario


class Perro(Mascota):
    mascotaID=randint(1,1000000)
    perros = {}

    #Constructor
    def __init__(self, nombre, edad, raza,idUsuario):
        self.mascotaID=Perro.mascotaID
        self._nombre = nombre
        self._edad = edad
        self._raza = raza
        self.usuario=self.encontrarUsuario(idUsuario)
        Perro.perros[self.mascotaID] = self

        Mascota._mascotas.append(self)
    #Metodos

    # Metodo que dependiendo de la edad del gato (ingresada en anos) retornara si es Cachorro o Adulto
    def calcularEdad(self):
        if (self._edad <= 1):
            return "Cachorro"
        else:
            return "Adulto"

    def __str__(self) -> str:
        return "~ ID # " + str(self.mascotaID) + "\n" \
               + "~ Nombre: " + str(self._nombre) + "\n" \
               + "~ Edad: " + str(self._edad) + "\n" \
               + "~ Raza: " + str(self._raza) + "\n" \
               + "~ Dueño: " + str(self.usuario) + "\n"


    # Metodo que dependiendo de la edad del gato, retornara una lista de productos recomendados
    def tipoAlimento(self):
        LAux = []
        for i in Tienda.getCatalogo():
            if isinstance(i, Producto):
                if ((i.getEspecie == "Perro") & (i.getRaza == self.getRaza) & (i.getEtapa == self.calcularEdad)):
                    LAux.append(i)

    def encontrarUsuario(self,id):
        if id in Usuario.getUsuarios().keys():
            return Usuario.getUsuarios()[id]
        else:
            return None
    @staticmethod
    def crearObjeto(nombre,edad,raza,idUsuario):
        try:
            edad = int(edad)
            idUsuario=int(idUsuario)
            Perro(nombre,edad,raza,idUsuario)
            return True
        except ValueError:
            return False
    #Getters & Setters
    @classmethod
    def getMascotaId(cls):
        return cls.mascotaID

    @classmethod
    def setMascotaId(cls, mascotaID):
        cls.mascotaID = mascotaID

    #Getters y setters

    @classmethod
    def getPerros(cls):
        return cls.perros

    @classmethod
    def setPerros(cls,perros):
        cls.perros=perros

    def getIdUsuario(self):
        return self._idUsuario

    def setIdUsuario(self, idUsuario):
        self._idUsuario= idUsuario

    def getNombre(self):
        return self._nombre

    def setNombre(self, nombre):
        self._nombre = nombre

    def getEdad(self):
        return self._edad

    def setEdad(self, edad):
        self._edad = edad

    def getRaza(self):
        return self._raza

    def setRaza(self, raza):
        self._raza = raza