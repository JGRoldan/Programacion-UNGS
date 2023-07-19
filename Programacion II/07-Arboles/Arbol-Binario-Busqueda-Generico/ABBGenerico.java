package ABBGenerico;

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
	
}
