package com.auth;

public class Credencial {

	private String usurname;
	private String password;
	private static int secuencia = 100;
	
	
	
	public Credencial(String Nombre,String Apellidos, String password) {
		super();
		this.usurname = generarUsername(Nombre, Apellidos);
		this.password = password;
		this.secuencia ++;
	}
	
	public String getUsurname() {
		return usurname;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String generarUsername(String nombre, String apellido) {
		String parteNombre = nombre.length() >= 3 ? nombre.substring(0,3).toLowerCase() : nombre.toLowerCase()+secuencia;
		String parteApellido = apellido.length() >= 3 ? apellido.substring(0,3).toLowerCase() : apellido.toLowerCase();
		return parteNombre + parteApellido + (secuencia++);
	}
	
	public boolean esPasswordSegura() {
		
		boolean tieneMAy=false;
		boolean tieneNum=false;
		
		if(password.length()>=8) {
			
			for( int i=0;i<password.length();i++) {
				
				if(Character.isDigit(password.charAt(i))) {
					tieneNum=true;
				}
				else if(Character.isUpperCase(password.charAt(i))) {
					tieneMAy=true;
				}
			
			}
		
		}
		return tieneMAy && tieneNum;
	}
	
	public boolean comprobarPassword(String otra) {
		return this.password.equals(otra);
	}
	
}
