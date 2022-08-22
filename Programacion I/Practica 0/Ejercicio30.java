package practica_0;

public class Ejercicio30 {

	//---------EJERCICIO a---------
	public static int sumatoriaRec(int n) {
		if(n==1) return 1; //CASO BASE
		return n + sumatoriaRec(n-1);
	}
	
	//---------EJERCICIO b---------
	
	public static int sumatoriaParesRec(int n) {
		if (n<0) return 0; //CASO BASE
		//SI ES PAR QUE ALMACENE N 
		//Y LLAME A RECURSION RESTANDO -2 
		//PARA QUE TOME LOS PARES. SINO QUE RESTE -1 A N
		if (n%2==0) return n + sumatoriaParesRec(n-2);
		return sumatoriaParesRec(n-1);
	}
	
	//---------EJERCICIO c---------
	public static double potenciaRec(double base, int exponente) {
		if(exponente==0) return 1; //CASO BASE
		return base * potenciaRec(base,exponente-1);
		
		//----------EXPLICACION----------
		//base * potenciaRec(base,exponente-1)
		//i=0		2 * potenciaRec(2,4-1)
		//i=1		2 * potenciaRec(2,3-1)
		//i=2		2 * potenciaRec(2,2-1)
		//i=3		2 * potenciaRec(2,1-1)
		//exponente == 0 => return 1 => 2*2*2*2 = 16
	}	
	
	//---------EJERCICIO d---------
	public static int factorialRec(int n) {
		if(n<1) return 1;
		return n*factorialRec(n-1);
	}
	
	
	public static void main(String[] args) {
		//System.out.println(sumatoriaRec(10)); //36
		//System.out.println(sumatoriaParesRec(13)); //42
		//System.out.println(potenciaRec(2.0,4)); //16
		//System.out.println(factorialRec(5)); //120
	}

}
