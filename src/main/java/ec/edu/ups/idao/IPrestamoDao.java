package ec.edu.ups.idao;

import ec.edu.ups.modelo.Libro;
import ec.edu.ups.modelo.Prestamo;

public interface IPrestamoDao {
	public void crearPrestamo(Prestamo prestamo);
	public boolean eliminarPrestamo(Libro libro);
}
