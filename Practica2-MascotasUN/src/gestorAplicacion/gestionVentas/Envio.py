"""
       Clase que permite la gestión de la 
       funcionalidad de los envíos programados periódicos a un cliente
    """
    
class Envio():
    #Identificador unico de cada instancia
    idEnvio=0
    #Diccionario para guardar los envios registrados en el sistema
    envios={}
    #Constructor para la clase
    def __init__(self,destino:str,estadoEnvio:str,periodicidad:int)->None:
        Envio.idEnvio+=1
        self.destino=destino
        self.estadoEnvio=estadoEnvio
        self.periodicidad =periodicidad
        #Se guarda el objeto en un diccionario con su id como key
        Envio.envios[self.idEnvio]=self 
        #Se trae objeto de tipo factura
        self.factura=None   
    #Métodos
    
    #Método que edita los atributos del envío    
    def editarEnvio(self,destino:str,estadoEnvio:str,periodicidad:int):
        self.estadoEnvio=estadoEnvio
        self.destino=destino
        self.periodicidad=periodicidad
        
    #Metodo toString    
    def __str__(self)->str:
        return   "Identificador: "+ str(self.idEnvio) + "\n" \
            + "Destino: "+ str(self.destino) + "\n" \
            + "Estado envio: "+ str(self.estadoEnvio) + "\n" \
            + "Periodicidad: "+ str(self.periodicidad) + "\n" \
            + "Factura Asociada: "+ str(self.factura) + "\n"

    #Metodos de clase
    @classmethod
    def getEnvios(cls):
        return cls.envios
    
    @classmethod
    def setEnvios(cls, envios):
        cls.envios=envios
        
    #Getters y setters
     
    def getDestino(self):
        return self.destino
    
    def setDestino(self,destino):
        self.destino=destino
        
    def getFactura(self):
        return self.factura
        
    def setFactura(self,factura):
        self.factura=factura
        
    def getEstadoEnvio(self):
        return self.estadoEnvio
    
    def setEstadoEnvio(self,estadoEnvio:str):
        self.estadoEnvio=estadoEnvio
    
    def getPeriodicidad(self):
        return self.periodicidad
    
    def setPeriodicidad(self,periodicidad):
        self.periodicidad=periodicidad
     
        
        