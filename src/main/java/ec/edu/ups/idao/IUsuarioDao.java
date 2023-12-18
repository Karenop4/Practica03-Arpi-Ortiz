package ec.edu.ups.idao;

import java.util.ArrayList;

import ec.edu.ups.modelo.Biblioteca;
import ec.edu.ups.modelo.Usuario;

public interface IUsuarioDao {
    public void crearUsuario(Usuario usuario);
	public boolean actualizarUsuario(String id, Usuario usuario, Biblioteca biblioteca);
	public boolean eliminarUsuario(String id);
	public Usuario obtenerUsuario(String id);
	public ArrayList <Usuario> obtenerListaUsuarios();
}
