package ec.edu.ups.controlodares;

import ec.edu.ups.idao.IUsuarioDao;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vistas.UsuarioVista;

public class UsuarioControlador {
	private IUsuarioDao usuarioDao;
	private UsuarioVista usuarioVista;
	private Usuario usuario;
	
	//Constructor

        public UsuarioControlador(IUsuarioDao usuarioDao, UsuarioVista usuarioVista) {
            this.usuarioDao = usuarioDao;
            this.usuarioVista = usuarioVista;
        }

        public UsuarioControlador() {
        }
    

	
	public void crearUsuario() {
		usuario = usuarioVista.ingresarDatosUsuario();
		usuarioDao.crearUsuario(usuario);
	}
	
	public void actualizarUsuario() {
		boolean existe;
		
		usuario = usuarioVista.actualizarDatosUsuario();
		existe = usuarioDao.actualizarUsuario(usuario.getIdentificacion(), usuario);
		
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
	
}
