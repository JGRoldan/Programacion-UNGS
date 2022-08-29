package practica_0;

public class Ejercicio33 {

	public static int mcd(int a,int b) {
		if(b==0) return a;
		return mcd(b,a%b);
	}
	
	public static void main(String[] args) {
		int a=36;
		int b=20;
		System.out.println("El maximo comun divisor entre " + a +" y " + b + " es:");
		System.out.println(mcd(a,b));
	}

}
