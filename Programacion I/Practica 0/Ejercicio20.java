package ejerciciosPracticas;

public class Ejercicio20 {

	public static boolean esCapicua(String s) {
		StringBuilder sb=new StringBuilder(s);
		if(sb.reverse().toString().equalsIgnoreCase(s))
			return true;
		return false;
	}
	
	public static boolean esCapicua2(String cadena) {
		String cadenaAlReves="";
		for(int i=0;i<cadena.length();i++) {
			cadenaAlReves = cadena.charAt(i) + cadenaAlReves;
		}
		
		if(cadenaAlReves.replace(" ", "").equalsIgnoreCase(cadena))
			return true;
		return false;
	}
	
	//NO TIENE QUE HABER "," O ACENTOS EN LAS PALABRAS
	public static void main(String[] args) {
		String frase="A luna ese anula".replace(" ","");
		System.out.println(esCapicua(frase));
		
		System.out.println(esCapicua2(frase));

	}

}
