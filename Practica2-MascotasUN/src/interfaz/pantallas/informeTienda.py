from tkinter import *
from src.interfaz.estilos.styles import *
from src.gestorAplicacion.gestionVentas import Producto
from src.gestorAplicacion.gestionVentas import Factura
from src.gestorAplicacion.gestionVentas import Tienda
from src.gestorAplicacion.gestionPersonas import Usuario
from src.gestorAplicacion.gestionPersonas import Vendedor
from src.gestorAplicacion.gestionPersonas import CuentaBancaria

class Informe(Frame):

    # Se crea el contructor de la clase dónde se le pasan como parámetros el padre o frame que lo contiene y la clase controlador que es Principal
    def __init__(self, padre, controlador):
        # Se llama inicializa el constructor padre de la clase
        super().__init__(padre)
        # Se configura el Frame
        self.configure(background=BACKGROUND_CONTENEDOR)
        # Atributos
        self._controlador = controlador

        # Se inicializan los widgets que van en la interfaz
        self._mostrarTitulo()
        self._mostrarBotonGenerarInfome()
        self._mostrarInforme()

    def _mostrarTitulo(self):
        # Label superior con el título de la pantalla
        self._titulo = Label(self, justify=CENTER, text="Estadísticas de MascotasUN", bg=BACKGROUND_FRAMES, font=FONT, fg=FG)
        self._titulo.pack(side=TOP, fill=X, padx=100, pady=10)

    def _mostrarBotonGenerarInfome(self):
        # Se crea el botón con el cuál  va a mostrar el Informe de PJ Tech
        self._botonGenerarInforme = Button(self, text="Generar Informe de Estadísticas", font=FONT, command=self.generarInforme)
        self._botonGenerarInforme.pack(side=TOP, fill=X, padx=400, pady=10)
        
    def _mostrarInforme(self):
        # Frame anidado debajo en el cuál se van a mostrar las compras realizadas por un cliente de acuerdo al codigo pasado en el Entry de arriba
        self._frameMostrarInforme = Frame(self, bg="white")
        self._frameMostrarInforme.pack( side=TOP, fill=BOTH, expand=True, padx=100, pady=30)

        # Label
        self._labelMostrarInforme = Label(self._frameMostrarInforme, text="", bg="white", font=FONT, fg=FG2, justify=CENTER)
        self._labelMostrarInforme.pack(side=TOP, fill=X, expand=True, padx=10, pady=10)
        
        # Adaptar 
        self._frameMostrarInforme.columnconfigure(1, weight=1)
        
        
    def generarInforme(self):
        # En este método se generará el informe a modo resumen de la tienda MascotasUN
        texto = "*******INFORME MascotasUN*******" + "\n\n\n" \
                    + "Número de ventas por vendedor"+"\n"+ str(self.imprimirVentas()) + "\n\n" \
                    + "Productos más vendidos" +"\n"+ str(self.imprimirProductos()) + "\n\n" \
                    + "Clientes destacados" +"\n"+ str(self.imprimirClientes()) + "\n" \
                        
        self._labelMostrarInforme.config(text=texto)
        
    # Método que muestra en pantalla cada vendedor y el número de ventas que ha realizado en orden descendente
    # Valores es una lista *** y ventas es un diccionario con el nombre del vendedor y el número de ventas
    def imprimirVentas(valores,ventas):
        for i in range(len(valores)):
            for j in ventas:
                if valores[i] == ventas[j]:
                    print("El vendedor",j,"ha realizado",ventas[j],"ventas")
                    break
                
    # Método que muestra en pantalla los productos más vendidos en orden descendente     
    def imprimirProductos(valores,productos):
        for i in range(len(valores)):
            for j in productos:
                if valores[i] == productos[j]:
                    print("El producto",j,"ha sido vendido",productos[j],"veces")
                    break
                
    # Método que muestra en pantalla los productos más vendidos en orden descendente
    def calcularProductoMasVendido(self,facturas,ventas):
        productos = {}
        for i in facturas:
            for j in i.getDetalle():
                if j.getProducto().getNombre() in productos:
                    productos[j.getProducto().getNombre()] += j.getCantidad()
                else:
                    productos[j.getProducto().getNombre()] = j.getCantidad()
        valores = list(productos.values())
        valores.sort(reverse=True)
        self.imprimirProductos(valores,productos)
        return productos
    
    def calcularProductoMasVendido(facturas, ventas):
        # dict donde se añade la suma de productos vendidos por cada factura
        for i in facturas: # Lista de diccionarios de facturas
            for k in i: # dict de productos vendidos
                z = 0
                for j in ventas: # dict de productos totales
                    if i[k] == ventas[j]:
                        a = i[k]
                        b = ventas[j]
                        c = a + b
                        z = 1
                        ventas[i[k]] = c
                    if z != 1:
                        ventas[i[k]] = i[k]
              
    def calcularProductoMasVendido(self):
        productos = Producto.getProductos()
        cantidad = 0
        for i in productos:
            if productos[i].getCantidad() > cantidad:
                cantidad = productos[i].getCantidad()
                producto = productos[i]
        return producto
                        
    # Método que muestra en pantalla los clientes que más han comprado en orden descendente
    def imprimirClientes(valores,clientes):
        for i in range(len(valores)):
            for j in clientes:
                if valores[i] == clientes[j]:
                    print("El cliente",j,"ha comprado",clientes[j],"productos")
                    break