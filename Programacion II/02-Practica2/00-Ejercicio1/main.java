package tad_ej1;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TAD_Nat entero = new TAD_Nat();
		entero.agregar(1);
		entero.agregar(2);
		entero.agregar(3);
		entero.agregar(4);
		entero.agregar(5);
		
		System.out.println(entero.toString());
		System.out.println("Suma de elementos: " + entero.sumar());
		
	}

}
