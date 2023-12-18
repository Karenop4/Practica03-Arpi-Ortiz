package ec.edu.ups.controlodares;

import ec.edu.ups.idao.*;
import ec.edu.ups.modelo.*;
import ec.edu.ups.vistas.*;

public class LibroControlador {
	
	private ILibroDao libroDao;
	private LibroVista libroVista;
	private Libro libro;
	
	private Biblioteca biblioteca;
	
	public LibroControlador(ILibroDao libroDao, LibroVista libroVista) {
		this.libroDao = libroDao;
		this.libroVista = libroVista;
	}


	public void seleccionarBiblioteca(Biblioteca biblioteca) {
    	this.biblioteca = biblioteca;	
    }
	
	public void crearLibro() {
		libro = libroVista.ingresarDatosLibro();
		if(biblioteca != null) {
			biblioteca.registrarLibro(libro);
			libroDao.crearLibro(libro);
		}else {
			System.out.println("Error!! Biblioteca no encontrada");
		}
	}
	
	public void actualizarLibro() {
		libro = libroVista.actualizarDatosLibro();
		if(biblioteca != null) {
			
		}else {
			System.out.println("Error!! Biblioteca no encontrada");
		}
	}
}
