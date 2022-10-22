package baseDatos;

//Gestion personas
import gestorAplicacion.gestionPersonas.Proveedor;
import gestorAplicacion.gestionPersonas.Usuario;
import gestorAplicacion.gestionPersonas.Vendedor;
import gestorAplicacion.gestionVentas.Envio;
import gestorAplicacion.gestionVentas.Factura;
//Gestion ventas

import java.io.*;
import java.util.ArrayList;

public class Deserializador {
    /* Se encarga de deserializar las listas de cada clase*/
    public static void deserializar(){
        FileInputStream fileIn;
        //Deserializacion proveedores
        try {
            fileIn = new FileInputStream("src\\baseDatos\\temp\\proveedores.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<Proveedor> proveedores;
            proveedores = (ArrayList<Proveedor>) in.readObject();
            Proveedor.setProveedores(proveedores);
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        //Deserializacion usuarios
        try {
            fileIn = new FileInputStream("src\\baseDatos\\temp\\usuarios.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<Usuario> usuarios;
            usuarios = (ArrayList<Usuario>) in.readObject();
            Usuario.setUsuarios(usuarios);
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        //Deserializacion vendedores
        try {
            fileIn = new FileInputStream("src\\baseDatos\\temp\\vendedores.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<Vendedor> vendedores;
            vendedores = (ArrayList<Vendedor>) in.readObject();
            Vendedor.setVendedores(vendedores);
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        //Deserializacion envios
        try {
            fileIn = new FileInputStream("src\\baseDatos\\temp\\envios.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<Envio> envios;
            envios = (ArrayList<Envio>) in.readObject();
            Envio.setEnvios(envios);
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        //Deserializacion facturas
        try {
            fileIn = new FileInputStream("src\\baseDatos\\temp\\facturas.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<Factura> facturas;
            facturas = (ArrayList<Factura>) in.readObject();
            Factura.setFacturas(facturas);
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
