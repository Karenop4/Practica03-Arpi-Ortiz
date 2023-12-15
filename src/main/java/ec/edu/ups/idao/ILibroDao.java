package ec.edu.ups.idao;

import ec.edu.ups.modelo.Libro;

public interface ILibroDao {
	public void crearLibro(Libro usuario, String nombreBiblioteca);
	public boolean actualizarLibro(String id,Libro libro);
	public boolean eliminarLibro(String id);
	public Libro obtenerLibro(String id);
}
