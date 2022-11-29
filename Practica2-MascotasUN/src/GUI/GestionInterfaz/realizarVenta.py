from tkinter import *
from src.gestorAplicacion.gestionVentas.Producto import Producto
from src.gestorAplicacion.gestionVentas.Tienda import Tienda
from src.gestorAplicacion.gestionVentas.Factura import Factura
from src.GUI.estilos.styles import *
from src.gestorAplicacion.gestionPersonas.Proveedor import Proveedor
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
        
        # Se inicializan los widgets que van en la GUI
        self._mostrarTitulo()
        self._ConsultarCompras()
        self._mostrarCompras()
        self._seleccionCompraADevolver()
        
    def _mostrarTitulo(self):
        # Label superior con el título de la pantalla
        self._titulo = Label(self, justify=CENTER, text="Realizar venta", bg=BACKGROUND_FRAMES, font=FONT, fg=FG)
        self._titulo.pack(side=TOP, fill=X, padx=10, pady=10)
        
    def _ConsultarCompras(self):
        # Frame anidado debajo del título en el cuál se le van a agregar los widgets para hacer la consulta de las compras realizadas por un Proveedor
        self._frameBuscarProveedor = Frame(self, bg=BACKGROUND_FRAMES)
        self._frameBuscarProveedor.pack(side=TOP, fill=X, padx=100, pady=10)
        
        # Label con el título Ingrese Codigo del Proveedor
        self._labelIngreseCodigoProveedor = Label(self._frameBuscarProveedor, text="Código del Usuario", bg=BACKGROUND_FRAMES, font=FONT, fg=FG, justify=CENTER)
        self._labelIngreseCodigoProveedor.pack(side=LEFT, fill=BOTH, expand=True, padx=10, pady=10)
        
        # Entry para ingresar el codigo por el cuál se quiere consultar las compras asociadas a un Proveedor
        self._codigoProveedor = Entry(self._frameBuscarProveedor, bg="white", font=FONT2, fg=FG2, justify=CENTER)
        self._codigoProveedor.pack(side=LEFT, fill=BOTH, expand=True, padx=10, pady=10)
        
        # Botón de consulta
        self._botonBuscar = Button(self._frameBuscarProveedor, text="Buscar", font=FONT, command=self.buscarProveedor)
        self._botonBuscar.pack(side=LEFT, fill=BOTH, expand=True, padx=10, pady=10)
        
        # Expandir los widgets dentro del contenedor
        self._frameBuscarProveedor.columnconfigure(1, weight=0)
        
    def  _mostrarCompras(self):
        # Frame anidado debajo en el cuál se van a mostrar las compras realizadas por un Proveedor de acuerdo al codigo pasado en el Entry de arriba
        self._frameMostrarComprasProveedor = Frame(self, bg="white")
        self._frameMostrarComprasProveedor.pack(side=TOP, fill=BOTH, expand=True, padx=100, pady=10)
        
        self._mostrarResultadoConsulta = Label(self._frameMostrarComprasProveedor, bg="white", font=FONT3, fg=FG2)
        self._mostrarResultadoConsulta.pack(side=TOP, fill=BOTH, expand=True, padx=10, pady=10)
        
        # Expandir los widgets dentro del contenedor
        self._frameMostrarComprasProveedor.columnconfigure(2, weight=1)

 
        
    def _seleccionCompraADevolver(self):
         # Frame anidado debajo del todo en el cuál se le van a agregar los widgets para hacer la devolucion de un producto por parte de un Proveedor
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
        

        # Botón de aceptar y elimina la compra seleccionada con el código de las compras del Proveedor
        self._botonAceptar = Button(self._frameSeleccionarCompraADevolver2, text="Vender", font=FONT, command=self.realizarCompra)
        self._botonAceptar.pack(side=LEFT, fill=BOTH, expand=True, padx=10, pady=10)

        # Expandir los widgets dentro del contenedor
        self._frameSeleccionarCompraADevolver.columnconfigure(3, weight=0)

        self._frameSeleccionarCompraADevolver2.columnconfigure(4, weight=0)
        
    #BUSCAR PROVEEDOR    
    def buscarProveedor(self):
        valor= self._codigoProveedor.get()

        try:
            val = int(valor)
        except ValueError:
            raise ExcepcionTiposErrados().showMessage()
            return

        if int(valor) < 0:
            try:
                raise ExcepcionNumNoValido()
            except ExcepcionNumNoValido as f:
                f.showMessage()
            return
        
        if len(valor) != 0:
            valor = int(valor)
            try:
                self._Proveedor = Proveedor.getProveedores()[valor]
            except KeyError:
                raise ExcepcionCodigoInexistente().showMessage()
                return
            self._showProductos(self._Proveedor)
        else:
            try:
                raise ExcepcionCamposVacios()
            except ExcepcionCamposVacios as f:
                f.showMessage()
            return
        
       # self._codigoProveedor.delete(0, END)
            
            
            
    #Mostrar productos a Productosr    
    def _showProductos(self, Proveedor):
        texto = ""

        if len(Producto.getProductos()) == 0:
            try:
                raise ExcepcionArregloSinDatos()
            except ExcepcionArregloSinDatos as f:
                f.showMessage()
            return
        
        for producto in Producto.getProductos():
            texto += producto.__str__() + "\n"
            
        self._mostrarResultadoConsulta.config(text=texto)
     
     
 #creo que lo de arriba ya       
        
    #Realizar compra
    def realizarCompra(self):
        valor = self._codigoCompra.get()
        valor2 = self._codigoCompra2.get()
        valor3=self._codigoProveedor.get()
        
        self._Proveedor = Proveedor.getProveedores()[int(valor3)]

        try:
            val = int(valor)
        except ValueError:
            raise ExcepcionTiposErrados().showMessage()
            return

        if int(valor) < 0 or int(valor2)<0:
            try:
                raise ExcepcionNumNoValido()
            except ExcepcionNumNoValido as f:
                f.showMessage()
            return
        
        if len(valor) != 0 or len(valor2) != 0:
            valor = int(valor)
            valor2=int(valor2)
            
            #F=crear una factura
            #total=con el id del producto(valor) buscar el precio y multiplicarlo por la cantidad(valor2)
            cuentaTienda=Tienda.cuenta
            self._Producto = Producto.getProductos()[valor]      #hay que ver que se haga el diccionario y que se llame con este
            precio=self._Producto.getPrecioCompra()
            total=precio*valor2                                    #ver como funcina el étodo y adecuarlo a lo que necesite
            """ F=Factura()      no sé si toca crearlo con parametros
            F.setProductos(self._Producto)
            pin=self._Proveedor.getCuenta().getPin()
            
            # producto en diccionario
            
            try:
                F.realizarCompraProveedor(self._Proveedor, total, pin)
            except KeyError:
                raise ExcepcionCodigoInexistente().showMessage()
                return"""
            
        else:
            try:
                raise ExcepcionCamposVacios()
            except ExcepcionCamposVacios as f:
                f.showMessage()
            return
            
        messagebox.showinfo("Éxito", "La venta se realizó correctamente")
        
        self._codigoCompra.delete(0, END)