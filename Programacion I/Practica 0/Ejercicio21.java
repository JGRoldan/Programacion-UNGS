package practica_0;

public class Ejercicio21 {

	public static int cuentaRepetidos(String s, char c) {
		int cont=0;
		
		for (int i=0;i<s.length();i++) {
			if(c == s.charAt(i)) {
				cont++;
			}
		}
		return cont;
	}
	
	public static boolean esSinRepetidos(String s) {
		int cantidad=0;
		for(int i=0;i<s.length();i++) {
			cantidad = cuentaRepetidos(s,s.charAt(i));
			if (cantidad>1)
				return false;
		}
		return true;
	}
	

	public static void main(String[] args) {
		String palabra="repetidos";
		palabra.replace(" ", "");
		String palabra2="reptidos";
		palabra2.replace(" ", "");
		
		System.out.println(esSinRepetidos(palabra));
		System.out.println(esSinRepetidos(palabra2));
	}

}
