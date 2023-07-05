package ABGenerico;

import ABgh.ABInt.NodoInt;

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
	
	/**
	 * Recorrido inorden
	 * izquierda - nodo - derecha
	 * @return
	 * 
	 * Complejidad = O(n)
	 */
	public String inOrden() {
		return inOrden(raiz);
	}
	
	private String inOrden(Nodo<T> nodo) {
		StringBuilder sb = new StringBuilder();
		if(nodo == null) return "";
		
		return sb.append(inOrden(nodo.consultarIzq()))
				.append(nodo.consultarElem()).append(" ")
				.append(inOrden(nodo.consultarDer()))
				.toString();
	}
	
	/**
	 * Recorrido preorden
	 * nodo - izquierda - derecha
	 * @return
	 * 
	 * Complejidad = O(n)
	 */
	public String preOrden() {
		return preOrden(raiz);
	}
	
	private String preOrden(Nodo<T> nodo) {
		StringBuilder sb = new StringBuilder();
		if(nodo == null) return "";
		
		return sb.append(nodo.consultarElem()).append(" ")
				.append(preOrden(nodo.consultarIzq()))
				.append(preOrden(nodo.consultarDer()))
				.toString();
	}
	
	/**
	 * Recorrido postorden
	 * izquierda - derecha - nodo
	 * @return
	 * 
	 * Complejidad = O(n)
	 */
	public String postOrden() {
		return postOrden(raiz);
	}
	
	private String postOrden(Nodo<T> nodo) {
		StringBuilder sb = new StringBuilder();
		if(nodo == null) return "";
		
		return sb.append(postOrden(nodo.consultarIzq()))
				.append(postOrden(nodo.consultarDer()))
				.append(nodo.consultarElem()).append(" ")
				.toString();
	}
	
	/**
	 * Arbol balanceado segun definicion
	 * @return
	 * 
	 * Complejidad = O(n)
	 */
	public boolean estaBalanceado() {
		return estaBalanceado(raiz);
	}
	
	private boolean estaBalanceado(Nodo<T> nodo) {
		if(nodo==null) return true;
		//Definicion de arbol balanceado
		return Math.abs(altura(nodo.izq) - altura(nodo.der)) >= 1 && estaBalanceado(nodo.izq)
				&& estaBalanceado(nodo.der);
	}
	
	/**
	 * Rama mas corta
	 * @return
	 * En este caso siempre es 2, por el 
	 * metodo agregar(nodo)
	 * 
	 * Complejidad = O(n)
	 */
	public int ramaMasCorta() {
		return ramaMasCorta(raiz);
	}

	private int ramaMasCorta(Nodo<T> nodo) {
		if (nodo.consultarIzq() == null && nodo.consultarDer() == null) {
			return 1;
		} else if (nodo.consultarIzq() == null) {
			return 1 + ramaMasCorta(nodo.consultarDer());
		} else if (nodo.consultarDer() == null) {
			return 1 + ramaMasCorta(nodo.consultarIzq());
		} else {
			return 1 + Math.min(ramaMasCorta(nodo.consultarIzq()), ramaMasCorta(nodo.consultarDer()));
		}
	}
	
	/**
	 * Imprimir nodos de un nivel dado 
	 * @param nivel
	 * @return
	 * 
	 * Complejidad = O(n)
	 */
	
	public String nodosDelNivel(int nivel) {
		if(raiz == null) 
			return "";
		return nodosDelNivel(raiz,nivel,1);
	}
	
	private String nodosDelNivel(Nodo<T> nodo,int nivel,int nivelActual) {
		StringBuilder sb = new StringBuilder();
		if(nodo == null) return sb.toString();
		if (nivel == nivelActual)
			return sb.append(nodo.consultarElem()).append(" ").toString();
		else
			return sb.append(nodosDelNivel(nodo.consultarIzq(),nivel,nivelActual+1))
						 .append(nodosDelNivel(nodo.consultarDer(),nivel,nivelActual+1)).toString();	
	}
	
	/**
	 * Cantidad de nodos no hojas contando la raiz
	 * @return
	 * 
	 * Complejidad = O(n)
	 */
	
	public int cantNodosNoHojas() {
		return cantNodosNoHojas(raiz);
	}
	
	private int cantNodosNoHojas(Nodo<T> nodo) {
		if (nodo == null) return 0;
		if(nodo.consultarIzq() != null || nodo.consultarDer() != null)
			return 1 + cantNodosNoHojas(nodo.consultarDer()) + cantNodosNoHojas(nodo.consultarIzq());
		else
			return 0;
	}
	
	/**
	 * Suma de nodos hoja
	 * @return
	 * 
	 * Complejidad = O(n)
	 */
	
	public int sumaDeHojas() {
		return sumaDeHojas(raiz);
	}
	
	private int sumaDeHojas(Nodo<T> nodo) {
		if (nodo == null) return 0;
		if(nodo.consultarIzq() == null && nodo.consultarDer() == null)
			return (int) nodo.consultarElem();
		return sumaDeHojas(nodo.consultarDer()) + sumaDeHojas(nodo.consultarIzq());
			
	}
	
	/**
	 * Imprimir hojas mayores a un elemento
	 * @return
	 * 
	 * Complejidad = O(n)
	 */
	
	public String imprimirHojasMayoresA(T elem) {
		return imprimirHojasMayoresA(raiz, elem);
	}
	
	private String imprimirHojasMayoresA(Nodo<T> nodo, T elem) {
		if (nodo == null) return "";
		if(nodo.consultarIzq() == null && nodo.consultarDer() == null)
			if(nodo.consultarElem().compareTo(elem) > 0)
				return nodo.consultarElem() + " ";
		return imprimirHojasMayoresA(nodo.consultarDer(), elem) + 
				imprimirHojasMayoresA(nodo.consultarIzq(),elem);
			
	}
	
	/**
	 * Suma de nodos NO hoja
	 * @return
	 * 
	 * Complejidad = O(n)
	 */
	
	public int sumaDeNoHojas() {
		return sumaDeNoHojas(raiz);
	}
	
	private int sumaDeNoHojas(Nodo<T> nodo) {
		if (nodo == null) return 0;
		if(nodo.consultarIzq() != null || nodo.consultarDer() != null)
			return (int) nodo.consultarElem() + sumaDeNoHojas(nodo.consultarDer()) + sumaDeNoHojas(nodo.consultarIzq());
		return sumaDeNoHojas(nodo.consultarDer()) + sumaDeNoHojas(nodo.consultarIzq());
			
	}
	
	/**
	 * Suma de nodos internos
	 * @return
	 * 
	 * Complejidad = O(n)
	 */
	public int sumaDeNodosInternos() {
		return sumaDeNodosInternos(raiz);
	}
	
	private int sumaDeNodosInternos(Nodo<T> nodo) {
		if(nodo == null) return 0;
		//Descarto la raiz
		if(nodo.equals(raiz)) 
			return sumaDeNodosInternos(nodo.consultarDer()) +
					sumaDeNodosInternos(nodo.consultarIzq());
		
		if(nodo.consultarDer() != null || nodo.consultarIzq() != null)
			return (int) nodo.consultarElem() + 
					sumaDeNodosInternos(nodo.consultarDer()) + 
					sumaDeNodosInternos(nodo.consultarIzq());
		return 0;
	}
	
	/**
	 * Cantidad de nodos con un hijo
	 * @return
	 * 
	 * Complejidad = O(n)
	 */
	
	public int nodosConUnHijo() {
		return nodosConUnHijo(raiz);
	}
	
	private int nodosConUnHijo(Nodo<T> nodo) {
		if(nodo == null) return 0;
		
		if(nodo.consultarDer() == null && nodo.izq != null)
			return 1 + nodosConUnHijo(nodo.consultarIzq()) ;
		if(nodo.consultarDer() != null && nodo.izq == null)
			return 1 + nodosConUnHijo(nodo.consultarDer());
		
		return nodosConUnHijo(nodo.consultarDer()) + nodosConUnHijo(nodo.consultarIzq());
	}
	
	
	/**
	 * Cambiar ppor hijo mayor
	 * 
	 * Complejidad = O(n)
	 */
	
    public void cambiarPorHijoMayor() {
    	cambiarPorHijoMayor(raiz);
    }
    
    private void cambiarPorHijoMayor(Nodo<T> nodo) {
    	if(nodo.consultarIzq() != null && nodo.consultarDer() != null) {
    		Nodo<T> maximoHijo = consultarMaximoHijo(nodo.consultarIzq(), nodo.consultarDer());
    		if(maximoHijo != null) {
    			T temp = nodo.consultarElem();
    			nodo.modificarNodo(maximoHijo.consultarElem());
    			maximoHijo.modificarNodo(temp);
    		}
    		cambiarPorHijoMayor(nodo.consultarIzq());
    		cambiarPorHijoMayor(nodo.consultarDer());
    	}
    
    }
    
    private Nodo<T> consultarMaximoHijo(Nodo<T> n1, Nodo<T> n2) {
    	if(n1.consultarElem().compareTo(n2.consultarElem())>0) return n1;
    	return n2;
    }
    
    /**
     * Nodos visitados hasta un elemento en preorden
     * @param elem
     * @return
     * 
     * Complejidad = O(n)
     */
    
    public int nodosVisitadosHasta(T elem) {
    	if (raiz == null) return 0;
    	if(!pertenece(elem)) return 0;
    	return nodosVisitadosHasta(raiz, elem);
    }
    
    private int nodosVisitadosHasta(Nodo<T> nodo, T elem) {
    	if(nodo == null) return 0;
    	if(nodo.consultarElem().equals(elem)) return 0;
    	return 1 + nodosVisitadosHasta(nodo.consultarIzq(), elem) + 
    			nodosVisitadosHasta(nodo.consultarDer(), elem);
    }

}
