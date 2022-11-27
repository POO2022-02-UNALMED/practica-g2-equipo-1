#Clase abstracta Padre de las clases Usuario, Proveedor y Vendedor encarga de darle atributos y metodos basicos
# a los objetos creados a partir de estas clases*/

from gestorAplicacion.gestionVentas.Factura import Factura # Importamos la clase Factura para el método de agregarFactura()

class Persona:
    personas = []
    
    #Constructor
    def __init__(self,personaId, nombre, email, telefono, cuenta):
        self.personaId = personaId
        self.nombre = nombre
        self.email = email
        self.telefono= telefono
        self.cuenta= cuenta
        Persona.personas.append(self)
    
    #// Sobrecarga de constructor, que incluye la cuenta bancaria de la persona
    #public Persona(long personaId, String nombre, String email, int telefono, CuentaBancaria cuenta){
    #    this(personaId,nombre,email,telefono);
    #    this.cuenta = cuenta;
    
    #Métodos
    
    # Método abstracto que se hereda a las clases Usuario, Proveedor y Vendedor,
    # que recibe como parámetro un objeto tipo Factura y retorna un void */
    def agregarFacturaf(): # Método abstracto
        pass
  	
  	#Método que recorre la lista de personas y las imprime, retornando un String.
  	#Se resuelve el metodo toString() más específico de Usuario, Proveedor o Vendedor
  	#por medio de la ligadura dinámica en tiempo de ejecucion*/
    def verPersona(cls):
        resultado_nombre = ""
        for i in range(len(cls.personas)):
            resultado_nombre += (i+1) + ". " + cls.personas[i] + "\n"
        return resultado_nombre
  	
  	#Método que encuentra a la persona en la lista de personas existentes y la retorna, dado su ID
    def encontrarPersona(cls,personaId):
        for p in cls.personas:
            if(p.getPersonaId()== personaId):
                return p
        return None
  	
 	#Método que dado el ID de la persona, retorna un String con su respectiva bienvenida.
 	#El método encontrarPersona() se resuelve por ligadura dinámica
    def bienvenidaPersona(ID):
        bienvenida = "Bienvenido, " + encontrarPersona(ID).getNombre()
        return bienvenida
    
    #Getters y setters
    
    def getVendedores(cls):
        return cls._vendedores
    
    def setVendedores(cls,vendedores):
        cls._vendedores=vendedores

    def setPersonaId(self,personaId):
        self.personaId = personaId
        
    def setNombre(self,nombre):
        self.nombre = nombre

    def setEmail(self,email):
        self.email = email
        
    def setTelefono(self,telefono):
        self.telefono = telefono
        
    def setCuenta(self,cuenta):
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


    