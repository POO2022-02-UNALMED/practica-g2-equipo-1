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
     static Factura facturita = new Factura();

    //Mostrar productos disponibles
    public static Scanner input = new Scanner(System.in);
    public static void funcionalidad() {
        int opcion;
        int opcion2;
        do {
            System.out.println("Realizar una compra");
            System.out.println(" 1. Mostrar productos disponibles");
            System.out.println(" 2. Agregar productos a la compra");
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
                        System.out.println(" 5. Configurar envio de compra");
                        System.out.println(" 6. volver al menu compra");
                        System.out.print("Indique su eleccion : ");
                        opcion2 = input.nextInt();

                        switch (opcion2){
                            case 1:

                                System.out.println("Ingrese 1 para un usuario registrado y 0 para agregar uno nuevo");
                                int us= input.nextInt();
                                switch (us){
                                    case 1:
                                        //hacer condicional que busque el cliente que ya esté registrado
                                        System.out.println("Ingrese el ID del cliente");
                                        long clienteID= input.nextLong();
                                        Usuario cliente= encontrarPersona(Usuario.getUsuarios(),clienteID);
                                        System.out.println("Ingrese la fecha en formado: dd/mm/yyyy ");
                                        String fecha=input.next();
                                        System.out.println("Ingrese el metodo de pago: \n 1 en caso de efectivo 0 en caso de tarjeta");
                                        facturita= new Factura(cliente, fecha, Vendedor.getVendedores().get(0));
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
                                                    System.out.println("Ingrese el Id de la mascota");
                                                    long mId= input.nextLong();
                                                    System.out.println("Ingrese el nombre de la mascota: ");
                                                    String na= input.next();
                                                    System.out.println("Ingrese la edad en años de la mascota: ");
                                                    int edad= input.nextInt();
                                                    System.out.println("Ingrese la raza de la mascota(para gato ingrese n): ");
                                                    String raza= input.next();

                                                    switch (n){
                                                        case 1:
                                                            Perro p =new Perro(mId,na, edad, raza);
                                                            pets.add(p);
                                                            break;
                                                        case 0:
                                                            Gato g =new Gato(mId,na, edad);
                                                            pets.add(g);
                                                            break;
                                                    }

                                                }
                                               Usuario user1 = new Usuario(id,nombre,email,telefono,new CuentaBancaria(nro,saldo,pin),dir,pets);
                                                System.out.println("Ingrese la fecha en formado: dd/mm/yyyy ");
                                                String fecha1=input.next();
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
                                                    System.out.println("Ingrese el ID de la mascota: ");
                                                    long mId = input.nextLong();
                                                    System.out.println("Ingrese el nombre de la mascota: ");
                                                    String na= input.next();
                                                    System.out.println("Ingrese la edad en años de la mascota: ");
                                                    int edad= input.nextInt();
                                                    System.out.println("Ingrese la raza de la mascota (si es gato no aplica (ingrese n)): ");
                                                    String raza= input.next();

                                                    switch (n){
                                                        case 1:
                                                            Perro p =new Perro(mId,na, edad, raza);
                                                            pets.add(p);
                                                            break;
                                                        case 0:
                                                            Gato g =new Gato(mId,na, edad);
                                                            pets.add(g);
                                                            break;
                                                    }

                                                }
                                                Usuario user2 = new Usuario(id1,nombre1,email1,telefono1,dir1,pets1);
                                                System.out.println("Ingrese la fecha en formado: dd/mm/yyyy ");
                                                String fecha2=input.next();
                                                facturita= new Factura(user2,fecha2,Vendedor.getVendedores().get(0));
                                                break;

                                        }



                                }
                                while (true){
                                    System.out.println("Ingrese el ID del producto que desea agregar: ");
                                    long idP=input.nextLong();
                                    Producto aComp= encontrarProducto(idP);
                                    System.out.println("Ingrese la cantidad del producto que desea agregar");
                                    int cantidad= input.nextInt();
                                    if (t.getInventario().get(aComp)>=cantidad){
                                        facturita.agregarProducto(aComp, cantidad);
                                        System.out.println("El producto se ha agregado con exito a la compra");
                                    } else{
                                        System.out.println("Lo sentimos no hay stock suficiente para esta venta");
                                        continue;
                                    }
                                    System.out.println("Desea agregar mas productos? ");
                                    System.out.println("1 para sí, 0 en caso contrario");
                                    int x = input.nextInt();
                                    if (x==0){break;}
                            }
                            case 2:
                                while (true){
                                    System.out.println("Ingrese el id del producto que desea eliminar");

                                    long idE= input.nextLong();
                                    Producto borrar= encontrarProducto(idE);
                                    if(t.getInventario().containsKey(borrar)==true){
                                        facturita.eliminarProducto(borrar);

                                    }else{
                                        System.out.println("Lo sentimos el producto no se encuentra en la factura");
                                    }
                                    System.out.println("Desea eliminar mas productos? ");
                                    System.out.println("1 para si, 0 en caso contrario");
                                    int x = input.nextInt();
                                    if (x==0){break;}
                                }
                            case 3:
                                System.out.println("Resumen de la factura: ");
                                System.out.println(facturita.toString());
                                int incrementa=1;
                                for (Map.Entry<Producto, Integer> entry : facturita.getProductos().entrySet()) {
                                    Producto k = entry.getKey();
                                    Integer v = entry.getValue();
                                    System.out.println(incrementa + ") " + k.getNombre()+" " + v + " unidades, y tiene un precio unitario de: " + k.getPrecioVenta());
                                    incrementa++;
                                }
                            case 4:
                                System.out.println("Está a punto de finalizar la compra, está seguro que desea terminar la venta?");
                                System.out.println("ingrese 1 para finalizar la compra y cero para continuar con la compra");
                                int y = input.nextInt();
                                if(y==0){
                                    break;
                                }else {
                                    System.out.println("Resumen de compra");
                                    System.out.println(facturita.toString());
                                    System.out.println("El usuario desea pagar en efectivo?");
                                    System.out.println("ingrese 1 si el pago es en efectivo y 0 si es con tarjeta");
                                    int z=input.nextInt();
                                    switch (z){
                                        case 1:
                                            float fina= facturita.realizarCompra(facturita.getCliente());
                                            System.out.println("el total de la compra fue: "+ fina);
                                            break;
                                        case 0:
                                            System.out.println("Solicite al cliente la contraseña de su cuenta bancaria");
                                            short contra= input.nextShort();
                                            if(facturita.getCliente().getCuenta().validarCredenciales(contra)==true){
                                                float fina2= facturita.realizarCompra(facturita.getCliente(),contra);
                                                System.out.println("el total de la compra fue: "+ fina2);
                                            }
                                            break;
                                    }
                                }
                                break;

                            case 5:
                                System.out.println("La compra con id "+facturita.getFacturaID()+" fue generada \n");
                                System.out.println("Desea que se realice un envio de esta?\n");
                                System.out.println("Digite 1 si el cliente lo requiere o 0 si no");
                                int g=input.nextInt();
                                switch (g){
                                    case 1:
                                        System.out.println("Ingrese el destino de su compra: ");
                                        String destino= input.next();
                                        Envio envio = new Envio(facturita.getFacturaID(),destino,0);
                                        System.out.println("Su envio fue creado exitosamente");
                                        break;
                                    case 0:
                                        System.out.println("");
                                        break;
                                }
                                System.out.println("Gracias por preferirnos");
                                break;

                            case 6:
                                break;
                        }
                    } while (opcion2 != 6);
                case 3: break;
            }

        }while (opcion != 3);

    }

    public static void obtenerProductos(Tienda tienda) {
        for (Map.Entry<Producto, Integer> fact : tienda.getInventario().entrySet()) {
            Producto k = fact.getKey();
            Integer v = fact.getValue();
            System.out.println("~ " + k.toString() + "\n" + "Tiene " + v + " unidades disponibles\n");

        }


    }
    public static Usuario encontrarPersona(ArrayList<Usuario> clientes, long id){
        for(Usuario cliente: clientes){
            if(cliente.getPersonaId()==id){
                return cliente;
            }
        }
        return null;
    }

    public static Producto encontrarProducto(long id){
        for(Producto p: t.getCatalogo()){
            if(p.getProductoID()==id){
                return p;
            }
        }
        return null;
    }
}

