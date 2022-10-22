package baseDatos;

import gestorAplicacion.gestionPersonas.Proveedor;
import gestorAplicacion.gestionPersonas.Usuario;
import gestorAplicacion.gestionPersonas.Vendedor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializador {
    /* Se encarga de serializar las listas de cada clase*/
    public static void serializar() {
        FileOutputStream fileOut;
        //serializador proveedores
        try {
            fileOut = new FileOutputStream("src\\baseDatos\\temp\\proveedores.txt");
            ObjectOutputStream salida = new ObjectOutputStream(fileOut);
            salida.writeObject(Proveedor.getProveedores());
            salida.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //serializador usuarios
        try {
            fileOut = new FileOutputStream("src\\baseDatos\\temp\\usuarios.txt");
            ObjectOutputStream salida = new ObjectOutputStream(fileOut);
            salida.writeObject(Usuario.getUsuarios());
            salida.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //serializador vendedores
        try {
            fileOut = new FileOutputStream("src\\baseDatos\\temp\\vendedores.txt");
            ObjectOutputStream salida = new ObjectOutputStream(fileOut);
            salida.writeObject(Vendedor.getVendedores());
            salida.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //serializador envio
        try {
            fileOut = new FileOutputStream("src\\baseDatos\\temp\\envios.txt");
            ObjectOutputStream salida = new ObjectOutputStream(fileOut);
            salida.writeObject(Envio.getEnvios());
            salida.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
