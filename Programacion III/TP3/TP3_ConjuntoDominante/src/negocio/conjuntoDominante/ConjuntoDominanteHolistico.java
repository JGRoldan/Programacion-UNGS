package negocio.conjuntoDominante;

import java.util.HashSet;
import java.util.Set;

import negocio.grafo.Grafo;

public class ConjuntoDominanteHolistico {
	
	public static Set<Integer> calcularConjuntoDominante(Grafo grafo) {
	    Set<Integer> conjuntoDominante = new HashSet<>();
	    Set<Integer> verticesNoCubiertos = new HashSet<>(grafo.obtenerVertices());
	    
	    if(!grafo.esConexo())
	    	return conjuntoDominante;

	    while (!verticesNoCubiertos.isEmpty()) {
	        int mejorVertice = encontrarMejorVertice(grafo, conjuntoDominante, verticesNoCubiertos);
	        if (mejorVertice == -1) {
	            // No se pudo encontrar un vertice que cubra todos los no cubiertos =>
	            break;
	        }

	        conjuntoDominante.add(mejorVertice);

	        // Actualiza los vertices no cubiertos, excluyendo los vecinos cubiertos por el vertice seleccionado.
	        for (int adyacente : grafo.obtenerVecinos(mejorVertice)) {
	            verticesNoCubiertos.remove(adyacente);
	        }
	        verticesNoCubiertos.remove(mejorVertice); // Eliminar el vertice seleccionado.
	    }
	    
	    return conjuntoDominante;
	}


	private static int encontrarMejorVertice(Grafo grafo, Set<Integer> conjuntoDominante, Set<Integer> verticesNoCubiertos) {
	    int mejorVertice = -1;
	    int maxNoCubiertos = -1;

	    for (int vertice : verticesNoCubiertos) {
	        int noCubiertos = contarVecinosNoCubiertos(grafo, vertice, conjuntoDominante, verticesNoCubiertos);
	        if (noCubiertos > maxNoCubiertos) {
	            maxNoCubiertos = noCubiertos;
	            mejorVertice = vertice;
	        }
	    }

	    return mejorVertice;
	}

	private static int contarVecinosNoCubiertos(Grafo grafo, int vertice, Set<Integer> conjuntoDominante, Set<Integer> verticesNoCubiertos) {
	    int contador = 0;
	    for (int adyacente : grafo.obtenerVecinos(vertice)) {
	        if (!conjuntoDominante.contains(adyacente) && verticesNoCubiertos.contains(adyacente)) {
	            contador++;
	        }
	    }
	    return contador;
	}
}
