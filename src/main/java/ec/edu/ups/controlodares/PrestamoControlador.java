package ec.edu.ups.controlodares;

import ec.edu.ups.idao.IPrestamoDao;
import ec.edu.ups.modelo.Libro;
import ec.edu.ups.modelo.Prestamo;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vistas.PrestamoVista;

public class PrestamoControlador {
        private IPrestamoDao prestamoDao;
	private PrestamoVista prestamoVista;
	private Prestamo prestamo;
        private Usuario usuario;

    public PrestamoControlador(IPrestamoDao prestamoDao, PrestamoVista prestamoVista, Prestamo prestamo) {
        this.prestamoDao = prestamoDao;
        this.prestamoVista = prestamoVista;
    }

    public void seleccionarUsuario(Usuario usuario){
        this.usuario=usuario;
    }
    
    public void crearPrestamo() {
            prestamo = prestamoVista.ingresarNuevoPrestamo(usuario);
            if(prestamo!=null){
                prestamoDao.crearPrestamo(prestamo);
                usuario.solicitarPrestamo(prestamo);
                System.out.println("Libro Prestado");                
            }
    }
	
	public void devolucion() {
		boolean existe;
		
		Libro libro = prestamoVista.eliminarPrestamo();
		existe = prestamoDao.eliminarPrestamo(libro);
		usuario.devolverLibro(libro);
		
		if(existe) {
			System.out.println("Libro ha sido devuelto!");
		}else {
			System.out.println("Libro no ha sido prestado al usuario");
		}
	}
	
	public void listarPrestamos() {
		for (Prestamo prestamo : usuario.devolverListaPrestamos()) {
			prestamoVista.mostrarDatosPrestamo(prestamo.getLibro().getTitulo(), prestamo.getLibro().getAutor(), prestamo.getLibro().getAnho(), prestamo.esPrestamoVigente(), prestamo.getFechaDevolucion());
		}
	}
}
