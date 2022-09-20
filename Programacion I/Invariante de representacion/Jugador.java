package irep;

public class Jugador {

	String nombre;
	int dorsal;
	String posicion;
	int goles;
	
	public Jugador() {
		this.nombre = "---";
		this.dorsal = 0;
		this.posicion = "---";
		this.goles = 0;
	}
	public Jugador(String nombre, int dorsal, String posicion, int goles) {
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.posicion = posicion;
		this.goles = goles;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", \ndorsal=" + dorsal + ", \nposicion=" + posicion + ", \ngoles=" + goles + "]";
	}
	
}
