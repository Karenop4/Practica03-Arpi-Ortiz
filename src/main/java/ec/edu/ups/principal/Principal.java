package ec.edu.ups.principal;

import java.util.Scanner;
import ec.edu.ups.controlodares.*;
import ec.edu.ups.dao.*;
import ec.edu.ups.idao.*;
import ec.edu.ups.modelo.Biblioteca;
import ec.edu.ups.vistas.*;

public class Principal {

	public static void main(String[] args) {
		IBibliotecaDao bibliotecaDao = new BibliotecaDaoImp();
		BibliotecaVista bibliotecaVista = new BibliotecaVista();
		
		
		IUsuarioDao usuarioDao = new UsuarioDaoImp();
		UsuarioVista usuarioVista = new UsuarioVista();
		
		ILibroDao libroDao = new LibroDaoImp();
		LibroVista libroVista = new LibroVista();
		
		BibliotecaControlador bibliotecaCont = new BibliotecaControlador(bibliotecaDao,bibliotecaVista);
		UsuarioControlador usuarioCont = new UsuarioControlador(usuarioDao,usuarioVista);
		LibroControlador libroCont = new LibroControlador(libroDao, libroVista);
		
		Scanner sc = new Scanner(System.in);
		int opc;//opción menu
		
		do {
			System.out.println("            MENU");
			System.out.println("============================");
			System.out.println("1. Bibliotecas");
			System.out.println("2. Seleccionar Biblioteca");
			System.out.println("3. Salir");
			System.out.println("============================");
			opc = sc.nextInt();
			
			switch(opc) {
				case 1: //Biblioteca
					do {
						System.out.println("1. Crear Biblioteca");
						System.out.println("2. Actualizar Datos");
						System.out.println("3. Eliminar Biblioteca");
						System.out.println("4. Listar Bibliotecas");
						System.out.println("5. Volver");
						opc = sc.nextInt();
						
						switch(opc) {
							case 1:
								bibliotecaCont.crearBiblioteca();
								break;
							case 2:
								bibliotecaCont.actualizarBiblioteca();
								break;
							case 3:
								bibliotecaCont.eliminarBiblioteca();
								break;
							case 4:
								bibliotecaCont.listarBibliotecas();
								break;
							case 5:
								System.out.println("Regresando menu principal");
								break;
							default:
								System.out.println("Opción no válida");
						}
					}while(opc!=5);
					
					break;
				case 2: //Seleccionar Biblioteca
					modificarElementosBiblioteca(seleccionarBiblioteca(bibliotecaDao,bibliotecaCont,bibliotecaVista),usuarioCont,libroCont,null,sc);
					break;
				case 3:
					System.out.println("Programa terminado");
					break;
				default:
					System.out.println("ERROR!! Elija otra opción");
			}
			
		}while(opc!=3);
		
		
	}
	
	public static Biblioteca seleccionarBiblioteca(IBibliotecaDao bibliotecaDao, BibliotecaControlador bibliotecaControlador, BibliotecaVista bibliotecaVista) {
		
		String nombreBiblioteca;
		bibliotecaControlador.listarBibliotecas();
		nombreBiblioteca = bibliotecaVista.buscarBiblioteca();
		return bibliotecaDao.obtenerBiblioteca(nombreBiblioteca);
	}
	
	public static void modificarElementosBiblioteca(Biblioteca biblioteca, UsuarioControlador usuarioCont, LibroControlador libroCont, PrestamoControlador prestamoCont, Scanner sc) {
		int opc;
		
		do {
			System.out.println(biblioteca.getNombre());
			System.out.println("1.Usuarios");
			System.out.println("2.Libros");
			System.out.println("3.Prestamos");
			System.out.println("4.Volver menu principal");
			opc = sc.nextInt();
			switch(opc) {
				case 1:
					modificarUsuarios(biblioteca, usuarioCont, sc);
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				default:
					System.out.println("ERROR!! Elija otra opción");
			}
		}while(opc!=4);
		
	}
	
	public static void modificarUsuarios(Biblioteca biblioteca, UsuarioControlador usuarioCont, Scanner sc) {
		int opc;
		
		usuarioCont.seleccionarBiblioteca(biblioteca);
		do {
			System.out.println("1. Crear Usuario");
			System.out.println("2. Actualizar Datos");
			System.out.println("3. Eliminar Usuario");
			System.out.println("4. Listar Usuarios");
			System.out.println("5. Volver");
			opc = sc.nextInt();
			
			switch(opc) {
				case 1:
					usuarioCont.crearUsuario();
					break;
				case 2:
					usuarioCont.actualizarUsuario();
					break;
				case 3:
					usuarioCont.eliminarUsuario();
					break;
				case 4:
					usuarioCont.listarUsuarios();
					break;
				case 5:
					System.out.println("Volviendo...");
					break;
				default:
					System.out.println("ERROR!! Elija otra opción");
			}
		}while(opc!=5);
		
	}
	
	public static void modificarLibros(Biblioteca biblioteca, LibroControlador libroCont, Scanner sc) {
		libroCont.seleccionarBiblioteca(biblioteca);
		System.out.println("1. Crear Libro");
		System.out.println("2. Actualizar Datos");
		System.out.println("3. Eliminar Libro");
		System.out.println("4. Listar Libros");
		System.out.println("5. Volver");
		int opc = sc.nextInt();
		
		switch(opc) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				System.out.println("Volviendo...");
				break;
			default:
				System.out.println("ERROR!! Elija otra opción");
		}
	}
	
	public static void modificarPrestamos() {
		
	}
}
