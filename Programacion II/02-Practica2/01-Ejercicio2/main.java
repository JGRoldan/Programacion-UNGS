package tad_ej2;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TAD_Tupla<Integer, Integer> tupla = new TAD_Tupla<>(null,null);
		
		ArrayList<TAD_Tupla<Integer,Integer>> coordenadas = new ArrayList<>();
		
		coordenadas.add(new TAD_Tupla<>(20,30));
		coordenadas.add(new TAD_Tupla<>(80,50));
		
		for (TAD_Tupla<Integer, Integer> coord : coordenadas) {
			System.out.println(coord);
		}
		
	}

}
