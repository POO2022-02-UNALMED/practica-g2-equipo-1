package uiMain;

import java.util.Scanner;

import baseDatos.Deserializador;
import baseDatos.Serializador;
import gestorAplicacion.gestionPersonas.Proveedor;
import gestorAplicacion.gestionPersonas.Vendedor;
import gestorAplicacion.gestionVentas.Producto;
import gestorAplicacion.gestionVentas.Tienda;
import uiMain.funcionalidades.EstadisticasV;
import uiMain.gestion.GestionClases;
import uiMain.gestion.gestionProductos.EditarProducto;
import uiMain.gestion.gestionProductos.GestionProductos;
import uiMain.gestion.gestionProveedores.GestionProveedor;

public class Principal {
	
	public static void showMenu(){

        // Inicio del programa
	System.out.println("𝗕𝗶𝗲𝗻𝘃𝗲𝗻𝗶𝗱𝗼 𝗮...\n");

	System.out.println( "███╗░░░███╗░█████╗░░██████╗░█████╗░░█████╗░████████╗░█████╗░░██████╗░░░░░░██╗░░░██╗███╗░░██╗\n"+
                        "████╗░████║██╔══██╗██╔════╝██╔══██╗██╔══██╗╚══██╔══╝██╔══██╗██╔════╝░░░░░░██║░░░██║████╗░██║\n"+
                        "██╔████╔██║███████║╚█████╗░██║░░╚═╝██║░░██║░░░██║░░░███████║╚█████╗░█████╗██║░░░██║██╔██╗██║\n"+
                        "██║╚██╔╝██║██╔══██║░╚═══██╗██║░░██╗██║░░██║░░░██║░░░██╔══██║░╚═══██╗╚════╝██║░░░██║██║╚████║\n"+
                        "██║░╚═╝░██║██║░░██║██████╔╝╚█████╔╝╚█████╔╝░░░██║░░░██║░░██║██████╔╝░░░░░░╚██████╔╝██║░╚███║\n"+
                        "╚═╝░░░░░╚═╝╚═╝░░╚═╝╚═════╝░░╚════╝░░╚════╝░░░░╚═╝░░░╚═╝░░╚═╝╚═════╝░░░░░░░░╚═════╝░╚═╝░░╚══╝\n");
    
	System.out.println("				𝕯𝖔𝖓𝖉𝖊 𝖊𝖓𝖈𝖔𝖓𝖙𝖗𝖆𝖗𝖆́𝖘 𝖙𝖔𝖉𝖔 𝖕𝖆𝖗𝖆 𝖙𝖚𝖘 𝖕𝖊𝖑𝖚𝖉𝖔𝖘\n\n");
	System.out.println("Que desea hacer?\n");
    
	/* El vendedor ingresa al programa y selecciona si desea iniciar sesión o salir
	 del programa */
	
    int response = 0; // Se inicializa la variable response
    do {
        System.out.println("1. Iniciar sesion");
        System.out.println("0. Salir");

        Scanner sc = new Scanner(System.in);
        response = Integer.valueOf(sc.nextLine());
        
        switch(response){
        case 1:
            inicioSesion();
            break;
        case 0:
            System.out.println("Vuelva pronto!");
            System.exit(0);
            break;
        default:
            System.out.println("Por favor seleccione una respuesta correcta");
		   }
    	} while(response != 0);
	}
	
	/* Menú que muestra el inicio de sesión*/
	
	static void inicioSesion(){
		String Usuario;
		String Contrasena;
		Scanner sc_usuario = new Scanner(System.in);
        System.out.println("Ingrese el usuario:" );
        Usuario = sc_usuario.nextLine();
        System.out.println("Ingresa la contrasena: ");
        Scanner sc_contra = new Scanner(System.in);
        Contrasena=sc_contra.nextLine();
        
        if(Vendedor.validarCredenciales(Usuario,Contrasena)==true) {
            System.out.println("Bienvenido, "+ Usuario);
            menuPrincipal();
        }
        else {
            System.err.println("Acceso denegado");
            inicioSesion();
        }
	}
	
	/* Acceso al menú de uiMain.funcionalidades */

	public static void menuPrincipal() {
		System.out.println("Que quieres hacer?");

		Scanner input = new Scanner(System.in);
        int opcion;
        do {
            System.out.println(" 1. Gestionar la aplicacion");
            System.out.println(" 2. Navegar por las funcionalidades");
            System.out.println(" 3. Salir");
            System.out.print("Indique su eleccion : ");
            opcion = input.nextInt();

            switch (opcion) {
                case 1: uiMain.gestion.GestionClases.gestionClases(); break;
                case 2: uiMain.funcionalidades.Funcionalidades.gestionFuncionalidades(); break;
                case 3: salirDelSistema(); break;
            }
        } while (opcion != 3);
		System.exit(0);
	}
	
	public static void salirDelSistema() {
        Serializador.serializar();
		System.out.println("Vuelva pronto!");
		System.exit(0);
    }
	
	// Entrada al programa
	public static void main(String[] args) {
		Deserializador.deserializar();
		CasosPrueba.crearCasosDePrueba();
    	Principal.showMenu();
    }
}