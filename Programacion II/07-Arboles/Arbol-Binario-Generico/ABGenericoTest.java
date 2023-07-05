package ABGenerico;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ABGenericoTest {
	
	static ABGenerico<Integer> arbol;
	static int perteneceElem,
				noPerteneceElem,
				cantNodos,
				altura,
				hojas,
				minimoElem,
				maximoElem,
				nodosNoHojas,
				sumaDeHojas,
				sumaDeNoHojas,
				sumaDeInternos;
	static String inorden,
					preorden,
					postOrden;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		arbol = new ABGenerico<>();
		arbol.agregarNodo(50);
		arbol.agregarNodo(20);
		arbol.agregarNodo(30);
		arbol.agregarNodo(15);
		arbol.agregarNodo(2);
		arbol.agregarNodo(40);
		arbol.agregarNodo(55);
		arbol.agregarNodo(25);
		arbol.agregarNodo(10);
		arbol.agregarNodo(80);
		
		perteneceElem = 55;
		noPerteneceElem = 0;
		cantNodos = 10;
		altura = 6;
		hojas = 5;
		minimoElem = 2;
		maximoElem = 80;
		nodosNoHojas = 5;
		sumaDeHojas = 180;
		sumaDeNoHojas=147;
		sumaDeInternos = 97;
		inorden = "20 50 15 30 40 2 25 55 80 10 ";
		preorden = "50 20 30 15 2 40 55 25 10 80 ";
		postOrden = "20 15 40 25 80 10 55 2 30 50 ";
		
		
	}

	@Test
	public void testPertenece() {
		assertTrue(arbol.pertenece(perteneceElem));
	}
	@Test
	public void testNoPertenece() {
		assertFalse(arbol.pertenece(noPerteneceElem));
	}
	@Test
	public void testCantNodos() {
		assertEquals(cantNodos, arbol.cantNodos());
	}
	@Test
	public void testAltura() {
		assertEquals(altura, arbol.altura());
	}
	@Test
	public void testCantHojas() {
		assertEquals(hojas, arbol.cantHojas());
	}
	@Test
	public void testMinimoElem() {
		assertEquals(minimoElem, arbol.minimoElem());
	}
	@Test
	public void testMaximoElem() {
		assertEquals(maximoElem, arbol.maximoElem());
	}
	@Test
	public void testRecorridoInorden() {
		assertEquals(inorden, arbol.inOrden());
	}
	@Test
	public void testRecorridoPreorden() {
		assertEquals(preorden, arbol.preOrden());
	}
	@Test
	public void testRecorridoPostorden() {
		assertEquals(postOrden, arbol.postOrden());
	}
	@Test
	public void testBalanceado() {
		assertFalse(arbol.estaBalanceado());
	}
	@Test
	public void testCantNodosNoHojas() {
		assertEquals(nodosNoHojas, arbol.cantNodosNoHojas());
	}
	@Test
	public void testSumaHojas() {
		assertEquals(sumaDeHojas, arbol.sumaDeHojas());
	}
	@Test
	public void testSumaNoHojas() {
		assertEquals(sumaDeNoHojas, arbol.sumaDeNoHojas());
	}
	@Test
	public void testSumaDeInternos() {
		assertEquals(sumaDeInternos, arbol.sumaDeNodosInternos());
	}
}
