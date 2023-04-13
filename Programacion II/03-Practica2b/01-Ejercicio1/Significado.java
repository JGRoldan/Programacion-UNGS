package agenda;

public class Significado {

	private String nombre;
	private int telefono;
	private String direccion;
	
	public Significado(String i, int t, String d) {
		nombre = i;
		telefono = t;
		direccion = d;
	}
	public Significado() {}
	@Override
	public String toString() {
		return "Significado [nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + "]";
	}
	
	

}
