package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Aguila {
	private int x;
	private int y;
	private int alto;
	private int ancho;
	private int velocidad = 15;
	private Image aguila=Herramientas.cargarImagen("imagenes/aguila.png");
	
	public Aguila(int x, int y, int alto, int ancho) {
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
	}
	public void dibujarAguila(Entorno entorno) {
		entorno.dibujarImagen(aguila, x, y, 0, 0.2);
	}
	public void mover() {
		this.x -=this.velocidad;
	}
	
	public int getXAguila() {
		return this.x;
	}
	public int getYAguila() {
		return this.y;
	}
	public int getAlto() {
		return this.alto;
	}
	public int getAncho() {
		return this.ancho;
	}
}
