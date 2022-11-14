package juego;


import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Serpiente {
	private int x;
	private int y;
	private int alto;
	private int ancho;
	private int velocidad;
	private Image serpiente= Herramientas.cargarImagen("imagenes/snake.png");;
	
	public Serpiente(int x, int y, int alto, int ancho, int velocidad) {
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
		this.velocidad = velocidad;
	}
	
	public void dibujarSerpiente(Entorno entorno) {
		entorno.dibujarImagen(serpiente, x, y, 0,0.13);
	}
	
	public void mover() {
		this.x -=this.velocidad;
	}
	
	public int getXSerpiente() {
		return this.x;
	}
	public int getYSerpiente() {
		return this.y;
	}
	public int getAlto() {
		return this.alto;
	}
	public int getAncho() {
		return this.ancho;
	}
}
