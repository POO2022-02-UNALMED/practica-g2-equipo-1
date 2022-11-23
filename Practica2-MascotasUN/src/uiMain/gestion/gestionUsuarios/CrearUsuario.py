# Esta clase se encarga de registrar un nuevo objeto de la clase usuario, incluyendo la cuenta bancaria que se asocia al mismo 
# y las mascotas que posee, por ultimo se muestra para comprobar que se agrego exitosamente

class CrearUsuario:
    
    @classmethod
    def crearUsuario(cls):
        print("Estás a punto de ingresar un nuevo usuario al sistema")
        print("Si el usuario se desea registrar con cuenta bancaria ingrese 1\n En caso contrario, ingrese 0")
        valor = int(input())
        id = input("Ingrese el ID del usuario: ")
        nombre = input("Ingrese el nombre del cliente: ")
        email = input("Ingrese el email del cliente: ")
        telefono = input("Ingrese el telefono del cliente: ")
        nro = input("Ingrese el numero de cuenta bancaria del cliente. Si no tiene, ingrese 0: ")
        saldo = input("Ingrese el saldo de la cuenta bancaria del cliente. Si no tiene, ingrese 0: ")
        pin = input("Ingrese el pin de la cuenta bancaria del cliente. Si no tiene, ingrese 0: ")
        direccion = input("Ingrese la dirección del cliente: ")
        numMascotas = input("Ingrese el número de mascotas del cliente: ")
        mascotas = []
            
        # Se hace una lista que agrega a las mascotas haciendo uso del for dependiendo de la cantidad de mascotas que tiene el cliente
        for i in range(int(numMascotas)):
            tipo = input("Ingrese 1 si es perro o 0 si es gato: ")
            if tipo == "1":
                mId = input("Ingrese el ID de la mascota: ")
                nombreMascota = input("Ingrese el nombre de la mascota: ")
                edad = input("Ingrese la edad en años de la mascota: ")
                raza = input("Ingrese la raza de la mascota: ")
                # Se crea un objeto de la clase perro y se agrega a la lista de mascotas
                mascota = Perro(mId, nombreMascota, edad, raza)
                mascotas.append(mascota)
            else:
                # Se crea un objeto de la clase gato y se agrega a la lista de mascotas
                mascota = Gato(mId, nombreMascota, edad)
                mascotas.append(mascota)
        # Se crea una nueva instancia de la clase usuario con su respectiva lista de mascotas y cuenta bancaria, 
        # que a su vez crean objetos de otras clases (CuentaBancaria y Perro o Gato)
        cuenta = CuentaBancaria(nro, saldo, pin)
        if valor == 1:
            nuevoUsuario = Usuario(id, nombre, email, telefono, cuenta, direccion, mascotas)
        else:
            nuevoUsuario = Usuario(id, nombre, email, telefono, direccion, mascotas)
        Tienda.usuarios[nuevoUsuario.usuario] = nuevoUsuario
        print("Ingrese la fecha en formato dd/mm/yyyy: ")
        print("Usuario creado exitosamente")
        # Se imprime el usuario creado con atributos predeterminados en el toString()
        nuevoUsuario.toString()
        print(nuevoUsuario)
        return nuevoUsuario