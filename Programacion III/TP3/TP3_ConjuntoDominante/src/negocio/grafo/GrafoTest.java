package negocio.grafo;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class GrafoTest {
	
	private Grafo grafo;
	
	@Before
	public void setUp() {
		grafo = new Grafo();
		agregarVertices();
		agregarAristas();
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void agregarUnVerticeIncorrecto() {
		grafo.agregarArista(10, 1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void agregarDosVerticesIncorrectos() {
		grafo.agregarArista(10, 8);
	}
	
	@Test
	public void agregarVerticeCorrecto() {
		grafo.agregarArista(1, 6);	
	}
	
	@Test
	public void contieneVertice() {
		assertTrue(grafo.contieneVertices(1, 5));	
	}
	
	@Test
	public void noContieneUnVertice() {
		assertFalse(grafo.contieneVertices(0, 5));	
	}
	
	@Test
	public void noContieneDosVertice() {
		assertFalse(grafo.contieneVertices(0, 8));	
	}
	
	@Test
	public void obtenerVerticesCorrectos() {
        Set<Integer> verticesActuales = grafo.obtenerVertices();
        Set<Integer> verticesEsperados = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        
        assertEquals(verticesEsperados,verticesActuales);
	}
	
	@Test
	public void obtenerVerticesIncorrectos() {
        Set<Integer> verticesActuales = grafo.obtenerVertices();
        Set<Integer> verticesNoEsperados = new HashSet<>(Set.of(1, 2, 3, 4, 5));
        
        assertNotEquals(verticesNoEsperados,verticesActuales);
	}
	
	@Test
	public void obtenerVecinosCorrecto() {
		TreeSet<Integer> vecinosActuales = grafo.obtenerVecinos(1);
		TreeSet<Integer> vecinosEsperados = new TreeSet<>();
		vecinosEsperados.add(2);
		vecinosEsperados.add(3);
		
		assertEquals(vecinosEsperados,vecinosActuales);
	}
	
	@Test
	public void obtenerVecinosIncorrectos() {
		TreeSet<Integer> vecinosActuales = grafo.obtenerVecinos(1);
		TreeSet<Integer> vecinosNoEsperados = new TreeSet<>();
		vecinosNoEsperados.add(1);
		vecinosNoEsperados.add(2);
		
		assertNotEquals(vecinosNoEsperados,vecinosActuales);
	}
	
	private void agregarVertices() {
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);
	}
	
	private void agregarAristas() {
        grafo.agregarArista(6, 5);
        grafo.agregarArista(5, 6);
        grafo.agregarArista(5, 4);
        grafo.agregarArista(5, 3);
        grafo.agregarArista(4, 2);
        grafo.agregarArista(3, 2);
        grafo.agregarArista(3, 1);
        grafo.agregarArista(2, 1);
	}
}