package irep;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Jugador j=new Jugador();
		j.setNombre("Messi");
		j.setDorsal(10);
		j.setPosicion("Delantero");
		j.setGoles(5);
		
		Jugador j1=new Jugador();
		j1.setNombre("dibala");
		j1.setDorsal(21);
		j1.setPosicion("Delantero");
		j1.setGoles(2);		

		Seleccion s=new Seleccion();
		s.setPais("Argentina");
		s.setPartidosEmpatados(1);
		s.setPartidosGanados(2);
		s.setPartidosPerdidos(0);
		s.setPuntos(s.getPartidosEmpatados() + s.getPartidosGanados()*3);
		s.jugadores = new Jugador[2];
		s.jugadores[0] = j;
		s.jugadores[1] = j1;
		
		Seleccion s2=new Seleccion();
		s2.setPais("Brasil");
		s2.setPartidosEmpatados(1);
		s2.setPartidosGanados(2);
		s2.setPartidosPerdidos(0);
		s2.setPuntos(s2.getPartidosEmpatados() + s2.getPartidosGanados()*3);
		s2.jugadores = new Jugador[2];
		s2.jugadores[0] = j;
		s2.jugadores[1] = j1;
		
		Seleccion s3=new Seleccion();
		s3.setPais("Uruguay");
		s3.setPartidosEmpatados(1);
		s3.setPartidosGanados(2);
		s3.setPartidosPerdidos(0);
		s3.setPuntos(s3.getPartidosEmpatados() + s3.getPartidosGanados()*3);
		s3.jugadores = new Jugador[2];
		s3.jugadores[0] = j;
		s3.jugadores[1] = j1;
		
		Seleccion s4=new Seleccion();
		s4.setPais("Paraguay");
		s4.setPartidosEmpatados(1);
		s4.setPartidosGanados(2);
		s4.setPartidosPerdidos(0);
		s4.setPuntos(s4.getPartidosEmpatados() + s4.getPartidosGanados()*3);
		s4.jugadores = new Jugador[2];
		s4.jugadores[0] = j;
		s4.jugadores[1] = j1;
		
		//System.out.println(s.toString()); //TODA LA DATA
		
		//SOLO RECORRE JUGADORES
//		for(int i=0;i<s.jugadores.length;i++) {
//			System.out.println(s.jugadores[i]);
//		}
		
		Grupo g=new Grupo();
		g.setId('A');
		g.setNombre("Grupo "+ g.getId());
		g.selecciones = new Seleccion[4];
		//Aca van 4 equipos del grupo A
		g.selecciones[0] = s;
		g.selecciones[1] = s2;
		g.selecciones[2] = s3;
		g.selecciones[3] = s4;
		//Este array seria de 23 jugadores para saber los goles de todos
		g.goleadores = new Jugador[s.jugadores.length];
		g.goleadores[0] = j;
		g.goleadores[1] = j1;

		for(int i=0;i<g.selecciones.length;i++) {
			System.out.println(g.getNombre() +" " + g.selecciones[i].pais);
		}
		
		//Verifica quien hizo mas de 3 goles
//		for(int i=0;i<g.goleadores.length;i++) {
//			System.out.println(g.goleadores[i].getGoles()>3);
//		}
		
		//SOLO RECORRE JUGADORES con nombre y goles
		for(int i=0;i<g.goleadores.length;i++) {
			System.out.println(s.getPais()+ " " + g.goleadores[i].getNombre()+ " "+ g.goleadores[i].getGoles());
		}

		//System.out.println(g.toString()); //TODA LA DATA
		
	}

}
