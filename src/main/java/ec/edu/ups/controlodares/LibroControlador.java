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
		libroDao.crearLibro(libro);
		biblioteca.registrarLibro(libro);
		System.out.println("Libro Creado");
	}
	
	public void actualizarLibro() {
		boolean existe;
		
		libro = libroVista.actualizarDatosLibro();
		existe = libroDao.actualizarLibro(libro.getTitulo(), libro, biblioteca);
		
		if(existe) {
			System.out.println("Usuario actualizado correctamente");
		}else {
			System.out.println("Usuario no encontrada");
		}
	}
	
	public void eliminarLibro() {
		boolean existe;
		
		String titulo = libroVista.eliminarLibro();
		existe = libroDao.eliminarLibro(titulo);
		biblioteca.eliminarLibro(libro);
		
		if(existe) {
			System.out.println("Libro eliminado correctamente");
		}else {
			System.out.println("Libro no encontrado");
		}
	}
	
	public void buscarLibro() {
		String titulo;
		Libro libro;
		
		titulo = libroVista.buscarLibro();
		libro = libroDao.obtenerLibro(titulo);
		
		if(libro == null) {
			System.out.println("Libro no encontrado");
		}else {
			libroVista.mostrarDatosLibro(libro.getTitulo(), libro.getAutor(), libro.getAnho(), libro.isDisponoible());
		}
	}
	
	public void listarLibros() {
		for (Libro libro : biblioteca.devolverListaLibros()) {
			libroVista.mostrarDatosLibro(libro.getTitulo(), libro.getAutor(), libro.getAnho(), libro.isDisponoible());
		}
	}
}
