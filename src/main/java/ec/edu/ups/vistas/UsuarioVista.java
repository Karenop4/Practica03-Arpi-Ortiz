package ec.edu.ups.vistas;

import ec.edu.ups.modelo.Usuario;
import java.util.Scanner;

public class UsuarioVista {
	private Scanner sc;
	
	public UsuarioVista() {
		sc = new Scanner(System.in);
	}
	
	public Usuario ingresarDatosUsuario () {
                String id;
		String nombre;
		String correo;
		
		System.out.println("                  Ingreso nuevo usuario");
		System.out.println("============================================================");
		System.out.println("Ingrese el id de la persona: ");
		id = sc.nextLine();            
		System.out.println("Ingrese el nombre de la persona: ");
		nombre = sc.nextLine();
		System.out.println("Ingrese el correo de la persona ");
		correo = sc.nextLine();
		return new Usuario(nombre, id ,correo);
	}
	
	public Usuario actualizarDatosUsuario () {
		String id;
		String nombre;
		String correo;
		
		System.out.println("                  Actualización del Usuario");
		System.out.println("============================================================");
		System.out.println("Ingrese el id de la persona: ");
		id = sc.nextLine();            
		System.out.println("Ingrese el nombre de la persona: ");
		nombre = sc.nextLine();
		System.out.println("Ingrese el correo de la persona ");
		correo = sc.nextLine();
		return new Usuario(nombre, id ,correo);
	}
	
	public String eliminarUsuario () {
		String id;
		
		System.out.println("                     Eliminar Usuario");
		System.out.println("============================================================");
		System.out.println("Ingrese el id del usuario: ");
		id = sc.nextLine();
		return id;
	}
	
	public String buscarUsuario () {
		String id;
		
		System.out.println("                      Buscar Usuario");
		System.out.println("============================================================");
		System.out.println("Ingrese el id de la persona: ");
		id = sc.nextLine();
		return id;
	}
	
	public void mostrarDatosUsuario(String nombre, String correo, String id) {
		System.out.println("============================================================");
                System.out.println("ID: "+id);
		System.out.println("Nombre '"+nombre);
		System.out.println("Correo: "+correo);
		System.out.println("============================================================");
	}
}
