package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entidad.Categoria;

public class DaoCategoria {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdinventario";

	public DaoCategoria() {

	}

	public Categoria buscarCategoria(int idCategoria) {
		Categoria categoria = null;
		String query = "SELECT * FROM categorias WHERE idCategoria = ?";
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setInt(1, idCategoria);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				categoria = new Categoria();
				categoria.setIdCategoria(rs.getInt("idCategoria"));
				categoria.setNombre(rs.getString("Nombre"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoria;
	}

	public int agregarCategoria(Categoria categoria) {
		String query = "INSERT INTO categorias(idCategoria,Nombre) VALUES ('"
		    + categoria.getIdCategoria() + "','" + categoria.getNombre() + "')";

		Connection cn = null;
		int filas = 0;

		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = cn.createStatement();
			filas = st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return filas;
	}

	public int eliminarCategoria(Categoria categoria) {
		Connection cn = null;
		int filas = 0;

		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			String query = "DELETE FROM categorias WHERE idCategoria = ?";
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setInt(1, categoria.getIdCategoria());
			filas = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return filas;
	}

	public int modificarCategoria(Categoria categoria) {
		Connection cn = null;
		int filas = 0;

		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			String query = "UPDATE categorias SET Nombre = ? WHERE idCategoria = ?";
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, categoria.getNombre());
			pst.setInt(2, categoria.getIdCategoria());
			filas = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	public ArrayList<Categoria> listarCategorias() {
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			String query = "SELECT * FROM categorias";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Categoria c = new Categoria();
				c.setIdCategoria(rs.getInt("idCategoria"));
				c.setNombre(rs.getString("Nombre"));
				lista.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
}
