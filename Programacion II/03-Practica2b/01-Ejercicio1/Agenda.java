package agenda;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Agenda {
	
	HashMap<Integer, Significado> diccionario;
	int index;
	
	public Agenda() {
		diccionario = new HashMap<>();
		index = 0;
	}
	
	public void agregar(int dni, Significado s) {
		if(dni<0)
			throw new RuntimeException("El numero debe ser mayor a 0");
		
		if(!estaElContacto(dni)) {
			diccionario.put(dni, s);
			index++;
		}
	}
	
	public void eliminar(int dni) {
		if(!estaElContacto(dni)) {
			throw new RuntimeException("El contacto no se encuentra en la agenda");
		}
		index--;
		diccionario.remove(dni);
	}
	
	public int tamanio() {
		return index;
	}
	public boolean estaVacio() {
		return tamanio()==0;
	}
	
	public Significado dameDatos(int dni) {
		if(!estaElContacto(dni)) {
			throw new RuntimeException("El contacto no se encuentra en la agenda");
		}
		return diccionario.get(dni);
	}
	
	private boolean estaElContacto(int dni) {
		return diccionario.containsKey(dni);
	}

	public Set<Entry<Integer, Significado>> dameTodos(){
		return diccionario.entrySet();
	}
	
	@Override
	public String toString() {
		return "Agenda [diccionario=" + diccionario + ", index=" + index + "]";
	}
}
