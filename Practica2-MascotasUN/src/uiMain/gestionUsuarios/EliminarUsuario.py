class EliminarUsuario:
    
    @classmethod
    def eliminarUsuario(cls):
        print("Estás a punto de eliminar un usuario del sistema")
        id = input("Ingrese el codigo del usuario que se quiere eliminar: ")
        if id in Tienda.usuarios:
            del Tienda.usuarios[id]
            print("Usuario eliminado exitosamente")
        else:
            print("El usuario no existe")