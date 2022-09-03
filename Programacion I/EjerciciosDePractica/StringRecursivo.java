package recursivo;

public class StringRecursivo {

	//longitud de cadena
	public static int longitud(String s) {
		if(s.length()==0) return 0;
		return 1 + longitud(s.substring(1));
	}
	//string inverso
	public static String inverso(String s) {
		if(s.length()==0) return "";
		return  s.charAt(longitud(s)-1) + inverso(s.substring(0,s.length()-1));
	}
	//combinar caracteres
	public static String combinar(String s1, String s2) {
		if(s1.length()==0 || s2.length()==0) return "";
		if(s1.charAt(0)<s2.charAt(0)) return s1.charAt(0) + combinar(s1.substring(1), s2.substring(1));
		else return s2.charAt(0) + combinar(s1.substring(1), s2.substring(1));
	}
	//es abecedaria
	public static boolean abcededaria(String s1) {
		if(s1.length()==1) return true;
		if (s1.charAt(0)<s1.charAt(1)) return abcededaria(s1.substring(1));
		else return false;
		
	}
	public static void main(String[] args) {
		System.out.println("Longitud de cadena : " + longitud("hola"));
		System.out.println("Invierte cadena : " + inverso("hola"));
		System.out.println("Combinar caracter : " + combinar("abc","bbc"));
		System.out.println("Es abecedaria : " + abcededaria("adios"));

	}

}
