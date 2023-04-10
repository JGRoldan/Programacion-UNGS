package tad_ej2;

import java.util.ArrayList;

public class TAD_Tupla<K,V>{
	
	private K elem1;
	private V elem2;
	
	public TAD_Tupla(K key, V value) {
		this.elem1 = key;
		this.elem2 = value;
	}
	
	public K getElem1() {
		return elem1;
	}

	public void setElem1(K elem1) {
		this.elem1 = elem1;
	}

	public V getElem2() {
		return elem2;
	}

	public void setElem2(V elem2) {
		this.elem2 = elem2;
	}


	@Override
	public String toString() {
		return "Tupla [key=" + elem1 + ", value=" + elem2 + "]";
	}
	

}
