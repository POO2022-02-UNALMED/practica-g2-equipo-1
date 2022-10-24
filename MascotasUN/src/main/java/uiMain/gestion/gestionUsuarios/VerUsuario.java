package uiMain.gestion.gestionUsuarios;

import gestorAplicacion.gestionPersonas.Usuario;
import gestorAplicacion.gestionVentas.Producto;
import gestorAplicacion.gestionVentas.Tienda;

import java.util.ArrayList;
import java.util.Scanner;

public class VerUsuario {
    private static int opcion;
    private static int id;
    public static void verUsuario(){
        Scanner input =new Scanner(System.in);
        do {
            System.out.println("Estas a punto de ver tus usuarios");
            System.out.println("1. Para ver un usuario en especifico");
            System.out.println("2. Para ver la lista completa de tus usuarios");
            System.out.println("3. Volver");
            opcion=Integer.parseInt(input.nextLine());
            switch (opcion){
                case 1:
                    System.out.println("Cuantos usuarios desea ver");
                    int cantidad=input.nextInt();
                    for(int i=1;i<=cantidad;i++){
                        System.out.println("Ingrese el codigo del usuario que quiere ver: ");
                        id=input.nextInt();
                        Usuario usuario= Usuario.encontrarPersona(id);
                        System.out.println(usuario.toString());
                        }
                    break;
                case 2:
                    System.out.println("Esta es la lista completa de tus usuarios");
                    imprimirUsuarios(Usuario.getUsuarios());
                    break;
                case 3:
                    break;
            }
        } while(opcion != 3);
    }
    public static void imprimirUsuarios(ArrayList<Usuario> usuarios) {
        for(Usuario i : usuarios) {
            System.out.println("*******************************");
            System.out.println("ID: "+ i.getPersonaId() +"\n"+ ". Nombre: " + i.getNombre() +"\n"+ ". Email: " + i.getEmail() +"\n"+". Telefono: " + i.getTelefono() +"\n"+". Compras: " + i.getCompras()+"\n"+". Mascotas: " + i.getMascotas()+"\n");
        }
    }
}

