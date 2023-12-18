package ec.edu.ups.modelo;

import java.util.ArrayList;

public class Biblioteca {
	private String nombre;
	private String direccion;
	private ArrayList <Usuario> listaUsuarios;
	private ArrayList <Libro> listaLibros;
	
	//Constructores
	public Biblioteca() {
		listaUsuarios = new ArrayList();
		listaLibros = new ArrayList();
	}
	public Biblioteca(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		listaUsuarios = new ArrayList();
		listaLibros = new ArrayList();
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
	

	public void registrarLibro(Libro libro) {
		listaLibros.add(libro);
	}
	
	public ArrayList<Libro> devolverListaLibros() {
		return listaLibros;
	}
	

    public ArrayList <Usuario> devolverListaUsuarios(){
        return listaUsuarios;
    }
    
    public void eliminarUsuario(Usuario usuario) {
    	listaUsuarios.remove(usuario);
    }
	
    public void actualizarUsuario(int pos, Usuario usuario) {
    	listaUsuarios.set(pos, usuario);
    }
	@Override
	public String toString() {
		return "Biblioteca [nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	
	
	
	
}
