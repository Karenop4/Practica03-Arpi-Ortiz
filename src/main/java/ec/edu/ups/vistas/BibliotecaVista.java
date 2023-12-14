package ec.edu.ups.vistas;

import java.util.Scanner;

import ec.edu.ups.modelo.Biblioteca;

public class BibliotecaVista {
	private Scanner sc;
	
	public BibliotecaVista() {
		sc = new Scanner(System.in);
	}
	
	public Biblioteca ingresarDatosBiblioteca () {
		String nombre;
		String direccion;
		
		System.out.println("                  Ingreso nueva biblioteca");
		System.out.println("============================================================");
		System.out.println("Ingrese el nombre de la biblioteca: ");
		nombre = sc.nextLine();
		System.out.println("Ingrese la dirección de la biblioteca ''"+ nombre + "''");
		direccion = sc.nextLine();
		return new Biblioteca(nombre, direccion);
	}
	
	public Biblioteca actualizarDatosBiblioteca () {
		String nombre;
		String direccion;
		
		System.out.println("               Actualización datos biblioteca");
		System.out.println("============================================================");
		System.out.println("Ingrese el nombre de la biblioteca: ");
		nombre = sc.nextLine();
		System.out.println("Ingrese la dirección de la biblioteca ''"+ nombre + "''");
		direccion = sc.nextLine();
		return new Biblioteca(nombre, direccion);
	}
	
	public String eliminarBiblioteca () {
		String nombre;
		
		System.out.println("                     Eliminar biblioteca");
		System.out.println("============================================================");
		System.out.println("Ingrese el nombre de la biblioteca: ");
		nombre = sc.nextLine();
		return nombre;
	}
	
	public String buscarBiblioteca () {
		String nombre;
		
		System.out.println("                      Buscar biblioteca");
		System.out.println("============================================================");
		System.out.println("Ingrese el nombre de la biblioteca: ");
		nombre = sc.nextLine();
		return nombre;
	}
	
	public void mostrarDatosBiblioteca(String nombre, String direccion) {
		System.out.println("============================================================");
		System.out.println("Biblioteca '"+nombre+"'");
		System.out.println("Dirección: "+direccion);
		System.out.println("============================================================");
	}
}
