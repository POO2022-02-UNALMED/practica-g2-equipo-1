from src.GUI.manager import Manager
from tkinter import *
from src.GUI.GestionInterfaz.principal import Principal
from src.baseDatos.Deserializador import *
from src.baseDatos.Serializador import *

if __name__ == "__main__":
    app = Manager()
    Deserializador.deserializar()
    app.mainloop()
    Serializador.serializar()