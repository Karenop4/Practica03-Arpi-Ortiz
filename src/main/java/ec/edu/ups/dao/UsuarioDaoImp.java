package ec.edu.ups.dao;


import ec.edu.ups.idao.IUsuarioDao;
import ec.edu.ups.modelo.Biblioteca;
import ec.edu.ups.modelo.Usuario;
import java.util.ArrayList;

public class UsuarioDaoImp implements IUsuarioDao{
    
    private Biblioteca biblioteca;
    private  ArrayList <Usuario> listaUsuarios;
    
    public UsuarioDaoImp() {
    	listaUsuarios = new ArrayList();
    }
    

    @Override
    public boolean actualizarUsuario(String id, Usuario usuario, Biblioteca biblioteca) {
    	int cont=0;
		for(Usuario usuarioBuscado : listaUsuarios) {
			if(usuarioBuscado.getIdentificacion().equals(id)) {
				listaUsuarios.set(cont, usuarioBuscado);
				biblioteca.actualizarUsuario(cont, usuario);
				return true;
			}
			cont++;
		}
		return false;
    }

    @Override
    public boolean eliminarUsuario(String id) {
    	int cont=0;
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
		for(Usuario usuarioBuscado : listaUsuarios) {
			if(usuarioBuscado.getIdentificacion().equals(id)) {
				return usuarioBuscado;
			}
			cont++;
		}
		return null;        
    }


	@Override
	public void crearUsuario(Usuario usuario) {
		listaUsuarios.add(usuario);
	}


	@Override
	public ArrayList<Usuario> obtenerListaUsuarios() {
		return listaUsuarios;
	}

}
