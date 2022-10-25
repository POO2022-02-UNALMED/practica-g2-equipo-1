package uiMain.funcionalidades;

import java.util.ArrayList;
import java.util.Scanner;

import baseDatos.Serializador;
import gestorAplicacion.gestionPersonas.CuentaBancaria;
import gestorAplicacion.gestionPersonas.Persona;
import gestorAplicacion.gestionPersonas.Proveedor;
import gestorAplicacion.gestionPersonas.Usuario;
import gestorAplicacion.gestionPersonas.Vendedor;
import gestorAplicacion.gestionVentas.Envio;
import gestorAplicacion.gestionVentas.Factura;
import gestorAplicacion.gestionPersonas.Mascota;
import gestorAplicacion.gestionPersonas.Gato;
import gestorAplicacion.gestionPersonas.Perro;
import gestorAplicacion.gestionVentas.Producto;
import gestorAplicacion.gestionVentas.Tienda;
import uiMain.funcionalidades.CompraInventario;
import uiMain.funcionalidades.EstadisticasV;
import uiMain.funcionalidades.RealizarVenta;
import uiMain.gestion.gestionProductos.AgregarProducto;
import uiMain.gestion.gestionProductos.EditarProducto;
import uiMain.gestion.gestionProductos.EliminarProducto;
import uiMain.gestion.gestionProductos.GestionProductos;
import uiMain.gestion.gestionProveedores.EliminarProveedor;
import uiMain.gestion.gestionProveedores.GestionProveedor;
import uiMain.gestion.gestionProveedores.VerProveedor;
import uiMain.gestion.gestionUsuarios.AgregarUsuario;

public class RecomendacionesP {
	public static void funcionalidad() {
		
		//Se pregunta al vendedor que usuario requiere la recomendación(El ID, o el nombre)
		System.out.println("Ingrese el ID de usuario");
		Scanner input1 = new Scanner(System.in);
		long opcion;
		System.out.print("Indique su eleccion : ");
        opcion = input1.nextInt();
        Usuario usuario = null;
		//Si este cliente existe, extraer la información, en caso contrario crear al cliente, con sus respectivas mascotas.
		if (Tienda.getUsuarios().containsKey(opcion)) {
			usuario = Tienda.getUsuarios().get(opcion);
			System.out.println("Para cual de sus mascotas desea la recomendacion");
			for (int i=0; i <usuario.getMascotas().size(); i++) {
				Mascota mascota = usuario.getMascotas().get(i);
				if (mascota.getClass() == Perro.class) {
					System.out.println(((Perro)mascota).getMascotaID() + " " + ((Perro)mascota).getNombre());
				}
				if (mascota.getClass() == Gato.class) {
					System.out.println(((Gato)mascota).getMascotaID() + " " + ((Gato)mascota).getNombre());
				}
			}		
		}
		Mascota mascotasel = RecomendacionesP.seleccionarMascota(usuario);
		
		
		
		//Crear nuevo cliente
		//Metodo para crear cliente y luego crear y añadir a sus mascotas
		
			
		//Se genera la lista de recomendaciones para esa mascota tipoAlimento()
		ArrayList<Producto> productosrecomendados = new ArrayList<Producto>();
		if (mascotasel.getClass() == Gato.class) {
			ArrayList<Producto> lista = RecomendacionesP.recomendacionGato(mascotasel);
			productosrecomendados = lista;
		}
		if (mascotasel.getClass() == Perro.class) {
			ArrayList<Producto> lista = RecomendacionesP.recomendacionPerro(mascotasel);
			productosrecomendados = lista;
		}
		
		//Se imprime el ToString de cada producto que aparezca en la lista
		for (int i = 1; i < productosrecomendados.size() + 1; i++) {
			System.out.println("Producto " + i + "\n" + productosrecomendados.get(i-1));
		}
		//(Podría preguntarse uno por uno de la lista si es el producto que desea o si no y continuar al siguiente en la lista.)
	
	}
	//Se pide seleccionar la mascota para la que desea la recomendación en caso de no existir crear la nueva mascota.
	public static Mascota seleccionarMascota(Usuario usuario) {
		System.out.println("Ingrese el ID de su mascota"); 
		Scanner input = new Scanner(System.in);
		long opcion;
		System.out.print("ID : "); //Se ingresa el ID de la mascota por consola
        opcion = input.nextInt();
        
        Mascota mascota = null; // Se declara una variable tipo mascota para almacenar la mascota seleccionada
        
        //Se recorre la lista de mascotas del usuario.
        for (int i=0; i <usuario.getMascotas().size(); i++) {
        	Mascota m = usuario.getMascotas().get(i);//Se extrae la mascota de la lista
        	//Se hace el proceso de buscar el ID de la mascota dentro de la lista de mascotas del usuario si es un Perro para seleccionarlo.
        	if (m.getClass() == Perro.class) {
        		if (((Perro)m).getMascotaID() == opcion) {
        			mascota = m;
        		}
        	}
        	//Se hace el proceso de buscar el ID de la mascota dentro de la lista de mascotas del usuario si es un Gato para seleccionarlo.
        	if (m.getClass() == Gato.class) {
        		if (((Gato)m).getMascotaID() == opcion) {
        			mascota = m;
        		}
        	}
        }
        return mascota;
	}
	
	public static ArrayList<Producto> recomendacionPerro(Mascota mascotasel) {
			Perro mascota = (Perro) mascotasel;
			System.out.println("La mascota seleccionada es: " + mascota.getNombre());
			System.out.println(mascota.calcularEdad());
			System.out.println(mascota.getRaza());
			ArrayList<Producto> lista = mascota.tipoAlimento();
			return lista;
	}
	
	public static ArrayList<Producto> recomendacionGato(Mascota mascotasel) {
		Gato mascota = (Gato) mascotasel;
		System.out.println("La mascota seleccionada es: " + mascota.getNombre());
		ArrayList<Producto> lista = mascota.tipoAlimento();
		return lista;
	}
}
