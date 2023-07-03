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
				maximoElem;
	
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

}
