package ec.edu.ups.principal;

import java.util.Scanner;
import ec.edu.ups.controlodares.*;
import ec.edu.ups.dao.*;
import ec.edu.ups.idao.*;
import ec.edu.ups.vistas.*;

public class Principal {

	public static void main(String[] args) {
		IBibliotecaDao bibliotecaDao = new BibliotecaDaoImp();
		BibliotecaVista bibliotecaVista = new BibliotecaVista();
		BibliotecaControlador bibliotecaCont = new BibliotecaControlador(bibliotecaDao,bibliotecaVista);
		
		IUsuarioDao usuarioDao = new UsuarioDaoImp();
		UsuarioVista usuarioVista = new UsuarioVista();
		UsuarioControlador usuarioCont = new UsuarioControlador(usuarioDao,usuarioVista);
		
		Scanner sc = new Scanner(System.in);
		int opc;//opción menu
		
		do {
			System.out.println("            MENU");
			System.out.println("============================");
			System.out.println("1. Bibliotecas");
			System.out.println("2. Usuarios");
			System.out.println("3. Libros");
			System.out.println("4. Préstamos");
			System.out.println("5. Salir");
			System.out.println("============================");
			opc = sc.nextInt();
			
			switch(opc) {
				case 1: //Biblioteca
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
					break;
				case 2: //Usuario
					System.out.println("1. Crear Usuario");
					System.out.println("2. Actualizar Datos");
					System.out.println("3. Eliminar Usuario");
					System.out.println("4. Listar Usuarios");
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
					break;
				case 3: //Libro
					break;
				case 4: //Prestamo
					break;
				case 5:
					System.out.println("Programa terminado");
					break;
				default:
					System.out.println("ERROR!! Elija otra opción");
			}
			
		}while(opc!=5);
		
		
	}

}
