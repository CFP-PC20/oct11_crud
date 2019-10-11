package model;

public class Usuarios {
	
	private int id;
	private String nombre, password, estado;
	
	public Usuarios (int i, String n, String p, String e) {
		id = i;
		nombre = n;
		password = p;
		estado = e;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPassword() {
		return password;
	}

	public String getEstado() {
		return estado;
	} 
	
}
