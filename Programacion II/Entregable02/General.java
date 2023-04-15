package estacionamiento;

public class General {
	private int precio;
	private int capacidad;
	
	public General() {
		precio = 20;
		capacidad = 100;
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
