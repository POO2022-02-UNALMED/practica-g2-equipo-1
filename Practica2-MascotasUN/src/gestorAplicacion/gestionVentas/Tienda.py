class Tienda:
    
    tienda = []
    cantidadDeVentas = []
    catalogo = []
    inventario = {}
    inventarioProductos = {}
    usuarios = {}
    # Falta agregar cuenta bancaria como atributo de clase
    
    # Métodos
    # Método que agrega un producto nuevo al catálogo de productos ofrecido por la tienda
    # Método que encuentra y retorna un producto del catálogo de la tienda dado su ID
    # Método que aumenta la cantidad de productos de un producto de la tienda
    # Método que reduce la cantidad de productos de un producto de la tienda
    # Método que agrega una venta a la lista de ventas realizadas por la tienda
    # Método que valida el ID ingresado con el ID correspondiente del catálogo
    # Método para ordenar el HashMap del inventario por su valor
    
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