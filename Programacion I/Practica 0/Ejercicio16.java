package ejerciciosPracticas;

import java.util.Scanner;

public class Ejercicio16 {

	//FUNCION QUE INVIERTE EL ORDEN DE LA CADENA
	public static void imprimirReversa(String cadena) {
		String cadenaAlReves="";
		for(int i=0;i<cadena.length();i++) {
			cadenaAlReves = cadena.charAt(i) + cadenaAlReves;
		}
		
		System.out.println(cadenaAlReves);
	}
	
	//FUNCION PARA INGRESAR DATOS POR TECLADO
	public static String datoUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese una palabra: ");
		return scan.nextLine();
	}
	
	public static void main(String[] args) {
		String user = datoUser();
		imprimirReversa(user);
	}

}
