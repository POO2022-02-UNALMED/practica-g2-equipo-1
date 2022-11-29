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
class Serializador:
    @classmethod
    def serializar(cls):
        baseDatos = {
            "gato": Gato.getGatos(),
            "perro": Perro.getPerros(),
            "producto": Producto.getProductos(),
            "vendedor": Vendedor.getVendedores(),
            "proveedor": Proveedor.getProveedores(),
            "usuario": Usuario.getUsuarios(),
            "factura": Factura.getFacturas(),
            "tienda": Tienda.getTienda(),
            "cuentaBancaria": CuentaBancaria.getCuentasBancarias(),
            "inventario": Tienda.getInventario(),
            "catalogo": Tienda.getCatalogo()
        }

        for arch, ite in baseDatos.items():
            picklefile = open(os.path.join(pathlib.Path(__file__).parent.absolute(), f"tmp\\{arch}"), "wb")
            pickle.dump(ite, picklefile)
            picklefile.close()