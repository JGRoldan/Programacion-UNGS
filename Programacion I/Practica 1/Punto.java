package resolucion;

public class Punto {
	double x;
	double y;
	
	//Si no pasas parametros => (x,y)=(0.0,0.0)
	public Punto() {
		this.x=0.0;
		this.y=0.0;
	}
	public Punto(double x, double y) {
		this.x=x;
		this.y=y;
	}
	public void imprimir() {
		System.out.println(this.x +" - " +this.y);
	}
	
	//Desplazar el punto en (x,y)
	public void desplazar(double desp_x, double desp_y) {
		x+=desp_x;
		y+=desp_y;
		System.out.println(x +" - " +y);
	}
	public static double distancia(Punto p1, Punto p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}
	
}
