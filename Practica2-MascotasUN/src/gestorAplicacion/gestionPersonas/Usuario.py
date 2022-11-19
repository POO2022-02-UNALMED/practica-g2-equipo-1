"""Clase que crea y gestiona los objetos tipo Usuario, los cuales interactúan
  con la tienda comprando productos. Hereda de la clase Persona"""

from gestionAplicacion.gestionVentas import Tienda
class Usuario(Persona):
    usuarios={}
     
     #Constructor de la clase
    def __init__(self,personaId:int,nombre:str,email:str,telefono:int,direccion:str)->None:
        cuenta=None
        #Hacemos referencia al construtor de la clase padre
        super().__init__(self,personaId,nombre,email,telefono,cuenta)
        #Atributos
        mascotas=None
        compras=None
        factura=None
        self.direccion=direccion
        Tienda.setUsuarios(personaId,self)
        #Se guarda el objeto en un diccionario con su id como key
        Usuario.usuarios[self.personaId]=self    
      
    """Revisar sobrecarga de constructor"""
    #Métodos

	#Metodo toString() sobreescrito que se encarga de mostrar atributos 
 #   determinados de la clase usuario
    def __str__(self)->str:
        return   "~ ID # "+ str(self.personaId) + "\n" \
            + "~ Nombre: "+ str(self.nombre) + "\n" \
            + "~ Email: "+ str(self.email) + "\n" \
            + "~ Telefono: "+ str(self.telefono) + "\n" \
            + "~ Direccion: "+ str(self.direccion) + "\n" \
            + "~ Mascotas: "+ str(self.mascotas) + "\n" \
            + "~ Compras: "+ str(self.compras) + "\n" 
    
    #Método que encuentra al usuario en la lista de usuarios existentes y lo retorna, dado su ID
    def encontrarPersona(self):
        for u in self.usuarios:
            if u.getPersonaId()==self.personaId:
                return u
        return None

    #Método que agrega una factura al usuario dentro de la lista de compras realizadas
    def agregarFactura(self,factura):
        if self.factura==None:
            self.compras=None
        self.compras.append(factura)   
        
    #Método que registra una nueva mascota en la lista de mascotas pertenecientes al usuario
    def agregarMascota(self,mascota):
        if mascota!=None:
            self.mascotas.append(mascota)
    
                                         