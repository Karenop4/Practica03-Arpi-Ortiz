package ec.edu.ups.vistas;

import ec.edu.ups.modelo.Libro;
import ec.edu.ups.modelo.Prestamo;
import ec.edu.ups.modelo.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class PrestamoVista {
private Scanner sc;
	
	public PrestamoVista() {
		sc = new Scanner(System.in);
	}
	
	public Prestamo ingresarNuevoPrestamo (Libro libro, Usuario usuario) {
		Date fechaDevolucion = null;
                LocalDate fechaActual = LocalDate.now();
                Date fechaDate = java.sql.Date.valueOf(fechaActual);
		
		System.out.println("                  Ingreso nuevo Prestamo");
		System.out.println("============================================================");
                System.out.print("Ingrese la fecha de devolucion (formato: dd/MM/yyyy): ");
                String fechaIngresada = sc.next();

                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    fechaDevolucion = formatoFecha.parse(fechaIngresada);
                } catch (ParseException e) {
                    System.out.println("Error al analizar la fecha. Asegúrese de usar el formato dd/MM/yyyy.");
                }
		return new Prestamo(libro, usuario, fechaDate, fechaDevolucion);
        }
	
	public String eliminarPrestamo() {
		String nombre;
		
		System.out.println("                     Eliminar biblioteca");
		System.out.println("============================================================");
		System.out.println("Ingrese el nombre de la biblioteca: ");
		nombre = sc.nextLine();
		return nombre;
	}
	
	public String buscarPrestamo () {
		String nombre;
		
		System.out.println("                      Buscar prestamo");
		System.out.println("============================================================");
		System.out.println("Ingrese el nombre de la biblioteca: ");
		nombre = sc.nextLine();
		return nombre;
	}
	
	public void mostrarDatosPrestamo(String nombre, String direccion) {
		System.out.println("============================================================");
		System.out.println("Biblioteca '"+nombre+"'");
		System.out.println("Dirección: "+direccion);
		System.out.println("============================================================");
	}
}
