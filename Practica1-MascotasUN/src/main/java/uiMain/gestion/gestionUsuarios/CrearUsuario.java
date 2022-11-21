/*Esta clase se encarga de registrar un nuevo objeto de la clase usuario, incluyendo la cuenta bancaria que se
 asocia al mismo y las mascotas que posee, por ultimo se muestra para comprobar que se agrego exitosamente */

package uiMain.gestion.gestionUsuarios;

import gestorAplicacion.gestionPersonas.CuentaBancaria;
import gestorAplicacion.gestionPersonas.Gato;
import gestorAplicacion.gestionPersonas.Mascota;
import gestorAplicacion.gestionPersonas.Perro;
import gestorAplicacion.gestionPersonas.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class CrearUsuario {
    public static Usuario crearUsuario() {
        Scanner input = new Scanner(System.in);
        System.out.println("Estas a punto de ingresar un nuevo usuario al sistema");
        System.out.println("Si el usuario se desea registrar con cuenta bancaria ingrese 1\n en caso contrario ingrese 0");
        int cu = input.nextInt();
        switch (cu) {
            case 1:
                System.out.println("Ingrese el ID del cliente: ");
                int id = input.nextInt();
                System.out.println("Ingrese el nombre del cliente: ");
                String nombre = input.next();
                System.out.println("Ingrese el email del cliente: ");
                String email = input.next();
                System.out.println("Ingrese el telefono del cliente: ");
                int telefono = input.nextInt();
                System.out.println("Ingrese el numero de la cuenta bancaria del cliente: ");
                long nro = input.nextLong();
                System.out.println("Ingrese el saldo de la cuenta bancaria del cliente: ");
                float saldo = input.nextFloat();
                System.out.println("Ingrese el pin de la cuenta bancaria cliente: ");
                int pin = input.nextInt();
                System.out.println("Ingrese la direccion del cliente");
                String dir = input.next();
                System.out.println("Ingrese el numero de mascotas del cliente :");
                int mas = input.nextInt();
                /*Se hace una lista que agrega a las mascotas haciendo uso del for dependiendo de la cantidad de mascotas
                que tiene el cliente
                */
                ArrayList<Mascota> pets = new ArrayList<>();
                for (int i = 1; i <= mas; i++) {
                    System.out.println("1 en caso de perro, 0 en caso de gato");
                    int n = input.nextInt();
                    System.out.println("Ingrese el Id de la mascota");
                    long mId = input.nextLong();
                    System.out.println("Ingrese el nombre de la mascota: ");
                    String na = input.next();
                    System.out.println("Ingrese la edad en años de la mascota: ");
                    int edad = input.nextInt();
                    System.out.println("Ingrese la raza de la mascota(para gato ingrese n): ");
                    String raza = input.next();
                    /*Se hace uso del switch para determinar si la instancia es de la clase perro o gato */
                    switch (n) {
                        case 1:
                            //Se crea instancia de la clase perro
                            Perro p = new Perro(mId, na, edad, raza);
                            pets.add(p);
                            break;
                        case 0:
                            //Se crea instancia de la clase gato
                            Gato g = new Gato(mId, na, edad);
                            pets.add(g);
                            break;
                    }
                }
                /*Se crea una nueva instancia de la clase usuario con su respectiva lista de mascotas y cuenta bancaria
                que a su vez crean objetos de otras clases (CuentaBancaria y Perro o Gato)
                */
                Usuario user1 = new Usuario(id, nombre, email, telefono, new CuentaBancaria(nro, saldo, pin), dir, pets);
                System.out.println("Ingrese la fecha en formato: dd/mm/yyyy ");
                System.out.println("El usuario se agrego de manera exitosa");
                /*Imprime el usuario creado con atributos predeterminados en el toString()*/
                user1.toString();
                System.out.println(user1);
                return user1;

            case 0: // Este case realiza lo mismo pero sin instanciar la clase CuentaBancaria
                System.out.println("Ingrese el ID del cliente: ");
                int id1 = input.nextInt();
                System.out.println("Ingrese el nombre del cliente: ");
                String nombre1 = input.next();
                System.out.println("Ingrese el email del cliente: ");
                String email1 = input.next();
                System.out.println("Ingrese el telefono del cliente: ");
                int telefono1 = input.nextInt();
                System.out.println("Ingrese la direccion del cliente");
                String dir1 = input.next();
                System.out.println("Ingrese el numero de mascotas del cliente :");
                int mas1 = input.nextInt();
                ArrayList<Mascota> pets1 = new ArrayList<>();
                for (int i = 1; i <= mas1; i++) {
                    System.out.println("1 en caso de perro, 0 en caso de gato");
                    int n = input.nextInt();
                    System.out.println("Ingrese el ID de la mascota: ");
                    long mId = input.nextLong();
                    System.out.println("Ingrese el nombre de la mascota: ");
                    String na = input.next();
                    System.out.println("Ingrese la edad en años de la mascota: ");
                    int edad = input.nextInt();
                    System.out.println("Ingrese la raza de la mascota (si es gato no aplica (ingrese n)): ");
                    String raza = input.next();

                    switch (n) {
                        case 1:
                            Perro p = new Perro(mId, na, edad, raza);
                            pets1.add(p);
                            break;
                        case 0:
                            Gato g = new Gato(mId, na, edad);
                            pets1.add(g);
                            break;
                    }
                }
                Usuario user2 = new Usuario(id1, nombre1, email1, telefono1, dir1, pets1);
                System.out.println("Ingrese la fecha en formado: dd/mm/yyyy ");
                System.out.println("El usuario se agrego de manera exitosa");
                user2.toString();
                System.out.println(user2);
                return user2;
        }
    return null;
    }
}

