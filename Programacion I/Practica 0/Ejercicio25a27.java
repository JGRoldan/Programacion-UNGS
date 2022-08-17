package practica_0;

public class Ejercicio25a27 {

	//---------EJERCICIO 25---------
	public static int maximo(int[] a) {
		int cont= 0;
		for (int i=0;i<a.length;i++) {
			if (a[i]>cont) {
				cont = a[i];
			}
		}
		return cont;
	}
	
	//---------EJERCICIO 26---------
	public static int maximoIndice(int[] a) {
		int cont=0;
		int idx= 0;
		for (int i=0;i<a.length;i++) {
			if (a[i]>cont) {
				cont=a[i];
				idx = i;
			}
		}
		return idx;
	}
	
	//---------EJERCICIO 27---------
	public static int sumatoria(int[] a) {
		int cont=0;
		for (int i=0;i<a.length;i++) {
				cont+=a[i];
			}
		return cont;
		}
	
	public static void main(String[] args) {

		int[] intArray = new int[]{5,180,8,25,90,120,30};
		System.out.println("Maximo numero en la lista: " + maximo(intArray));
		
		System.out.println("Maximo indice en la lista: " + maximoIndice(intArray));
		
		System.out.println("Suma de numeros en la lista: " + sumatoria(intArray));
	}

}
