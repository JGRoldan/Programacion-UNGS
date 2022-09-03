package objetoRectanglePoint;

import java.awt.*;

public class RectangleAndPoint {

	//Distancia entre dos puntos
	public static double distancia(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}
	//Medida de diagonal con pitagoras
	 public static double diagonal(Rectangle r) {
		 return Math.sqrt(Math.pow(r.width, 2) + Math.pow(r.height, 2));
	 }
	//Punto central del rectangulo
	public static Point puntoCentral(Rectangle r) {
		return new Point(r.width/2,r.height/2);
	}
	
	//¿El punto esta dentro del rectangulo?
	public static boolean estaDentro(Point p1,Rectangle r) {
		return p1.x<r.width && p1.y<r.height;	 
	}
	
	//Punto medio entre dos coordenadas
	public static Point puntoMedio(Point p1, Point p2) {
		return new Point((p1.x+p2.x)/2,(p1.y+p2.y)/2);
	}
	
	public static void main(String[] args) {
		Point p1=new Point(1,3);
		Point p2=new Point(11,3);
		System.out.println("X1 = " + p1.x + ", X2 = " + p2.x);
		System.out.println("Y1 = " + p1.y + ", Y1 = " + p2.y);
		System.out.println("Distancia entre dos puntos :" + distancia(p1,p2));
		
		Rectangle r = new Rectangle(0,0,100,200);
		System.out.println("Medida de la diagonal :" + diagonal(r));
		System.out.println("Punto medio del rectangulo :" + "("+puntoCentral(r).x+","+ puntoCentral(r).y+")");
		System.out.println("El punto esta en el rectangulo :" + estaDentro(p1,r));
		
		System.out.println("Punto medio entre dos puntos : " + "("+puntoMedio(p1,p2).x+","+puntoMedio(p1,p2).y+")");
	}

}
