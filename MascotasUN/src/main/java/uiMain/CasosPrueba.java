package uiMain;
import java.util.ArrayList;
import java.util.Date;

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
		
	Vendedor vendedor1 = new Vendedor(46785214, "Juan Pablo Arcila", "jpardilla@email.com", 4478514, new ArrayList<Factura>(), "Juan Pablo Arcila", "holi12");
	Vendedor vendedor2 = new Vendedor(13205481, "Roberto Barrientos", "rbarriendo@email.com", 4905873, new ArrayList<Factura>(), "Roberto Barrientos", "adios13");
	Vendedor vendedor3 = new Vendedor(119258647, "Laura Vanegas", "lavanega@email.com", 3158647, new ArrayList<Factura>(), "Laura Vanegas", "lau1245");
	
		// Cuentas de clientes
	CuentaBancaria cuenta1 = new CuentaBancaria((long)108952347, (float)2023456.1, 1852);
	CuentaBancaria cuenta2 = new CuentaBancaria((long)278782778, (float)800.5, 8728);
	CuentaBancaria cuenta3 = new CuentaBancaria((long)387787222, (float)500456.7, 7885);
	
		// Cuenta bancaria del proveedor
	CuentaBancaria cuentaProveedor = new CuentaBancaria((long)1089523479, (float)20858967.8, 5782);
		
		// Cuenta bancaria de la tienda
	CuentaBancaria cuentaTienda = new CuentaBancaria((long)1077774562, (float)10889456.6, 1023);
	
	// Productos
		// Perro grande adulto
	Producto producto1 = new Producto(1, "Croquetas Adulto Plus", "13/04/2023", "Comida para perro adulto de raza grande", 5000, 12000, 2);
	Producto producto2 = new Producto(1, "Croquetas Adulto Plus", "13/04/2023", "Comida para perro adulto de raza grande", 5000, 12000, 3);
	Producto producto3 = new Producto(1, "Croquetas Adulto Plus", "13/04/2023", "Comida para perro adulto de raza grande", 5000, 12000, 1);
		
		// Perro grande cachorro
	Producto producto4 = new Producto(1, "Croquetas Adulto Plus", "13/04/2023", "Comida para perro adulto de raza grande", 5000, 12000, 4);
	Producto producto5 = new Producto(1, "Croquetas Adulto Plus", "13/04/2023", "Comida para perro adulto de raza grande", 5000, 12000, 2);
	Producto producto6 = new Producto(1, "Croquetas Adulto Plus", "13/04/2023", "Comida para perro adulto de raza grande", 5000, 12000, 3);
		
		// Perro pequeño adulto
	Producto producto7 = new Producto(1, "Croquetas Adulto Plus", "13/04/2023", "Comida para perro adulto de raza grande", 5000, 12000, 2);
	Producto producto8 = new Producto(1, "Croquetas Adulto Plus", "13/04/2023", "Comida para perro adulto de raza grande", 5000, 12000, 2);
	Producto producto9 = new Producto(1, "Croquetas Adulto Plus", "13/04/2023", "Comida para perro adulto de raza grande", 5000, 12000, 4);
		
		// Perro pequeño cachorro
	Producto producto10 = new Producto(1, "Croquetas Adulto Plus", "13/04/2023", "Comida para perro adulto de raza grande", 5000, 12000, 1);
	Producto producto11 = new Producto(1, "Croquetas Adulto Plus", "13/04/2023", "Comida para perro adulto de raza grande", 5000, 12000, 2);
	Producto producto12 = new Producto(1, "Croquetas Adulto Plus", "13/04/2023", "Comida para perro adulto de raza grande", 5000, 12000, 1);
		
		// Gato cachorro
	Producto producto13 = new Producto(1, "Croquetas Adulto Plus", "13/04/2023", "Comida para perro adulto de raza grande", 5000, 12000, 7);
	Producto producto14 = new Producto(1, "Croquetas Adulto Plus", "13/04/2023", "Comida para perro adulto de raza grande", 5000, 12000, 2);
	Producto producto15 = new Producto(1, "Croquetas Adulto Plus", "13/04/2023", "Comida para perro adulto de raza grande", 5000, 12000, 1);
		
		// Gato adulto
	Producto producto16 = new Producto(1, "Croquetas Adulto Plus", "13/04/2023", "Comida para perro adulto de raza grande", 5000, 12000, 8);
	Producto producto17 = new Producto(1, "Croquetas Adulto Plus", "13/04/2023", "Comida para perro adulto de raza grande", 5000, 12000, 1);
	Producto producto18 = new Producto(1, "Croquetas Adulto Plus", "13/04/2023", "Comida para perro adulto de raza grande", 5000, 12000, 2);
		
	// Proveedor
	
	Proveedor proveedor1 = new Proveedor(43825896, "Pedro Casas", "pcasas@email.com", 4484250, cuentaProveedor, new ArrayList<Producto>(), true) ;
	
	// Clientes
		
	Usuario usuario1 = new Usuario(1093186721, "Manuela Arboleda", "manuarbol@email.com", 4422879, cuenta1, "Cra 170 # 2-103", new ArrayList<Mascota>());
	Usuario usuario2 = new Usuario(35164789, "Valentina Higuita", "vhiguita@email.com", 3728945, cuenta2, "Cra 58 # 78-29", new ArrayList<Mascota>());
	Usuario usuario3 = new Usuario(25787278, "Jorge Sierra", "jsierra@email.com", 7895589, cuenta3, "Cll 66 # 43-47", new ArrayList<Mascota>());
	Usuario usuario4 = new Usuario(1027278278, "Manuela Arboleda", "manuarbol@email.com", 4422879, "Cll 48 # 63-102", new ArrayList<Mascota>());
	
	// Facturas
		
	Factura factura1 = new Factura();
	Factura factura2 = new Factura();
	Factura factura3 = new Factura();
	
	Factura factura4 = new Factura();
	Factura factura5 = new Factura();
	Factura factura6 = new Factura();
	
	Factura factura7 = new Factura();
	Factura factura8 = new Factura();
	Factura factura9 = new Factura();
	
	// Vendedores	
	
	Vendedor vendedor1 = new Vendedor(46785214, "Juan Pablo Arcila", "jpardilla@email.com", 4478514, new ArrayList<Factura>(), "Juan Pablo Arcila", "holi12");
	Vendedor vendedor2 = new Vendedor(13205481, "Roberto Barrientos", "rbarriendo@email.com", 4905873, new ArrayList<Factura>(), "Roberto Barrientos", "adios13");
	Vendedor vendedor3 = new Vendedor(119258647, "Laura Vanegas", "lavanega@email.com", 3158647, new ArrayList<Factura>(), "Laura Vanegas", "lau1245");
	
	// Mascotas
		// Perros
	Perro perro1 = new Perro(100, "Dante", 0.5, "Grande");
	
		// Gatos
	Gato gato1 = new Gato(123, "Jackie", 4, "Hogare�o");
	}
}