package irep;

import java.util.Arrays;

public class Seleccion {

	String pais;
	Jugador[] jugadores;
	int puntos,partidosGanados,partidosEmpatados,
		partidosPerdidos,partidosJugados;
	
	public Seleccion() {
		this.pais = "---";
		this.jugadores = null;
		this.puntos = 0;
		this.partidosGanados = 0;
		this.partidosEmpatados = 0;
		this.partidosPerdidos = 0;
		this.partidosJugados = 0;
	}
	
	public Seleccion(String pais, Jugador[] jugadores, int puntos, int partidosGanados, int partidosEmpatados,
			int partidosPerdidos, int partidosJugados) {
		this.pais = pais;
		this.jugadores = jugadores;
		this.puntos = puntos;
		this.partidosGanados = partidosGanados;
		this.partidosEmpatados = partidosEmpatados;
		this.partidosPerdidos = partidosPerdidos;
		this.partidosJugados = partidosJugados;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Jugador[] getJugadores() {
		return jugadores;
	}

	public void setJugadores(Jugador[] jugadores) {
		this.jugadores = jugadores;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getPartidosGanados() {
		return partidosGanados;
	}

	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}

	public int getPartidosEmpatados() {
		return partidosEmpatados;
	}

	public void setPartidosEmpatados(int partidosEmpatados) {
		this.partidosEmpatados = partidosEmpatados;
	}

	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}

	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}

	public int getPartidosJugados() {
		return partidosJugados;
	}

	public void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}

	@Override
	public String toString() {
		return " \nSeleccion [pais=" + pais + ", \njugadores=" + Arrays.toString(jugadores) + ", \npuntos=" + puntos
				+ ", \npartidosGanados=" + partidosGanados + ", \npartidosEmpatados=" + partidosEmpatados
				+ ", \npartidosPerdidos=" + partidosPerdidos + ", \npartidosJugados=" + partidosJugados + "]";
	}

}
