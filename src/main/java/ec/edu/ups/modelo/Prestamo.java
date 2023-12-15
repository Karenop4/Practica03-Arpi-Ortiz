package ec.edu.ups.modelo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
	
	//Constructores
    public Prestamo(Libro libro, Usuario usuario, Date fechaPrestamo, Date fechaDevolucion) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Prestamo() {
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    

	
    //Metodos
    public int calcularDiasPrestamo(){

        // Convertir las fechas a LocalDate
        LocalDate localDateInicio = fechaPrestamo.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDateFin = fechaDevolucion.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Calcular la duración entre las dos fechas
        Duration duracion = Duration.between(localDateInicio.atStartOfDay(), localDateFin.atStartOfDay());

        // Obtener la cantidad de días
        long dias = duracion.toDays();
        return (int) dias;
    }
    
    public boolean esPrestamoVigente(){
        Date fechaHoy = new Date();
        return fechaHoy.before(fechaDevolucion);
    }
    
    @Override
    public String toString(){
        return "Prestamo [libro: " + libro + ", usuario: " + usuario + ", fecha prestamo: " + fechaPrestamo + ", fecha devolucion: " + fechaDevolucion + "]";
    }

	@Override
	public int hashCode() {
		return Objects.hash(libro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prestamo other = (Prestamo) obj;
		return Objects.equals(libro, other.libro);
	}  

}
