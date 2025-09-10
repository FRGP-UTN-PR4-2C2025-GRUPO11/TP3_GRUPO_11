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
				
		
		DaoProducto dp = new DaoProducto();
		
		Producto p = new Producto("11", "Chauchas", 1200, 60, 1);

		if (dp.eliminarProducto(p) == 1)
		{
			System.out.println("Producto eliminado con éxito\n" + p );
		}
		else
		{
			System.out.println("Producto no pudo ser eliminado\n" + p);
		}
				
	}

}


