package negocio.grafo;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Grafo {
	 private HashMap<Integer, TreeSet<Integer>> listaAdyacencia;

	    public Grafo() {
	        listaAdyacencia = new HashMap<>();
	    }

	    public void agregarVertice(int vertice) {
	        if (!listaAdyacencia.containsKey(vertice)) {
	            listaAdyacencia.put(vertice, new TreeSet<>());
	        }
	    }

	    public void agregarArista(int verticeOrigen, int verticeDestino) {
	        if (!contieneVertices(verticeOrigen, verticeDestino)) {
	        	throw new IllegalArgumentException("Alguno de los vertices no existe.");
	        }
	        listaAdyacencia.get(verticeOrigen).add(verticeDestino);
	        listaAdyacencia.get(verticeDestino).add(verticeOrigen);
	    }
	    
	    public Set<Integer> obtenerVertices() {
	        return listaAdyacencia.keySet();
	    }
	    
		public TreeSet<Integer> obtenerVecinos(int vertice) {
	        if (!listaAdyacencia.containsKey(vertice)) {
	        	return new TreeSet<>();
	        }
	        return listaAdyacencia.get(vertice);
	    }
		
	    boolean contieneVertices(int verticeOrigen, int verticeDestino) {
			return listaAdyacencia.containsKey(verticeOrigen) && listaAdyacencia.containsKey(verticeDestino);
		}

		public int tamano() {
			return listaAdyacencia.size();
		}

		public boolean esConexo() {
			if(this.tamano()==1)
				return true;
			
			for(int vertice : this.obtenerVertices())
				if(this.obtenerVecinos(vertice).size()==0)
					return false;
			
			return true;
		}
}
