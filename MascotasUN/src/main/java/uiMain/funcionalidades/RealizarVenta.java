package uiMain.funcionalidades;
import gestorAplicacion.gestionPersonas.*;
import gestorAplicacion.gestionVentas.*;
import uiMain.CasosPrueba;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Date;
public class RealizarVenta {
    static  Tienda t= new Tienda();

    //Mostrar productos disponibles
    public static Scanner input = new Scanner(System.in);
    public static  void funcionalidad() throws ParseException {
        int opcion;
        int opcion2;
        do {
            System.out.println("Realizar una compra");
            System.out.println(" 1. Mostrar productos disponibles");
            System.out.println(" 2. agregar productos a la compra");
            System.out.println(" 3. Regresar");
            System.out.print("Indique su eleccion : ");
            opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    obtenerProductos(t);
                    break;
                case 2:
                    do{
                        System.out.println("Agregar a la compra");
                        System.out.println(" 1. Agregar un nuevo producto");
                        System.out.println(" 2. Eliminar un producto");
                        System.out.println(" 3. Mostrar resumen de factura");
                        System.out.println(" 4. Finalizar compra");
                        System.out.println(" 5. volver al menu compra");
                        System.out.print("Indique su eleccion : ");
                        opcion2 = input.nextInt();
                        Factura facturita;
                        switch (opcion2){
                            case 1:
                                System.out.println("Ingrese 1 para un usuario registrado y 0 para agregar uno nuevo");
                                int us= input.nextInt();
                                switch (us){
                                    case 1:
                                        //hacer condicional que busque el cliente que ya esté registrado
                                        System.out.println("Ingrese la fecha en formado: dd/mm/yyyy ");
                                        String f=input.next();
                                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                        Date fecha = sdf.parse(f);
                                        System.out.println("Ingrese el metodo de pago: \n 1 en caso de efectivo 0 en caso de tarjeta");
                                        facturita= new Factura(Usuario.getUsuarios().get(0), fecha, Vendedor.getVendedores().get(0));
                                        break;
                                    case 0:
                                        System.out.println("Si el usuario se desea registrar con cuenta bancaria ingrese 1\n en caso contrario ingrese 0");
                                        int cu= input.nextInt();
                                        switch (cu){
                                            case 1:
                                                System.out.println("Ingrese el ID del cliente: ");
                                                int id= input.nextInt();
                                                System.out.println("Ingrese el nombre del cliente: ");
                                                String nombre= input.next();
                                                System.out.println("Ingrese el email del cliente: ");
                                                String email= input.next();
                                                System.out.println("Ingrese el email del cliente: ");
                                                int telefono= input.nextInt();
                                                System.out.println("Ingrese el numero de la cuenta bancaria del cliente: ");
                                                long nro= input.nextLong();
                                                System.out.println("Ingrese el saldo de la cuenta bancaria del cliente: ");
                                                float saldo= input.nextFloat();
                                                System.out.println("Ingrese el pin de la cuenta bancaria cliente: ");
                                                int pin= input.nextInt();
                                                System.out.println("Ingrese la direccion del cliente");
                                                String dir= input.next();
                                                System.out.println("Ingrese el numero de mascotas del cliente :");
                                                int mas = input.nextInt();
                                                ArrayList<Mascota> pets = new ArrayList<>();
                                                for(int i=0;i<=mas;i++){
                                                    System.out.println("1 en caso de perro, 0 en caso de gato");
                                                    int n=input.nextInt();
                                                    System.out.println("Ingrese el nombre de la mascota: ");
                                                    String na= input.next();
                                                    System.out.println("Ingrese la edad en años de la mascota: ");
                                                    int edad= input.nextInt();
                                                    System.out.println("Ingrese la raza de la mascota: ");
                                                    String raza= input.next();

                                                    switch (n){
                                                        case 1:
                                                            Perro p =new Perro(na, edad, raza);
                                                            pets.add(p);
                                                            break;
                                                        case 0:
                                                            Gato g =new Gato(na, edad, raza);
                                                            pets.add(g);
                                                            break;
                                                    }

                                                }
                                               Usuario user1 = new Usuario(id,nombre,email,telefono,new CuentaBancaria(nro,saldo,pin),dir,pets);
                                                System.out.println("Ingrese la fecha en formado: dd/mm/yyyy ");
                                                String f1=input.next();
                                                SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                                                Date fecha1 = sdf1.parse(f1);
                                                facturita= new Factura(user1,fecha1,Vendedor.getVendedores().get(0));
                                                break;
                                            case 0:
                                                System.out.println("Ingrese el ID del cliente: ");
                                                int id1= input.nextInt();
                                                System.out.println("Ingrese el nombre del cliente: ");
                                                String nombre1= input.next();
                                                System.out.println("Ingrese el email del cliente: ");
                                                String email1= input.next();
                                                System.out.println("Ingrese el email del cliente: ");
                                                int telefono1= input.nextInt();
                                                System.out.println("Ingrese la direccion del cliente");
                                                String dir1= input.next();
                                                System.out.println("Ingrese el numero de mascotas del cliente :");
                                                int mas1 = input.nextInt();
                                                ArrayList<Mascota> pets1 = new ArrayList<>();
                                                for(int i=0;i<=mas;i++){
                                                    System.out.println("1 en caso de perro, 0 en caso de gato");
                                                    int n=input.nextInt();
                                                    System.out.println("Ingrese el nombre de la mascota: ");
                                                    String na= input.next();
                                                    System.out.println("Ingrese la edad en años de la mascota: ");
                                                    int edad= input.nextInt();
                                                    System.out.println("Ingrese la raza de la mascota: ");
                                                    String raza= input.next();

                                                    switch (n){
                                                        case 1:
                                                            Perro p =new Perro(na, edad, raza);
                                                            pets.add(p);
                                                            break;
                                                        case 0:
                                                            Gato g =new Gato(na, edad, raza);
                                                            pets.add(g);
                                                            break;
                                                    }

                                                }
                                                Usuario user2 = new Usuario(id1,nombre1,email1,telefono1,dir1,pets1);
                                                System.out.println("Ingrese la fecha en formado: dd/mm/yyyy ");
                                                String f2=input.next();
                                                SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                                                Date fecha2 = sdf2.parse(f2);
                                                facturita= new Factura(user2,fecha2,Vendedor.getVendedores().get(0));
                                                break;

                                        }



                                }

                        }
                    }
                    }
            }

        }

    public static void obtenerProductos(Tienda tienda) {
        for (Map.Entry<Producto, Integer> fact : tienda.getInventario().entrySet()) {
            Producto k = fact.getKey();
            Integer v = fact.getValue();
            System.out.println("~ " + k.toString() + "\n" + "Tiene " + v + " unidades disponibles\n");

        }
    }

}

