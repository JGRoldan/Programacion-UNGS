package tad_ej1;
import java.util.LinkedList;

//[  TAD = datos + Operaciones  ]

//	operaciones:
//		agregar()
//		sumar()

// IREP
//	numeros >= 0

public class TAD_Nat {
	
	private LinkedList<Integer> nat;
	private int sumador=0;
	
	public TAD_Nat(){
		nat = new LinkedList<>();			
	}
	
	public void agregar(int n) {
		if(n<0) {
			throw new RuntimeException("El numero debe ser mayor a 0");
		}
		nat.add(n);
		sumador+=n;
	}

	//Al tener una variable que suma cada elemento al momento de 
	//agregarse => disminuyo la complejidad a O(1)
	//Sino habria que recorrer el linkedList => O(n)
	public int sumar() {
		return sumador;
	}
	
	@Override
	public String toString() {
		return "nat=" + nat;
	}
	
}



