import gestorAplicacion.gestionVentas.Producto
import gestorAplicacion.gestionVentas.Tienda

class CrearProducto:

    @classmethod
    def registrarProducto(cls):
        print("Estas a punto de agregar un nuevo producto \n")
        nombre= input("Ingresa el nombre del producto")
        productoID= float(input("Ingrese el ID del producto"))
        fechaV= input("Ingrese la fecha de vencimiento")
        descripcion = input("Ingrese la descripción del producto")
        cantidadComprada= int(input("Ingrese la cantidad de productos que se ha comprado"))
        precioCompra = float(input("Ingrese el precio de compra del producto"))
        precioVenta = float(input("Ingrese el precio de venta del producto"))

        prod  = Producto(productoID, nombre, fechaV, descripcion, precioCompra, precioVenta, cantidadComprada )
        Tienda.agregarProductoCatalogo(prod)
        Producto.AgregarProducto(prod)
        print("El producto se agregó de manera existosa")
        print(prod)