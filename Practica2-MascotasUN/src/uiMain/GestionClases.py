#Esta clase se encarga de gestionar las clases individuales de gestion de productos, proveedores, usuarios y vendedores

from uiMain.gestion.gestionProductos import GestionProductos
from uiMain.gestion.gestionProveedores import GestionProveedor
from uiMain.gestion.gestionUsuarios import GestionUsuarios
from uiMain.gestion.gestionVendedores import GestionVendedores


class GestionClases:
    opcion=0
    @classmethod
    def gestionClases(cls):
        print("Bienvenido, en este lugar puedes gestionar todo lo relacionado con tus companeros, usuarios, proveedores y productos de tu tienda")
        print("Que deseas hacer?")
        print(" 1. Gestionar Productos")
        print(" 2. Gestionar Proveedores")
        print(" 3. Gestionar Usuarios")
        print(" 4. Gestionar Companeros")
        print(" 5. Regresar")
        cls.opcion = input()
            
        
        if cls.opcion==1:
            GestionProductos.gestionarProductos() 
        if cls.opcion==2:
            GestionProveedor.gestionProveedores()
        if cls.opcion==3:
            GestionUsuarios.gestionarUsuarios()
        if cls.opcion==4:
            GestionVendedores.gestionarVendedores()
        if cls.opcion==5:
            pass    #"regresar a donde"???

    
    