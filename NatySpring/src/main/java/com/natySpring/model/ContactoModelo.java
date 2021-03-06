package com.natySpring.model;

public class ContactoModelo {
	
	// atributos 
	
	private int id;	
	private String nombre;	
	private String apellido;
	private String telefono;
	private String ciudad;
	
	// constructores
	
	public ContactoModelo() {}
	
	public ContactoModelo(int id, String nombre, String apellido, String telefono, String ciudad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.ciudad = ciudad;
	}
	
	// getters y setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	// toString()
	@Override
	public String toString() {
		
		String cadena = "****************************************************** \n";
		
		return 	cadena +
				"Contacto Modelo " + nombre + " : \n " +
				cadena +
				"Codigo : " + id + " \n " + 
				"Nombre : " + nombre + " \n " +
				"Apellido : " + apellido + " \n " +
				"Telefono : " + telefono + " \n " +
				"Ciudad : " + ciudad + " \n " +
				cadena
				;
	}	

}
