# Clase que crea y gestiona los objetos de tipo Producto, los cuales son los productos que la aplicación vende
from  random import randint
class Producto:
    productos = {}
    productoID = randint(444444,888888)

    # Constructor
    def __init__(self, nombre, fechaVencimiento, descripcion, precioCompra, precioVenta, cantidadComprada, raza="",
                 etapa="", especie=""):
        Producto.productoID+=1
        self.productoID=Producto.productoID
        self.nombre = nombre
        self.fechaVencimiento = fechaVencimiento
        self.descripcion = descripcion
        self.precioCompra = precioCompra
        self.precioVenta = precioVenta
        self.cantidadComprada = cantidadComprada
        self.raza = raza
        self.etapa = etapa
        self.especie = especie
        Producto.productos[self.productoID] = self

    # Métodos

    # Método sobrecargado toString para imprimir los datos de un producto
    def __str__(self) -> str:
        return "Código: " + str(self.productoID) + "\n" \
               + "Producto: " + str(self.nombre) + "\n" \
               + "Fecha de Vencimiento: " + str(self.fechaVencimiento) + "\n" \
               + "Descripción: " + str(self.descripcion) + "\n" \
               + "Precio: " + str(self.precioVenta) + "\n"

    # Método encargado de editar los atributos de un producto
    def editarProducto(self, nombre, precioVenta, cantidadComprada):
        self.nombre = nombre
        self.precioVenta = precioVenta
        self.cantidadComprada = cantidadComprada

    @staticmethod
    def crearObjeto(nombre, fechaVencimiento, descripcion, precioCompra, precioVenta, cantidadComprada, raza="",
                    etapa="", especie=""):
        try:
            precioCompra = int(precioCompra)
            precioVenta = int(precioVenta)
            cantidadComprada = int(cantidadComprada)
            Producto(nombre, fechaVencimiento, descripcion, precioCompra, precioVenta, cantidadComprada, raza, etapa,
                     especie)
            return True
        except ValueError:
            return False

    # Método que elimina un producto de la lista de productos a comprar
    @classmethod
    def eliminarProducto(cls, productoID):
        for producto in cls.productos:
            if producto.productoID == productoID:
                cls.productos.remove(producto)
                return True
        return False

    # Método que agrega un producto a la lista de productos a comprar
    @classmethod
    def agregarProducto(cls, producto):
        cls.productos.append(producto)

    # Setters y getters
    @classmethod
    def getProductoId(cls):
        return cls.productoID

    @classmethod
    def setProductoId(cls, productoID):
        cls.productoID = productoID

    @classmethod
    def getProductos(cls):
        return cls.productos

    @classmethod
    def setProductos(cls, productos):
        cls.productos = productos

    def getNombre(self):
        return self.nombre

    def setNombre(self, nombre):
        self.nombre = nombre

    def getFechaVencimiento(self):
        return self.fechaVencimiento

    def setFechaVencimiento(self, fechaVencimiento):
        self.fechaVencimiento = fechaVencimiento

    def getDescripcion(self):
        return self.descripcion

    def setDescripcion(self, descripcion):
        self.descripcion = descripcion

    def getPrecioCompra(self):
        return self.precioCompra

    def setPrecioCompra(self, precioCompra):
        self.precioCompra = precioCompra

    def getPrecioVenta(self):
        return self.precioVenta

    def setPrecioVenta(self, precioVenta):
        self.precioVenta = precioVenta

    def getCantidadComprada(self):
        return self.cantidadComprada

    def setCantidadComprada(self, cantidadComprada):
        self.cantidadComprada = cantidadComprada

    def getRaza(self):
        return self.raza

    def setRaza(self, raza):
        self.raza = raza

    def getEtapa(self):
        return self.etapa

    def setEtapa(self, etapa):
        self.etapa = etapa

    def getEspecie(self):
        return self.especie

    def setEspecie(self, especie):
        self.especie = especie
