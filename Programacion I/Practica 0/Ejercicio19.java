package ejerciciosPracticas;

import java.util.Arrays;

public class Ejercicio19 {

	public static boolean esAbecedaria(String sInput) {
		
		//CONVIERTE EL STRING EN UN ARRAY DE CHAR'S
		char[] arr = sInput.toCharArray();
		//ORDENA EL ARRAY DE CHAR'S
		Arrays.sort(arr);
		
		//TRANSFORMA EL ARRAY A STRING 
		String outPut= new String(arr);
		
		if (sInput.equalsIgnoreCase(outPut))
			return true;
		return false;
	}
	
		//--------OTRA SOLUCION--------
	public static boolean abecedaria(String s) {
		String abecedario = "abcdefghijklmnopqrstuvwxyz";
		
		for(int i=0;i<s.length();i++) {
			if (pos(abecedario,s.charAt(i)) < i) {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		System.out.println(esAbecedaria("agil"));
		
		System.out.println(abecedaria("agil"));
		
	}

}
