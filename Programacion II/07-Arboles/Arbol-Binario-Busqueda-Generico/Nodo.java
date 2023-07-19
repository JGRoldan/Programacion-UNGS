package ABBGenerico;

public class Nodo <T extends Comparable<T>> {
	
	private T elemento;
	Nodo<T> der,izq;
	public Nodo(T valor) {
		this.elemento=valor;
		this.izq = null;
		this.der = null;
	}
	
	public Nodo<T> consultarIzq(){
		return this.izq;
	}
	public Nodo<T> consultarDer(){
		return this.der;
	}
	
	public T consultarElem(){
		return this.elemento;
	}
	
	public void modificarNodo(T nodo) {
		this.elemento = nodo;
	}
	
	public void modificarIzq(Nodo<T> nodo) {
		this.izq = nodo;
	}
	public void modificarDer(Nodo<T> nodo) {
		this.der = nodo;
	}
}
