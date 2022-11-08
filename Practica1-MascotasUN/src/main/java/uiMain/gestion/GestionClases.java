/*Esta clase se encarga de gestionar las clases individuales de gestion de productos, proveedores, usuarios y vendedores*/

package uiMain.gestion;

import uiMain.gestion.gestionProductos.GestionProductos;
import uiMain.gestion.gestionProveedores.GestionProveedor;
import uiMain.gestion.gestionUsuarios.GestionUsuarios;
import uiMain.gestion.gestionVendedores.GestionVendedores;


import java.util.Scanner;

public class GestionClases {
    private static int opcion;
    public static void gestionClases() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Bienvenido, en este lugar puedes gestionar todo lo relacionado con tus companeros, usuarios, proveedores y productos de tu tienda");
            System.out.println("Que deseas hacer?");
            System.out.println(" 1. Gestionar Productos");
            System.out.println(" 2. Gestionar Proveedores");
            System.out.println(" 3. Gestionar Usuarios");
            System.out.println(" 4. Gestionar Companeros");
            System.out.println(" 5. Regresar");
            opcion = input.nextInt();

            switch (opcion) {
                case 1: ; GestionProductos.gestionarProductos(); break;
                case 2: ; GestionProveedor.gestionProveedores(); break;
                case 3: ; GestionUsuarios.gestionarUsuarios(); break;
                case 4: ; GestionVendedores.gestionarVendedores(); break;
                case 5: break;
            }
        } while (opcion != 5);
    }
}
