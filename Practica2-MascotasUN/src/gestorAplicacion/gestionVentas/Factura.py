class Factura:
    facturas= []
    facturaID = 38040000
    total = 0.0
    IVA = 1.16

    def __int__(self):
        self.facturaID+=1
        self.facturas.append(self)
        self.productos = {}
    def __init__(self, cliente, fechaFactura, vendedor):
        self.facturaID+=1
        self.facturas.append(self)
        self.cliente=cliente
        self.fechaFactura = fechaFactura
        self.vendedor= vendedor
        self.productos= {}
    def __init__(self, cliente, fechaFactura, vendedor):
        self.facturaID+=1
        self.facturas.append(self)
        self.cliente=cliente
        self.fechaFactura = fechaFactura
        self.vendedor= vendedor
        self.productos = {}

    def __str__(self):
        str = "~ Factura #"+ self.facturaID + "\n"+ "~ Fecha = " + self.fechaFactura +"\n"+ "~ Cliente = " + self.cliente.getNombre() + '\n' +"~ Cantidad a pagar = " +self.total+ "\n";
        return str


    def calcularTotal(self):
        tot=0
        for producto in self.productos:
            tot+= producto* self.productos[producto]
        self.total=tot*self.IVA
        return  tot

    def agregarProducto(self, producto, cantidad):
        self.productos[producto] = cantidad

    def eliminarProducto(self, producto):
        if producto in self.productos:
            self.productos.pop(producto)
            return True
        else:
            return  False
    @classmethod
    def getFacturas(cls):
        return cls.facturas
    @classmethod
    def setFacturas(cls, facturas):
        cls.facturas=facturas
    @classmethod
    def getFacturaID(cls):
        return cls.facturaID
    @classmethod
    def setFacturaID(cls, f):
        cls.facturaID = f

    def getCliente(self):
        return self.cliente
    def setCliente(self, cliente):
        self.cliente=cliente
    def getFechaFactura(self):
        return self.fechaFactura
    def getProductos(self):
        return  self.productos
    def setProductos(self, productos):
        self.productos=productos
    @classmethod
    def getTotal(cls):
        return cls.total
    @classmethod
    def setTotal(cls, total):
        cls.total= total

    def getVendedor(self):
        return  self.vendedor
    def setVendedor(self, v):
        self.vendedor=v
