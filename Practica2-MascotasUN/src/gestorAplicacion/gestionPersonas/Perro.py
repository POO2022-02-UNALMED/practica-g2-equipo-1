
from gestionVentas.Tienda import Producto
from gestionVentas.Tienda import Tienda
from Mascota import Mascota

class Perro(Mascota):

    #Constructor
    def __init__(self, mascotaID, nombre, edad, raza):
        self._mascotaID = mascotaID
        self._nombre = nombre
        self._edad = edad
        self._raza = raza

    #Metodos

    # Metodo que dependiendo de la edad del gato (ingresada en anos) retornara si es Cachorro o Adulto
    def calcularEdad(self):
        if (self._edad <= 1):
            return "Cachorro"
        else:
            return "Adulto"

    # Metodo que dependiendo de la edad del gato, retornara una lista de productos recomendados
    def tipoAlimento(self):
        LAux = []
        for i in Tienda.getCatalogo:
            if (i isinstance Producto): 

    #Getters & Setters
    def getMascotaID(self):
        return self._mascotaID
    
    def setMascotaID(self, mascotaID):
        self._mascotaID = mascotaID

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