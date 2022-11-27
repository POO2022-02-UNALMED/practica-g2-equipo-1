from src.interfaz import manager
from tkinter import *
from src.interfaz.pantallas.principal import Principal
from src.baseDatos.Deserializador import *
from src.baseDatos.Serializador import *

if __name__ == "__main__":
    app = manager.Manager()
    Deserializador.deserializar()
    app.mainloop()
    Serializador.serializar()