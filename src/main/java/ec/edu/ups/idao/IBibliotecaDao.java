package ec.edu.ups.idao;

import java.util.ArrayList;

import ec.edu.ups.modelo.Biblioteca;

public interface IBibliotecaDao {
	public void crearBiblioteca(Biblioteca biblioteca);
	public boolean actualizarBiblioteca(String nombre, Biblioteca biblioteca);
	public boolean eliminarBiblioteca(String nombre);
	public Biblioteca obtenerBiblioteca(String nombre);
	public ArrayList <Biblioteca> obtenerListaBiblliotecas();
}
