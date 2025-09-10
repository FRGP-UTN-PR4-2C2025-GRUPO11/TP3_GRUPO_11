package dao;

import entidad.Producto;

import java.sql.*;

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
}
