package ec.edu.ups.vistas;

import ec.edu.ups.dao.LibroDaoImp;
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
	
	public Prestamo ingresarNuevoPrestamo (Usuario usuario) {
		LibroDaoImp libroDao = new LibroDaoImp();
		Date fechaDevolucion = null;
                LocalDate fechaActual = LocalDate.now();
                Date fechaDate = java.sql.Date.valueOf(fechaActual);
		
		System.out.println("                  Ingreso nuevo Prestamo");
		System.out.println("============================================================");
                System.out.println("Ingrese el nombre del libro: ");
                String titulo = sc.next();
                Libro libro = libroDao.obtenerLibro(titulo);
                if (libro.isDisponoible()==false) {
                    System.out.println("Libro no disponible!");
                    return null;
                }
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
	
	public Libro eliminarPrestamo() {
                LibroDaoImp libroDao = new LibroDaoImp();
		String nombre;		
		System.out.println("                     Devolucion de libro");
		System.out.println("============================================================");
		System.out.println("Ingrese el nombre del libro a devolver: ");
                nombre = sc.nextLine();
                Libro libro = libroDao.obtenerLibro(nombre);
		return libro;
	}
	
	
	public void mostrarDatosPrestamo(String titulo, String autor, int anho, boolean vigencia, Date fechaDev) {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                String fechaFormateada = formatoFecha.format(fechaDev);
		System.out.println("============================================================");
		System.out.println("Libro '"+titulo+"'");
		System.out.println("Autor: "+autor);
                System.out.println("Anho: "+anho);
                if (vigencia) {
                    System.out.println("Prestamo vigente hasta "+fechaDev);
                }else{
                    System.out.println("Vigencia expirada! Llamando a las autoridades");
                }
		System.out.println("============================================================");
	}
}
