package juego;
import java.awt.Color;
import java.awt.Image;
import javax.sound.sampled.Clip;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
	
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	// Nuestros personajes, sonidos y banderas de control
	private Mono mono;
	private Serpiente serpiente;
	private Tigre[] tigre;
	private Piedra piedra;
	private Rama[] rama;
	private Aguila aguila;
	private int dyrama;
	private int puntos = 0;
	private Image img;
	private Clip musica;
	private Clip piedraSonido;
	private Clip salto;
	private Clip caida;
	private Clip aguilaRapida;
	private Clip finalizado;
	private boolean juegoFinalizado=false;
	private boolean crearAguila=false;
	private boolean crearCaida=false;
	//MENU 
	private boolean menu = true;
	private boolean menuAbajo = false; 
	private boolean menuArriba = true; 
	private Image flechaMenu = Herramientas.cargarImagen("imagenes/flecha.png");
	private Clip menuSeleccion;
	//IMAGEN PIERDE
	private Image perder;
	private Image ganar;
	Juego() {

		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Selva Mono Capuchino - Grupo 1 - v1", 1000, 800);
		
		// Inicializan las variables de instancia
		rama = new Rama[4];
		tigre = new Tigre[2];
		mono = new Mono(150, 680, 50, 50);
		piedra = null;
		aguila = null;
		tigre[0] = new Tigre(1300, 685, 50, 50, 2);
		tigre[1] = new Tigre(1000, 685, 50, 50, 2);
		rama[0] = new Rama(800, 560, 20, 150, 1);
		rama[1] = new Rama(1000, 550, 20, 150, 1);
		rama[2] = new Rama(500, 570, 20, 150, 1);
		rama[3] = new Rama(200, 580, 20, 150, 1);
		serpiente = new Serpiente(860, 520, 30, 30, 1);
		this.img = Herramientas.cargarImagen("imagenes/fondo.png");
		this.musica = Herramientas.cargarSonido("sonidos/stageMusic.wav");
		this.menuSeleccion=Herramientas.cargarSonido("sonidos/musicaMenu.wav");

		this.entorno.iniciar();
	
	}
	
	
	//CARGA EL MENU 
	void menuJuego() {
		this.entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/fondoMenu.png"), 500, 400, 0);
		this.menuSeleccion.start();
	}
	//
	
	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y por lo
	 * tanto es el método más importante de esta clase. Aquí se debe actualizar el
	 * estado interno del juego para simular el paso del tiempo (ver el enunciado
	 * del TP para mayor detalle).
	 */

	public void tick() {
		// Procesamiento de un instante de tiempo
		// ...
		
		if (menu) {
			menuJuego();
			if (this.entorno.sePresiono(entorno.TECLA_ABAJO) || menuAbajo) {
				
				menuAbajo = true;
				menuArriba = false;
				dibujarFlechaMenu(450);
				

			}
			if (this.entorno.sePresiono(entorno.TECLA_ARRIBA) || menuArriba) {
				
				menuArriba = true;
				menuAbajo = false;
				dibujarFlechaMenu(350);
				
			}

			if (this.entorno.sePresiono(entorno.TECLA_ENTER) && menuArriba) {
				menu = false;
				this.menuSeleccion.stop();
			}

			if (this.entorno.sePresiono(entorno.TECLA_ENTER) && menuAbajo) {
				System.exit(0);
			}
		} 
		
		else {
		this.entorno.dibujarImagen(img, entorno.ancho()/2, entorno.alto()/2, 0, 1);
		this.musica.start();
		
		//PARA ACUMULAR PUNTOS EN RAMA 
		if (mono!=null && mono.monoSobreUnaRama(rama) && !mono.getMonoSubiendo()) {
			this.puntos+=1;
		}
		
		
		// ------------------------
		// Mono saltando
		// ------------------------
		
		
		if (entorno.sePresiono(entorno.TECLA_ARRIBA) && mono != null && (mono.monoSobreUnaRama(rama) || mono.getYMono()==680)) {
			mono.setMonoSaltando(true);
			mono.setMonoSubiendo(true);
			this.salto = Herramientas.cargarSonido("sonidos/salto.wav");
			this.salto.start();
		}
		if(mono!=null && mono.getMonoSaltando()) {
			if(entorno.sePresiono(entorno.TECLA_ARRIBA) && mono.monoSobreUnaRama(rama)){
					mono.setMonoSubiendo(true);
					mono.invertirVelocidad();
					mono.saltar(rama);
				}
				mono.saltar(rama);

			}

		// ------------------------
		// Sonido de mono cayendo
		// ------------------------
		
		if(mono!=null && (mono.getMonoSaltando() && !mono.getMonoSubiendo() && !crearCaida)){
				this.caida = Herramientas.cargarSonido("sonidos/caida.wav");
				this.caida.start();	
				crearCaida = true;
		}
		if(mono!=null && !mono.getMonoSaltando()) {
			crearCaida = false;
		}
		
		
		// ------------------------
		// Creacion de ramas
		// ------------------------
		
		if (rama != null) {
			for (int i = 0; i < rama.length; i++) {
				if (rama[i].getXRama() == -50) {
					rama[i] = null;
					dibujarRama();
				} else {
					rama[i].dibujarArbol(entorno);
					rama[i].dibujarRama(entorno);
					rama[i].mover();
				}
			}
		}

		// ------------------------
		// Creacion de serpiente en ramas random
		// ------------------------
		if (serpiente!=null) {
			
			if (serpiente.getXSerpiente() <= 0) {
				serpiente = null;
				crearSerpienteRandom(rama);
			} else {
				serpiente.dibujarSerpiente(entorno);
				serpiente.mover();
			}
		}

		// ------------------------
		// Creacion de tigres
		// ------------------------

		if (tigre != null) {
			
			for (int i = 0; i < tigre.length; i++) {
				if (tigre[i].getXTigre() <= 0) {
					tigre[i] = null;
					dibujarTigre();
				} else if (piedra != null && hayColisionTigreYPiedra(tigre[i])) {
					tigre[i] = null;
					piedra = null;
					puntos++;
					
					dibujarTigre();

				} else if (mono != null && (hayColisionMonoYTigre(tigre[i]))) {		
					mono = null;
					tigre[i]=null;
					this.juegoFinalizado=true;
					//dibujarTigre();
				} else {
					tigre[i].dibujarTigre(entorno);
					tigre[i].mover();
				}

			}
		}
		
		
		// ------------------------
		// Creacion de aguilas
		// ------------------------
		//El crearAguila es una flag para que el sonido se reproduzca una vez mientras pasa
		
		
		if (mono!=null && puntos % 100 == 0 && puntos != 0 && !crearAguila) {
			aguila = new Aguila(1050, mono.getYMono(), 30, 100);
			this.aguilaRapida = Herramientas.cargarSonido("sonidos/apareceAguila.wav");
			this.aguilaRapida.start();
			this.crearAguila=true;
		}

		
		if (aguila != null) {
			if (aguila.getXAguila() > 0) {
				aguila.dibujarAguila(entorno);
				aguila.mover();
				

			} else {
				aguila = null;
				this.crearAguila=false;
			}
			if (hayColisionPiedraYAguila()) {
				aguila = null;
				piedra = null;
				this.crearAguila=false;
			}
			if (hayColisionAguilaYMono()) {
				mono = null;
				this.juegoFinalizado=true;
			}
		}

		// ------------------------
		// Creacion de piedra
		// ------------------------

		if (presiono() != null) {
			if (this.piedra != null) {
				this.piedra.dibujarPiedra(entorno);
				this.piedra.moverPiedra();
				if (piedra.getXPiedra() >= 1000) {
					this.piedra = null;
					presiono();
				}
					if(hayColisionSerpienteYPiedra()) {
						serpiente=null;						
						piedra = null;						
						this.crearSerpienteRandom(rama);
					}
			}
		}

		// ------------------------
		// Creacion de mono - y puntos 
		// ------------------------
		
		if (mono != null) {
			mono.dibujarMono(entorno); // Se dibuja abajo para que la piedra salga atras del mono
				if(serpiente != null && hayColisionSerpienteYMono()){
					mono=null;
					this.juegoFinalizado=true;
				}
			this.entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/piso.png"), entorno.ancho()/2, 760, 0, 1);
			//MUESTRA EN PANTALLA EL PUNTAJE
			entorno.cambiarFont("Minecraft", 40, Color.white);
			entorno.escribirTexto("PUNTOS: ", 10, 50);
			entorno.escribirTexto(Integer.toString(puntos), 250, 50);
			//PERDISTE
		} else {
			rama = null;
			tigre = null;
			this.perder = Herramientas.cargarImagen("imagenes/gameOver.png");
			entorno.dibujarImagen(perder, 500, 400, 0,1);
			entorno.cambiarFont("Minecraft", 90, Color.black);
			entorno.escribirTexto(Integer.toString(puntos), entorno.alto()/2+50,310);
		}
		
		// ------------------------
		// GAME OVER
		// ------------------------
		//Carga el sonido de juego finalizado
		if(this.juegoFinalizado) {
			this.finalizado = Herramientas.cargarSonido("sonidos/pierde.wav");
			this.finalizado.start();
			this.juegoFinalizado=false;

		}

		
		// ------------------------
		// GANASTE
		// ------------------------

		if(puntos >= 1000) {
			mono=null;
			serpiente=null;
			aguila=null;
			rama=null;
			this.ganar = Herramientas.cargarImagen("imagenes/ganador.png");
			entorno.dibujarImagen(ganar, 500, 400, 0,1);
			entorno.cambiarFont("Minecraft", 90, Color.black);
			entorno.escribirTexto(Integer.toString(puntos), entorno.alto()/2-40,510);
			
		}
		
		}	
	}// Llave CIERRE de tick

	//Crea una serpiente en cualquier rama de forma aleatoria 
	public void crearSerpienteRandom(Rama [] r) {
		if(rama!=null) {
			int x = (int) (Math.random() * rama.length);
			serpiente = new Serpiente(r[x].getXRama() + 50, r[x].getYRama() - 20, 30, 30, 1);
		}
		
	}
	
	// ---------------
	// Colision aguila-mono
	// ---------------
	private boolean hayColisionAguilaYMono() {
		return  mono != null && aguila != null
				
				&& mono.getXMono() + mono.getAncho() / 2 <= aguila.getXAguila() - aguila.getAncho() / 2
				&& mono.getXMono() + mono.getAncho() / 2 >= (aguila.getXAguila() - aguila.getAncho() / 2) - 1
				&& mono.getYMono()>= aguila.getYAguila()-5
				&& mono.getYMono()<= aguila.getYAguila() + 5;

	}

	// ---------------
	// Colision piedra-aguila
	// ---------------
	public boolean hayColisionPiedraYAguila() {
		return  piedra != null && aguila != null

				&& piedra.getXPiedra() + piedra.getAncho() / 2 <= aguila.getXAguila() - aguila.getAncho() / 2
				&& piedra.getXPiedra() + piedra.getAncho() / 2 >= ((aguila.getXAguila() - aguila.getAncho() / 2) - 10)
				&& piedra.getYPiedra()>= aguila.getYAguila() - 20
				&& piedra.getYPiedra()<= aguila.getYAguila() + 20;
	}

	// ---------------
	// Colision serpiente-piedra
	// ---------------
	public boolean hayColisionSerpienteYPiedra() {
		return  piedra != null
				&& piedra.getXPiedra() + piedra.getAncho() / 2 <= serpiente.getXSerpiente() - serpiente.getAncho() / 2
				&& piedra.getXPiedra() + piedra.getAncho() / 2 >= (serpiente.getXSerpiente() - serpiente.getAncho() / 2)- 10
				&& piedra.getYPiedra()>=serpiente.getYSerpiente()-20
				&& piedra.getYPiedra()<=serpiente.getYSerpiente()+20;					
			}

	// ---------------
	// Colision serpiente-mono
	// ---------------

	public boolean hayColisionSerpienteYMono() {
		return  mono.getXMono() + mono.getAncho() / 2 <= serpiente.getXSerpiente() - serpiente.getAncho() / 2
				&& mono.getXMono() + mono.getAncho() / 2 >= (serpiente.getXSerpiente() - serpiente.getAncho() / 2) - 1
				&& mono.getYMono()>= serpiente.getYSerpiente()-20
				&& mono.getYMono()<= serpiente.getYSerpiente()+20;
	}


	// ---------------
	// Colision piedra-tigre
	// ---------------
	
	private boolean hayColisionTigreYPiedra(Tigre tigre) {
		return  piedra != null 
				&& piedra.getXPiedra() + piedra.getAncho() / 2 <= tigre.getXTigre() - tigre.getAncho() / 2
				&& piedra.getXPiedra() + piedra.getAncho() / 2 >= ((tigre.getXTigre() - tigre.getAncho() / 2) - 5)
				&& piedra.getYPiedra() - piedra.getAlto() / 2 >= tigre.getYTigre() - tigre.getAlto() / 2
				&& piedra.getYPiedra() + piedra.getAlto() / 2 <= tigre.getYTigre() + tigre.getAlto() / 2;
	}

	// ---------------
	// Colision mono - tigre
	// ---------------

	private boolean hayColisionMonoYTigre(Tigre tigre) {

		boolean seTocaXIzquierda = mono.getXMono() >= tigre.getXTigre() - tigre.getAncho() / 2;
		boolean seTocaXDerecha = mono.getXMono() <= tigre.getXTigre() + tigre.getAncho() / 2;
		boolean seTocaY = mono.getYMono() >= tigre.getYTigre() - tigre.getAlto() / 2;
		boolean seTocaHorizontal = mono.getXMono() <= tigre.getXTigre() && mono.getXMono() + 40 >= tigre.getXTigre();

		return seTocaXIzquierda && seTocaXDerecha && seTocaY && seTocaHorizontal;
	}

	// ---------------
	// Metodo para crear piedra desde mono
	// ---------------

	public Piedra presiono() {
		if (mono != null && this.entorno.sePresiono(this.entorno.TECLA_ESPACIO) && this.piedra == null) {
			piedra = mono.lanzarPiedra();
			this.piedraSonido = Herramientas.cargarSonido("sonidos/piedra.wav");
			this.piedraSonido.start();
		}
		return piedra;
	}

	// ---------------
	// Metodos para dibujar rama - serpiente - tigre
	// ---------------

	public void dibujarRama() {
		for (int i = 0; i < rama.length; i++) {
			if (rama[i] == null) {
				int dy = (int) (Math.random() * (650 - 550 + 1) + 550);
				dyrama = dy;
				rama[i] = new Rama(1000, dy, 20, 150, 1);
			}
		}
	}

	public void dibujarSerpiente() {
		serpiente = new Serpiente(1050, dyrama - 20, 30, 30, 1);
	}

	public void dibujarTigre() {
		int x=0;
		for (int i = 0; i < tigre.length; i++) {
			if (tigre[i] == null) {
				int dx = (int) (Math.random() * (1050 - 1000 + 1) + 1000);
				x+=200;
				tigre[i] = new Tigre(dx+x, 685, 50, 50, 2);
			}
		}
	}
	
	//DIBUJA EL CURSOR EN EL MENU 
		void dibujarFlechaMenu(int posY) {
			this.entorno.dibujarImagen(flechaMenu, 100, posY, 0, 0.5);
		}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
