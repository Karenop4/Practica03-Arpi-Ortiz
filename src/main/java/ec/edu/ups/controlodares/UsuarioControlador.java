package ec.edu.ups.controlodares;

import java.util.ArrayList;

import ec.edu.ups.dao.BibliotecaDaoImp;
import ec.edu.ups.idao.IBibliotecaDao;
import ec.edu.ups.idao.IUsuarioDao;
import ec.edu.ups.modelo.Biblioteca;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vistas.UsuarioVista;

public class UsuarioControlador {
	private IUsuarioDao usuarioDao;
	private UsuarioVista usuarioVista;
	private Usuario usuario;
	
	private Biblioteca biblioteca;
	
	//Constructor
    
	public UsuarioControlador(IUsuarioDao usuarioDao, UsuarioVista usuarioVista) {
		this.usuarioDao = usuarioDao;
		this.usuarioVista = usuarioVista;
	}

    
	
	public void seleccionarBiblioteca(Biblioteca biblioteca) {
    	this.biblioteca = biblioteca;
    }
    
    
	public void crearUsuario() {
		usuario = usuarioVista.ingresarDatosUsuario();
		usuarioDao.crearUsuario(usuario);
		biblioteca.registrarUsuario(usuario);
		System.out.println("Usuario Creado");
	}
	
	public void actualizarUsuario() {
		boolean existe;
		
		usuario = usuarioVista.actualizarDatosUsuario();
		existe = usuarioDao.actualizarUsuario(usuario.getIdentificacion(), usuario, biblioteca);
		
		if(existe) {
			System.out.println("Usuario actualizado correctamente");
		}else {
			System.out.println("Usuario no encontrada");
		}
	}
	
	public void eliminarUsuario() {
		boolean existe;
		
		String id = usuarioVista.eliminarUsuario();
		existe = usuarioDao.eliminarUsuario(id);
		biblioteca.eliminarUsuario(usuario);
		
		if(existe) {
			System.out.println("Usuario eliminado correctamente");
		}else {
			System.out.println("Usuario no encontrado");
		}
	}
	
	public void buscarUsuario() {
		String id;
		Usuario usuario;
		
		id = usuarioVista.buscarUsuario();
		usuario = usuarioDao.obtenerUsuario(id);
		
		if(usuario == null) {
			System.out.println("Usuario no encontrado");
		}else {
			usuarioVista.mostrarDatosUsuario(usuario.getNombre(), usuario.getCorreo(), usuario.getIdentificacion());
		}
	}
	
	public void listarUsuarios() {
		for (Usuario usuario : biblioteca.devolverListaUsuarios()) {
			usuarioVista.mostrarDatosUsuario(usuario.getNombre(),usuario.getCorreo(),usuario.getIdentificacion());
		}
	}
	
}
