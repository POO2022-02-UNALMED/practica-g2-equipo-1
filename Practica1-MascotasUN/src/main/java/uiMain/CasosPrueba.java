package uiMain;
import java.util.ArrayList;
import java.util.HashMap;

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

//Pendiente: ¿Tienda lleva constructor?. Y revisar el cantidad_Comprada

public class CasosPrueba {
	
	public static void crearCasosDePrueba() {
	
	// Cuentas bancarias
		// Cuentas de clientes
	CuentaBancaria cuenta1 = new CuentaBancaria((long)108952347, (float)2023456.1, 1852);
	CuentaBancaria cuenta2 = new CuentaBancaria((long)278782778, (float)800.5, 8728);
	CuentaBancaria cuenta3 = new CuentaBancaria((long)387787222, (float)500456.7, 7885);
	
		// Cuenta bancaria del proveedor
	CuentaBancaria cuentaProveedor = new CuentaBancaria((long)1089523479, (float)20858967.8, 5782);
	CuentaBancaria cuentaProveedor1 = new CuentaBancaria((long)1872854124, (float)48248582.8, 5784);
	CuentaBancaria cuentaProveedor2 = new CuentaBancaria((long)1234567887, (float)0, 1875);
		
		// Cuenta bancaria de la tienda
	CuentaBancaria cuentaTienda = new CuentaBancaria((long)1077774562, (float)10889456.6, 1023);
	Tienda.setCuenta(cuentaTienda);
	
	// Productos
			// Perro grande adulto
		Producto producto1 = new Producto(1001, "Croquetas Adulto Plus", "13/04/2023", "Comida en croquetas para perro adulto de raza grande", 5000, 12000, 10, "Grande", "Adulto");
		Producto producto2 = new Producto(1002, "Comida humeda Adulto Max", "28/12/2022", "Comida humeda para perro adulto de raza grande", 2000, 5000, 3, "Grande", "Adulto");
		Producto producto3 = new Producto(1003, "Cuido Adulto Extra", "18/05/2023", "Comida diaria para perro adulto de raza grande", 9000, 15000, 4, "Grande", "Adulto");
			
			// Perro grande cachorro
		Producto producto4 = new Producto(1004, "Croquetas Cachorro Plus", "18/05/2023", "Comida en croquetas para perro cachorro de raza grande", 5000, 12000, 4, "Grande", "Cachorro", "Perro");
		Producto producto5 = new Producto(1005, "Comida humeda Cachorro Max", "29/11/2022", "Comida humeda para perro cachorro de raza grande", 2000, 5000, 2, "Grande", "Cachorro", "Perro");
		Producto producto6 = new Producto(1006, "Cuido Cachorro Extra", "17/04/2023", "Comida diaria para perro cachorro de raza grande", 9000, 15000, 3, "Grande", "Cachorro", "Perro");
			
			// Perro pequeño adulto
		Producto producto7 = new Producto(1007, "Croquetas Adulto Mini", "30/08/2023", "Comida en croquetas para perro adulto de raza pequeña", 6000, 13000, 2, "Pequena", "Adulto", "Perro");
		Producto producto8 = new Producto(1008, "Comida humeda Adulto Junior", "18/12/2022", "Comida humeda para perro adulto de raza pequeña", 3000, 6000, 10, "Pequena", "Adulto", "Perro");
		Producto producto9 = new Producto(1009, "Cuido Adulto Small", "14/01/2023", "Comida diaria para perro adulto de raza pequeña", 10000, 16000, 4, "Pequena", "Adulto", "Perro");
			
			// Perro pequeño cachorro
		Producto producto10 = new Producto(1010, "Croquetas Cachorro Mini", "29/08/2023", "Comida en croquetas para perro cachorro de raza pequeña", 6000, 13000, 5, "Pequena", "Cachorro", "Perro");
		Producto producto11 = new Producto(1011, "Comida humeda Cachorro Junior", "17/12/2022", "Comida humeda para perro cachorro de raza pequeña", 3000, 6000, 3, "Pequena", "Cachorro", "Perro");
		Producto producto12 = new Producto(1012, "Cuido Cachorro Small", "13/01/2023", "Comida diaria para perro cachorro de raza pequeña", 10000, 16000, 2, "Pequena", "Cachorro", "Perro");
			
			// Gato cachorro
		Producto producto13 = new Producto(1013, "Purina catchow cachorro", "19/01/2024", "Comida seca para gato cachorro", 7000, 10000, 7, "Cachorro", "Gato");
		Producto producto14 = new Producto(1014, "Comida enlatada felino cachorro", "29/05/2024", "Comida humeda para gato cachorro", 5000, 9000, 2, "Cachorro", "Gato");
		Producto producto15 = new Producto(1015, "Whiskas para felino cachorro", "09/08/2024", "Alimento balanceado para gato cachorro", 11000, 15000, 1, "Cachorro", "Gato");
			
			// Gato adulto
		Producto producto16 = new Producto(1016, "Purina catchow adulto", "18/01/2024", "Comida seca para gato adulto", 7000, 10000, 2, "Adulto", "Gato");
		Producto producto17 = new Producto(1017, "Comida enlatada felino adulto", "28/05/2024", "Comida humeda para gato adulto", 5000, 9000, 3, "Adulto", "Gato");
		Producto producto18 = new Producto(1018, "Whiskas para felino adulto", "01/09/2024", "Alimento balanceado para gato adulto", 11000, 15000, 4, "Adulto", "Gato");
		
	//ArrayList de productos que tiene la tienda
	ArrayList<Producto> listaProductos = new ArrayList<Producto>(); listaProductos.add(producto1); listaProductos.add(producto2);listaProductos.add(producto3); listaProductos.add(producto4);
	listaProductos.add(producto5); listaProductos.add(producto6); listaProductos.add(producto7); listaProductos.add(producto8); listaProductos.add(producto9); listaProductos.add(producto10);
	listaProductos.add(producto11); listaProductos.add(producto12); listaProductos.add(producto13); listaProductos.add(producto14); listaProductos.add(producto15); listaProductos.add(producto16);
	listaProductos.add(producto17); listaProductos.add(producto18);
	Tienda.setCatalogo(listaProductos);

	Tienda.setCatalogo(listaProductos); // Creamos el catalogo de la tienda
	ArrayList<Producto> listaProductos1 = new ArrayList<Producto>(); listaProductos1.add(producto1); listaProductos1.add(producto2);listaProductos1.add(producto3); listaProductos1.add(producto4);
	listaProductos1.add(producto5); listaProductos1.add(producto6); listaProductos1.add(producto7); listaProductos1.add(producto10);listaProductos1.add(producto11); listaProductos1.add(producto12);

	ArrayList<Producto> listaProductos2 = new ArrayList<Producto>();
	listaProductos2.add(producto5); listaProductos2.add(producto6); listaProductos2.add(producto7); listaProductos2.add(producto10);listaProductos2.add(producto11); listaProductos2.add(producto12);
	Tienda.setCatalogo(listaProductos2);

	ArrayList<Producto> listaProductos3 = new ArrayList<Producto>(); listaProductos3.add(producto1); listaProductos3.add(producto2);listaProductos3.add(producto3); listaProductos3.add(producto4);
	listaProductos.add(producto5); listaProductos3.add(producto6); listaProductos3.add(producto7); listaProductos3.add(producto8); listaProductos3.add(producto9); listaProductos3.add(producto10);
	listaProductos.add(producto11); listaProductos3.add(producto12); listaProductos3.add(producto13); listaProductos3.add(producto14); listaProductos3.add(producto15); listaProductos3.add(producto16);
	listaProductos.add(producto17); listaProductos3.add(producto18);
	Tienda.setCatalogo(listaProductos3);
	// Creando el inventario
	HashMap<String, Integer> listaInventario = new HashMap<String, Integer>(); listaInventario.put(producto1.getNombre(), producto1.getCantidadComprada());
	listaInventario.put(producto2.getNombre(), producto2.getCantidadComprada());
	listaInventario.put(producto3.getNombre(), producto3.getCantidadComprada());
	listaInventario.put(producto4.getNombre(), producto4.getCantidadComprada());
	listaInventario.put(producto5.getNombre(), producto5.getCantidadComprada());
	listaInventario.put(producto6.getNombre(), producto6.getCantidadComprada());
	listaInventario.put(producto7.getNombre(), producto7.getCantidadComprada());
	listaInventario.put(producto8.getNombre(), producto8.getCantidadComprada());
	listaInventario.put(producto9.getNombre(), producto9.getCantidadComprada());
	listaInventario.put(producto10.getNombre(), producto10.getCantidadComprada());
	listaInventario.put(producto11.getNombre(), producto11.getCantidadComprada());
	listaInventario.put(producto12.getNombre(), producto12.getCantidadComprada());
	listaInventario.put(producto13.getNombre(), producto13.getCantidadComprada());
	listaInventario.put(producto14.getNombre(), producto14.getCantidadComprada());
	listaInventario.put(producto15.getNombre(), producto15.getCantidadComprada());
	listaInventario.put(producto16.getNombre(), producto16.getCantidadComprada());
	listaInventario.put(producto17.getNombre(), producto17.getCantidadComprada());
	listaInventario.put(producto18.getNombre(), producto18.getCantidadComprada());
	Tienda.setInventarioProductos(listaInventario);
	//HashMap de productos(solo con el nombre

/////// Se crea el inventario (Hay que revisar listainventario porque no tiene nada de sentido
		HashMap<Producto, Integer> inventario = new HashMap<Producto, Integer>(); inventario.put(producto1, producto1.getCantidadComprada());
		inventario.put(producto2, producto2.getCantidadComprada());
		inventario.put(producto3 , producto3.getCantidadComprada());
		inventario.put(producto4, producto4.getCantidadComprada());
		inventario.put(producto5, producto5.getCantidadComprada());
		inventario.put(producto6, producto6.getCantidadComprada());
		inventario.put(producto7, producto7.getCantidadComprada());
		inventario.put(producto8, producto8.getCantidadComprada());
		inventario.put(producto9, producto9.getCantidadComprada());
		inventario.put(producto10, producto10.getCantidadComprada());
		inventario.put(producto11, producto11.getCantidadComprada());
		inventario.put(producto12, producto12.getCantidadComprada());
		inventario.put(producto13, producto13.getCantidadComprada());
		inventario.put(producto14, producto14.getCantidadComprada());
		inventario.put(producto15, producto15.getCantidadComprada());
		inventario.put(producto16, producto16.getCantidadComprada());
		inventario.put(producto17, producto17.getCantidadComprada());
		inventario.put(producto18, producto18.getCantidadComprada());
		Tienda.setInventario(inventario);
		//Compras usuario1
	HashMap<Producto, Integer> compra1 =new HashMap<Producto, Integer>(); compra1.put(producto4, 2); compra1.put(producto5, 2); compra1.put(producto6, 3); compra1.put(producto13, 4); 
	compra1.put(producto14, 2); compra1.put(producto15, 1);	
	HashMap<Producto, Integer> compra2 =new HashMap<Producto, Integer>(); compra2.put(producto4, 2); compra2.put(producto13, 3);
	
		//Compra usuario2
	HashMap<Producto, Integer> compra3 =new HashMap<Producto, Integer>(); compra3.put(producto16, 2); compra3.put(producto17, 2); compra3.put(producto18, 3);
	HashMap<Producto, Integer> compra4 =new HashMap<Producto, Integer>(); compra4.put(producto17, 1);
	
		//Compra usuario3
	HashMap<Producto, Integer> compra5 =new HashMap<Producto, Integer>(); compra5.put(producto1, 2); compra5.put(producto2, 3); compra5.put(producto3, 3);
	HashMap<Producto, Integer> compra6 =new HashMap<Producto, Integer>(); compra6.put(producto3, 1);
	
		//Compra usuario4
	HashMap<Producto, Integer> compra7 =new HashMap<Producto, Integer>(); compra7.put(producto7, 2); compra7.put(producto8, 2); compra7.put(producto9, 3); compra7.put(producto10, 3); 
	compra7.put(producto11, 2); compra7.put(producto12, 1);
	HashMap<Producto, Integer> compra8 =new HashMap<Producto, Integer>(); compra8.put(producto8, 1); compra8.put(producto9, 1); compra8.put(producto10, 2); compra8.put(producto11, 1); 
	compra8.put(producto12, 1);
	
	HashMap<Producto, Integer> compra9 =new HashMap<Producto, Integer>(); compra9.put(producto8, 1);
	// Mascotas
			// Perros
		Perro perro1 = new Perro(100, "Dante", 1, "Grande"); //Perro Cachorro Grande
		Perro perro2 = new Perro(101, "Tony", 5, "Grande"); //Perro Adulto Grande
		Perro perro3 = new Perro(102, "Apolo", 8, "Pequeño"); //Perro Adulto Pequeño
		Perro perro4 = new Perro(103, "Lupita", 0, "Pequeño"); //Perro Cachorro pequeño
		
			// Gatos
		Gato gato1 = new Gato(123, "Jackie", 1); //Gato Cachorro
		Gato gato2 = new Gato(124, "Manchita", 4); //Gato Adulto 
		
		// ArrayList de mascotas
		ArrayList<Mascota> listaMascotas1 = new ArrayList<Mascota>(); listaMascotas1.add(perro1); listaMascotas1.add(gato1);
		ArrayList<Mascota> listaMascotas2 = new ArrayList<Mascota>(); listaMascotas2.add(gato2);
		ArrayList<Mascota> listaMascotas3 = new ArrayList<Mascota>(); listaMascotas3.add(perro2);
		ArrayList<Mascota> listaMascotas4 = new ArrayList<Mascota>(); listaMascotas4.add(perro3); listaMascotas1.add(perro4);
		
	
	// Proveedor
	Proveedor proveedor1 = new Proveedor(43825896, "Pedro Casas", "pcasas@email.com", 4484250, cuentaProveedor, listaProductos1, true) ;
	ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
	proveedores.add(proveedor1);


	Proveedor proveedor2 = new Proveedor(43825897, "Armando Marin", "armandocasasde@email.com", 4484254, cuentaProveedor1, listaProductos2, false) ;
	proveedores.add(proveedor2);

	Proveedor proveedor3 = new Proveedor(58415, "Sol lunar", "solunar@email.com", 3482414, cuentaProveedor2, listaProductos3,true) ;
	ArrayList<Proveedor> proveedores2 = new ArrayList<Proveedor>();
	proveedores.add(proveedor3);
	Proveedor.setProveedores(proveedores);


	// Clientes
	Usuario usuario1 = new Usuario(1093186721, "Manuela Arboleda", "manuarbol@email.com", 4422879, cuenta1, "Cra 170 # 2-103", listaMascotas1); //Usuario 1 tiene Perro Cachorro Grande y Gato Cachorro
	Usuario usuario2 = new Usuario(35164789, "Valentina Higuita", "vhiguita@email.com", 3728945, cuenta2, "Cra 58 # 78-29", listaMascotas2); //Usuario 2 tiene Gato Adulto
	Usuario usuario3 = new Usuario(25787278, "Jorge Sierra", "jsierra@email.com", 7895589, cuenta3, "Cll 66 # 43-47", listaMascotas3); //Usuario 3 tiene Perro Adulto Grande
	Usuario usuario4 = new Usuario(1027278278, "Manuela Sanchez", "manuarbol@email.com", 4422879, "Cll 48 # 63-102", listaMascotas4); // Usuario 4 tiene Perro Adulto Pequeño y Perro Cachorro Pequeño
	
	ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>(); listaUsuarios.add(usuario1); listaUsuarios.add(usuario2);
	listaUsuarios.add(usuario3); listaUsuarios.add(usuario4);
	Usuario.setUsuarios(listaUsuarios);
	
	
	// Vendedores
	Vendedor vendedor1 = new Vendedor(46785214, "Juan Pablo Arcila", "jpardilla@email.com", 4478514, new ArrayList<Factura>(), "Juan Pablo Arcila", "holi12",new CuentaBancaria(1085645245,986543.3f,4328));
	Vendedor vendedor2 = new Vendedor(13205481, "Roberto Barrientos", "rbarriendo@email.com", 4905873, new ArrayList<Factura>(), "Roberto Barrientos", "adios13",new CuentaBancaria(10793452,123344.3f,3342));
	Vendedor vendedor3 = new Vendedor(119258647, "Laura Vanegas", "lavanega@email.com", 3158647, new ArrayList<Factura>(), "Laura Vanegas", "lau1245",new CuentaBancaria(108956543,341234.3f,1733));
	
	// Diccionario de vendedores (usuario,contraseña)
	
	HashMap<String, String> listavendedores = new HashMap<String, String>(); listavendedores.put(vendedor1.getUsuario(), vendedor1.getContrasena());
	listavendedores.put(vendedor2.getUsuario(), vendedor2.getContrasena());
	listavendedores.put(vendedor3.getUsuario(), vendedor3.getContrasena());
	
	Vendedor.setUsuarios(listavendedores);

	
	
	// Facturas
		Factura factura1 = new Factura(usuario1, "23/10/2022", vendedor1);
		factura1.setProductos(compra1);
		Factura factura2 = new Factura(usuario1, "15/10/2022", vendedor1);
		factura2.setProductos(compra2);
		usuario1.agregarFactura(factura1);
		usuario1.agregarFactura(factura2);
		
		Factura factura3 = new Factura(usuario2, "22/10/2022", vendedor2);
		factura3.setProductos(compra3);
		Factura factura4 = new Factura(usuario2, "21/10/2022", vendedor2);
		factura4.setProductos(compra4);
		usuario2.agregarFactura(factura3);
		usuario2.agregarFactura(factura4);
		
		Factura factura5 = new Factura(usuario3, "19/10/2022", vendedor3);
		factura5.setProductos(compra5);
		Factura factura6 = new Factura(usuario3, "18/10/2022", vendedor3);
		factura6.setProductos(compra6);
		usuario3.agregarFactura(factura5);
		usuario3.agregarFactura(factura6);
		
		Factura factura7 = new Factura(usuario4, "17/10/2022", vendedor3);
		factura7.setProductos(compra7);
		Factura factura8 = new Factura(usuario4, "16/10/2022", vendedor3);
		factura8.setProductos(compra8);
		Factura factura9 = new Factura(usuario4, "10/10/2022", vendedor2);
		factura9.setProductos(compra9);
		usuario4.agregarFactura(factura9);
		usuario4.agregarFactura(factura7);
		usuario4.agregarFactura(factura8);
	
	
	//ArrayList de facturas
		ArrayList<Factura> listaFactura1 = new ArrayList<Factura>(); listaFactura1.add(factura1); listaFactura1.add(factura2);
		vendedor1.setVentas(listaFactura1);
		ArrayList<Factura> listaFactura2 = new ArrayList<Factura>(); listaFactura2.add(factura3); listaFactura2.add(factura4);  listaFactura2.add(factura9);
		vendedor2.setVentas(listaFactura2);
		ArrayList<Factura> listaFactura3 = new ArrayList<Factura>(); listaFactura3.add(factura5); listaFactura3.add(factura6); listaFactura3.add(factura7); listaFactura3.add(factura8);
		vendedor3.setVentas(listaFactura3); 
		
	// Diccionario de vendedores (usuario,cantidadVentas)
		
		HashMap<String, Integer> ventasT = new HashMap<String, Integer>(); ventasT.put(vendedor1.getUsuario(), vendedor1.getVentas().size());
		ventasT.put(vendedor2.getUsuario(), vendedor2.getVentas().size());
		ventasT.put(vendedor3.getUsuario(), vendedor3.getVentas().size());
		
		Vendedor.setCantidadVentas(ventasT);
		
		
	//Lista de facturas para la tienda
		ArrayList<Factura> listaFacturasTienda = new ArrayList<Factura>(); listaFacturasTienda.add(factura1);listaFacturasTienda.add(factura2);
		listaFacturasTienda.add(factura3);listaFacturasTienda.add(factura4); listaFacturasTienda.add(factura5); listaFacturasTienda.add(factura6);
		listaFacturasTienda.add(factura7); listaFacturasTienda.add(factura8);listaFacturasTienda.add(factura9);
		
		
		Tienda.setCantidadDeVentas(listaFacturasTienda);
	}
	
}