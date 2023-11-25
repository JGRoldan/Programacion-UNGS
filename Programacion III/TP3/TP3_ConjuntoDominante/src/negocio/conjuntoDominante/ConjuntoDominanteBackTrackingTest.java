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

public class ConjuntoDominanteBackTrackingTest{
	
    private Map<Integer, Set<Integer>> conjuntoDominanteMap;

    @Before
    public void setUp() {
        conjuntoDominanteMap = new HashMap<>();

        setUpGrafo("assets/data/grafo-5-vertices.json", 1);
        setUpGrafo("assets/data/grafo-6-vertices.json", 2);
        setUpGrafo("assets/data/grafo-8-vertices.json", 3);
    }

    @Test
    public void conjuntoDominanteBacktrackingCero() {
    	assertEquals(ConjuntoDominanteBackTracking.calcularConjuntoDominanteBacktracking(new Grafo()).size(),0);
    }
    
    @Test
    public void conjuntoDominanteBacktrackingUno() {
    	Grafo grafo = new Grafo();
    	grafo.agregarVertice(0);
    	assertEquals(ConjuntoDominanteBackTracking.calcularConjuntoDominanteBacktracking(grafo).size(),1);
    }
    
    @Test
    public void conjuntoDominanteBacktrackingNoConexo() {
    	Grafo grafo = new Grafo();
    	grafo.agregarVertice(0);
    	grafo.agregarVertice(1);
    	grafo.agregarVertice(2);
    	assertEquals(ConjuntoDominanteBackTracking.calcularConjuntoDominanteBacktracking(grafo).size(),0);
    }
    
    @Test
    public void conjuntoDominanteBacktrackingGrafo5Vertices() {
        Set<Integer> conjDomEsperado = new HashSet<>(List.of(1));
        assertEquals(conjDomEsperado, conjuntoDominanteMap.get(1));
    }
    
    @Test
    public void conjuntoDominanteBacktrackingGrafo5VerticesIncorrecto() {
        Set<Integer> conjDomEsperado = new HashSet<>(List.of(2));
        assertNotEquals(conjDomEsperado, conjuntoDominanteMap.get(1));
    }

    @Test
    public void conjuntoDominanteBacktrackingGrafo6Vertices() {
        Set<Integer> conjDomEsperado = new HashSet<>(List.of(1, 5));
        assertEquals(conjDomEsperado, conjuntoDominanteMap.get(2));
    }
    
    @Test
    public void conjuntoDominanteBacktrackingGrafo6VerticesIncorrecto() {
        Set<Integer> conjDomEsperado = new HashSet<>(List.of(2, 5));
        assertNotEquals(conjDomEsperado, conjuntoDominanteMap.get(2));
    }

    @Test
    public void conjuntoDominanteBacktrackingGrafo8Vertices() {
        Set<Integer> conjDomEsperado = new HashSet<>(List.of(1, 5, 6));
        assertEquals(conjDomEsperado, conjuntoDominanteMap.get(3));
    }
    
    @Test
    public void conjuntoDominanteBacktrackingGrafo8VerticesIncorrecto() {
        Set<Integer> conjDomEsperado = new HashSet<>(List.of(1, 4, 8));
        assertNotEquals(conjDomEsperado, conjuntoDominanteMap.get(3));
    }

    private void setUpGrafo(String ruta, int numero) {
        GrafoJson grafoJson = new GrafoJson(ruta);
        BufferedReader reader = grafoJson.leerJson();
        Grafo grafo = grafoJson.crearGrafo(reader);

        Set<Integer> conjuntoDominante = ConjuntoDominanteBackTracking.calcularConjuntoDominanteBacktracking(grafo);
        conjuntoDominanteMap.put(numero, conjuntoDominante);
    }

}
