package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Rama {
	private int x;
	private int y;
	private int alto;
	private int ancho;
	private int velocidad;
	private Image img = Herramientas.cargarImagen("imagenes/arbol2.png");
	private Image rama= Herramientas.cargarImagen("imagenes/tronco.png");
	
	public Rama(int x, int y, int alto, int ancho, int velocidad) {
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
		this.velocidad = velocidad;
	}

	public void dibujarRama(Entorno entorno) {
		entorno.dibujarImagen(rama, x, y, 0, 0.25);
	}

	public void dibujarArbol(Entorno entorno) {
		entorno.dibujarImagen(img, x, y, 0, .5);
	}
	public void mover() {
		this.x -= this.velocidad;
	}

	public int getXRama() {
		return this.x;
	}

	public int getYRama() {
		return this.y;
	}

	public int getAncho() {
		return this.ancho;
	}

	public int getAlto() {
		return this.alto;
	}
}
