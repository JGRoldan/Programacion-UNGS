package clasesPropias;

public class ClaseFecha {

	public static void main(String[] args) {
		Fecha f1 = new Fecha(5,1,2015);
		Fecha f2 = new Fecha(5,3,2015);
		Fecha f3 = new Fecha(2,2,2020);
		
		//System.out.println(Fecha.diasDelMes(2, 2016));
		
		//System.out.println(f1.esValida());
		
		//Avanzar dia,mes,año
		//System.out.println("Hoy: ");
		//f1.imprimir();
		//System.out.println("Mañana: ");
		//f1.avanzarDia();
		//f1.imprimir();
		//System.out.println();
		
		//Antes que otra fecha
		//System.out.println(f1.antesQue(f2));
		//System.out.println();
		
		//Dia del año a la fecha dada
		//System.out.println(f1.diaDelAnio());
		System.out.println(f1.diasDeDiferencia(f2));
	}

}
