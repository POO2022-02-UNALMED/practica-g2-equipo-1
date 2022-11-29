# Clase desde la cual se gestiona la inteligencia de negocio de la tienda, desde la parte económica y de inventario, 
# hasta las estadísticas relacionadas con ello
class Tienda:
    
    tienda = []
    cantidadDeVentas = []
    catalogo = []
    inventario = {}
    inventarioProductos = {}
    usuarios = {}
    cuenta =120000
    # Falta agregar cuenta bancaria como atributo de clase
    
    # Métodos
    # Método que agrega un producto nuevo al catálogo de productos ofrecido por la tienda
    @classmethod
    def agregarProductoCatalogo(cls, producto):
        cls.catalogo.append(producto)
    
    # Método que encuentra y retorna un producto del catálogo de la tienda dado su ID
    @classmethod
    def encontrarProducto(cls, productoID):
        for producto in cls.catalogo:
            if producto.productoID == productoID:
                return producto
        return None
    
    # Método que aumenta la cantidad de productos de un producto de la tienda según una factura realizada
    @classmethod
    def aumentarStock(cls, factura):
        for producto in factura.getProductos():
            if producto.productoID in cls.inventario:
                cls.inventario[producto.productoID] += producto.cantidad
            else:
                cls.inventario[producto.productoID] = producto.cantidad
                
    # Método que reduce la cantidad de productos de un producto de la tienda según una factura realizada
    @classmethod
    def reducirStock(cls, factura):
        for producto in factura.productos:
            if producto.productoID in cls.inventario:
                cls.inventario[producto.productoID] -= producto.cantidad
            else:
                cls.inventario[producto.productoID] = producto.cantidad
    
    # Método que agrega una venta a la lista de ventas realizadas por la tienda
    @classmethod
    def agregarVenta(cls, factura):
        cls.tienda.append(factura)
    
    # Método que valida el ID ingresado con el ID correspondiente del catálogo
    @classmethod
    def validarID(cls, productoID):
        for producto in cls.catalogo:
            if producto.productoID == productoID:
                return True
        return False
    
    # Método para ordenar el HashMap del inventario por su valor
    @classmethod
    def ordenarInventario(cls):
        cls.inventario = dict(sorted(cls.inventario.items(), key=lambda item: item[1]))
    
    # Getters y setters
    
    @classmethod
    def getTienda(cls):
        return cls.tienda
    
    @classmethod
    def setTienda(cls, tienda):
        cls.tienda = tienda
        
    @classmethod
    def getCantidadDeVentas(cls):
        return cls.cantidadDeVentas
    
    @classmethod
    def setCantidadDeVentas(cls, cantidadDeVentas):
        cls.cantidadDeVentas = cantidadDeVentas
        
    @classmethod
    def getCatalogo(cls):
        return cls.catalogo
    
    @classmethod
    def setCatalogo(cls, catalogo):
        cls.catalogo = catalogo
        
    @classmethod
    def getInventario(cls):
        return cls.inventario
    
    @classmethod
    def setInventario(cls, inventario):
        cls.inventario = inventario
        
    @classmethod
    def getInventarioProductos(cls):
        return cls.inventarioProductos
    
    @classmethod
    def setInventarioProductos(cls, inventarioProductos):
        cls.inventarioProductos = inventarioProductos
        
    @classmethod
    def getUsuarios(cls):
        return cls.usuarios
    
    @classmethod
    def setUsuarios(cls, usuarios):
        cls.usuarios = usuarios

    @classmethod
    def getCuenta(cls):
        return cls.cuenta

    @classmethod
    def setCuenta(cls, cuenta):
        cls.cuenta = cuenta