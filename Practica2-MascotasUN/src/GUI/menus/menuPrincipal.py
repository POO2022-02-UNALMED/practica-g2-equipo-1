# Se importan las librería a utilizar
from distutils import command
from tkinter import *
from tkinter import messagebox
from src.GUI.GestionInterfaz.cobrarComision import CobrarComision

from src.GUI.GestionInterfaz import consultaInformacion
from src.GUI.GestionInterfaz.clientesValioso import ClienteValioso
from src.GUI.GestionInterfaz.comision import Comision
from src.GUI.GestionInterfaz.comprar import Comprar
from src.GUI.GestionInterfaz.consultaInformacion import ConsultaInformacion
#from src.GUI.GestionInterfaz.devolucion import Devolucion
from src.GUI.GestionInterfaz.informeTienda import Informe

from src.gestorAplicacion.gestionVentas.Producto import Producto
from src.GUI.GestionInterfaz.recomendacion import Recomendacion

"""from GUI.GestionInterfaz.fieldFrame import *
from GUI.GestionInterfaz.clientesValioso import ClienteValioso
from GUI.GestionInterfaz.devolucion import Devolucion
from GUI.GestionInterfaz.comision import Comision
from GUI.GestionInterfaz.informeTienda import Informe
from GUI.GestionInterfaz.consultaBDD import ConsultaBDD"""

class MenuPrincipal(Menu):
    
    #Se crea el método constructor
    def __init__(self, padre, controlador):
        # Se llama al padre (Menu), para que inicialice
        super().__init__(padre)
        
        # Atributos
        self._padre = padre
        self._controlador = controlador
        
        # Se crea la barra del menu con los submenus
        menuArchivos = Menu(self, tearoff=0)
        menuProcesos = Menu(self, tearoff=0)
        menuAyuda = Menu(self, tearoff=0)
        
        # se añaden los submenus a la barra del menu
        self.add_cascade(label="Archivo", menu=menuArchivos)
        self.add_cascade(label="Procesos y Consultas", menu=menuProcesos)
        self.add_cascade(label="Ayuda", menu=menuAyuda)
        
        self._values = {"tituloCriterios":"Atributos", "tituloValores":"Valores"}
        # Se crean los opciones de cada submenu
        
        # Para el caso del submenu Archivos
        menuArchivos.add_command(label="Aplicacion", command=self.informacionAplicativo)
        menuArchivos.add_command(label="Salir", command=self.salir)

        # Para el caso del submenu Procesos y Consultas
        menuProcesos.add_command(label="Gestionar Productos", command=self._gestionarProductos)
        menuProcesos.add_command(label="Gestionar Proveedores", command = self._gestionarProveedores)
        menuProcesos.add_command(label="Gestionar Usuarios", command=self._gestionarUsuarios)
        menuProcesos.add_command(label="Gestionar Perro", command = self._gestionarPerro)
        menuProcesos.add_command(label="Gestionar Gato", command=self._gestionarGato)
        menuProcesos.add_command(label="Gestionar Vendedores", command = self._gestionarVendedores)
        menuProcesos.add_command(label="Consultar datos MascotasUN", command=self._consultaInformacion)
        menuProcesos.add_command(label="Comprar inventario", command=self._comprar)
        menuProcesos.add_command(label="Ver estadisticas ventas", command=self._verInforme)
        menuProcesos.add_command(label="Recomendaciones Personalizadas", command=self._recomendacion)
        menuProcesos.add_command(label="Cobrar comision", command=self._cobrarComision)
        """
        
        menuProcesos.add_command(label="Comprar inventario", command=self._comprarInventario)
        menuProcesos.add_command(label="Cobrar comision", command=self._cobrarComision)
        
        menuProcesos.add_command(label="", command=self._recomendacionesPersonalizadas)"""

        # Para el caso del submenu Ayuda
        menuAyuda.add_command(label="Acerca de", command=self.quienesSomos)
        
    def salir(self):
        self._controlador.deiconify()
        self._padre.destroy()
        
    def informacionAplicativo(self):
        messagebox.showinfo(
                title="Información Básica",
                message="MascotasUN es una aplicacion pensada para la gestión de facturacion e inventario de una tienda "
                        "de productos para mascotas vista desde un administrador  que es el vendedor y  al obtener este "
                        "producto de software tendra acceso a una aplicacion en la cual podra llevar control de la tienda"
            )
        
    def quienesSomos(self):
        messagebox.showinfo(
                title="Autores",
                message="Hinara Pastora Sanchez Mata \nAlejandra Uribe Sierra \n Anna Ospina Bedoya \n Juan Felipe Lopez Ramirez\nJuan Jose Tobon Zapata"
            )
        
    def _gestionarUsuarios(self):
        self._values["criterios"] = ["ID","Nombre","Email","Telefono","Direccion","nroCuenta","saldo","pin"]
        self._values["habilitado"] = ["ID"]
        self._values["nombreProceso"] = "Gestionar usuario"
        self._values["descripcionProceso"] = "Guarda la informacion de un nuevo cliente"
        from src.gestorAplicacion.gestionPersonas.Vendedor import Usuario
        self._values["objeto"] = Usuario
        self._values["valores"] = [Usuario.getPersonaId] + [None]*(len(self._values["criterios"]) - len(self._values['habilitado']))
        self._values["atributos"] = ['id','nombre','email','telefono','direccion','nroCuenta','saldo','pin']
        self._padre.showFieldFrame(self._values)

    def _gestionarProveedores(self):
        self._values["criterios"] = ["ID","Nombre","Email","Telefono","Stock","nroCuenta","saldo","pin"]
        self._values["habilitado"] = ["ID"]
        self._values["nombreProceso"] = "Gestionar Proveedores"
        self._values["descripcionProceso"] = "Guarda la informacion de un nuevo proveedor"
        from src.gestorAplicacion.gestionPersonas.Proveedor import Proveedor
        self._values["objeto"] = Proveedor
        self._values["valores"] = [Proveedor.getId()] + [None]*(len(self._values["criterios"]) - len(self._values['habilitado']))
        self._values["atributos"] = ['id','nombre','email','telefono','stock','nroCuenta','saldo','pin']
        self._padre.showFieldFrame(self._values)

    def _gestionarVendedores(self):
        self._values["criterios"] = ["ID","Nombre","Email","Telefono","Usuario","Contrasena","nroCuenta","saldo","pin"]
        self._values["habilitado"] = ["ID"]
        self._values["nombreProceso"] = "Gestionar Vendedores"
        self._values["descripcionProceso"] = "Guarda la informacion de un nuevo vendedor"
        from src.gestorAplicacion.gestionPersonas.Vendedor import Vendedor
        self._values["objeto"] = Vendedor
        self._values["valores"] = [Vendedor.getId()] + [None]*(len(self._values["criterios"]) - len(self._values['habilitado']))
        self._values["atributos"] = ['id','nombre','email','telefono','usuario','contrasena','nroCuenta','saldo','pin']
        self._padre.showFieldFrame(self._values)

    #Falta
    def _gestionarProductos(self):
        self._values["criterios"] = ["ID","Nombre","Fecha de vencimiento","Descripcion","Precio Compra","Precio Venta","Cantidad Comprada","Raza","Etapa","Especie"]
        self._values["habilitado"] = ["ID"]
        self._values["nombreProceso"] = "Gestionar Productos"
        self._values["descripcionProceso"] = "Registra la informacion de un nuevo producto al sistema"
        from src.gestorAplicacion.gestionVentas.Producto import Producto
        self._values["objeto"] = Producto
        self._values["valores"] = [Producto.getProductoId()] + [None]*(len(self._values["criterios"]) - len(self._values['habilitado']))
        self._values["atributos"] = ['id','nombre','fechaVencimiento','descripcion','precioCompra','precioVenta','cantidadComprada','raza','etapa','especie']
        self._padre.showFieldFrame(self._values)

    def _gestionarPerro(self):
        self._values["criterios"] = ["ID", "Nombre", "Edad", "Raza","Id Usuario"]
        self._values["habilitado"] = ["ID"]
        self._values["nombreProceso"] = "Gestionar Perros"
        self._values["descripcionProceso"] = "Registra la informacion de una nueva mascota de tipo perro"
        from src.gestorAplicacion.gestionPersonas.Gato import Perro
        self._values["objeto"] = Perro
        self._values["valores"] = [Perro.getMascotaId()] + [None] * (len(self._values["criterios"]) - len(self._values['habilitado']))
        self._values["atributos"] = ['id', 'nombre','edad','raza','idUsuario']
        self._padre.showFieldFrame(self._values)

    def _gestionarGato(self):
        self._values["criterios"] = ["ID", "Nombre", "Edad","Id Usuario"]
        self._values["habilitado"] = ["ID"]
        self._values["nombreProceso"] = "Gestionar Gatos"
        self._values["descripcionProceso"] = "Registra la informacion de una nueva mascota de tipo gato"
        from src.gestorAplicacion.gestionPersonas.Gato import Gato
        self._values["objeto"] = Gato
        self._values["valores"] = [Gato.getId()] + [None] * (len(self._values["criterios"]) - len(self._values['habilitado']))
        self._values["atributos"] = ['id', 'nombre','edad','idUsuario']
        self._padre.showFieldFrame(self._values)
    
    def _comprar(self):
        self._padre.mostrarFuncionalidades(Comprar)
    def _consultaInformacion(self):
        self._padre.mostrarFuncionalidades(ConsultaInformacion)

 #   def _comprarInventario(self):
    #    self._padre.mostrarFuncionalidades(Devolucion)

    def _cobrarComision(self):
        self._padre.mostrarFuncionalidades(CobrarComision)

    def _verInforme(self):
        self._padre.mostrarFuncionalidades(Informe)

    def _recomendacion(self):
        self._padre.mostrarFuncionalidades(Recomendacion)
