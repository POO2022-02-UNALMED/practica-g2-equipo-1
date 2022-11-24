import pickle
from  src.gestorAplicacion.gestionPersonas import Vendedor
from  src.gestorAplicacion.gestionPersonas import Usuario
from  src.gestorAplicacion.gestionPersonas import Proveedor
from  src.gestorAplicacion.gestionPersonas import Perro
from  src.gestorAplicacion.gestionPersonas import Gato
from  src.gestorAplicacion.gestionPersonas import CuentaBancaria
from src.gestorAplicacion.gestionVentas import Envio
from src.gestorAplicacion.gestionVentas import Factura
from src.gestorAplicacion.gestionVentas import Producto
from src.gestorAplicacion.gestionVentas import Tienda
class Serializador:
    @classmethod
    def serializar(cls):
        #Serializador Proveedor
        proveedores = open("src/baseDatos/tmp/proveedores.pkl","wb")
        pickle.dump(Proveedor.getProveedores(), proveedores)
        proveedores.close()
        #Serializador Vendedor
        vendedores=open("src/baseDatos/tmp/vendedores.pkl","wb")
        pickle.dump(Vendedor.getVendedores(), vendedores)
        vendedores.close()
        #Serializador Usuario
        usuarios=open("src/baseDatos/tmp/usuarios.pkl","wb")
        pickle.dump(Usuario.getUsuarios(), usuarios)
        usuarios.close()
        #Serializador Perro
        perros=open("src/baseDatos/tmp/perros.pkl","wb")
        pickle.dump(Perro.getPerros(), perros)
        perros.close()
        #Serializador Gato
        gatos=open("src/baseDatos/tmp/gatos.pkl","wb")
        pickle.dump(Gato.getGatos(),gatos)
        gatos.close()
        #Serializador CuentaBancaria
        cuentasbancarias=open("src/baseDatos/tmp/cuentasbancarias.pkl","wb")
        pickle.dump(CuentaBancaria.getCuentasBancarias(),cuentasbancarias)
        cuentasbancarias.close()
        #Serializador Envio
        envios=open("src/baseDatos/tmp/envios.pkl","wb")
        pickle.dump(Envio.getEnvios,envios)
        envios.close()
        #Serializador Facturas
        facturas=open("src/baseDatos/tmp/facturas.pkl","wb")
        pickle.dump(Factura.getFacturas(),facturas)
        facturas.close()
        #Serializador Producto
        productos=open("src/baseDatos/tmp/productos.pkl","wb")
        pickle.dump(Producto.getProductos(),productos)
        productos.close()
        #Serializador Tienda
        tienda=open("src/baseDatos/tmp/tienda.pkl","wb")
        pickle.dump(Tienda.getTienda(), tienda)
        tienda.close()
        #Serializador Inventario
        inventario=open("src/baseDatos/tmp/inventario.pkl","wb")
        pickle.dump(Tienda.getInventario(),inventario)
        inventario.close()
        #Serializador Catalogo
        catalogo=open("src/baseDatos/tmp/catalogo.pkl","wb")
        pickle.dump(Tienda.getCatalogo(),catalogo)
        catalogo.close()