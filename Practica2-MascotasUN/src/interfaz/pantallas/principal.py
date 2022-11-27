# Se importan las librerías que vamos a utilizar
from tkinter import *
from src.interfaz.menus.menuPrincipal import MenuPrincipal
from src.interfaz.estilos.styles import *
from src.interfaz.pantallas.Instrucciones import Instrucciones
from src.interfaz.pantallas.fieldFrame import FieldFrame
from src.interfaz.pantallas.clientesValioso import ClienteValioso
from src.interfaz.pantallas.devolucion import Devolucion
from src.interfaz.pantallas.comision import Comision
from src.interfaz.pantallas.informeTienda import Informe
from src.interfaz.pantallas.consultaBDD import ConsultaBDD

class Principal(Toplevel):
    
    # Se crea el contructor de la clase
    def __init__(self, padre):
        # Se llama al padre (Toplevel)
        super().__init__(padre)
        
        # Titulo
        self.title("Mascotas UN")
        self.geometry("1280x1080")
        # Se agrega el menu
        menuPrincipal = MenuPrincipal(self, padre)
        self['menu'] = menuPrincipal
        
        # Inicio
        self._contenedor = Frame(self)
        self._contenedor.pack(side=TOP, fill=BOTH, expand=True)
        self._contenedor.configure(background=BACKGROUND_CONTENEDOR)
        self._contenedor.grid_columnconfigure(0, weight=1)
        self._contenedor.grid_rowconfigure(0, weight=1)
        
        self.frameFuncionalidad = {}
        
        for F in (Instrucciones, ClienteValioso, Devolucion, Comision, Informe, ConsultaBDD):
            self._frame =F(self._contenedor, self)
            self.frameFuncionalidad[F] = self._frame
            self._frame.grid(row=0, column=0, sticky=NSEW)
        self.mostrarFuncionalidades(Instrucciones)
        self._frame = Instrucciones(self._contenedor, self)
        self._frame.grid(row=0, column=0, sticky=NSEW)
        
    def showFieldFrame(self, values:dict):
        self._frame = FieldFrame(self._contenedor, self, **values)
        self._frame.grid(row=0, column=0, sticky=NSEW)
        self._frame.tkraise()

    def mostrarFuncionalidades(self, container):
        self._frame = self.frameFuncionalidad[container]
        self._frame.tkraise()
