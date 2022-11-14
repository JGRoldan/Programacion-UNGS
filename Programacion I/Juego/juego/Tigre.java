	package juego;

import java.awt.Color;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Tigre {
	private int x;
	private int y;
	private int alto;
	private int ancho;
	private int velocidad;
	private Image img = Herramientas.cargarImagen("imagenes/puma.png");
	
	public Tigre(int x, int y, int alto, int ancho, int velocidad) {
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
		this.velocidad = velocidad;
	}
	
	public void dibujarTigre(Entorno entorno) {
	entorno.dibujarImagen(img, x, y, 0, .6);
	}

	public void mover() {
		this.x -=this.velocidad;
	}
	
	public int getXTigre() {
		return this.x;
	}
	public int getYTigre() {
		return this.y;
	}
	public int getAlto() {
		return this.alto;
	}
	public int getAncho() {
		return this.ancho;
	}
}
