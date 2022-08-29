package practica_0;

public class Ejercicio34 {

	public static String nuevaCadena(String s) {
		if(s.length()==0) return "";
		return s.charAt(0) + "*" + nuevaCadena(s.substring(1));
	}
	public static void main(String[] args) {
		String s="hola";
		System.out.println("Antes: " + s);
		System.out.println("Despues: " +nuevaCadena(s));
	}

}
