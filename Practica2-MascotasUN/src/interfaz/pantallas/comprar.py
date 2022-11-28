from tkinter import *
from interfaz.estilos.styles import *
from gestionAplicacion.compras.cliente import Cliente
from excepciones import *

class Comprar(Frame):
    
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
        
    def _mostrarTitulo(self):
        # Label superior con el título de la pantalla
        self._titulo = Label(self, justify=CENTER, text="Compra de inventario", bg=BACKGROUND_FRAMES, font=FONT, fg=FG)
        self._titulo.pack(side=TOP, fill=X, padx=10, pady=10)
        
    def _ConsultarCompras(self):
        # Frame anidado debajo del título en el cuál se le van a agregar los widgets para hacer la consulta de las compras realizadas por un cliente
        self._frameBuscarCliente = Frame(self, bg=BACKGROUND_FRAMES)
        self._frameBuscarCliente.pack(side=TOP, fill=X, padx=100, pady=10)
        
        # Label con el título Ingrese Codigo del Cliente
        self._labelIngreseCodigoCliente = Label(self._frameBuscarCliente, text="Código del Proveedor", bg=BACKGROUND_FRAMES, font=FONT, fg=FG, justify=CENTER)
        self._labelIngreseCodigoCliente.pack(side=LEFT, fill=BOTH, expand=True, padx=10, pady=10)
        
        # Entry para ingresar el codigo por el cuál se quiere consultar las compras asociadas a un cliente
        self._codigoCliente = Entry(self._frameBuscarCliente, bg="white", font=FONT2, fg=FG2, justify=CENTER)
        self._codigoCliente.pack(side=LEFT, fill=BOTH, expand=True, padx=10, pady=10)
        
        # Botón de consulta
        self._botonBuscar = Button(self._frameBuscarCliente, text="Buscar", font=FONT, command=self.buscarCliente)
        self._botonBuscar.pack(side=LEFT, fill=BOTH, expand=True, padx=10, pady=10)
        
        # Expandir los widgets dentro del contenedor
        self._frameBuscarCliente.columnconfigure(1, weight=0)
        
    def  _mostrarCompras(self):
        # Frame anidado debajo en el cuál se van a mostrar las compras realizadas por un cliente de acuerdo al codigo pasado en el Entry de arriba
        self._frameMostrarComprasCliente = Frame(self, bg="white")
        self._frameMostrarComprasCliente.pack(side=TOP, fill=BOTH, expand=True, padx=100, pady=10)
        
        self._mostrarResultadoConsulta = Label(self._frameMostrarComprasCliente, bg="white", font=FONT3, fg=FG2)
        self._mostrarResultadoConsulta.pack(side=TOP, fill=BOTH, expand=True, padx=10, pady=10)
        
        # Expandir los widgets dentro del contenedor
        self._frameMostrarComprasCliente.columnconfigure(2, weight=1)

 
        
    def _seleccionCompraADevolver(self):
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
        
    #BUSCAR PROVEEDOR    
    def buscarCliente(self):
        valor= self._codigoCliente.get()

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
                self._cliente = Cliente.getClientes()[valor]
            except KeyError:
                raise ExcepcionCodigoNoExite().showMessage()
                return
            self._showCompra(self._cliente)
        else:
            try:
                raise ExcepcionCamposNulos()
            except ExcepcionCamposNulos as f:
                f.showMessage()
            return
        
        self._codigoCliente.delete(0, END)
            
            
            
    #Mostrar productos a comprar    
    def _showCompra(self, cliente):
        texto = ""

        if len(cliente.getCompras().values()) == 0:
            try:
                raise ExcepcionConjuntoVacio()
            except ExcepcionConjuntoVacio as f:
                f.showMessage()
            return
        
        for compra in cliente.getCompras().values():
            texto += compra.__str__() + "\n"
            
        self._mostrarResultadoConsulta.config(text=texto)
        
        
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