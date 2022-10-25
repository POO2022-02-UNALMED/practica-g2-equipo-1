package uiMain.funcionalidades;
import java.util.Scanner;

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
        
        // Se le muestra al vendedor las ventas por vendedor, ordenados de mmayor a menor
        case 1:

        	
        // Se le muestra al vendedor los productos más vendidos, ordenados de mayor a menor
        case 2:

        	break;
   
        }
        
    }  while(opcion != 1 & opcion != 2 );
}

}
