package negocio.grafoJson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;

import negocio.grafo.Grafo;

public class GrafoJson {
	    private Gson _gson;
	    private Grafo _grafo;
	    private String _JSONpath;

	    public GrafoJson(String jsonPath) {
	        this._gson = new Gson();
	        this._grafo = new Grafo();
	        this._JSONpath = jsonPath;
	    }
	    
	    public BufferedReader leerJson(){
	    	BufferedReader reader = null;
	        // Ruta absoluta del archivo utilizando ClassLoader
			ClassLoader classLoader = getClass().getClassLoader();
			InputStream inputStream = classLoader.getResourceAsStream(_JSONpath);

			// Verificar si se ha encontrado el archivo
			if (inputStream == null) {
			    throw new IllegalArgumentException("El archivo no se pudo encontrar en la ruta especificada.");
			}

			// Leer el JSON
			reader = new BufferedReader(new InputStreamReader(inputStream));
	        return reader;
	    }
	    
	    public Grafo crearGrafo(BufferedReader reader) {
	        try (reader) {
	            GrafoData grafoData = _gson.fromJson(reader, GrafoData.class);
	            agregarVertices(grafoData.getVertices());
	            agregarAristas(grafoData.getAristas());   
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return _grafo;
	    }
	    
	    private void agregarVertices(int[] vertices) {
			for (int vertice : vertices) {
				_grafo.agregarVertice(vertice);
			}
	    }

	    private void agregarAristas(Arista[] aristas) {
			for (Arista arista : aristas) {
				_grafo.agregarArista(arista.getOrigen(), arista.getDestino());
			}    		
	    }

	
}
