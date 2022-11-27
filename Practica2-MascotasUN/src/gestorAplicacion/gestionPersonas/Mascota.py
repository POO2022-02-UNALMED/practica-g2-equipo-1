class Mascota:
    _mascotas = []
    

    #Metodo para identificar una mascota con su id.
    def encontrarMascota(cls, id):
        for i in cls._mascotas:
            if isinstance(i, Mascota):
                if (i.getMascotaID == id):
                    return i
