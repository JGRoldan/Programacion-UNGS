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
	public static int pos(char c) {
		String abecedario = "abcdefghijklmnopqrstuvwxyz";
		int pos=0;
		for (int i=0;i<abecedario.length();i++) {
			if (c==abecedario.charAt(i)) pos=i;
		}
		return pos;
	}
	
	public static boolean abecedaria(String s) {
		
		for(int i=0;i<s.length()-1;i++) {
			if (pos(s.charAt(i)) > pos(s.charAt(i+1))) return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		System.out.println(esAbecedaria("agil"));
		
		System.out.println(abecedaria("agil"));
		
	}

}
