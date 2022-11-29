# Se importan las librerías que vamos a utilizar
from tkinter import *
from src.GUI.menus.menuPrincipal import MenuPrincipal
from src.GUI.estilos.styles import *
from src.GUI.GestionInterfaz.Instrucciones import Instrucciones
from src.GUI.GestionInterfaz.comprar import Comprar
from src.GUI.GestionInterfaz.fieldFrame import FieldFrame
from src.GUI.GestionInterfaz.clientesValioso import ClienteValioso
#from src.GUI.GestionInterfaz.devolucion import Devolucion
from src.GUI.GestionInterfaz.comision import Comision
from src.GUI.GestionInterfaz.informeTienda import Informe
from src.GUI.GestionInterfaz.consultaInformacion import ConsultaInformacion
from src.GUI.GestionInterfaz.recomendacion import Recomendacion


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
        
        for F in (Instrucciones, Comprar,  Comision, Informe, ConsultaInformacion,Recomendacion):
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
        self._frame.place(relheight=1,relwidth=1)
    def mostrarFuncionalidades(self, container):
        self._frame = self.frameFuncionalidad[container]
        self._frame.tkraise()
        self._frame.place(relheight=1, relwidth=1)