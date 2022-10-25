/*
Funcionalidad RealizarVenta:
Accede al menu y muestra las opcciones de realizar venta especificadas en los switch del codigo.
al iniciar se pide el id del vendedor, luego el del cliente y entra en el menu
ahi puede realizar una compra,agregar y eliminar productos de la factura y realizar un envio de la compra 
 */
package uiMain.funcionalidades;
import gestorAplicacion.gestionPersonas.*;
import gestorAplicacion.gestionVentas.*;
import uiMain.Principal;

import java.util.Map;
import java.util.Scanner;

public class RealizarVenta {
    public static Scanner input = new Scanner(System.in);
    //static Factura facturaInstance;
    public static void funcionalidad() {

        int opcionM1;
        int opcionM2;
        //Primero se pide al vendedor que proporcione su ID para proceder las acciones de compra
        Vendedor vend;

        while (true) {
            System.out.println("Para iniciar la venta por favor indique el ID a continuacion: ");
            long vendedorID = input.nextLong();
            vend = Vendedor.encontrarPersona(vendedorID);

            if (vend != null) {
                break;
            }
            System.out.println("Ingrese un ID de vendedor valido");
            // Luego se pide al vendedor que solicite al usuario su id para proceder a crear la factura
        }
        System.out.println("Hola " + vend.getNombre() + " puede proceder con la compra\n");
        Usuario cliente;
        while (true) {
            System.out.println("Para crear la factura ingrese el id del cliente");
            long clienteID = input.nextLong();
            cliente = Usuario.encontrarPersona(clienteID);
            if (cliente != null) {
                break;
            }
            System.out.println("Ingrese un ID de cliente valido");
        }
        System.out.println("Se va a crear una factura a nombre de: "+ cliente.getNombre());
        System.out.println("Ingrese la fecha en formado: dd/mm/yyyy ");
        String fecha = input.next();

        Factura facturaInstance = new Factura(cliente, fecha, vend);
        do {

            //se despliega el menu en el cual se muestran las principales opciones de la funcionalidad
            System.out.println("Realizar una compra");
            System.out.println(" 1. Mostrar productos disponibles");
            System.out.println(" 2. Agregar productos a la compra");
            System.out.println(" 3. Regresar");
            System.out.print("Indique su eleccion : ");
            opcionM1 = input.nextInt();
            switch (opcionM1) {
                case 1:
                    // En este caso se imprime el inventario, para que el vendedor pueda saber que ofertar al cliente
                    mostrarInventario();

                    System.out.println("Su accion ha sido finalizada presione 1 para volver al menu");
                    int m=input.nextInt();
                    if(m==1){break;}
                case 2:
                    // Se entra al menu de la compra donde se gestionan los productos y el envio de la factura
                    do {
                        System.out.println("Agregar a la compra");
                        System.out.println(" 1. Agregar un nuevo producto");
                        System.out.println(" 2. Eliminar un producto");
                        System.out.println(" 3. Mostrar resumen de factura");
                        System.out.println(" 4. Finalizar compra");
                        System.out.println(" 5. Configurar envio de compra");
                        System.out.println(" 6. volver al menu compra");
                        System.out.print("Indique su eleccion : ");
                        opcionM2 = input.nextInt();

                        switch (opcionM2) {
                            case 1:
                                //En este caso se agregan los productos
                                // Se verifica que el producto exista y que tenga stock disponible y luego se procede a agregar a la compra
                                while (true) {
                                    System.out.println("Ingrese el ID del producto que desea agregar: ");
                                    Producto aComp;
                                    while (true) {
                                        long idP = input.nextLong();
                                        aComp = Tienda.encontrarProducto(idP);
                                        System.out.println("Ingrese la cantidad del producto que desea agregar");
                                        if (aComp != null) {
                                            break;
                                        }
                                        System.out.println("el ID ingresado no corresponde a ningun producto, ingrese de nuevo ");

                                    }


                                    while (true) {
                                        int cantidad = input.nextInt();
                                        if (aComp.getCantidadComprada() >= cantidad) {
                                            facturaInstance.agregarProducto(aComp, cantidad);
                                            System.out.println("El producto se ha agregado con exito a la compra");
                                            break;
                                        } else {
                                            System.out.println("Lo sentimos no hay stock suficiente para esta venta");
                                            System.out.println("Desea cambiar la cantidad? 1 para si 0 para no");
                                            int sn = input.nextInt();
                                            if (sn == 1) {
                                                continue;
                                            } else {
                                                break;
                                            }

                                        }
                                    }
                                    System.out.println("Desea agregar mas productos? ");
                                    System.out.println("1 para sí, 0 en caso contrario");
                                    int x = input.nextInt();
                                    if (x == 0) {
                                        break;

                                    }

                                }
                                System.out.println("Su accion ha sido finalizada presione 1 para volver al menu");
                                int me=input.nextInt();
                                if(me==1){break;}
                            case 2:
                                //En este caso se accede a eliminar productos, aqui se valida que el producto este en la factura
                                while (true) {
                                    System.out.println("Ingrese el id del producto que desea eliminar");

                                    long idE = input.nextLong();
                                    Producto borrar = Tienda.encontrarProducto(idE);
                                    boolean b= facturaInstance.eliminarProducto(borrar);
                                    if (b) {
                                        System.out.println("El producto fue borrado con exito");

                                    } else {
                                        System.out.println("Lo sentimos el producto no se encuentra en la factura");
                                    }
                                    System.out.println("Desea eliminar mas productos? ");
                                    System.out.println("1 para si, 0 en caso contrario");
                                    int x = input.nextInt();
                                    if (x == 0) {
                                        break;
                                    }
                                }
                                System.out.println("Su accion ha sido finalizada presione 1 para volver al menu");
                                int me1=input.nextInt();
                                if(me1==1){break;}
                            case 3:
                                //En este caso se imprime la informacion más relevante de la factura, para proporcionar al vendedor
                                //un resumen de compra del que se pueda mostrar al cliente
                                System.out.println("Resumen de la factura: ");
                                facturaInstance.calcularTotal();
                                System.out.println(facturaInstance.toString());
                                int incrementa = 1;
                                for (Map.Entry<Producto, Integer> entry : facturaInstance.getProductos().entrySet()) {
                                    Producto k = entry.getKey();
                                    Integer v = entry.getValue();
                                    System.out.println(incrementa + ") " + k.getNombre() + " " + v + " unidades, y tiene un precio unitario de: " + k.getPrecioVenta());
                                    incrementa++;
                                }
                                System.out.println("Su accion ha sido finalizada presione 1 para volver al menu");
                                int me2=input.nextInt();
                                if(me2==1){break;}
                            case 4:
                                //En este caso se realiza la compra para ello se solicita el medio de pago y se procede
                                System.out.println("Está a punto de finalizar la compra, está seguro que desea terminar la venta?");
                                System.out.println("ingrese 1 para finalizar la compra y cero para continuar con la compra");
                                int y = input.nextInt();
                                if (y == 0) {
                                    break;
                                } else {
                                    System.out.println("Resumen de compra");
                                    facturaInstance.calcularTotal();
                                    System.out.println(facturaInstance.toString());
                                    System.out.println("El usuario desea pagar en efectivo?");
                                    System.out.println("ingrese 1 si el pago es en efectivo y 0 si es con tarjeta");
                                    int z = input.nextInt();
                                    switch (z) {
                                        case 1:
                                            facturaInstance.realizarCompra(facturaInstance.getCliente());
                                            System.out.println("el total de la compra fue: " + facturaInstance.getTotal());
                                            break;
                                        case 0:
                                            System.out.println("Solicite al cliente la contraseña de su cuenta bancaria");
                                            short contra = input.nextShort();
                                            if (facturaInstance.getCliente().getCuenta().validarCredenciales(contra) == true) {
                                                facturaInstance.realizarCompra(facturaInstance.getCliente(), contra);
                                                System.out.println("el total de la compra fue: " + facturaInstance.getTotal());
                                            }
                                            break;
                                        default:
                                            System.out.println("Por favor seleccione una respuesta correcta");
                                    }
                                }
                                System.out.println("Su accion ha sido finalizada presione 1 para volver al menu");
                                int me3=input.nextInt();
                                if(me3==1){break;}

                            case 5:
                                // En este caso se ofrece al cliente la opcion de envio en caso de llegar a ser necesario
                                // Y se genera el envio
                                System.out.println("La compra con id " + facturaInstance.getFacturaID() + " fue generada \n");
                                System.out.println("Desea que se realice un envio de esta?\n");
                                System.out.println("Digite 1 si el cliente lo requiere o 0 si no");
                                int g = input.nextInt();
                                switch (g) {
                                    case 1:
                                        System.out.println("Ingrese el destino de su compra: ");
                                        String destino = input.next();
                                        Envio envio = new Envio(facturaInstance.getFacturaID(), destino, 0);
                                        envio.setEstadoEnvio("ENVIADO");
                                        System.out.println("Su envio fue creado exitosamente");
                                        break;
                                    case 0:
                                        System.out.println("");
                                        break;
                                }
                                System.out.println("Gracias por preferirnos");
                                System.out.println("Su accion ha sido finalizada presione 1 para volver al menu");
                                int me4=input.nextInt();
                                if(me4==1) {break;}

                            case 6:
                                break;
                            default:
                                System.out.println("Por favor seleccione una respuesta correcta");
                        }
                    } while (opcionM2 != 6);
                case 3:
                    ;
                default:
                    System.out.println("Por favor seleccione una respuesta correcta");
            }

        } while (opcionM1 != 3);

    }
    //metodo que imprime los productos tomados del hashmap  inventario
static void mostrarInventario(){
    for (Map.Entry<Producto, Integer> entry :Tienda.getInventario().entrySet()) {
        Producto k = entry.getKey();
        Integer v = entry.getValue();
        System.out.println("~ "+k.getNombre()+ "tiene "+ v+ " productos disponibles y tiene un costo de "+k.getPrecioVenta()+ ", ID: "+k.getProductoID());
}
    }


}


