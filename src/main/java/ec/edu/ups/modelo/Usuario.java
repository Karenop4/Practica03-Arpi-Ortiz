package ec.edu.ups.modelo;

public class Usuario extends Persona{
	private String correo;
	
	//Constructores
	public Usuario() {
		
	}
	public Usuario(String nombre, String identificacion, String correo) {
		super(nombre, identificacion);
		this.correo = correo;
	}
	
	//Getters y Setters
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}


	@Override
	public void mostrarInformacion() {
		// TODO Auto-generated method stub
		
	}
	
	
}
