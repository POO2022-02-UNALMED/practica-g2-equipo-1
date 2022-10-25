package uiMain.funcionalidades;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.gestionPersonas.Vendedor;
import gestorAplicacion.gestionVentas.Factura;
import gestorAplicacion.gestionVentas.Tienda;
import uiMain.Principal;


public class CobrarComision {
    public static void funcionalidad(){
	// Se le pregunta al vendedor si desea cobrar su comisión por las ventas realizadas
	System.out.println("¿Desea cobrar su comisión por las ventas realizadas?\n");
	Scanner input1 = new Scanner(System.in);
    int opcion;
    do {
    	System.out.println("	1. Si");
        System.out.println("	2. No, Salir \n");
        System.out.print("Indique su eleccion : ");
        opcion = input1.nextInt();
        switch (opcion) {

        // Se calcula y se cobra la comision
        case 1:
        	long cedula;
    		Scanner sc_cedula = new Scanner(System.in);
            System.out.println("Ingrese su cedula:" );
            cedula = sc_cedula.nextLong();
            Vendedor vendedorcito =Vendedor.encontrarPersona(cedula);
            if (vendedorcito==null) {
            	System.out.println("Ingresó mal su cedula, vuelva a intentarlo");
            	funcionalidad();
            }
            ArrayList<Factura> fact= vendedorcito.getVentas(); //lista de facturas del vendedor
            double a=calcularTotalVentas(fact);
            double b= a*Vendedor.getComision();
            System.out.println("Tus ventas totales fueron: "+a);
            System.out.println("Por lo que tus comisiones son: "+b);
            Tienda.getCuenta().tranferir(vendedorcito.getCuenta(), (float) b , Tienda.getCuenta().getPin());
            System.out.println("Tu dinero ha sido transferido exitosamente ");
        // Se sale de la funcionalidad
        case 2:
        	Principal.salirDelSistema();
        	break;
        }

    }  while(opcion != 1 & opcion != 2 );


}
    //método para calcular el total de las ventas
    public static double calcularTotalVentas(ArrayList<Factura> facturas) {
    	double a=0;
		for(Factura i : facturas) {  // lista de diccionarios de facturas
			a+=i.calcularTotal();
			}
		return a;
		}

}
