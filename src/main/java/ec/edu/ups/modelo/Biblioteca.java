package ec.edu.ups.modelo;

import java.util.ArrayList;

public class Biblioteca {
	private String nombre;
	private String direccion;
	private ArrayList <Usuario> listaUsuarios;
	
	//Constructores
	public Biblioteca() {
		listaUsuarios = new ArrayList();
	}
	public Biblioteca(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		listaUsuarios = new ArrayList();
	}
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	//Metodos
	public void registrarUsuario(Usuario usuario) {
		listaUsuarios.add(usuario);
	}
	
	@Override
	public String toString() {
		return "Biblioteca [nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	
	
	
}
