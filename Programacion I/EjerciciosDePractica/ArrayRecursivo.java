package recursivo;

import java.util.Arrays;

public class ArrayRecursivo {

	public static int[] resto(int [] a) {
		int [] nuevo = new int[a.length-1];
		for (int i=1;i<a.length;i++) {
			nuevo[i-1] = a[i];
		}
		return nuevo;
	}
	//sumar elementos arr
	public static int imprimir(int [] arr) {
		if(arr.length==0) return 0;
		
		return arr[0] + imprimir(Arrays.copyOfRange(arr, 1, arr.length));
		//return arr[0] + imprimir(resto(arr));
	}
	
	//True si esta de menor a mayor
	public static boolean estaOrdenado(int [] arr) {
		if(arr.length==1) return true;
		if(arr[0]>arr[1]) return false;
		return estaOrdenado(resto(arr));
		
	}
	
	//Cantidad de apariciones
	public static int apariciones(int [] arr,int n) {
		if(arr.length==0) return 0;
		if(arr[0]==n) return 1 + apariciones(resto(arr),n);
		else return apariciones(resto(arr), n);
		
	}
	
	//Numero en arreglo
		public static boolean esta(int [] arr,int n) {
			if(arr.length==1) return false;
			if(arr[0]==n) return true;
			else return esta(resto(arr), n);
			
		}
	public static void main(String[] args) {
		int [] arr= {1,2,3,1,5};
		System.out.println("Suma de arr : " + imprimir(arr));
		System.out.println("Esta ordenado el array : " + estaOrdenado(arr));
		System.out.println("Cantidad de apariciones : " + apariciones(arr,1));
		System.out.println("Esta el numero en el arr : " + esta(arr,4));
		
	}

}
