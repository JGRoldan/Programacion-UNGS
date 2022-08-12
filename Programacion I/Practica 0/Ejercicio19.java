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
	
	public static void main(String[] args) {
		
		System.out.println(esAbecedaria("agil"));
		
	}

}
