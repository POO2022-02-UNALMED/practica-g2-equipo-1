
from src.gestorAplicacion.gestionVentas import Producto
from src.gestorAplicacion.gestionVentas.Tienda import Tienda
from src.gestorAplicacion.gestionPersonas import Usuario
from Mascota import Mascota

class Gato(Mascota):
    mascotaID=0
    gatos = {}
    #Constructor
    def __init__(self, nombre, edad,idUsuario):
        Gato.mascotaID+=1
        self._nombre = nombre
        self._edad = edad
        Mascota._mascotas.append(self)
        self.usuario=self.encontrarUsuario(idUsuario)
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
               + "~ Dueño: " + str(self._idUsuario) + "\n"

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

    #Getters & Setters
    @classmethod
    def getMascotaId(cls):
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