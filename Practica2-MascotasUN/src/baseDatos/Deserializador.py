import pickle
from src.gestorAplicacion.gestionPersonas.Gato import Gato
from src.gestorAplicacion.gestionPersonas.Gato import Perro
from src.gestorAplicacion.gestionVentas.Producto import Producto
from src.gestorAplicacion.gestionPersonas.Vendedor import Vendedor
from src.gestorAplicacion.gestionPersonas.Proveedor import Proveedor
from src.gestorAplicacion.gestionPersonas.Vendedor import Usuario
from src.gestorAplicacion.gestionVentas.Envio import Envio
from src.gestorAplicacion.gestionVentas.Factura import Factura
from src.gestorAplicacion.gestionVentas.Tienda import Tienda
from src.gestorAplicacion.gestionPersonas.CuentaBancaria import CuentaBancaria
class Deserializador:
    @classmethod
    def deserializar(cls):
        #Deserializar Vendedor
        vendedores=open("src/baseDatos/tmp/vendedores.pkl","rb")
        Vendedor.setVendedores(pickle.load(vendedores))
        vendedores.close()
        #Deserializador Usuario
        usuarios=open("src/baseDatos/tmp/usuarios.pkl","rb")
        Usuario.setUsuarios(pickle.load(usuarios))
        usuarios.close()
        #Deserializador Proveedor
        proveedores=open("src/baseDatos/tmp/proveedores.pkl","rb")
        Proveedor.setProveedores(pickle.load(proveedores))
        proveedores.close()
        #Deserializador Perro
        perros=open("src/baseDatos/tmp/perros.pkl","rb")
        Perro.setPerros(pickle.load(perros))
        perros.close()
        #Deserializador Gato
        gatos=open("src/baseDatos/tmp/gatos.pkl","rb")
        Gato.setGatos(pickle.load(gatos))
        gatos.close()
        #Deserializador CuentaBancaria
        cuentasbancarias=open("src/baseDatos/tmp/cuentasbancarias.pkl.pkl","rb")
        CuentaBancaria.setCuentasBancarias(pickle.load(cuentasbancarias))
        cuentasbancarias.close()
        #Deserializador Envio
        envios=open("src/baseDatos/tmp/envios.pkl","rb")
        Envio.setEnvios(pickle.load(envios))
        envios.close()
        #Deserializador Factura
        facturas=open("src/baseDatos/tmp/facturas.pkl","rb")
        Factura.setFacturas(pickle.load(facturas))
        facturas.close()
        #Deserializador Producto
        productos=open("src/baseDatos/tmp/productos.pkl","rb")
        Producto.setProductos(pickle.load(productos))
        productos.close()
        #Deserializador Tienda
        tienda=open("src/baseDatos/tmp/tienda.pkl","rb")
        Tienda.setTienda(pickle.load(tienda))
        tienda.close()
        #Deserializador Inventario
        inventario=open("src/baseDatos/tmp/inventario.pkl","rb")
        Tienda.setInventario(pickle.load(inventario))
        inventario.close()
        #Deserializador Catalogo
        catalogo=open("src/baseDatos/tmp/catalogo.pkl","rb")
        Tienda.setCatalogo(pickle.load(catalogo))
        catalogo.close()