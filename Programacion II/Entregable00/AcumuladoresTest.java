package acumuladores;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AcumuladoresTest {

	Acumuladores acum;
	int[][] vacia = {};
	int[][] mat;
	int numExisteFilaDeMultiplos,
		numNoExisteFilaDeMultiplos, 
		numNegativo;

	int[][] matConInterseccionPorFila, 
		matSinInterseccionPorFila, 
		matConDistintaCantFilas;

	int columnaSumaMasQueCualquierFila, 
		columnaSumaMenosQueAlgunaFila, 
		columnaFueraDeRango;

	int[][] matConInterseccionPorColumna, 
		matSinInterseccionPorColumna, 
		matConDistintaCantColumnas;

	@Before
	public void setUp() throws Exception {
		acum = new Acumuladores();
		// Para todos los tests
		int[][] aux = { 
				{  1,  9,  6,  31 }, 
				{  9, 12, 18, 18 }, // todos multiplos de 3
				{ 15, 14,  9, 30 } };
		mat = aux;
		// Para TEST ej1
		numExisteFilaDeMultiplos = 3;
		numNoExisteFilaDeMultiplos = 5;
		numNegativo = -3;
		
		// Para TEST ej2
		int[][] aux2 = { 
				{  9, 12, 18 }, 
				{ 14,  9, 30 }, 
				{  9,  6,  2 } };
		matConInterseccionPorFila = aux2;
		int[][] aux3 = { 
				{  2, 18, 18 }, 
				{ 15, 14,  9 }, 
				{  1,  6,  2 } };
		matSinInterseccionPorFila = aux3;
		int[][] aux4 = { 
				{ 1,  9,  6, 31 }, 
				{ 9, 12, 18, 18 } };
		matConDistintaCantFilas = aux4;

		// Para TEST ej3
		columnaSumaMasQueCualquierFila = 3;
		columnaSumaMenosQueAlgunaFila = 1;
		columnaFueraDeRango = 4;

		// Para TEST ej4
		int[][] aux5 = { 
				{  9,  1,  2,  6 }, 
				{ 12, 15, 19, 18 }, 
				{ 14,  9, 18,  9 }, 
				{ 21, 22, 23, 24 } };
		matConInterseccionPorColumna = aux5;
		int[][] aux6 = { 
				{ 10,  1,  2,  6 }, 
				{ 12, 15, 19, 17 }, 
				{ 14, 13, 31,  9 }, 
				{ 21, 22, 23, 24 } };
		matSinInterseccionPorColumna = aux6;
		int[][] aux7 = { 
				{  1,  9,  6 }, 
				{  9, 12, 18 }, 
				{ 15, 14,  9 } };
		matConDistintaCantColumnas = aux7;
	}

	// ejercicio 1 todosMultiplosEnAlgunaFila()

	@Test
	public void ej1_siExisteFilaMultiplo_RetornaTrue() {
		assertTrue(acum.todosMultiplosEnAlgunaFila(mat, numExisteFilaDeMultiplos));
	}

	@Test
	public void ej1_siNoHayFilaMultiplo_RetornaFalse() {
		assertFalse(acum.todosMultiplosEnAlgunaFila(mat, numNoExisteFilaDeMultiplos));
	}

	@Test
	public void ej1_siMatrizVacia_RetornaFalse() {
		assertFalse(acum.todosMultiplosEnAlgunaFila(vacia, numExisteFilaDeMultiplos));
	}

	@Test
	public void ej1_siNumNoPositivo_RetornaFalse() {
		assertFalse(acum.todosMultiplosEnAlgunaFila(mat, numNegativo));
		assertFalse(acum.todosMultiplosEnAlgunaFila(mat, 0));
	}

	
	// ejercicio 2 hayInterseccionPorFila()
	@Test
	public void ej2_siHayinterseccionEnCadaFila_RetornaTrue() {
		assertTrue(acum.hayInterseccionPorFila(mat, mat));
		assertTrue(acum.hayInterseccionPorFila(mat, matConInterseccionPorFila));
		assertTrue(acum.hayInterseccionPorFila(matConInterseccionPorFila, mat));

	}

	@Test
	public void ej2_siNoHayInterseccionEnCadaFila_RetornaFalse() {
		assertFalse(acum.hayInterseccionPorFila(mat, matSinInterseccionPorFila));
		assertFalse(acum.hayInterseccionPorFila(matSinInterseccionPorFila, mat));
	}

	@Test
	public void ej2_siNoTienenMismaCantidadDeFilas_RetornaFalse() {
		assertFalse(acum.hayInterseccionPorFila(mat, matConDistintaCantFilas));
		assertFalse(acum.hayInterseccionPorFila(matConDistintaCantFilas, mat));
	}

	@Test
	public void ej2_siAlgunaMatrizVacia_RetornaFalse() {
		assertFalse(acum.hayInterseccionPorFila(mat, vacia));
		assertFalse(acum.hayInterseccionPorFila(vacia, mat));
		assertFalse(acum.hayInterseccionPorFila(vacia, vacia));
	}

	// ejercicio 3 algunaFilaSumaMasQueLaColumna()
	@Test
	public void ej3_siHayFilaQueSumeMasQueNumColumna_RetornaTrue() {
		assertTrue(acum.algunaFilaSumaMasQueLaColumna(mat, columnaSumaMenosQueAlgunaFila));
	}

	@Test
	public void ej3_siNoHayFilaQueSumeMasQueNumColumna_RetornaFalse() {
		assertFalse(acum.algunaFilaSumaMasQueLaColumna(mat, columnaSumaMasQueCualquierFila));
	}

	@Test
	public void ej3_siColumnaInvalida_RetornaFalse() {
		assertFalse(acum.algunaFilaSumaMasQueLaColumna(mat, columnaFueraDeRango));
		assertFalse(acum.algunaFilaSumaMasQueLaColumna(mat, -columnaFueraDeRango));
	}

	@Test
	public void ej3_siMatrizEstaVaciaRetornaFalse() {
		assertFalse(acum.algunaFilaSumaMasQueLaColumna(vacia, 0));
	}

	// ejercicio 4 hayInterseccionPorColumna()

	@Test
	public void ej4_siHayinterseccionEnCadaColumna_RetornaTrue() {
		assertTrue(acum.hayInterseccionPorColumna(mat, mat));
		assertTrue(acum.hayInterseccionPorColumna(mat, matConInterseccionPorColumna));
		assertTrue(acum.hayInterseccionPorColumna(matConInterseccionPorColumna, mat));

	}

	@Test
	public void ej4_siNoHayInterseccionEnCadaColumna_RetornaFalse() {
		assertFalse(acum.hayInterseccionPorColumna(mat, matSinInterseccionPorColumna));
		assertFalse(acum.hayInterseccionPorColumna(matSinInterseccionPorColumna, mat));
	}

	@Test
	public void ej4_siNoTienenMismaCantidadDeColumnas_RetornaFalse() {
		assertFalse(acum.hayInterseccionPorColumna(mat, matConDistintaCantColumnas));
		assertFalse(acum.hayInterseccionPorColumna(matConDistintaCantColumnas, mat));
	}

	@Test
	public void ej4_siAlgunaMatrizEstaVacia_RetornaFalse() {
		assertFalse(acum.hayInterseccionPorColumna(mat, vacia));
		assertFalse(acum.hayInterseccionPorColumna(vacia, mat));
		assertFalse(acum.hayInterseccionPorColumna(vacia, vacia));
	}
}
