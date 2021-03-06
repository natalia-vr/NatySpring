package com.natySpring.model;

public class CredencialesUsuario {
	
	// atributos
	private String nombreUsuario;
	private String passUsuario;
	
	// constructores	
	public CredencialesUsuario() {};	
	
	public CredencialesUsuario(String nombreUsuario, String passUsuario) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.passUsuario = passUsuario;
	}

	// getters y setters
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassUsuario() {
		return passUsuario;
	}

	public void setPassUsuario(String passUsuario) {
		this.passUsuario = passUsuario;
	}

	// toString()
	@Override
	public String toString() {	
		
		String cadena = "****************************************************** \n";
		
		return 	cadena +
				"Credenciales usuario : \\n " + nombreUsuario + " : \n " +
				cadena +
				"Nombre usuario : " + nombreUsuario + " \n " + 
				"Contrasena usuario : " + passUsuario + " \n " +				
				cadena
				;
	}	

}
