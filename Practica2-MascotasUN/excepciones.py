from tkinter import messagebox

class ErrorApp(Exception):

    def __init__(self, mensaje):
        self._error = "Manejo de errores de nuestra aplicacion " + mensaje
        super().__init__(self._error)

    def showMessage(self):
        messagebox.showerror('Excepcion', self._error)

class ExcepcionCampos(ErrorApp):

    def __init__(self, mensaje):
        self._error = "ExcepcionCampos " + mensaje
        super().__init__(self._error)

class ExcepcionRepeticion(ErrorApp):

    def __init__(self, mensaje):
        self._error = "ExcepcionRepetidos " + mensaje
        super().__init__(self._error)

class ExcepcionCamposVacios(ExcepcionCampos):

    def __init__(self):
        super().__init__("Campo nulo, llene todos los espacios")

class ExcepcionNumNoValido(ExcepcionCampos):

    def __init__(self):
        super().__init__("No ingrese numero negativos")

class ExcepcionTiposErrados(ExcepcionCampos):

    def __init__(self):
        super().__init__("Los tipos de datos no coinciden")

class ExcepcionCodigoInexistente(ExcepcionRepeticion):

    def __init__(self):
        super().__init__("Esa entidad no existe, por favor verifique el codigo")

class ExcepcionArregloSinDatos(ExcepcionRepeticion):

    def __init__(self):
        super().__init__("No existen valores para la busqueda solicitada")
