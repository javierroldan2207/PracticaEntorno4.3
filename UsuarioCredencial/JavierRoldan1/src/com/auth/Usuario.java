package com.auth;
public class Usuario {
	private String nombre;
	private String apellidos;
	private String email;
	private int intentos;
	private Credencial credencial;
	
	public Usuario(String nombre, String apellidos,String Password) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.credencial = new Credencial(nombre, apellidos, Password);
	}
	
	public Usuario(String nombre, String apellidos,String Password,String email) {
		this(nombre,apellidos,Password);
		this.email= email;
	}

	public void setCredencial(Credencial credencial) {
		this.credencial = credencial;
	}
	
	public boolean esCuentaBloqueada(int intentos) {
		boolean estado= false;
		if (intentos >=3) {
			estado =true;
		}
		return estado;
	}
	
	public boolean esPasswordSegura() {
		
		return this.credencial.esPasswordSegura();
	
	}
	
	public boolean modificarPassword(String oldpass,String newpass,String newpassverif) {
		boolean estado = false;
		if(this.credencial.comprobarPassword(oldpass)&& !oldpass.equals(newpass) && newpass.equals(newpassverif)) {
			this.credencial.setPassword(newpass);
			estado=true;
		}
		return estado;
		
	}
	
	public boolean hacerLogin(String username, String password) {
		boolean estado = false;
		if(username.equals(this.credencial.getUsurname())){
			if( this.credencial.comprobarPassword(password)){
				estado=true;
			}
		}
		
		return estado;
	}
}
