package practica_0;

public class Ejercicio31 {

	public static int fibRec(int n) {
		if (n<=1) return n;
		else return fibRec(n-2) + fibRec(n-1);
	}
	public static void main(String[] args) {
		
		int n=6;
		System.out.print("Fibonacci de " + n +" : ");
		for(int i=0; i<=n;i++) {
			System.out.print(fibRec(i) + " ");
		}
		System.out.println("= "+fibRec(n));
	}
	

}
