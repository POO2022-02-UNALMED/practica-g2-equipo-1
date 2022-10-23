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
	
	Vendedor vendedor1 = new Vendedor(46785214, "Juan Pablo Arcila", "jpardilla@email.com", 4478514, new CuentaBancaria(null, 154849652, 5781010.2, 9514), "jarcila", "ardillaspordoquier");
	Vendedor vendedor2 = new Vendedor(13205481, "Roberto Barrientos", "rbarriendo@email.com", 4905873, new CuentaBancaria(null, 461528521, 1452879.78, 1234), "rbarrientos", "barriendolacasa");
	Vendedor vendedor3 = new Vendedor(119258647, "Laura Vanegas", "lavanega@email.com", 3158647, new CuentaBancaria(null, 7548215, 542158, 1358), "lvanegas", "amoamiperro");
	
	Usuario usuario1 = new Usuario(1093186721, "Jose Noreña", "jnor@email.com", 4422879, new CuentaBancaria(null, 1023947811, 2259023.2, 0224), "Tarjeta", "Cra 170 # 2-103", new ArrayList<Mascota>());
	Perro perro1 = new Perro(100, "Dante", 0.5, "Grande");
}
