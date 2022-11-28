from tkinter import *
from src.interfaz.estilos.styles import *
from src.gestorAplicacion.gestionPersonas import Usuario
from src.gestorAplicacion.gestionVentas import Producto

from src.gestorAplicacion.gestionVentas import *
from excepciones import *

class RealizarVenta(Frame):
    
    # Se crea el contructor de la clase dónde se le pasan como parámetros el padre o frame que lo contiene y la clase controlador que es Principal
    def __init__(self, padre, controlador):
        # Se llama inicializa el constructor padre de la clase
        super().__init__(padre)
        # Se configura el Frame
        self.configure(background=BACKGROUND_CONTENEDOR)
        #Atributos
        self._controlador = controlador
        
        # Se inicializan los widgets que van en la interfaz
        self._mostrarTitulo()
        self._ConsultarCompras()
        self._mostrarCompras()
        self._seleccionCompraADevolver()

        self._mostrarTitulo()
        self._consultarUsuario()
        self._mostrarProductosDisponibles()
        self._agregarProductoCompra()
        self._eliminarProductoCompra()
        self._mostrarResumen()
        self._configurarEnvio()
        self._finalizarCompra()
        
    def _mostrarTitulo(self):
        # Label superior con el título de la pantalla
        self._titulo = Label(self, justify=CENTER, text="Realizar venta", bg=BACKGROUND_FRAMES, font=FONT, fg=FG)
        self._titulo.pack(side=TOP, fill=X, padx=10, pady=10)
        
    def _ConsultarUsuario(self):
        # Frame anidado debajo del título en el cuál se le van a agregar los widgets para hacer la consulta de las compras realizadas por un cliente
        self._frameBuscarUsuario = Frame(self, bg=BACKGROUND_FRAMES)
        self._frameBuscarUsuario.pack(side=TOP, fill=X, padx=100, pady=10)
        
        # Label con el título Ingrese Codigo del Cliente
        self._labelIngreseCodigoCliente = Label(self._frameBuscarUsuario, text="Código del usuario", bg=BACKGROUND_FRAMES, font=FONT, fg=FG, justify=CENTER)
        self._labelIngreseCodigoCliente.pack(side=LEFT, fill=BOTH, expand=True, padx=10, pady=10)
        
        # Entry para ingresar el codigo por el cuál se quiere consultar las compras asociadas a un cliente
        self._codigoUsuario = Entry(self._frameBuscarUsuario, bg="white", font=FONT2, fg=FG2, justify=CENTER)
        self._codigoUsuario.pack(side=LEFT, fill=BOTH, expand=True, padx=10, pady=10)
        
        # Botón de consulta
        self._botonBuscar = Button(self._frameBuscarUsuario, text="Buscar", font=FONT, command=self.buscarUsuario)
        self._botonBuscar.pack(side=LEFT, fill=BOTH, expand=True, padx=10, pady=10)

        self._frameMostrarUsuario = Frame(self, bg="white")
        self._frameMostrarUsuario.pack(side=TOP, fill=BOTH, expand=True, padx=100, pady=10)

        self._mostrarUsuario = Label(self._frameMostrarUsuario, bg="white", font=FONT3, fg=FG2)
        self._mostrarUsuario.pack(side=TOP, fill=BOTH, expand=True, padx=10, pady=10)
        
        # Expandir los widgets dentro del contenedor
        self._frameBuscarCliente.columnconfigure(1, weight=0)

    def _mostrarProductosDisponibles(self):
       # Frame anidado debajo en el cuál se van a mostrar las compras realizadas por un cliente de acuerdo al codigo pasado en el Entry de arriba
        self._frameMostrarProductos = Frame(self, bg="white")
        self._frameMostrarProductos.pack(side=TOP, fill=BOTH, expand=True, padx=100, pady=10)

        self._mostrarResultadoConsulta1 = Label(self._frameMostrarProductos,text="Productos disponibles", bg="white", font=FONT3, fg=FG2)
        self._mostrarResultadoConsulta1.pack(side=TOP, fill=BOTH, expand=True, padx=10, pady=10)
        # Expandir los widgets dentro del contenedor
        self._frameMostrarProductos.columnconfigure(2, weight=1)

 
        
    def _agregarProductoCompra(self):
         # Frame anidado debajo del todo en el cuál se le van a agregar los widgets para hacer la devolucion de un producto por parte de un cliente
        self._frameSeleccionarCompraADevolver= Frame(self, bg=BACKGROUND_FRAMES)
        self._frameSeleccionarCompraADevolver.pack(side=TOP, fill=X, padx=100, pady=100)
        #_______________________________________________________
        self._frameSeleccionarCompraADevolver2= Frame(self, bg=BACKGROUND_FRAMES)
        self._frameSeleccionarCompraADevolver2.pack(side=TOP, fill=X, padx=100, pady=100)
        
        
        
        # Label con el título Ingrese Codigo de la Compra a Devolver
        self._labelIngreseCodigoCompra = Label(self._frameSeleccionarCompraADevolver, text="Código del producto a comprar", bg=BACKGROUND_FRAMES, font=FONT, fg=FG, justify=CENTER)
        self._labelIngreseCodigoCompra.pack(side=LEFT, fill=BOTH, expand=True, padx=10, pady=10)
        #_________________________________________________________
        self._labelIngreseCodigoCompra2 = Label(self._frameSeleccionarCompraADevolver2, text="Cantidad del producto a comprar", bg=BACKGROUND_FRAMES, font=FONT, fg=FG, justify=CENTER)
        self._labelIngreseCodigoCompra2.pack(side=LEFT, fill=BOTH, expand=True, padx=10, pady=10)
        
        
        
        # Entry para ingresar el codigo por el cuál se quiere devolver una compra
        self._codigoCompra = Entry(self._frameSeleccionarCompraADevolver, bg="white", font=FONT2, fg=FG2, justify=CENTER)
        self._codigoCompra.pack(side=LEFT, fill=BOTH, expand=True, padx=10, pady=10)
        #_________________________________________________________
        self._codigoCompra2 = Entry(self._frameSeleccionarCompraADevolver2, bg="white", font=FONT2, fg=FG2, justify=CENTER)
        self._codigoCompra2.pack(side=LEFT, fill=BOTH, expand=True, padx=10, pady=10)        
        

        # Botón de aceptar y elimina la compra seleccionada con el código de las compras del cliente
        self._botonAceptar = Button(self._frameSeleccionarCompraADevolver2, text="Comprar", font=FONT, command=self.eliminarCompraCliente)
        self._botonAceptar.pack(side=LEFT, fill=BOTH, expand=True, padx=10, pady=10)

        # Expandir los widgets dentro del contenedor
        self._frameSeleccionarCompraADevolver.columnconfigure(3, weight=0)

        self._frameSeleccionarCompraADevolver2.columnconfigure(4, weight=0)
        
    #Buscar Usuario
    def buscarUsuario(self):
        valor= self._codigoUsuario.get()

        try:
            val = int(valor)
        except ValueError:
            raise ExcepcionTiposMissMatch().showMessage()
            return

        if int(valor) < 0:
            try:
                raise ExcepcionNegativos()
            except ExcepcionNegativos as f:
                f.showMessage()
            return
        
        if len(valor) != 0:
            valor = int(valor)
            try:
                self._codigoUsuario = Usuario.getUsuarios()[valor]
            except KeyError:
                raise ExcepcionCodigoNoExite().showMessage()
                return
            self._mostrarUsuario(self._codigoUsuario)
        else:
            try:
                raise ExcepcionCamposNulos()
            except ExcepcionCamposNulos as f:
                f.showMessage()
            return
        
        self._codigoUsuario.delete(0, END)
            
            
            
    #Mostrar productos a comprar    
    def _mostrarUsuario(self, usuario):
        texto = ""

        if len(usuario.getUsuarios().values()) == 0:
            try:
                raise ExcepcionConjuntoVacio()
            except ExcepcionConjuntoVacio as f:
                f.showMessage()
            return
        texto=usuario.encontrarPersona(self._codigoUsuario)
        self._mostrarResultadoConsulta.config(text=texto)

    # Mostrar productos a comprar
    def _showProductos(self,producto):
        texto = ""

        for producto in Producto.getProductos().values():
            texto += producto.__str__() + "\n"

        self._mostrarResultadoConsulta1.config(text=texto)

   def agregarProducto(self):
       valor = self._codigoProducto.get()
       try:
           val = int(valor)
       except ValueError:
           raise ExcepcionTiposMissMatch().showMessage()
           return

       if int(valor) < 0:
           try:
               raise ExcepcionNegativos()
           except ExcepcionNegativos as f:
               f.showMessage()
           return

       if len(valor) != 0:
           valor = int(valor)
           try:
               self._codigoProducto = Producto.getProducto()[valor]
           except KeyError:
               raise ExcepcionCodigoNoExite().showMessage()
               return
           self._cantidadComprada
       else:
           try:
               raise ExcepcionCamposNulos()
           except ExcepcionCamposNulos as f:
               f.showMessage()
           return

    #Realizar compra
    def eliminarCompraCliente(self):
        valor = self._codigoCompra.get()

        try:
            val = int(valor)
        except ValueError:
            raise ExcepcionTiposMissMatch().showMessage()
            return

        if int(valor) < 0 :
            try:
                raise ExcepcionNegativos()
            except ExcepcionNegativos as f:
                f.showMessage()
            return
        
        if len(valor) != 0:
            valor = int(valor)
            try:
                del self._cliente.getCompras()[valor]
            except KeyError:
                raise ExcepcionCodigoNoExite().showMessage()
                return
        else:
            try:
                raise ExcepcionCamposNulos()
            except ExcepcionCamposNulos as f:
                f.showMessage()
            return
            
        messagebox.showinfo("Exito", "La compra se realizó correctamente")
        
        self._codigoCompra.delete(0, END)