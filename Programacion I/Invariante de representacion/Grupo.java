package irep;

import java.util.Arrays;

public class Grupo {

	char id;
	String nombre;
	Seleccion[] selecciones;
	Jugador[] goleadores;
	
	public Grupo() {

		this.id = '-';
		this.nombre = "---";
		this.selecciones = null;
		this.goleadores = null;
	}
	
	public Grupo(char id, String nombre, Seleccion[] selecciones, Jugador[] goleadores) {

		this.id = id;
		this.nombre = nombre;
		this.selecciones = selecciones;
		this.goleadores = goleadores;
	}

	public char getId() {
		return id;
	}

	public void setId(char id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Seleccion[] getSelecciones() {
		return selecciones;
	}

	public void setSelecciones(Seleccion[] selecciones) {
		this.selecciones = selecciones;
	}

	public Jugador[] getGoleadores() {
		return goleadores;
	}

	public void setGoleadores(Jugador[] goleadores) {
		this.goleadores = goleadores;
	}

	@Override
	public String toString() {
		return "Grupo [id= " + id + ", \nnombre=" + nombre + ", \nselecciones=" + Arrays.toString(selecciones)
				+ ", \ngoleadores=" + Arrays.toString(goleadores) + "]";
	}
	
	
	
	
}
