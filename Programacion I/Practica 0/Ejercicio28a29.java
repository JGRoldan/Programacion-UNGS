package practica_0;

public class Ejercicio28a29 {

	public static boolean estaOrdenado(int[] a) {
		boolean ordenado=true;
		
		for(int i=0;i<a.length-1;i++) {
			if (!(a[i] < a[i+1])) ordenado=false;
		}
		return ordenado;
	}
	
	
	public static double promedio(double[] a) {
		double prom=0;
		for(int i=0;i<a.length;i++) prom+=a[i];
		
		return prom/a.length;
	}
	
	
	public static void main(String[] args) {
		
		int[] intArray = new int[]{1,2,3,4,5};
		int[] intArray2 = new int[]{5,4,3,2,1};
		int[] intArray3 = new int[]{20,30,1,2};
		
		System.out.println("Array ordenado de menor a mayor: " + estaOrdenado(intArray));
		System.out.println("Array ordenado de menor a mayor: " + estaOrdenado(intArray2));
		System.out.println("Array ordenado de menor a mayor: " + estaOrdenado(intArray3));
		
		double[] promArr=new double[]{7.8,4.5,3.6,8.8};
		System.out.println("Promedio de array: " + promedio(promArr));

	}

}
