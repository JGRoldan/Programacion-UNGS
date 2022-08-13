package ejerciciosPracticas;

import java.util.Scanner;

public class Ejercicio17a18 {

	//---------EJERCICIO 17---------
	public static int cantidadApariciones(String s, char c) {
		int cantApariciones=0;
		for(int i=0;i<s.length();i++) {
			if (s.charAt(i)==c)
				cantApariciones++;
		}
		return cantApariciones;
	}
	
	
	//---------EJERCICIO 17---------
	public static int cantidadVocales(String s) {
		int cantVocales=0;
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='a' || 
			   s.charAt(i)=='e'	|| 
			   s.charAt(i)=='i' || 
			   s.charAt(i)=='o' || 
			   s.charAt(i)=='u') {
				cantVocales++;
			}
		}
		return cantVocales;
	}
	
	public static String userString() {
		Scanner scan=new Scanner(System.in);
		return scan.nextLine();
	}
	public static void main(String[] args) {
		System.out.println("Ingrese una palabra: ");
		String s=userString();
		System.out.println("Ingrese una letra: ");
		char c = userString().charAt(0);
		System.out.println(cantidadApariciones(s,c));
		
		System.out.println("Ingrese una palabra: ");
		String user=userString().toLowerCase();
		System.out.println("La cantidad de vocales de " + user + " es: " + cantidadVocales(user));
		
	}
}

