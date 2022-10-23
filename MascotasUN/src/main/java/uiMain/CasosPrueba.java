package uiMain;
import java.util.ArrayList;

import gestorAplicacion.gestionPersonas.CuentaBancaria;
import gestorAplicacion.gestionPersonas.Persona;
import gestorAplicacion.gestionPersonas.Proveedor;
import gestorAplicacion.gestionPersonas.Usuario;
import gestorAplicacion.gestionPersonas.Vendedor;
import gestorAplicacion.gestionVentas.Envio;
import gestorAplicacion.gestionVentas.Factura;
import gestorAplicacion.gestionVentas.Mascota;
import gestorAplicacion.gestionVentas.Gato;
import gestorAplicacion.gestionVentas.Perro;
import gestorAplicacion.gestionVentas.Producto;
import gestorAplicacion.gestionVentas.Tienda;


public class CasosPrueba {
	
	public static void crearCasosDePrueba() {
		
	Vendedor vendedor1 = new Vendedor(46785214, "Juan Pablo Arcila", "jpardilla@email.com", 4478514, "Juan Pablo Arcila", "holi12");
	Vendedor vendedor2 = new Vendedor(13205481, "Roberto Barrientos", "rbarriendo@email.com", 4905873, "Roberto Barrientos", "adios13");
	Vendedor vendedor3 = new Vendedor(119258647, "Laura Vanegas", "lavanega@email.com", 3158647, "Laura Vanegas", "lau1245");
	
	Usuario usuario1 = new Usuario(1093186721, "Jose Nore�a", "jnor@email.com", 4422879, new CuentaBancaria(null, 1023947811, 2259023.2, 0224), "Tarjeta", "Cra 170 # 2-103", new ArrayList<Mascota>());
	Perro perro1 = new Perro("Dante", 5, "Grande");
	Gato gato1 = new Gato( "Jackie", 4, "Hogare�o");
	}
}