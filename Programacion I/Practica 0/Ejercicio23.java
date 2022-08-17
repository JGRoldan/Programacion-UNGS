package practica_0;

public class Ejercicio23 {

	
		public static boolean puedenColocarse(String a,String b,String c) {
		
		for(int i=0; i<b.length();i++) {
			if(a.indexOf(b.charAt(i))!= -1) { //ubicamos a en b
				i++; //salto un renglon
				
				for (int j=i+1;j<b.length();j++) {
					if(c.indexOf(b.charAt(j))!= -1) {//ubicamos c en b
						return true;
					}
				}
				return false;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		
		String a="jugo";
		String b="bueno";
		String c="anana";
		System.out.println(puedenColocarse(a,b,c));
		
	}

}
