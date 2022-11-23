class VerUsuario:
    
    @classmethod
    def verUsuario(cls):
        print("Ingrese el ID del usuario que desea ver: ")
        id = input()
        if id in Tienda.usuarios:
            print("Usuario encontrado")
            print(Tienda.usuarios[id])
        else:
            print("Usuario no encontrado")