/*Esta clase se encarga de permitir la vista de las instancias creadas en la clase Vendedor segun un id o mediante
la obtencion de todas los objetos de esta.
 */

package uiMain.gestion.gestionVendedores;

import gestorAplicacion.gestionPersonas.Vendedor;
import gestorAplicacion.gestionVentas.Producto;
import gestorAplicacion.gestionVentas.Tienda;

import java.util.ArrayList;
import java.util.Scanner;

public class VerVendedor {
    private static int opcion;
    private static int id;
    public static void verVendedor(){
        Scanner input =new Scanner(System.in);
        do {
            System.out.println("Estas a punto de ver algunos datos de tus companeros de laburo");
            System.out.println("1. Para ver un companero en especifico");
            System.out.println("2. Para ver la lista completa de tus companeros");
            System.out.println("3. Volver");
            opcion=input.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Cuantos companeros desea ver?");
                    int cantidad=input.nextInt();
                    //Hace un for segun la cantidad de productos que desee ver la vendedores
                    for(int i=1;i<=cantidad;i++){
                        System.out.println("Ingrese el codigo del companero que quiere ver: ");
                        id=input.nextInt();
                        //retorna el vendedor buscado por su id
                        Vendedor vendedor= Vendedor.encontrarPersona(id);
                        //imprime el vendedor retornado con parametros especificos
                        System.out.println(vendedor.toString());
                        }
                    break;
                case 2:
                    System.out.println("Esta es la lista completa de tus companeros");
                    //imprime todas las instancias de vendedor
                    System.out.println(Vendedor.getVendedores().toString());
                    break;
                case 3:
                    break;
            }
        } while(opcion != 3);
    }
}

