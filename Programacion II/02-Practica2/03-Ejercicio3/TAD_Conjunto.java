package tad_ej3;

import java.util.ArrayList;
//Conjunto sin utilizar HASHSET :(
import java.util.Collection;

public class TAD_Conjunto<T> {
	
	private ArrayList<T> elementos;
	private int indice;
	
	public TAD_Conjunto(){
		elementos = new ArrayList<>();
		indice=0;
	}
	
	public int indice() {
		return indice;
	}
	
	public boolean agregar(T elem) {
		if (pertenece(elem))
			return false;
		
		return elementos.add(elem); // https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#add-E-
	}

	public boolean quitar(T elem) {
		if (pertenece(elem) && indice > 0)
			indice--;
		return elementos.remove(elem); // https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#remove-java.lang.Object-
	}
	
	public boolean pertenece(T elem) {
		return elementos.contains(elem);
	}
	
	public T dameUno() {
		if (estaVacio())
			throw new RuntimeException("El conjunto esta vacio");
		
		if (indice >= tamanio())
			indice=0;
		
		return elementos.get(indice++);
	}
	
	public boolean estaVacio() {
		return tamanio()==0;
	}
	public int tamanio() {
		return elementos.size();
	}
	
	public void union(TAD_Conjunto<T> c){
		// union1: Destructiva
		
		for (T t : c.elementos) {
			agregar(c.dameUno());
		}
		
	}
	
	public TAD_Conjunto<T> union2(TAD_Conjunto<T> c){
		// union2: No debe tener Aliasing!
		TAD_Conjunto<T> ret = new TAD_Conjunto<T>();
		ret.union(this);
		ret.union(c);
		return ret;
	}
	
	public void interseccion(TAD_Conjunto<T> c){
		//Destructiva
		throw new RuntimeException("No se :(");
	} 
	public TAD_Conjunto<T> interseccion2(TAD_Conjunto<T> c){
		//No debe tener Aliasing
		throw new RuntimeException("No se :(");
	}
}
