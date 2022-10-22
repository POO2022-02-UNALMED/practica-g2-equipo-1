package uiMain;
import java.util.Scanner;

public class Principal {
	
	public static void showMenu(){
	System.out.println("𝗕𝗶𝗲𝗻𝘃𝗲𝗻𝗶𝗱𝗼 𝗮...\n");

	System.out.println("███╗░░░███╗░█████╗░░██████╗░█████╗░░█████╗░████████╗░█████╗░░██████╗░░░░░░██╗░░░██╗███╗░░██╗\n"+
"████╗░████║██╔══██╗██╔════╝██╔══██╗██╔══██╗╚══██╔══╝██╔══██╗██╔════╝░░░░░░██║░░░██║████╗░██║\n"+
"██╔████╔██║███████║╚█████╗░██║░░╚═╝██║░░██║░░░██║░░░███████║╚█████╗░█████╗██║░░░██║██╔██╗██║\n"+
"██║╚██╔╝██║██╔══██║░╚═══██╗██║░░██╗██║░░██║░░░██║░░░██╔══██║░╚═══██╗╚════╝██║░░░██║██║╚████║\n"+
"██║░╚═╝░██║██║░░██║██████╔╝╚█████╔╝╚█████╔╝░░░██║░░░██║░░██║██████╔╝░░░░░░╚██████╔╝██║░╚███║\n"+
"╚═╝░░░░░╚═╝╚═╝░░╚═╝╚═════╝░░╚════╝░░╚════╝░░░░╚═╝░░░╚═╝░░╚═╝╚═════╝░░░░░░░░╚═════╝░╚═╝░░╚══╝\n");
    
	System.out.println("				𝕯𝖔𝖓𝖉𝖊 𝖊𝖓𝖈𝖔𝖓𝖙𝖗𝖆𝖗𝖆́𝖘 𝖙𝖔𝖉𝖔 𝖕𝖆𝖗𝖆 𝖙𝖚𝖘 𝖕𝖊𝖑𝖚𝖉𝖔𝖘\n\n");
	System.out.println("¿Qué desea hacer?\n");
    
    int response = 0;
    do {
        System.out.println("1. Iniciar sesión");
        System.out.println("0. Salir");

        Scanner sc = new Scanner(System.in);
        response = Integer.valueOf(sc.nextLine());
        
        switch(response){
        case 1:
            inicioSesion();
            break;
        case 0:
            System.out.println("¡Vuelva pronto!");
            break;
        default:
            System.out.println("Por favor seleccione una respuesta correcta");
		   }
	}while (response != 0);
	}
	
	static void inicioSesion(){
		Scanner sc = new Scanner(System.in);
        String Usuario;
        System.out.println("Ingrese el usuario:" );
        Usuario = sc.nextLine();
        String Contrasena;
        System.out.println("Ingresa la contraseña: ");
        Contrasena=sc.nextLine();

        switch(Usuario) {
        case "Juan Pablo Arcila":
            if("holi12".equals(Contrasena)) {
                System.out.println("Bienvenido, Juan Pablo Arcila");
                break;
            }
            else {
                System.err.println("Acceso denegado");
                System.exit(0);
            }
        case "Roberto Barrientos":
            if("adios13".equals(Contrasena)) {
                System.out.println("Bienvenido, Roberto Barrientos");
                break;
            }
            else {
                System.err.println("Acceso denegado");
                System.exit(0);
            }
        case "Laura Vanegas":
            if("lau1245".equals(Contrasena)) {
                System.out.println("Bienvenido, Laura Vanegas");
                break;
            }
            else {
                System.err.println("Acceso denegado");
                System.exit(0);
            }
        default: {
            System.err.println("No se reconoce el usuario");
            System.exit(0);
        }
        }
    }
}
