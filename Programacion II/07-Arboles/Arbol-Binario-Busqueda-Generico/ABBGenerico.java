package ABBGenerico;

import ABB.NodoInt;
import ABGenerico.Nodo;

public class ABBGenerico <T extends Comparable<T>>{
	
	private Nodo<T> raiz;
	
	public ABBGenerico() {
		this.raiz = null;
	}
	
	/**
	 * Agregar nodo en arbol binario de busqueda
	 * @param nodo
	 * 
	 * Complejidad
	 * 			Worst Case = O(n)
	 * 			Best Case  = O(Log(n))
	 */
	
	public void agregarNodo(T nodo) {
		this.raiz = agregarNodo(raiz , nodo);
	}
	
	private Nodo<T> agregarNodo(Nodo<T> nodo, T elem) {
		if(nodo == null) return new Nodo<T>(elem);
		
		if(nodo.consultarElem().compareTo(elem) > 0)
			nodo.modificarIzq(agregarNodo(nodo.consultarIzq(), elem));			
		else 
			nodo.modificarDer(agregarNodo(nodo.consultarDer(), elem));
		return nodo;
	}
	
	
	/**
	 * Imprimir el arbol
	 * @param level
	 * 
	 * Complejidad = O(n)
	 * 
	 */
	
	public void printBinaryTree(int level) {
		printBinaryTree(raiz, level);
	}
	private void printBinaryTree(Nodo<T> root, int level) {
		if (root == null)
			return;
		printBinaryTree(root.consultarDer(), level + 1);
		if (level != 0) {
			for (int i = 0; i < level - 1; i++)
				System.out.print(" |\t");
			System.out.println(" |------(" + root.consultarElem() + ")");
		} else
			System.out.println("(" + root.consultarElem() + ")");
		printBinaryTree(root.consultarIzq(), level + 1);
	}
	
	/**
	 * Pertenece nodo
	 * @param valor
	 * 
	 * Complejidad
	 * 			Worst Case = O(n)
	 * 			Best Case  = O(Log(n))
	 * @return
	 */
	public boolean pertenece(T valor) {
		return pertenece(raiz, valor);
	}
	
	private boolean pertenece(Nodo<T> nodo, T valor) {
		if(nodo == null) return false;
		if(nodo.consultarElem().compareTo(valor) == 0) return true;
		
		//O(log n) xq cada llamado recursivo es n/2
		if(nodo.consultarElem().compareTo(valor) < 0) return pertenece(nodo.consultarDer(), valor);
		else return pertenece(nodo.consultarIzq(), valor);
	}
	
	/**
	 * Encontrar maximo en un ABB
	 * @return
	 * 
	 * Complejidad
	 * 			Worst Case = O(n)
	 * 			Best Case  = O(Log(n))
	 */
	public int maximo() {
		return maximo(raiz);
	}
	
	private int maximo(Nodo<T> nodo) {
		if (nodo == null) return 0;
		if(nodo.consultarDer() == null) return (int)nodo.consultarElem();
	
		return maximo(nodo.consultarDer());
	}
	
	/**
	 * Encontrar minimo en un ABB
	 * @return
	 * 
	 * Complejidad
	 * 			Worst Case = O(n)
	 * 			Best Case  = O(Log(n))
	 */
	public int minimo() {
		return minimo(raiz);
	}
	
	private int minimo(Nodo<T> nodo) {
		if (nodo == null) return 0;
		if(nodo.consultarIzq() == null) return (int)nodo.consultarElem();
	
		return minimo(nodo.consultarIzq());
	}
	
	/**
	 * Altura de un arbol
	 * @return
	 * 
	 * Compejidad = O(n)
	 */
	
	public int altura() {
		return altura(raiz);
	}

	private int altura(Nodo<T> nodo) {
		if (nodo == null) {
			return 0;
		} else {
			return 1 + Math.max(altura(nodo.consultarIzq()), altura(nodo.consultarDer()));
		}
	}
	
	/**
	 * Cantidad de nodos
	 * @return
	 * 
	 * Complejidad = O(n)
	 * 	
	 */
	
	public int cantNodos() {
		if(raiz == null) return 0;
		return cantNodos(raiz);
	}
	
	private int cantNodos(Nodo<T> nodo) {
		if (nodo == null) return 0;
		return 1 + cantNodos(nodo.consultarDer()) + cantNodos(nodo.consultarIzq());
	}
	
	/**
	 * Determinar si un arbol esta balanceado
	 * @return
	 */
	
	public boolean estaBalanceado() {
		return estaBalanceado(raiz);
	}
	
	private boolean estaBalanceado(Nodo<T> nodo) {
		if (nodo == null) {
			return true;
		}
		//Definicion de arbol balanceado 
		return Math.abs(altura(nodo.consultarIzq()) - altura(nodo.consultarDer())) <= 1 && estaBalanceado(nodo.consultarIzq())
				&& estaBalanceado(nodo.consultarDer());
	}
	
	/**
	 * Invertir nodos
	 * 
	 * EJ:
	 * before reverseTree
	 * 		50
	 * 	   /  \
	 *    10   60
	 *    
	 * after
	 *    	50
	 * 	   /  \
	 *    60   10
	 *    
	 *    Complejidad = O(n)
	 */
	
	public void reverseTree() {
		reverseTree(raiz);
	}
	
	private void reverseTree(Nodo<T> nodo) {
		if(nodo == null) return;
		Nodo<T> temp = nodo.consultarIzq();
		nodo.modificarIzq(nodo.consultarDer());
		nodo.modificarDer(temp);
		
		reverseTree(nodo.consultarDer());
		reverseTree(nodo.consultarIzq());
	}
	
	
	//Recorrer un ABB en preOrden, postOrden o inOrden
	//es lo mismo que un AB. La complejidad en todos -> O(n)
	//Ejemplo inorden
	
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
	 * Nodos mayores a un elemento
	 * @param elem
	 * @return
	 * 
	 * Complejidad
	 * 			Worst Case = O(n)
	 * 			Best Case  = O(Log(n))
	 */
	
	public int mayoresQue(T elem) {
		return mayoresQue(raiz, elem);
	}

	private int mayoresQue(Nodo<T> nodo, T elem) {
		if (nodo == null) {
			return 0;
		}
		int contador = 0;
		
		if(nodo.consultarElem().compareTo(elem) > 0) {
			contador += 1 + mayoresQue(nodo.consultarIzq(), elem) + mayoresQue(nodo.consultarDer(), elem);
		}
		else {
			contador += mayoresQue(nodo.consultarDer(), elem);
		}
		
		return contador;
	}
	
	/**
	 * Imprimir nodos mayores un elemento
	 * @param elem
	 * @return
	 * 
	 * Complejidad =  O(n)
	 */
	
	public String imprimirMayoresA(T elem) {
		return imprimirMayoresA(raiz, elem);
	}
	
	private String imprimirMayoresA(Nodo<T> nodo, T elem) {
		if(nodo == null) return "";
		if(nodo.consultarElem().compareTo(elem) <= 0) {
			return imprimirMayoresA(nodo.consultarDer(), elem)+
			imprimirMayoresA(nodo.consultarIzq(), elem);
		}
		
		return " " + nodo.consultarElem()+
		imprimirMayoresA(nodo.consultarDer(), elem)+
		imprimirMayoresA(nodo.consultarIzq(), elem);
	}
	
	/**
	 * Suma de nodos internos
	 * @return
	 * 
	 * Complejidad = O(n)
	 */
	
	public int sumaInternos() {
		return (raiz == null) ? 0 : sumaInternos(raiz);
	}
	
	private int sumaInternos(Nodo<T> nodo) {
		if(nodo == null) {
			return 0;
		}	
		//NO tiene en cuenta la raiz
		if(nodo == raiz) {
			return sumaInternos(nodo.consultarIzq()) + sumaInternos(nodo.consultarDer());
		}
		if(nodo.consultarIzq() != null || nodo.consultarDer() != null) {
			return (int)nodo.consultarElem() + sumaInternos(nodo.consultarIzq()) + sumaInternos(nodo.consultarDer());
		}
		return 0;
	}
	
	/**
	 * Hojas mayores a un elemento
	 * @param elem
	 * @return
	 * 
	 * Complejidad = O(n)
	 */
	
	public int hojasMayoresA(T elem) {
		if (raiz == null) return 0;
		return hojasMayoresA(raiz, elem);
	}
	
	private int hojasMayoresA(Nodo<T> nodo, T elem) {
	    if (nodo == null) return 0;
	    int count = 0;
	    
	    if (nodo.consultarElem().compareTo(elem)>0) {
	        if (esHoja(nodo)) {
	            count = 1;
	        }
	        count += hojasMayoresA(nodo.consultarIzq(), elem) + hojasMayoresA(nodo.consultarDer(), elem);
	    } else {
	        count += hojasMayoresA(nodo.consultarDer(), elem);
	    }

	    return count;
	}
	
	private boolean esHoja(Nodo<T> n) {
		return n.consultarIzq() == null && n.consultarDer() == null;
	}

		/**
	 * Determinar la cantidad de nodos que tiene un subArbol
	 * @param elem
	 * @return
	 * 
	 * Compejidad = O(n)
	 */
	
	public int cantElementosEnSubArbol(T elem) {
		return cantElementosEnSubArbol(raiz, elem);
	}
	
	private int cantElementosEnSubArbol(Nodo<T> nodo, T elem) {
		if(nodo == null) return 0;
		
		if(nodo.consultarElem().equals(elem)) return cantNodos(nodo);
		
		if(nodo.consultarElem().compareTo(elem) < 0)
			return cantElementosEnSubArbol(nodo.consultarDer(), elem);
		
		return cantElementosEnSubArbol(nodo.consultarIzq(), elem); 
	}
	
}
