package baseDatos;

//Gestion personas
import gestorAplicacion.gestionPersonas.CuentaBancaria;
import gestorAplicacion.gestionPersonas.Proveedor;
import gestorAplicacion.gestionPersonas.Usuario;
import gestorAplicacion.gestionPersonas.Vendedor;
import gestorAplicacion.gestionVentas.*;
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
        //Deserializacion Cuentas Bancarias
        try {
            fileIn = new FileInputStream("src\\baseDatos\\temp\\cuentasBancarias.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<CuentaBancaria> cuentasBancarias;
            cuentasBancarias = (ArrayList<CuentaBancaria>) in.readObject();
            CuentaBancaria.setCuentasBancarias(cuentasBancarias);
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
      //Deserializacion gatos
        try {
            fileIn = new FileInputStream("src\\baseDatos\\temp\\gatos.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<Gato> gatos;
            gatos = (ArrayList<Gato>) in.readObject();
            Gato.setGatos(gatos);
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        //Deserializacion perros
        try {
            fileIn = new FileInputStream("src\\baseDatos\\temp\\perros.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<Perro> perros;
            perros = (ArrayList<Perro>) in.readObject();
            Perro.setPerros(perros);
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        //Deserializacion productos
        try {
            fileIn = new FileInputStream("src\\baseDatos\\temp\\productos.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<Producto> productos;
            productos = (ArrayList<Producto>) in.readObject();
            Producto.setProductos(productos);
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        //Deserializar tienda
        try {
            fileIn = new FileInputStream("src\\baseDatos\\temp\\tienda.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<Tienda> tienda;
            tienda = (ArrayList<Tienda>) in.readObject();
            Tienda.setTienda(tienda);
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
