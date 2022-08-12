package ejerciciosPracticas;

public class Ejercicios10a15 {

	//---------EJERCICIO 10---------
	public static int sumatoria(int n) {
		int sumatoriaHastaN=0;
		for(int i=1;i<=n;i++) {
			sumatoriaHastaN+=i;
		};
		return sumatoriaHastaN;
	}
	
	//---------EJERCICIO 11---------
	public static int sumatoriaPares(int n) {
		int sumatoriaPar=0;
		for (int i=2;i<=n;i+=2) {
			sumatoriaPar+=i;
		}
		return sumatoriaPar;
	}
	
	//---------EJERCICIO 12---------
	public static double potencia(double x,int a) {
		return Math.pow(x, a);
	}
	
	//---------EJERCICIO 13---------
	public static int factorial(int n) {
		int factorial=1;
		if(n<0) {
			return -1;
		}else {
			for (int i=1;i<=n;i++) {
				factorial*=i;
			}
		}
		return factorial;
	}
	
	//---------EJERCICIO 14---------
	
	public static int cantCifras(int n) {
		int contCifras=0;
		while(n>0) {
			n/=10;
			contCifras++;
		}
		return contCifras;
	}
	
	//---------EJERCICIO 15---------
	
	public static boolean esDivisible(int n, int m) {
		if(n%m==0)
			return true;
		return false;
	}
	
	//-----------------------------------
	//---------------MAIN----------------
	//-----------------------------------
	public static void main(String[] args) {
		
		int ej_10 = sumatoria(8); //36 = 1+2+3+...+8
		int ej_11=sumatoriaPares(13);//42 = 2+4+6+...+12
		double ej_12=potencia(2.5,3);//15.625
		int ej_13=factorial(5);//120 = 5x4x3x2x1
		int ej_14 = cantCifras(12458); //5
		boolean ej_15=esDivisible(10,5); // TRUE
		
		System.out.println(ej_15);
	}

}
