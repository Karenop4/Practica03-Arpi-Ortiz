package ec.edu.ups.vistas;

import java.util.Scanner;

import ec.edu.ups.modelo.Libro;

public class LibroVista {
private Scanner sc;
	
	public LibroVista() {
		sc = new Scanner(System.in);
	}
	
	public Libro ingresarDatosLibro () {
        String titulo;
		String autor;
		int anho;
		boolean disponible;
		sc.nextLine(); // Limpiar el buffer
		System.out.println("                  Ingreso nuevo Libro");
		System.out.println("============================================================");
		System.out.println("Ingrese el titulo del libro: ");
		titulo = sc.nextLine();            
		System.out.println("Ingrese el el autor: ");
		autor = sc.nextLine();
		System.out.println("Ingrese el año de publicación: ");
		anho = sc.nextInt();
		System.out.println("El libro se encuentra disponible?\n1.Si   2.No");
		int opc = sc.nextInt();
		if(opc==1)
			disponible=true;
		else
			disponible=false;
		
		return new Libro(titulo,autor,anho,disponible);
	}
	
	public Libro actualizarDatosLibro () {
		String titulo;
		String autor;
		int anho;
		boolean disponible;
		sc.nextLine();
		System.out.println("                  Actualizar datos Libro");
		System.out.println("============================================================");
		System.out.println("Ingrese el titulo del libro: ");
		titulo = sc.nextLine();            
		System.out.println("Ingrese el el autor: ");
		autor = sc.nextLine();
		System.out.println("Ingrese el año de publicación: ");
		anho = sc.nextInt();
		System.out.println("El libro se encuentra disponible?\n1.Si   2.No");
		int opc = sc.nextInt();
		if(opc==1)
			disponible=true;
		else
			disponible=false;
		
		return new Libro(titulo,autor,anho,disponible);
	}
	
	public String eliminarLibro () {
		String titulo;
		
		System.out.println("                     Eliminar Libro");
		System.out.println("============================================================");
		System.out.println("Ingrese el titulo del libro: ");
		titulo = sc.nextLine();
		return titulo;
	}
	
	public String buscarLibro () {
		String titulo;
		
		System.out.println("                      Buscar Libro");
		System.out.println("============================================================");
		System.out.println("Ingrese el titulo del libro: ");
		titulo = sc.nextLine();
		return titulo;
	}
	
	public void mostrarDatosLibro(String titulo,String autor,int anho,boolean disponible) {
		System.out.println("============================================================");
        System.out.println("Título: "+titulo);
		System.out.println("Autor '"+autor);
		System.out.println("Año: "+anho);
		System.out.println("Disponible: "+ (disponible ? "Sí" : "No"));
		System.out.println("============================================================");
	}
}
