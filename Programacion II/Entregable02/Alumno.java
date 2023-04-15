package estacionamiento;

public class Alumno {
	private int precio;
	private int capacidad;
	
	public Alumno() {
		precio = 5;
		capacidad = 50;
	}
	
	public int damePrecio() {
		return precio;
	}
	public int capacidad() {
		return capacidad;
	}
	
	public void restarEspacios() {
		capacidad--;
	}
	public void sumarEspacios() {
		capacidad++;
	}
	
	public int precioTotal(int entrada, int salida) {
		return (salida - entrada)*precio;
	}
}
