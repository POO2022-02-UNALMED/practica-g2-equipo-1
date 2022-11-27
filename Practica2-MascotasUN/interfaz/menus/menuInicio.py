import tkinter as tk
from tkinter import messagebox

class MenuInicio(tk.Menu):
    
    def __init__(self, padre):
        super().__init__(padre)
        self._padre = padre
        inicio = tk.Menu(self)
        self.add_cascade(menu = inicio, label = "Inicio")
        inicio.add_command(label = "Descripcion del sistema", command=self.mostrarInfoSistema)
        inicio.add_command(label = "Salir", command=self.salir)
        
    def salir(self):
        self._padre.destroy()
        
    def mostrarInfoSistema(self):
        messagebox.showinfo(
                title="Descripción MascotasUN",
                message="Este sistema se encarga de gestionar toda la información de la tienda Mascotas UN, como por ejemplo el inventario, clientes, empleados entre otras funcionalidades"
            )