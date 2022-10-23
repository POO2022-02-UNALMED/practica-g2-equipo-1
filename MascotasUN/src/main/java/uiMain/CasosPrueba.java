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
	
	ArrayList<Vendedor> vendedores = new ArrayList<>();
	vendedores.add(new Vendedor(46785214, "Juan Pablo Arcila", "jpardilla@email.com", 4478514, new CuentaBancaria(null, 154849652, 5781010.2, 9514), "Juan Pablo Arcila", "holi12"));
	vendedores.add(new Vendedor(13205481, "Roberto Barrientos", "rbarriendo@email.com", 4905873, new CuentaBancaria(null, 461528521, 1452879.78, 1234), "Roberto Barrientos", "adios13"));
	vendedores.add(new Vendedor(119258647, "Laura Vanegas", "lavanega@email.com", 3158647, new CuentaBancaria(null, 7548215, 542158, 1358), "Laura Vanegas", "lau1245"));
	
	Usuario usuario1 = new Usuario(1093186721, "Jose Nore�a", "jnor@email.com", 4422879, new CuentaBancaria(null, 1023947811, 2259023.2, 0224), "Tarjeta", "Cra 170 # 2-103", new ArrayList<Mascota>());
	Perro perro1 = new Perro(100, "Dante", 0.5, "Grande");
	Gato gato1 = new Gato(123, "Jackie", 4, "Hogare�o");
}
