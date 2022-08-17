package practica_0;

public class Ejercicio23 {

	
	public static boolean puedenColocarse(String a,String b,String c) {
		if(a.charAt(1)==b.charAt(1) && a.charAt(3)==c.charAt(3)) return true;
		return false;
	}
	public static void main(String[] args) {
		
		String a="bueno";
		String b="jugo";
		String c="anana";
		System.out.println(puedenColocarse(a,b,c));
		
	}

}
