package ec.edu.ups.dao;

import ec.edu.ups.idao.IUsuarioDao;
import ec.edu.ups.modelo.Biblioteca;
import ec.edu.ups.modelo.Usuario;
import java.util.ArrayList;

public class UsuarioDaoImp implements IUsuarioDao{
    
    private BibliotecaDaoImp bibliotecaDao;
    private Biblioteca biblioteca;
    
    public UsuarioDaoImp() {
    }
    
    
    @Override
    public void crearUsusario(Usuario usuario, String nombreBiblioteca) {
        this.biblioteca=bibliotecaDao.obtenerBiblioteca(nombreBiblioteca);
        biblioteca.registrarUsuario(usuario);
    }

    @Override
    public boolean actualizarUsuario(String id, Usuario usuario) {
    		int cont=0;
                ArrayList <Usuario> listaUsuarios = new ArrayList();
                listaUsuarios = biblioteca.devolverListaUsuarios();
		for(Usuario usuarioBuscado : listaUsuarios) {
			if(usuarioBuscado.getIdentificacion().equals(id)) {
				listaUsuarios.set(cont, usuarioBuscado);
				return true;
			}
			cont++;
		}
		return false;
    }

    @Override
    public boolean eliminarUsuario(String id) {
    		int cont=0;
                ArrayList <Usuario> listaUsuarios = new ArrayList();
                listaUsuarios = biblioteca.devolverListaUsuarios();
		for(Usuario usuarioBuscado : listaUsuarios) {
			if(usuarioBuscado.getIdentificacion().equals(id)) {
				listaUsuarios.remove(cont);
                                return true;
			}
			cont++;
		}
		return false;        
    }

    @Override
    public Usuario obtenerUsuario(String id) {
    		int cont=0;
                ArrayList <Usuario> listaUsuarios = new ArrayList();
                listaUsuarios = biblioteca.devolverListaUsuarios();
		for(Usuario usuarioBuscado : listaUsuarios) {
			if(usuarioBuscado.getIdentificacion().equals(id)) {
                                return usuarioBuscado;
			}
			cont++;
		}
		return null;        
    }

}
