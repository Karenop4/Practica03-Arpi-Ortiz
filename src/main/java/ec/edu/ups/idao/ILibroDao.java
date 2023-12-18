package ec.edu.ups.idao;

import ec.edu.ups.modelo.Biblioteca;
import ec.edu.ups.modelo.Libro;

public interface ILibroDao {
	public void crearLibro(Libro usuario);
	public boolean actualizarLibro(String id,Libro libro, Biblioteca biblioteca);
	public boolean eliminarLibro(String id);
	public Libro obtenerLibro(String id);
}
