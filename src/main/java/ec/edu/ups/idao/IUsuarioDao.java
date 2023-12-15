package ec.edu.ups.idao;

import ec.edu.ups.modelo.Usuario;

public interface IUsuarioDao {
    	public void crearUsuario(Usuario usuario);
	public boolean actualizarUsuario(String id, Usuario usuario);
	public boolean eliminarUsuario(String id);
	public Usuario obtenerUsuario(String id);
}
