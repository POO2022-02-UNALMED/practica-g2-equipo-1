from tkinter import *
from src.GUI.estilos.styles import *

class Instrucciones(Frame):
    
    def __init__(self, padre, controlador):
        super().__init__(padre)
        self.configure(background=BACKGROUND_CONTENEDOR)
        self._controlador = controlador
        
        self._inicializarTitulo()
        self._mostrarInformacion()
        
    def _inicializarTitulo(self):    
        # Se inicializa el título  que va a estar en la parte superior de la ventana
        labelInicial = Label(self, justify=CENTER, text="Manual de Instrucciones e Información de la aplicación", bg=BACKGROUND_FRAMES, font=FONT, fg=FG)
        labelInicial.pack(side=TOP, fill=BOTH, padx=10, pady=10)
        
    def _mostrarInformacion(self):
        Label(self, text="Te encuentras en el menu principal de Mascotas UN", bg=BACKGROUND_CONTENEDOR, font=FONT2, fg=FG).pack(side=TOP, fill=BOTH, padx=10, pady=10)
        Label(self, text="Tienes las siguientes opciones disponibles", bg=BACKGROUND_CONTENEDOR, font=FONT2, fg=FG).pack(side=TOP, fill=BOTH, padx=10, pady=10)
        Label(self, text="En el menú desplegable en la parte superior podras encontrar", bg=BACKGROUND_CONTENEDOR, font=FONT3, fg=FG, justify=LEFT).pack(side=TOP, fill=BOTH, padx=10, pady=30)
        Label(self, text="~ [Archivo] Aquí encontraras información sobre acerca de la tienda Mascotas UN", bg=BACKGROUND_CONTENEDOR, font=FONT4, fg=FG, justify=LEFT).pack(side=TOP, fill=BOTH, padx=10, pady=10)
        Label(self, text="~ [Procesos y consultas] Aquí podrás utilizar las principales funcionalidades de la aplicación, entre ellas cálculos de comisiones, búsquedas, y otras funcionalidades de mucha utilidad para la tienda", bg=BACKGROUND_CONTENEDOR, font=FONT4, fg=FG, justify=LEFT).pack(side=TOP, fill=BOTH, padx=10, pady=10)
        Label(self, text="~ [Ayuda] Aquí puedes encontrar la información de contacto de los desarrolladores", bg=BACKGROUND_CONTENEDOR, font=FONT4, fg=FG, justify=LEFT).pack(side=TOP, fill=BOTH, padx=10, pady=10)
        
        
        
        
