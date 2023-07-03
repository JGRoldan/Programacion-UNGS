package tano_construcciones;

public abstract class Persona {
	protected String nombre;
	protected String telefono;
	
	public Persona(String nombre, String telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}
}
