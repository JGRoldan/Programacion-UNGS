package practica_0;

public class Ejercicio35 {
	
	public static String noRep(String s) {
		if(s.length()==1) return s;
		if(s.charAt(0)==s.charAt(1)) return noRep(s.substring(1));
		return s.charAt(0) + noRep(s.substring(1));
	}
	public static void main(String[] args) {
		String s="hhhooolllaaaa";
		System.out.println("Antes: " + s);
		System.out.println("Despues: " +noRep(s));
	}

}
