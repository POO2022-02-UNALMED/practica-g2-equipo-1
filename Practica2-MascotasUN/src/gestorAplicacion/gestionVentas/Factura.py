from src.gestorAplicacion.gestionPersonas import Vendedor
from src.gestorAplicacion.gestionPersonas import Usuario
from random import randint
from src.gestorAplicacion.gestionVentas.Tienda import Tienda
class Factura:
    facturas= {}
    facturaID = randint(3424242,7654564)
    total = 0.0
    IVA = 1.16


    def __init__(self, cliente=None, fechaFactura="", vendedor=None):
        self.facturaID= Factura.facturaID
        Factura.facturas[self.facturaID] = self
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
    @classmethod
    def realizarCompra(cls,cliente):
        total= cls.calcularTotal()
        Tienda.reducirStock(cls)
        Tienda.getCuenta.depositar(total)
        cliente.agregarFactura(cls)
        Tienda.agregarVenta(cls)
    @classmethod
    def realizarCompraProveedor(cls, proveedor, total, pin):
        Tienda.aumentarStock(cls)
        Tienda.getCuenta().transferir(proveedor.getCuenta(),total,pin)
        return total
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
