package ec.edu.ups.controlodares;

import ec.edu.ups.idao.IPrestamoDao;
import ec.edu.ups.modelo.Biblioteca;
import ec.edu.ups.modelo.Libro;
import ec.edu.ups.modelo.Prestamo;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vistas.PrestamoVista;

public class PrestamoControlador {
        private IPrestamoDao prestamoDao;
	private PrestamoVista prestamoVista;
	private Prestamo prestamo;
        private Usuario usuario;
        private Biblioteca biblioteca;

    public PrestamoControlador(IPrestamoDao prestamoDao, PrestamoVista prestamoVista) {
        this.prestamoDao = prestamoDao;
        this.prestamoVista = prestamoVista;
    }

    public void seleccionarUsuario(Usuario usuario){
        this.usuario=usuario;
    }
    
    public void seleccionarBiblioteca(Biblioteca biblioteca){
        this.biblioteca=biblioteca;
    }
    
    public void crearPrestamo() {
            prestamo = prestamoVista.ingresarNuevoPrestamo(usuario, biblioteca);
            if(prestamo!=null){
                prestamoDao.crearPrestamo(prestamo);
                usuario.solicitarPrestamo(prestamo);
                System.out.println("Libro Prestado");                
            }
    }
	
	public void devolucion() {
		boolean existe;
		
		Libro libro = prestamoVista.eliminarPrestamo(usuario);
		existe = prestamoDao.eliminarPrestamo(libro, usuario);
		if(existe) {
                        usuario.devolverLibro(libro);
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
