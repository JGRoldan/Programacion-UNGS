package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Mono {
	private int x;
	private int y;
	private int alto;
	private int ancho;
	private int velocidad = 2;
	private boolean monoSaltando=false;
	private boolean monoSubiendo = false; 
	private Image mono=Herramientas.cargarImagen("imagenes/monoSaltando.png");
	
	public Mono(int x, int y, int alto, int ancho) {
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
	}

	public void setMonoSaltando(boolean monoSaltando) {
		this.monoSaltando = monoSaltando;
	}
	public boolean getMonoSaltando() {
		return this.monoSaltando;
	}
	
	public void setMonoSubiendo(boolean monoSubiendo) {
		this.monoSubiendo = monoSubiendo;
	}

	public boolean getMonoSubiendo() {
		return this.monoSubiendo;
	}
	
	
	public void dibujarMono(Entorno entorno) {
		entorno.dibujarImagen(mono, x, y, 0, 0.8);
	}
	public int getXMono() {
		return this.x;
	}
	
	public int getYMono() {
		return this.y;
	}
	public int getAlto() {
		return this.alto;
	}
	public int getAncho() {
		return this.ancho;
	}
	public void mover() {
		this.y -= this.velocidad;
	}
	public void invertirVelocidad() {
		this.velocidad *= -1;
	}

	
//SALTO DEL MONO
	
	//mono subiendo
	public void saltar(Rama [] ramas) {
		if(this.monoSaltando && this.monoSubiendo) {
			if(this.y>400) {
				this.mover();
			}
			else {
				this.invertirVelocidad();
				this.mover();
				this.monoSubiendo=false;
			}
		}
	//mono bajando	
		if(this.monoSaltando && !this.monoSubiendo) {
			if(!this.monoSobreUnaRama(ramas)) {
				if(this.y>=680) {
					this.monoSaltando=false;
					this.invertirVelocidad();
				}
				else {
					this.mover();
					}
				}
			}
		}
	
//CREA PIEDRA	
	public Piedra lanzarPiedra(){
		return new Piedra(x,y,1,1,4);
	}
//AVISA SI EL MONO ESTA SOBRE UNA RAMA 	
	public boolean monoSobreUnaRama(Rama[] ramas) {
		boolean contacto=false;
		for(int i=0;i<ramas.length;i++) {
			if(hayContactoRamaYmono(ramas[i]))
				contacto=true;
										}
		return contacto;
		
													}
//COLISION DE RAMA Y MONO
	public boolean hayContactoRamaYmono(Rama b) { 
		return	this.getXMono()+this.getAncho()/2 >= b.getXRama()-b.getAncho()/2
				&& 
				this.getXMono()+this.getAncho()/2 <= b.getXRama()+b.getAncho()/2
				&&
				this.getYMono()+this.getAlto()/2 <=b.getYRama()-b.getAlto()/2
				&&
				this.getYMono()+this.getAlto()/2 >= ((b.getYRama()-b.getAlto()/2)-1);
	}

}
