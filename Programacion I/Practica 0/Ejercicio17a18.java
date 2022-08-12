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
		System.out.println("Ingrese una palabra: ");
		Scanner scan=new Scanner(System.in);
		return scan.nextLine();
	}
	public static void main(String[] args) {
		System.out.println(cantidadApariciones("oftalmologo",'o'));
		
		String user=userString().toLowerCase();
		System.out.println("La cantidad de vocales de " + user + " es: " + cantidadVocales(user));
		
		}
}

