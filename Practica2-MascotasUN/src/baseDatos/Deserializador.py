import pickle
import os
import pathlib
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
        baseDatos = {
            "gato":lambda x :Gato.setGatos(x),
            "perro":lambda x :Perro.setPerros(x),
            "producto":lambda x :Producto.setProductos(x),
            "vendedor":lambda x :Vendedor.setVendedores(x),
            "proveedor":lambda x :Proveedor.setProveedores(x),
            "usuario":lambda x :Usuario.setUsuarios(x),
            "factura":lambda x :Factura.setFacturas(x),
            "tienda":lambda x :Tienda.setTienda(x),
            "cuentaBancaria":lambda x :CuentaBancaria.setCuentasBancarias(x),
            "inventario":lambda x :Tienda.setInventario(x),
            "catalogo":lambda x :Tienda.setCatalogo(x)
        }

        for arch, set in baseDatos.items():
            picklefile = open(os.path.join(pathlib.Path(__file__).parent.absolute(), f"tmp\\{arch}"), "rb")
            dato = pickle.load(picklefile)
            set(dato)
            picklefile.close()