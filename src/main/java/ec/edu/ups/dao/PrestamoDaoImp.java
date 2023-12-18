package ec.edu.ups.dao;

import ec.edu.ups.idao.IPrestamoDao;
import ec.edu.ups.modelo.Libro;
import ec.edu.ups.modelo.Prestamo;
import ec.edu.ups.modelo.Usuario;
import java.util.ArrayList;

public class PrestamoDaoImp implements IPrestamoDao {
    private UsuarioDaoImp usuarioDao;
    private Usuario usuario;
    private ArrayList <Prestamo> listaPrestamos;

    public PrestamoDaoImp() {
        listaPrestamos = new ArrayList();
    }
    
    
    public void crearPrestamo(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
    }

    public boolean eliminarPrestamo(Libro libro, Usuario usuario) {
        listaPrestamos = usuario.devolverListaPrestamos();
        int cont=0;
        for(Prestamo prestamoBuscado : listaPrestamos) {
                if(prestamoBuscado.getLibro().equals(libro)) {
                        listaPrestamos.remove(cont);
                        return true;
                }
                cont++;
        }
        return false;
    }

}
