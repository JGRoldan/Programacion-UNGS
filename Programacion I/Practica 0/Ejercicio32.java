package practica_0;

public class Ejercicio32 {
	
    public static void collatz(int n) {
    	System.out.print(n + " ");
        if (n == 1) return;
        else if (n % 2 == 0) collatz(n/2);
        else collatz((3*n) + 1);
    }

    public static void main(String[] args) {
        int n = 10;
        collatz(n);
    }
}
