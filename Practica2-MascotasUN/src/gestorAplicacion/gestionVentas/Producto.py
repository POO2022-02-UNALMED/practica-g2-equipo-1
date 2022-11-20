class Producto:
    
    productos = []
    
    # Constructor
    def __init__(self, productoID, nombre, fechaVencimiento, descripcion, precioCompra, precioVenta, cantidadComprada):
        self.productoID = productoID
        self.nombre = nombre
        self.fechaVencimiento = fechaVencimiento
        self.descripcion = descripcion
        self.precioCompra = precioCompra
        self.precioVenta = precioVenta
        self.cantidadComprada = cantidadComprada
        self.productos.append(self)
        
    # Sobreescritura de constructor para crear productos relacionados con gatos
    def __init__(self, productoID, nombre, fechaVencimiento, descripcion, precioCompra, precioVenta, cantidadComprada, etapa, especie):
        self.productoID = productoID
        self.nombre = nombre
        self.fechaVencimiento = fechaVencimiento
        self.descripcion = descripcion
        self.precioCompra = precioCompra
        self.precioVenta = precioVenta
        self.cantidadComprada = cantidadComprada
        self.etapa = etapa
        self.especie = especie
        self.productos.append(self)
        
    # Sobreescritura de constructor para crear productos relacionados con perros
    def __init__(self, productoID, nombre, fechaVencimiento, descripcion, precioCompra, precioVenta, cantidadComprada, raza, etapa, especie):
        self.productoID = productoID
        self.nombre = nombre
        self.fechaVencimiento = fechaVencimiento
        self.descripcion = descripcion
        self.precioCompra = precioCompra
        self.precioVenta = precioVenta
        self.cantidadComprada = cantidadComprada
        self.raza = raza
        self.etapa = etapa
        self.especie = especie
        self.productos.append(self)
        
    # Métodos
    
    # Método para imprimir los datos de un producto (toString)
    # Método encargado de editar los atributos de un producto
    # Método que elimina un producto de la lista de productos a comprar
    # Método que agrega un producto a la lista de productos a comprar
    
    # Setters y getters
    
    @classmethod
    def getProductos(cls):
        return cls.productos
    
    @classmethod
    def setProductos(cls, productos):
        cls.productos = productos
    
    def getProductoID(self):
        return self.productoID
    
    def setProductoID(self, productoID):
        self.productoID = productoID
        
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