package ec.edu.ups.vistas;

import ec.edu.ups.modelo.Biblioteca;
import ec.edu.ups.modelo.Prestamo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PrestamoVista {
private Scanner sc;
	
	public PrestamoVista() {
		sc = new Scanner(System.in);
	}
	
	public Prestamo ingresarNuevoPrestamo () {
		String libro;
		Date fechaDevolucion;
		
		System.out.println("                  Ingreso nuevo Prestamo");
		System.out.println("============================================================");
		System.out.println("Ingrese el nombre del libro a adquirir: ");
		libro = sc.nextLine();
                System.out.print("Ingrese la fecha de devolucion (formato: dd/MM/yyyy): ");
                String fechaIngresada = sc.next();

                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    fechaDevolucion = formatoFecha.parse(fechaIngresada);
                } catch (ParseException e) {
                    System.out.println("Error al analizar la fecha. Asegúrese de usar el formato dd/MM/yyyy.");
                }
		return new Prestamo(nombre, direccion);
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
