package uiMain.funcionalidades;

import gestorAplicacion.gestionVentas.Tienda;

public class CompraInventario {
	public static  void funcionalidad() {
		System.out.println("Este es su inventario actual");
		System.out.println(Tienda.getInventarioProductos());
		// Imprimir lista de inventario ordenado por cantidadComprada
		System.out.println("¿Desea comprar inventario?");
	}
}