from tkinter import *
from src.gestorAplicacion.gestionPersonas.Vendedor import Vendedor
from src.GUI.estilos.styles import *
from src.gestorAplicacion.gestionVentas.Producto import Producto
from src.gestorAplicacion.gestionVentas.Factura import Factura
from excepciones import *

class CobrarComision(Frame):

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
        self._titulo = Label(self, justify=CENTER, text="Calcular Comisiones", bg=BACKGROUND_FRAMES, font=FONT, fg=FG)
        self._titulo.pack(side=TOP, fill=X, padx=100, pady=10)

    def _Consultar(self):
        # Frame anidado debajo del título en el cuál se le van a agregar los widgets para hacer la consulta 
        self._frameSolicitarConsulta = Frame(self, bg=BACKGROUND_FRAMES)
        self._frameSolicitarConsulta.pack(side=TOP, fill=X, padx=50, pady=10)

        # Label con el título Ingrese los datos a consultar
        texto = "Ingrese el id del vendedor" + "\n" \
                
                    
        self._labelConsulta = Label(self._frameSolicitarConsulta, text=texto, bg=BACKGROUND_FRAMES, font=FONT3, fg=FG, justify=CENTER)
        self._labelConsulta.pack(side=LEFT, fill=BOTH, expand=True, padx=10, pady=10)

        # Entry para ingresar el valor por el cuál se quiere consultar un cliente valioso
        self._entryConsulta = Entry(self._frameSolicitarConsulta, bg="white", font=FONT2, fg=FG2, justify=CENTER)
        self._entryConsulta.pack(side=LEFT, fill=BOTH,expand=True, padx=10, pady=10)

        # Botón de consulta
        self._botonConsulta = Button(self._frameSolicitarConsulta, text="Buscar", font=FONT, command=self.buscarConsulta)
        self._botonConsulta.pack(side=LEFT, fill=BOTH, expand=True, padx=10, pady=10)

        self._frameSolicitarConsulta.columnconfigure(1, weight=1)

    def _inicializarFrameConsulta(self):
        # Frame anidado debajo en el cuál se van a mostrar los clientes valiosos de acuerdo al valor valioso pasado en el Entry de arriba
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
        valor = self._entryConsulta.get()

        try:
            val = int(valor)
        except ValueError:
            raise ExcepcionTiposErrados().showMessage()
            return

        if int(valor) < 0 :
            try:
                raise ExcepcionNumNoValido()
            except ExcepcionNumNoValido as f:
                f.showMessage()
            return
        
        if len(valor) != 0:
            valor = int(valor)
            self._mostrarConsulta(valor)
        else:
            try:
                raise ExcepcionCamposVacios()
            except ExcepcionCamposVacios as f:
                f.showMessage()
            return
                
#TRADUCIR FUNCIONALIDAD
    def _mostrarConsulta(self, valor):
        texto = ""

        if Vendedor.encontrarPersona(valor)!=None:
            try:
                raise ExcepcionArregloSinDatos()
            except ExcepcionArregloSinDatos as f:
                f.showMessage()
            return 
        
        vendedorcito=Vendedor.encontrarPersona(valor)
        facturas=vendedorcito.getVentas()
        a=0
        for i in facturas():
            a+=i.calcularTotal()
        b=a*Vendedor.getComision()
        texto = "Tus ventas totales fueron: ",a, "\n","Por lo que tus comisiones son: ", b
            
        self._texto.insert(END, texto)
 