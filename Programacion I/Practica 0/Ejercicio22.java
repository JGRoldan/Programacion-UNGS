package practica_0;

public class Ejercicio22 {

	public static int cuentaRepetidos(String s, char c) {
		int cont=0;
		
		for (int i=0;i<s.length();i++) {
			if(c == s.charAt(i)) {
				cont++;
			}
		}
		return cont;
	}
	
	public static String esSinRepetidos(String s) {
		int cantidad=0;
		String v="";
		for(int i=0;i<s.length();i++) {
			cantidad = cuentaRepetidos(s,s.charAt(i));
		
		}
		return v;
	}
	

	public static void main(String[] args) {
		System.out.println(esSinRepetidos("casos"));
	}

}
