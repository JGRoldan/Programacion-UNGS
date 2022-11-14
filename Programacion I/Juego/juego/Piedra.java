package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Piedra {
	private int x;
	private int y;
	private int alto;
	private int ancho;
	private int velocidad;
	private Image img=Herramientas.cargarImagen("imagenes/piedra.png");
	public Piedra(int x, int y, int alto, int ancho, int velocidad) {
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
		this.velocidad = velocidad;
	}


	public void dibujarPiedra(Entorno entorno) {
		entorno.dibujarImagen(img, x, y, 0, 0.7);
	}
	public int getXPiedra() {
		return this.x;
	}
	public int getYPiedra() {
		return this.y;
	}
	public void moverPiedra() {
		this.x+=velocidad;
	}
	public int getAncho() {
		return this.ancho;
	}
	public int getAlto() {
		return this.alto;
	}
}
