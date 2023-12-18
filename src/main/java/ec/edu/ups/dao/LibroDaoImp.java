package ec.edu.ups.dao;

import java.util.ArrayList;

import ec.edu.ups.idao.ILibroDao;
import ec.edu.ups.modelo.Biblioteca;
import ec.edu.ups.modelo.Libro;
import ec.edu.ups.modelo.Usuario;

public class LibroDaoImp implements ILibroDao{
	private BibliotecaDaoImp bibliotecaDao;
    private Biblioteca biblioteca;
    private ArrayList <Libro> listaLibros;
    
    
    public LibroDaoImp() {
    	listaLibros = new ArrayList();
    }
    
	@Override
	public void crearLibro(Libro libro) {
		listaLibros.add(libro);
	}

	@Override
	public boolean actualizarLibro(String titulo, Libro libro) {
		int cont=0;
		for(Libro libroBuscado : listaLibros) {
			if(libroBuscado.getTitulo().equals(titulo)) {
				listaLibros.set(cont, libroBuscado);
				return true;
			}
			cont++;
		}
		return false;
	}

	@Override
	public boolean eliminarLibro(String titulo) {
		int cont=0;
		for(Libro libroBuscado : listaLibros) {
			if(libroBuscado.getTitulo().equals(titulo)) {
				listaLibros.remove(cont);
				return true;
			}
			cont++;
		}
		return false;
	}

	@Override
	public Libro obtenerLibro(String titulo) {
		int cont=0;
		for(Libro libroBuscado : listaLibros) {
			if(libroBuscado.getTitulo().equals(titulo)) {
				return libroBuscado;
			}
			cont++;
		}
		return null;
	}

}
