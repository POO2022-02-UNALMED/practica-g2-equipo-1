package baseDatos;
//Importamos del paquete gestion personas
import gestorAplicacion.gestionPersonas.CuentaBancaria;
import gestorAplicacion.gestionPersonas.Proveedor;
import gestorAplicacion.gestionPersonas.Usuario;
import gestorAplicacion.gestionPersonas.Vendedor;
//Importamos del paquete gestion ventas
import gestorAplicacion.gestionVentas.*;
import gestorAplicacion.gestionVentas.Gato;
import gestorAplicacion.gestionVentas.Perro;

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
        //serializador CuentaBancaria
        try {
            fileOut = new FileOutputStream("src\\baseDatos\\temp\\cuentasBancarias.txt");
            ObjectOutputStream salida = new ObjectOutputStream(fileOut);
            salida.writeObject(CuentaBancaria.getCuentasBancarias());
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
        //serializador factura
        try {
            fileOut = new FileOutputStream("src\\baseDatos\\temp\\facturas.txt");
            ObjectOutputStream salida = new ObjectOutputStream(fileOut);
            salida.writeObject(Factura.getFacturas());
            salida.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //serializador perro
        try {
            fileOut = new FileOutputStream("src\\baseDatos\\temp\\perros.txt");
            ObjectOutputStream salida = new ObjectOutputStream(fileOut);
            salida.writeObject(Perro.getPerros());
            salida.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
      //serializador gato
        try {
            fileOut = new FileOutputStream("src\\baseDatos\\temp\\gatos.txt");
            ObjectOutputStream salida = new ObjectOutputStream(fileOut);
            salida.writeObject(Gato.getGatos());
            salida.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //serializador productos
        try {
            fileOut = new FileOutputStream("src\\baseDatos\\temp\\productos.txt");
            ObjectOutputStream salida = new ObjectOutputStream(fileOut);
            salida.writeObject(Producto.getProductos());
            salida.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //serializador tienda
        try {
            fileOut = new FileOutputStream("src\\baseDatos\\temp\\tienda.txt");
            ObjectOutputStream salida = new ObjectOutputStream(fileOut);
            salida.writeObject(Tienda.getTienda());
            salida.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
