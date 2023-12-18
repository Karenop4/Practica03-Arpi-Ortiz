package ec.edu.ups.modelo;

import ec.edu.ups.interfaces.IPrestable;

public class Libro implements IPrestable{

	private String titulo;
	private String autor;
	private int anho;
	private boolean disponoible;
	
	
	//Constructores
	public Libro() {
		
	}

	public Libro(String titulo, String autor, int anho, boolean disponoible) {
		this.titulo = titulo;
		this.autor = autor;
		this.anho = anho;
		this.disponoible = disponoible;
	}
	
	//Getters y Setters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnho() {
		return anho;
	}

	public void setAnho(int anho) {
		this.anho = anho;
	}

	public boolean isDisponoible() {
		return disponoible;
	}

	public void setDisponoible(boolean disponoible) {
		this.disponoible = disponoible;
	}
	
	
	
	@Override
	public void prestar(Libro libro) {
		libro.setDisponoible(false);
		
	}
	@Override
	public void devolver(Libro libro) {
		libro.setDisponoible(false);
		
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", anho=" + anho + ", disponoible=" + disponoible + "]";
	}
}
