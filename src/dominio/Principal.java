package dominio;

import entidad.*;

import java.util.ArrayList;
import java.util.ListIterator;

import dao.*;

public class Principal {

	public static void main(String[] args) {

		// Agrego una categoria
//		Categoria cat = new Categoria();
//		cat.setNombre("Congelados");
//
//		DaoCategoria dc = new DaoCategoria();
//		dc.agregarCategoria(cat);

		// Agregar productos con metodo agregarProducto

//		ArrayList <Producto> al = new ArrayList<>();
//
//		al.add(new Producto("2", "Papas Simplot", 15000, 60, 1));
//		al.add(new Producto("3", "Paty", 15000, 400, 1));
//		al.add(new Producto("4", "Karinat", 25000, 90, 1));
//		al.add(new Producto("5", "Helado Frigor", 9000, 60, 1));
//		al.add(new Producto("6", "Pacu", 35000, 10, 1));
//		al.add(new Producto("7", "Sibarita", 11000, 50, 1));
//		al.add(new Producto("8", "Pollo Granja del Sol", 1500, 354, 1));
//		al.add(new Producto("9", "Franui", 8000, 400, 1));
//		al.add(new Producto("10", "Choclo", 1000, 300, 1));
//		al.add(new Producto("11", "Chauchas", 1200, 60, 1));
//
//		ListIterator <Producto> li = al.listIterator();

//
//		DaoProducto dp = new DaoProducto();
//
//
//		while (li.hasNext())
//		{
//			Producto p = li.next();
//			if( dp.agregarProducto(p) > 0 )
//			{
//				System.out.println("Se agrego el producto\n" + p);
//			} else
//			{
//				System.out.println("Hubo un error en la carga del producto\n" + p);
//			}
//
//		}

		// DaoProducto dp = new DaoProducto();

		// Producto pr = new Producto("11", "Chauchas", 1200, 60, 1);

		/*
		 * if (dp.eliminarProducto(p) == 1) {
		 * System.out.println("Producto eliminado con éxito\n" + p ); } else {
		 * System.out.println("Producto no pudo ser eliminado\n" + p); }
		 */

		// dp.sp_AgregarProducto(pr);

		// 1.Agrego una categoria y verifico si se agrego correctamente
		DaoCategoria dc = new DaoCategoria();
//		Categoria c = new Categoria("Congelados");
//		int res = dc.agregarCategoria(c);
//
//		if (res > 0) {
//			System.out.println("Se agrego la categoria\n" + c);
//		} else {
//			System.out.println("Hubo un error en la carga de la categoria\n" + c);
//		}

		//2. Creamos un array de categorias:
//		String[] nombresCategorias = { "Electrónica", "Ropa y accesorios", "Hogar y cocina", "Deportes y aire libre",
//				"Juguetes y juegos", "Libros y música", "Belleza y cuidado personal", "Salud y bienestar",
//				"Alimentos y bebidas" };
//
//		System.out.println("Listado de categorias a agregar:" +  nombresCategorias.length);
//		//2. Creo un ArrayList para almacenar las categorias
//		ArrayList<Categoria> al = new ArrayList<>();
//		//2. Creamos una for para agregar categorias
//		for (String nombre : nombresCategorias) {
//		    Categoria c = new Categoria(nombre);
//		    int res = dc.agregarCategoria(c);
//		    if (res > 0) {
//		        System.out.println("Se agregó la categoría: " + c);
//		    } else {
//		        System.out.println("Error al agregar la categoría: " + c);
//		    }
//		}

//		//2. Listo todas las categorias
//		al  = dc.listarCategorias();
//		for (Categoria categoria : al) {
//		    System.out.println(categoria);
//		}

		//3. Modifico una categoria:

		Categoria c = new Categoria();
		c = dc.buscarCategoria(1);
		System.out.println("Categoria a modificar: " + c);
		c.setNombre("Congelados editado");
		int res = dc.modificarCategoria(c);
		if (res > 0) {
		    System.out.println("Se modificó la categoría: " + c);
		} else {
		    System.out.println("Error al modificar la categoría: " + c);
		}

		//4. Elimino una categoria:
			Categoria c = new Categoria();
			c = dc.buscarCategoria(10); // Alinentos y bebidas
			System.out.println("Categoria a eliminar: " + c);
			int res = dc.eliminarCategoria(c);
			if (res > 0) {
			    System.out.println("Se eliminó la categoría: " + c);
			} else {
			    System.out.println("Error al eliminar la categoría: " + c);
			}
	}

}
