package practica_0;

public class Ejercicio24 {

	public static boolean dobleCapicua(String s1, String s2) {
		boolean b1=true;
		boolean b2=true;
		for(int i=0; i<(s1.length())/2;i++) {
			if(s1.charAt(i) != s1.charAt(s1.length()-1-i)) {
				b1=false;
			}
		}
		for(int i=0; i<(s2.length())/2;i++) {
			if(s2.charAt(i) != s2.charAt(s2.length()-1-i)) {
				b2=false;
			}
		}
		if(b1 && b2) return true;
		return false;
	}
	
	//--------CON UN SOLO FOR--------
	public static boolean dobleCapicuaOptimizado(String s) {
		for(int i=0; i<(s.length())/2;i++) {
			if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(dobleCapicua("neuquen","oro"));
		
		if(dobleCapicuaOptimizado("neuquen") && dobleCapicuaOptimizado("oro")) System.out.println("TRUE");
		else System.out.println("FALSE");

	}

}
