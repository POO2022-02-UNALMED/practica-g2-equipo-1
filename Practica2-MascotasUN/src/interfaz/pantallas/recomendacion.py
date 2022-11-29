from tkinter import *
from excepciones import *
from src.gestorAplicacion.gestionPersonas.Gato import Gato
from src.gestorAplicacion.gestionPersonas.Gato import Perro
from src.gestorAplicacion.gestionPersonas.Gato import Mascota
from src.gestorAplicacion.gestionVentas.Producto import Producto
from src.gestorAplicacion.gestionVentas.Tienda import Tienda
from src.interfaz.estilos.styles import *

class Recomendacion(Frame):
    
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
        self._ConsultarMascota()
        self._inicializarFrameMascota()
        
    def _mostrarTitulo(self):
        # Label superior con el título de la pantalla
        self._titulo = Label(self, justify=CENTER, text="Recomendaciones personalizadas", bg=BACKGROUND_FRAMES, font=FONT, fg=FG)
        self._titulo.pack(side=TOP, fill=X, padx=100, pady=10)
        
    def _ConsultarMascota(self):
        # Frame anidado debajo del título en el cuál se le van a agregar los widgets para hacer la consulta de los clientes valiosos
        self._frameIngresarMascota = Frame(self, bg=BACKGROUND_FRAMES)
        self._frameIngresarMascota.pack(side=TOP, fill=X, padx=100, pady=10)
        
        # Label con el título Ingrese Valor Valioso
        self._labelIngreseMascota = Label(self._frameIngresarMascota, text="Ingrese el id de su mascota", bg=BACKGROUND_FRAMES, font=FONT, fg=FG, justify=CENTER)
        self._labelIngreseMascota.pack(side=LEFT, fill=BOTH, expand=True, padx=10, pady=10)
        
        # Entry para ingresar el valor por el cuál se quiere consultar un cliente valioso
        self._Mascota = Entry(self._frameIngresarMascota, bg="white", font=FONT2, fg=FG2, justify=CENTER)
        self._Mascota.pack(side=LEFT, fill=BOTH, expand=True, padx=10, pady=10)
        
        # Botón de consulta
        self._botonMascota = Button(self._frameIngresarMascota, text="Buscar", font=FONT, command=self.buscarMascota)
        self._botonMascota.pack(side=LEFT, fill=BOTH, expand=True, padx=10, pady=10)
        
        self._frameIngresarMascota.columnconfigure(1, weight=1)
        
        
    def _inicializarFrameMascota(self):
        # Frame anidado debajo en el cuál se van a mostrar los clientes valiosos de acuerdo al valor valioso pasado en el Entry de arriba
        self._frameMostrarMascota = Frame(self, bg="white")
        self._frameMostrarMascota.pack(side=TOP, fill=BOTH, expand=True, padx=100, pady=10)
        
        self._mostrarMascota = Label(self._frameMostrarMascota, bg="white", font=FONT3, fg=FG2)
        self._mostrarMascota.pack(side=TOP, fill=BOTH, expand=True, padx=10, pady=10)
        
        # Se crea un widget tipo Text 
        self._texto = Text(self._mostrarMascota)
        self._texto.grid(row=0, column=0, sticky=EW, padx=100, pady=10)
        
        # Se crea un widget tipo Scrollbar
        self._scrollbar = Scrollbar(self._mostrarMascota, command=self._texto.yview)
        
        # Se le asigna el comando al Text de que va a contener un scrollbar vertical
        self._texto.config(yscrollcommand=self._scrollbar.set)
        
        # Se empaqueta el scrollbar
        self._scrollbar.grid(row=0, column=1, sticky=NS, pady=10)
        
        self._frameMostrarMascota.columnconfigure(1, weight=1)
        self._mostrarMascota.columnconfigure(1, weight=1)
        
    def buscarMascota(self):
        valor = self._Mascota.get()

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

            self.michi = Gato.getGatos()[valor]
             #self.gua=Perro.getPerros()[valor]

            """
            try:
                self.michi = Gato.getGatos()[valor]
                self.gua=Perro.getPerros()[valor]
            except KeyError:
                #raise ExcepcionCodigoNoExite().showMessage()
                return"""
            tipoAlimento=self.tipoAlimento(self.michi)
            self.mostrarMascota(tipoAlimento)
            #self.mostrarMascota(self.gua)
        else:
            try:
                raise ExcepcionCamposVacios()
            except ExcepcionCamposVacios as f:
                f.showMessage()
            return
    def tipoAlimento(self,gato):
        LAux = []
        for i in Producto.getProductos().values():
            if isinstance(i, Producto):
                if ((i.getEspecie() == "Gato") & (i.getEtapa == self.calcularEdad(gato))):
                    LAux.append(i)
        return LAux
    def calcularEdad(self,gato):
        if (gato.getEdad() <= 1):
            return "Cachorro"
        else:
            return "Adulto"
    def mostrarMascota(self, lista):
        texto = lista
        self._texto.insert(END, texto)
"""
        for val in lista:
            texto += "Producto: "+ val + "\n"""

