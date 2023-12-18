package ec.edu.ups.principal;

import java.util.Scanner;
import ec.edu.ups.controlodares.*;
import ec.edu.ups.dao.*;
import ec.edu.ups.idao.*;
import ec.edu.ups.modelo.Biblioteca;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vistas.*;

public class Principal {

	public static void main(String[] args) {
		IBibliotecaDao bibliotecaDao = new BibliotecaDaoImp();
		BibliotecaVista bibliotecaVista = new BibliotecaVista();
		
		IUsuarioDao usuarioDao = new UsuarioDaoImp();
		UsuarioVista usuarioVista = new UsuarioVista();
		
		ILibroDao libroDao = new LibroDaoImp();
		LibroVista libroVista = new LibroVista();
                
                IPrestamoDao prestamoDao = new PrestamoDaoImp();
                PrestamoVista prestamoVista = new PrestamoVista();
		
		BibliotecaControlador bibliotecaCont = new BibliotecaControlador(bibliotecaDao,bibliotecaVista);
		UsuarioControlador usuarioCont=new UsuarioControlador(usuarioDao,usuarioVista);
		LibroControlador libroCont = new LibroControlador(libroDao, libroVista);
                PrestamoControlador prestamoCont = new PrestamoControlador(prestamoDao, prestamoVista);
		
		Scanner sc = new Scanner(System.in);
		int opc;//opción menu
		
		do {
			System.out.println("            MENU");
			System.out.println("============================");
			System.out.println("1. Biblioteca");
			System.out.println("2. Seleccionar Biblioteca");
			System.out.println("3. Salir");
			System.out.println("============================");
			opc = sc.nextInt();
			
			switch(opc) {
				case 1: //CRUD Biblioteca
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
					
					//Busca y devuelve una biblioteca
					Biblioteca biblioteca = new Biblioteca();
					String nombre = bibliotecaVista.buscarBiblioteca();
			    	biblioteca = bibliotecaDao.obtenerBiblioteca(nombre);
					
			    	//Cada controlador selecciona la biblioteca
			    	usuarioCont.seleccionarBiblioteca(biblioteca);
					libroCont.seleccionarBiblioteca(biblioteca);
                                        prestamoCont.seleccionarBiblioteca(biblioteca);
					
					
					do {
						System.out.println("1.Usuarios");
						System.out.println("2.Libros");
						System.out.println("3.Préstamos");
						System.out.println("4.Volver menu principal");
						opc = sc.nextInt();
						switch(opc) {
							
							case 1://Crud Usuario por biblioteca
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
								break;
							case 2://Crud Libro por biblioteca
								do {
									System.out.println("1. Crear Libro");
									System.out.println("2. Actualizar Datos");
									System.out.println("3. Eliminar Libro");
									System.out.println("4. Listar Libros");
									System.out.println("5. Volver");
									opc = sc.nextInt();
									
									switch(opc) {
										case 1:
											libroCont.crearLibro();
											break;
										case 2:
											libroCont.actualizarLibro();
											break;
										case 3:
											libroCont.eliminarLibro();
											break;
										case 4:
											libroCont.listarLibros();
											break;
										case 5:
											System.out.println("Volviendo...");
											break;
										default:
											System.out.println("ERROR!! Elija otra opción");
									}
								}while(opc!=5);
								break;
							case 3://Prestamo
                                                            Usuario usuario = new Usuario();
                                                            String id = usuarioVista.buscarUsuario();
                                                            usuario = usuarioDao.obtenerUsuario(id);
                                                            prestamoCont.seleccionarUsuario(usuario);
                                                                if(usuario!=null){


                                                                    do{
                                                                            System.out.println("1. Solicitar un prestamo");
                                                                            System.out.println("2. Devolver un libro");
                                                                            System.out.println("3. Listar Prestamos");
                                                                            System.out.println("4. Volver al menú principal");
                                                                            opc = sc.nextInt();

                                                                            switch (opc) {
                                                                            case 1:
                                                                                prestamoCont.crearPrestamo();
                                                                                break;
                                                                            case 2:
                                                                                prestamoCont.devolucion();
                                                                                break;
                                                                            case 3:
                                                                                prestamoCont.listarPrestamos();
                                                                                break;
                                                                            case 4:
                                                                                System.out.println("Volviendo...");
                                                                                break;
                                                                            default:
                                                                                System.out.println("ERROR!! Elija otra opción");
                                                                            }
                                                                    }while(opc!=4);
                                                                }else{
                                                                    System.out.println("El usuario no existe");
                                                                }
								break;
							case 4:
                                                                System.out.println("Volviendo al menú principal...");
								break;
							default:
								System.out.println("ERROR!! Elija otra opción");
						}
					}while(opc!=4);
					break;
				case 3:
					System.out.println("Programa terminado");
					break;
				default:
					System.out.println("ERROR!! Elija otra opción");
			}
			
		}while(opc!=3);
		
		sc.close();
	}
}
