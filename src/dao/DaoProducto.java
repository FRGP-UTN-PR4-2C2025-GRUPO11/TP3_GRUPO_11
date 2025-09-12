package dao;

import entidad.Producto;
import java.sql.*;
import java.util.ArrayList;

public class DaoProducto {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdinventario";
	
	public int agregarProducto (Producto p) {
		String query = "INSERT INTO productos(Codigo, Nombre, Precio, Stock, IdCategoria) "
				+ "VALUES ('" + p.getCodigo() + "', '" + p.getNombre() + "', '" + p.getPrecio() + "', '" + p.getStock() + "', '" + p.getIdCategoria() + "')";
		Connection cn = null;
		int filas = 0;
		
		try
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			filas = st.executeUpdate(query);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	
		return filas;
	}
	
	public int eliminarProducto(Producto p) {		
		Connection cn = null;
		int filas = 0;
		
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			String query = "DELETE FROM productos WHERE Codigo = ?";
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, p.getCodigo());
			filas = pst.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return filas;
		
	}
	
	public int modificarProducto(Producto p) {
		Connection cn = null;
		int filas = 0;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			String query = "UPDATE productos SET Nombre = ?, Precio = ?, Stock = ?, IdCategoria = ? WHERE Codigo = ?";
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, p.getNombre());
			pst.setFloat(2, p.getPrecio());
			pst.setInt(3, p.getStock());
			pst.setInt(4, p.getIdCategoria());
			pst.setString(5,p.getCodigo());
			filas = pst.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}
	
	public ArrayList<Producto> listarProductos(){
		ArrayList<Producto> array = new ArrayList<Producto>();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			String query = "SELECT * FROM productos";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Producto p = new Producto ();
				p.setCodigo(rs.getString("Codigo"));
				p.setNombre(rs.getString("Nombre"));
				p.setPrecio(rs.getFloat("Precio"));
				p.setStock(rs.getInt("Stock"));
				p.setIdCategoria(rs.getInt("IdCategoria"));
				array.add(p);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return array;
	}

	public void sp_AgregarProducto (Producto producto) {
		 Connection cn = null;
	
		 try {
			 cn = DriverManager.getConnection(host+dbName,user,pass);
			 CallableStatement cst = cn.prepareCall("CALL sp_AgregarProducto(?,?,?,?,?)");
			 cst.setString(1, producto.getCodigo());
			 cst.setString(2, producto.getNombre());
			 cst.setFloat(3, producto.getPrecio());
			 cst.setInt(4, producto.getStock());
			 cst.setInt(5, producto.getIdCategoria());
			 cst.execute();
			
		 }
		 catch (Exception e) {
			 e.printStackTrace();
		 }
		 
		
	}
}
