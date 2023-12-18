package ec.edu.ups.dao;

import java.util.ArrayList;

import ec.edu.ups.idao.IBibliotecaDao;
import ec.edu.ups.modelo.Biblioteca;
import ec.edu.ups.modelo.Libro;

public class BibliotecaDaoImp implements IBibliotecaDao {
	private ArrayList <Biblioteca> listaBibliotecas;
	
	//Constructor
	public BibliotecaDaoImp() {
		listaBibliotecas = new ArrayList();
	}

	
	
	@Override
	public void crearBiblioteca(Biblioteca biblioteca) {
		listaBibliotecas.add(biblioteca);
		
	}

	@Override
	public boolean actualizarBiblioteca(String nombre, Biblioteca biblioteca) {
		int cont=0;
		for(Biblioteca bibliotecaBuscada : listaBibliotecas) {
			if(bibliotecaBuscada.getNombre().equals(nombre)) {
				listaBibliotecas.set(cont, biblioteca);
				return true;
			}
			cont++;
		}
		return false;
	}

	@Override
	public boolean eliminarBiblioteca(String nombre) {
		int cont=0;
		for(Biblioteca bibliotecaBuscada : listaBibliotecas) {
			if(bibliotecaBuscada.getNombre().equals(nombre)) {
				listaBibliotecas.remove(cont);
				return true;
			}
			cont++;
		}
		return false;
	}

	@Override
	public Biblioteca obtenerBiblioteca(String nombre) {
		int cont=0;
		for(Biblioteca bibliotecaBuscada : listaBibliotecas) {
			if(bibliotecaBuscada.getNombre().equals(nombre)) {
				return bibliotecaBuscada;
			}
			cont++;
		}
		return null;
	}

	@Override
	public ArrayList<Biblioteca> obtenerListaBiblliotecas() {
		return listaBibliotecas;
	}

	
	
	
}
