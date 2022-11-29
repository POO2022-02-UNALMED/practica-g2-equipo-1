from tkinter import *
from src.GUI.estilos.styles import *
from src.gestorAplicacion.gestionPersonas.Gato import Gato
from src.gestorAplicacion.gestionPersonas.Gato import Perro
from src.gestorAplicacion.gestionVentas.Producto import Producto
from src.gestorAplicacion.gestionPersonas.Vendedor import Vendedor
from src.gestorAplicacion.gestionPersonas.Proveedor import Proveedor
from src.gestorAplicacion.gestionPersonas.Vendedor import Usuario

from excepciones import *

class ConsultaInformacion(Frame):

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
        self._Consultar()
        self._inicializarFrameConsulta()

    def _mostrarTitulo(self):
        # Label superior con el título de la pantalla
        self._titulo = Label(self, justify=CENTER, text="Consulta Base de Datos", bg=BACKGROUND_FRAMES, font=FONT, fg=FG)
        self._titulo.pack(side=TOP, fill=X, padx=100, pady=10)

    def _Consultar(self):
        # Frame anidado debajo del título en el cuál se le van a agregar los widgets para hacer la consulta 
        self._frameConsultar = Frame(self, bg=BACKGROUND_FRAMES)
        self._frameConsultar.pack(side=TOP, fill=X, padx=100, pady=10)

        # Label con el título Ingrese los datos a consultar
        texto = "Bienvenido. Ingrese el tipo de dato que desea visualizar: " + "\n" \
                    + "(1) Gatos registrados" + "\n" \
                    + "(2) Perros registrados" + "\n" \
                    + "(3) Proveedores registrados" + "\n" \
                    + "(4) Usuarios registrados" + "\n" \
                    + "(5) Vendedores registrados" + "\n" \
                    + "(6) Productos registrados" + "\n"
                    
        self._labelConsulta = Label(self._frameConsultar, text=texto, bg=BACKGROUND_FRAMES, font=FONT3, fg=FG, justify=CENTER)
        self._labelConsulta.pack(side=LEFT, fill=BOTH, expand=True, padx=10, pady=10)

        # Entry para ingresar el valor por el cuál se quiere consultar un cliente valioso
        self._entryConsulta = Entry(self._frameConsultar, bg="white", font=FONT2, fg=FG2, justify=CENTER)
        self._entryConsulta.pack(side=LEFT, fill=BOTH,expand=True, padx=10, pady=10)

        # Botón de consulta
        self._botonConsulta = Button(self._frameConsultar, text="Buscar", font=FONT, command=self.buscarConsulta)
        self._botonConsulta.pack(side=LEFT, fill=BOTH, expand=True, padx=10, pady=10)

        self._frameConsultar.columnconfigure(1, weight=1)

    def _inicializarFrameConsulta(self):
        self._frameMostrarResultadoConsulta = Frame(self, bg="white")
        self._frameMostrarResultadoConsulta.pack(side=TOP, fill=BOTH, expand=True, padx=100, pady=10)
        
        # Se crea Label en el cuál se mostrarán los resultados de la consulta implementando un Scrollbar
        self._mostrarResultadoConsulta = Label(self._frameMostrarResultadoConsulta, bg="white", font=FONT3, fg=FG2)
        self._mostrarResultadoConsulta.pack(side=TOP, fill=BOTH, expand=True, padx=10, pady=10)
        
        # Se crea un widget tipo Text 
        self._texto = Text(self._mostrarResultadoConsulta)
        self._texto.grid(row=0, column=0, sticky=EW, padx=100, pady=10)
        
        # Se crea un widget tipo Scrollbar
        self._scrollbar = Scrollbar(self._mostrarResultadoConsulta, command=self._texto.yview)
        
        # Se le asigna el comando al Text de que va a contener un scrollbar vertical
        self._texto.config(yscrollcommand=self._scrollbar.set)
        
        # Se empaqueta el scrollbar
        self._scrollbar.grid(row=0, column=1, sticky=NS, pady=10)

        self._frameMostrarResultadoConsulta.columnconfigure(1, weight=1)
        self._mostrarResultadoConsulta.columnconfigure(1, weight=1)

    def buscarConsulta(self):
        entrada = self._entryConsulta.get()

        try:
            valor = int(entrada)
        except ValueError:
            raise ExcepcionTiposErrados().showMessage()
            return

        if int(entrada) < 0:
            try:
                raise ExcepcionNumNoValido()
            except ExcepcionNumNoValido as f:
                f.showMessage()
            return
        
        if len(entrada) != 0:
            valor = int(entrada)
            self._mostrarConsulta(valor)
        else:
            try:
                raise ExcepcionCamposVacios()
            except ExcepcionCamposVacios as f:
                f.showMessage()
            return
                
    def _mostrarConsulta(self, entrada):
        texto = ""
        
        if entrada == 1:

            if len(Gato.getGatos().values()) == 0:
                try:
                    raise ExcepcionArregloSinDatos()
                except ExcepcionArregloSinDatos as f:
                    f.showMessage()
                return

            for gato in Gato.getGatos().values():
                texto += gato.__str__() + "\n"
                
        elif entrada == 2:

            if len(Perro.getPerros().values()) == 0:
                try:
                    raise ExcepcionArregloSinDatos()
                except ExcepcionArregloSinDatos as f:
                    f.showMessage()
                return

            for perro in Perro.getPerros().values():
                texto += perro.__str__() + "\n"
        
        elif entrada == 3:

            if len(Proveedor.getProveedores().values()) == 0:
                try:
                    raise ExcepcionArregloSinDatos()
                except ExcepcionArregloSinDatos as f:
                    f.showMessage()
                return

            for proveedor in Proveedor.getProveedores().values():
                texto += proveedor.__str__() + "\n"

        elif entrada == 4:

            if len(Usuario.getUsuarios().values()) == 0:
                try:
                    raise ExcepcionArregloSinDatos()
                except ExcepcionArregloSinDatos as f:
                    f.showMessage()
                return

            for usuarios in Usuario.getUsuarios().values():
                texto += usuarios.__str__() + "\n"
                
        elif entrada == 5:

            if len(Vendedor.getVendedores().values()) == 0:
                try:
                    raise ExcepcionArregloSinDatos()
                except ExcepcionArregloSinDatos as f:
                    f.showMessage()
                return

            for vendedor in Vendedor.getVendedores().values():
                texto += vendedor.__str__() + "\n"

        elif entrada == 6:

            if len(Producto.getProductos().values()) == 0:
                try:
                    raise ExcepcionArregloSinDatos()
                except ExcepcionArregloSinDatos as f:
                    f.showMessage()
                return

            for producto in Producto.getProductos().values():
                texto += producto.__str__() + "\n"
                
        else: 
            try:
                raise ErrorApp("Numero no valido")
            except ErrorApp as f:
                f.showMessage()
            return
            
        self._texto.insert(END, texto)

        def mostrarGatos(self):
            self._mensaje = ""
            if len(Gato.getGatos().values()) == 0:
                try:
                    raise ExcepcionArregloSinDatos()
                except ExcepcionArregloSinDatos as f:
                    f.showMessage()
                    return
            for gato in Gato.getGatos().values():
                self._mensaje += gato.__str__() + "\n"
                self._texto.insert(END, texto)

