package ABGenerico;

public class ABGenerico<T extends Comparable<T>>{
	private Nodo<T> raiz;
	
	public ABGenerico() {
		this.raiz = null;
	}
	
	/**
	 * Agregar Nodo
	 * 
	 * @param nodo
	 * Arbol generado : 
	 * 
	 *   X
	 *  / \
	 * X   X
	 *    / \
	 *   X   X
	 *    	/ \
	 *     X   X
	 */
	public void agregarNodo(T nodo) {
		this.raiz = agregarNodo(raiz , nodo);
	}
	
	private Nodo<T> agregarNodo(Nodo<T> nodo, T elem) {
		if(nodo == null) return new Nodo<T>(elem);
		
		//Rigth Skew Tree
		if(nodo.consultarIzq() == null) 
			nodo.modificarIzq(agregarNodo(nodo.consultarIzq(), elem));
		else 
			nodo.modificarDer(agregarNodo(nodo.consultarDer(), elem));
		
		return nodo;
	}
	
	/**
	 * Consultar si un elemento se 
	 * encuentra en el arbol
	 * 
	 * @param elem
	 * @return
	 * 
	 * Complejidad = O(n)
	 */
	public boolean pertenece(T elem) {
		return pertenece(raiz, elem);
	}
	
	private boolean pertenece(Nodo<T> nodo, T elem) {
		if (nodo == null) return false;
		if(nodo.consultarElem().equals(elem)) return true;
		return pertenece(nodo.consultarIzq(), elem) || pertenece(nodo.consultarDer(), elem);
	}
	
	/**
	 * Cantidad de nodos
	 * @return
	 * 
	 * Complejidad = O(n)
	 */
	public int cantNodos() {
		return cantNodos(raiz);
	}
	
	private int cantNodos(Nodo<T> nodo) {
		if(nodo == null) return 0;
		return 1 + cantNodos(nodo.consultarDer()) + cantNodos(nodo.consultarIzq());
	}
	
	/**
	 * Altura del arbol
	 * @return
	 * 
	 * Complejidad = O(n)
	 */
	public int altura() {
		return altura(raiz);
	}
	
	private int altura(Nodo<T> nodo) {
		if(nodo == null) return 0;
		return 1 + Math.max(altura(nodo.consultarDer()), altura(nodo.consultarIzq()));
	}
	
	/**
	 * Cantidad de hojas
	 * @return
	 * 
	 * Complejidad = O(n)
	 */
	public int cantHojas() {
		return cantHojas(raiz);
	}
	private int cantHojas(Nodo<T> nodo) {
		if(nodo == null) return 0;
		if(nodo.consultarDer() == null && nodo.consultarIzq() == null)
			return 1;
		return cantHojas(nodo.consultarDer()) + cantHojas(nodo.consultarIzq());
	}
	
	/**
	 * Minimo elemento del arbol
	 * @return
	 * 
	 * Complejidad = O(n)
	 */
	
	public int minimoElem() {
		return minimoElem(raiz,Integer.MAX_VALUE);
	}
	
	private int minimoElem(Nodo<T> nodo, int min) {
		if(nodo == null) return min;
		
		if((int)nodo.consultarElem() < min)
			min = (int) nodo.consultarElem();
		
		int minIzq = minimoElem(nodo.consultarIzq(), min);
		int minDer = minimoElem(nodo.consultarDer(),min);
		
		return Math.min(min, Math.min(minIzq, minDer));
	}
	
	/**
	 * Maximo elemento del arbol
	 * @return
	 * 
	 * Complejidad = O(n)
	 */
	
	public int maximoElem() {
		return maximoElem(raiz,Integer.MIN_VALUE);
	}
	
	private int maximoElem(Nodo<T> nodo, int max) {
		if(nodo == null) return max;
		
		if((int)nodo.consultarElem() > max)
			max = (int) nodo.consultarElem();
		
		int maxIzq = maximoElem(nodo.consultarIzq(), max);
		int maxDer = maximoElem(nodo.consultarDer(),max);
		
		return Math.max(max, Math.max(maxIzq, maxDer));
	}
	
	
	
	
	
	
	
}
