package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.Date;

public class Usuario extends Persona{
	private String correo;
	private ArrayList <Prestamo> listaPrestamos;
	
	//Constructores
	public Usuario() {
		this.listaPrestamos = new ArrayList();
	}
	public Usuario(String nombre, String identificacion, String correo) {
		super(nombre, identificacion);
		this.correo = correo;
		this.listaPrestamos = new ArrayList();
	}
	
	//Getters y Setters
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	//Metodos
	public void solicitarPrestamo(Libro libro, Usuario usuario, Date fechaPrestamo, Date fechaDevolucion) {//Creacion lista de préstamos
		Prestamo nuevoPrestamo = new Prestamo (libro, usuario, fechaPrestamo, fechaDevolucion);	
		listaPrestamos.add(nuevoPrestamo);
	}
	
	public void devolverLibro(Libro libro) {//Metodo para cuando el usuario devuelva el libro a la biblioteca
		if (libro.isDisponoible()==false) {
			libro.setDisponoible(true);
			Prestamo prestamo = new Prestamo();
			for(int i=0;i<listaPrestamos.size();i++) {
				prestamo=listaPrestamos.get(i);
				if(prestamo.getLibro().equals(libro)) {
					listaPrestamos.remove(i);
				}
			}
		}
	}
	
}
