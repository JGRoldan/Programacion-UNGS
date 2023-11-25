package negocio.conjuntoDominante;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import negocio.grafo.Grafo;
import negocio.grafoJson.GrafoJson;

public class ConjuntoDominanteHolisticoTest {

	    private Map<Integer, GrafoJson> grafoJsonMap;
	    private Map<Integer, BufferedReader> readerMap;
	    private Map<Integer, Grafo> grafoMap;
	    private Map<Integer, Set<Integer>> conjuntoDominanteMap;

	    @Before
	    public void setUp() {
	        grafoJsonMap = new HashMap<>();
	        readerMap = new HashMap<>();
	        grafoMap = new HashMap<>();
	        conjuntoDominanteMap = new HashMap<>();

	        setUpGrafoJson("assets/data/grafo-5-vertices.json", 1);
	        setUpGrafoJson("assets/data/grafo-6-vertices.json", 2);
	        setUpGrafoJson("assets/data/grafo-8-vertices.json", 3);
	    }

	    @Test
	    public void conjuntoDominanteHolisticoCero() {
	    	assertEquals(ConjuntoDominanteHolistico.calcularConjuntoDominante(new Grafo()).size(),0);
	    }
	    
	    @Test
	    public void conjuntoDominanteUno() {
	    	Grafo grafo = new Grafo();
	    	grafo.agregarVertice(0);
	    	assertEquals(ConjuntoDominanteHolistico.calcularConjuntoDominante(grafo).size(),1);
	    }
	    
	    @Test
	    public void conjuntoDominanteHolisticoNoConexo() {
	    	Grafo grafo = new Grafo();
	    	grafo.agregarVertice(0);
	    	grafo.agregarVertice(1);
	    	grafo.agregarVertice(2);
	    	assertEquals(ConjuntoDominanteHolistico.calcularConjuntoDominante(grafo).size(),0);
	    }
	    
		@Test
		public void conjuntoNoDominanteGrafo5Vertices() {
			Set<Integer> conjDomEsperado = new HashSet<>(List.of(1,2));
			assertNotEquals(conjDomEsperado, conjuntoDominanteMap.get(1));
		}
		
		@Test
		public void conjuntoNoDominanteGrafo6Vertices() {
			Set<Integer> conjDomEsperado = new HashSet<>(List.of(2,5,3));
			assertNotEquals(conjDomEsperado, conjuntoDominanteMap.get(2));
		}
		
		@Test
		public void conjuntoNoDominanteGrafo8Vertices() {
			Set<Integer> conjDomEsperado = new HashSet<>(List.of(1,4,5,8));
			assertNotEquals(conjDomEsperado, conjuntoDominanteMap.get(3));
		}
	    
		@Test
		public void conjuntoDominanteGrafo5Vertices() {
			Set<Integer> conjDomEsperado = new HashSet<>(List.of(1));
			assertEquals(conjDomEsperado, conjuntoDominanteMap.get(1));
		}
		
		@Test
		public void conjuntoDominanteGrafo6Vertices() {
			Set<Integer> conjDomEsperado = new HashSet<>(List.of(2,5));
			assertEquals(conjDomEsperado, conjuntoDominanteMap.get(2));
		}
		
		@Test
		public void conjuntoDominanteGrafo8Vertices() {
			Set<Integer> conjDomEsperado = new HashSet<>(List.of(1,4,8));
			assertEquals(conjDomEsperado, conjuntoDominanteMap.get(3));
		}
		

	    private void setUpGrafoJson(String ruta, int numero) {
	        GrafoJson grafoJson = new GrafoJson(ruta);
	        grafoJsonMap.put(numero, grafoJson);

	        BufferedReader reader = grafoJson.leerJson();
	        readerMap.put(numero, reader);

	        Grafo grafo = grafoJson.crearGrafo(reader);
	        grafoMap.put(numero, grafo);

	        Set<Integer> conjuntoDominante = ConjuntoDominanteHolistico.calcularConjuntoDominante(grafo);
	        conjuntoDominanteMap.put(numero, conjuntoDominante);
	    }
}
