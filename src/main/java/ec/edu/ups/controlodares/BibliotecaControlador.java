package ec.edu.ups.controlodares;

import java.util.ArrayList;

import ec.edu.ups.idao.*;
import ec.edu.ups.modelo.*;
import ec.edu.ups.vistas.*;

public class BibliotecaControlador {
	private IBibliotecaDao bibliotecaDao;
	private BibliotecaVista bibliotecaVista;
	private Biblioteca biblioteca;
	
	//Constructor
	public BibliotecaControlador(IBibliotecaDao bibliotecaDao, BibliotecaVista bibliotecaVista) {
		this.bibliotecaDao = bibliotecaDao;
		this.bibliotecaVista = bibliotecaVista;
	}
	
	
	
	public void crearBiblioteca() {
		biblioteca = bibliotecaVista.ingresarDatosBiblioteca();
		bibliotecaDao.crearBiblioteca(biblioteca);
	}

	public void actualizarBiblioteca() {
		boolean existe;
		
		biblioteca = bibliotecaVista.actualizarDatosBiblioteca();
		existe = bibliotecaDao.actualizarBiblioteca(biblioteca.getNombre(), biblioteca);
		
		if(existe) {
			System.out.println("Biblioteca actualizada correctamente");
		}else {
			System.out.println("Biblioteca no encontrada");
		}
	}
	
	public void eliminarBiblioteca() {
		boolean existe;
		
		String nombre = bibliotecaVista.eliminarBiblioteca();
		existe = bibliotecaDao.eliminarBiblioteca(nombre);
		
		if(existe) {
			System.out.println("Biblioteca eliminada correctamente");
		}else {
			System.out.println("Biblioteca no encontrada");
		}
	}
	
	public void listarBibliotecas() {
		ArrayList <Biblioteca> listaBibliotecas = bibliotecaDao.obtenerListaBiblliotecas();
		for (Biblioteca biblioteca : listaBibliotecas) {
			bibliotecaVista.mostrarDatosBiblioteca(biblioteca.getNombre(), biblioteca.getDireccion());
		}
	}
}
