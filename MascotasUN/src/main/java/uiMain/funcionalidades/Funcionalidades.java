package uiMain.funcionalidades;
import java.text.ParseException;
import java.util.Scanner;

public class Funcionalidades {
    public static void gestionFuncionalidades(){
        Scanner input = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("¿Que haremos hoy?");
            System.out.println(" 1. Realizar una venta");
            System.out.println(" 2. Comprar inventario");
            System.out.println(" 3. Cobrar una comision");
            System.out.println(" 4. Mostrar recomendaciones personalizadas con base a mascota");
            System.out.println(" 5. Mostrar estadisticas de ventas");
            System.out.println(" 6. Regresar");
            System.out.print("Indique su eleccion : ");
            opcion = input.nextInt();
            input.nextLine();

            switch (opcion) {
                case 1: RealizarVenta.funcionalidad(); break;
                case 2: CompraInventario.funcionalidad(); break;
                case 3: CobrarComision.funcionalidad(); break;
                case 4: RecomendacionesP.funcionalidad(); break;
                case 5: EstadisticasV.funcionalidad(); break;
                case 6: break;
            }
        } while (opcion != 6);
    }
}

