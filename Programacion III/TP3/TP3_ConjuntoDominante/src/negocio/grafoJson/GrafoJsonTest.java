package negocio.grafoJson;

import org.junit.Before;
import org.junit.Test;

public class GrafoJsonTest {

private GrafoJson grafoJson;
	
	@Before
	public void setUp() {
		grafoJson = new GrafoJson(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void pathJSONInconrrecto(){
		String pathIncorrecto = "assets/data/grafo-no-existe.json";
		grafoJson = new GrafoJson(pathIncorrecto);
		grafoJson.leerJson();
	}
	
	@Test
	public void pathJSONConrrecto(){
		String pathIncorrecto = "assets/data/grafo-6-vertices.json";
		grafoJson = new GrafoJson(pathIncorrecto);
		grafoJson.leerJson();
	}

}
