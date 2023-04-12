package tad_ej5;

import java.util.ArrayList;

import tad_ej2.TAD_Tupla;
import tad_ej3.TAD_Conjunto;

public class TAD_Dicc<C,V> {

	private ArrayList<TAD_Tupla<C,V>> entradas;
	private TAD_Conjunto<C> clave;
	
	public TAD_Dicc(C key, V value) {
		entradas = new ArrayList<>();
		clave = new TAD_Conjunto<>();
	}
	
	public void agregar(C c, V v) {
		if(!pertenece(c)) {
			entradas.add(new TAD_Tupla<>(c,v));
			clave.agregar(c);
		}
		else {
			buscarEntrada(c).setElem2(v);
		}
	}
	
	private TAD_Tupla<C,V> buscarEntrada(C c){
		for(TAD_Tupla<C,V> e: entradas) {
			if(e.getElem1().equals(c))
				return e;
		}
		return null;
	}
	
	public boolean pertenece(C c) {
		return clave.pertenece(c);
	}
	
	public int tamanio() {
		return entradas.size();
	}
	
	public boolean estaVacio() {
		return tamanio() == 0;
	}

	public V obtener(C c) {
		if(!pertenece(c)) {
			return null;
		}
		return buscarEntrada(c).getElem2();
	}
	
	public void quitar(C c) {
		if(!pertenece(c)) {
			return;
		}
		TAD_Tupla<C, V> e = buscarEntrada(c);
		entradas.remove(e);
		clave.quitar(c);
		
	}
	
}
