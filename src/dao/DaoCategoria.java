package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import entidad.Categoria;

public class DaoCategoria {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdinventario";
	
	public DaoCategoria() {
		
	}
	
	public int agregarCategoria(Categoria categoria) {
		String query = "INSERT INTO categoria(idCategoria,Nombre) VALUES ('"+categoria.getIdCategoria()+"','"+categoria.getNombre()+"')";
		
		Connection cn = null;
		int filas = 0;
		
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			filas = st.executeUpdate(query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return filas;
	}
	
	public int eliminarCategoria(int idCategoria) {		
		Connection cn = null;
		int filas = 0;
		
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			String query = "DELETE FROM categoria WHERE idCategoria = ?";
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setInt(1, idCategoria);
			filas = pst.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return filas;
	}
}
