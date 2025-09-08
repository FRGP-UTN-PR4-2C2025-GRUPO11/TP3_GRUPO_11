package entidad;

public class Categoria {
	private int idCategoria;
	private String nombre;
	public Categoria ()
	{}
	public int getIdCategoria() {
		return idCategoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nombre=" + nombre + "]";
	}
}
