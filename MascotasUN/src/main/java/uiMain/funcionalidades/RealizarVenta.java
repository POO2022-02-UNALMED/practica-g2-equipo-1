package uiMain.funcionalidades;
import gestorAplicacion.gestionPersonas.*;
import gestorAplicacion.gestionVentas.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import uiMain.gestion.gestionProductos.VerProducto;
import uiMain.gestion.gestionUsuarios.AgregarUsuario;
import uiMain.gestion.gestionUsuarios.GestionUsuarios;

public class RealizarVenta {
    public static Scanner input = new Scanner(System.in);
    static Factura facturaInstance = new Factura();
    public static void funcionalidad() {

        int opcionM1;
        int opcionM2;
        do {
            //Primero se pide al vendedor que proporcione su ID para proceder las acciones de compra
            System.out.println("Para iniciar ingrese ID del vendendor a continuacion: ");
            long vendedorID= input.nextLong();
            Vendedor vend= encontrarVendedor(vendedorID);
            System.out.println("Hola "+ vend.getNombre() +" puede proceder con la compra\n\n");
            //Muestra las opciones del menu
            System.out.println("Realizar una compra");
            System.out.println(" 1. Mostrar productos disponibles");
            System.out.println(" 2. Agregar productos a la compra");
            System.out.println(" 3. Regresar");
            System.out.print("Indique su eleccion : ");
            opcionM1 = input.nextInt();
            switch (opcionM1) {
                case 1:
                    obtenerProductos(Tienda.getInventario());
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
                        opcionM2 = input.nextInt();

                        switch (opcionM2){
                            case 1:

                                System.out.println("Ingrese 1 para un usuario registrado y 0 para agregar uno nuevo");
                                int us= input.nextInt();
                                switch (us){
                                    case 1:
                                        //hacer condicional que busque el cliente que ya esté registrado
                                        System.out.println("Ingrese el ID del cliente");
                                        long clienteID= input.nextLong();
                                        Usuario cliente= encontrarPersona(clienteID);
                                        System.out.println("Ingrese la fecha en formado: dd/mm/yyyy ");
                                        String fecha=input.next();
                                        System.out.println("Ingrese el metodo de pago: \n 1 en caso de efectivo 0 en caso de tarjeta");
                                        facturaInstance= new Factura(cliente, fecha, vend);
                                        break;
                                    case 0:
                                        Usuario clienteN= AgregarUsuario.agregarUsuario();
                                        System.out.println("Ingrese la fecha en formado: dd/mm/yyyy ");
                                        String fecha1=input.next();
                                        System.out.println("Ingrese el metodo de pago: \n 1 en caso de efectivo 0 en caso de tarjeta");
                                        facturaInstance= new Factura(clienteN, fecha1, vend);

                                }
                                while (true){
                                    System.out.println("Ingrese el ID del producto que desea agregar: ");
                                    long idP=input.nextLong();
                                    Producto aComp= Tienda.encontrarProducto(idP);
                                    System.out.println("Ingrese la cantidad del producto que desea agregar");
                                    int cantidad= input.nextInt();
                                    if (Tienda.getInventario().get(aComp)>=cantidad){
                                        facturaInstance.agregarProducto(aComp, cantidad);
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
                                    Producto borrar= Tienda.encontrarProducto(idE);
                                    if(Tienda.getInventario().containsKey(borrar)==true){
                                        facturaInstance.eliminarProducto(borrar);

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
                                System.out.println(facturaInstance.toString());
                                int incrementa=1;
                                for (Map.Entry<Producto, Integer> entry : facturaInstance.getProductos().entrySet()) {
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
                                    System.out.println(facturaInstance.toString());
                                    System.out.println("El usuario desea pagar en efectivo?");
                                    System.out.println("ingrese 1 si el pago es en efectivo y 0 si es con tarjeta");
                                    int z=input.nextInt();
                                    switch (z){
                                        case 1:
                                            float fina= facturaInstance.realizarCompra(facturaInstance.getCliente());
                                            System.out.println("el total de la compra fue: "+ fina);
                                            break;
                                        case 0:
                                            System.out.println("Solicite al cliente la contraseña de su cuenta bancaria");
                                            short contra= input.nextShort();
                                            if(facturaInstance.getCliente().getCuenta().validarCredenciales(contra)==true){
                                                float fina2= facturaInstance.realizarCompra(facturaInstance.getCliente(),contra);
                                                System.out.println("el total de la compra fue: "+ fina2);
                                            }
                                            break;
                                    }
                                }
                                break;

                            case 5:
                                System.out.println("La compra con id "+facturaInstance.getFacturaID()+" fue generada \n");
                                System.out.println("Desea que se realice un envio de esta?\n");
                                System.out.println("Digite 1 si el cliente lo requiere o 0 si no");
                                int g=input.nextInt();
                                switch (g){
                                    case 1:
                                        System.out.println("Ingrese el destino de su compra: ");
                                        String destino= input.next();
                                        Envio envio = new Envio(facturaInstance.getFacturaID(),destino,0);
                                        envio.setEstadoEnvio("ENVIADO");
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
                    } while (opcionM2 != 6);
                case 3: break;
            }

        }while (opcionM1 != 3);

    }

    public static void obtenerProductos(HashMap<Producto, Integer> inventario) {
        for (Map.Entry<Producto, Integer> fact : inventario.entrySet()) {
            Producto k = fact.getKey();
            Integer v = fact.getValue();
            System.out.println("~ " + k.toString() + "\n" + "Tiene " + v + " unidades disponibles\n");

        }


    }
    public static Usuario encontrarPersona(long id){
        for(Usuario cliente: Usuario.getUsuarios()){
            if(cliente.getPersonaId()==id){
                return cliente;
            }
        }
        return null;
    }
    public static Vendedor encontrarVendedor(long id){
        for(Vendedor v:Vendedor.getVendedores()){
            if(v.getPersonaId()==id){
                return v;
            }
        }
        return null;
    }
}

