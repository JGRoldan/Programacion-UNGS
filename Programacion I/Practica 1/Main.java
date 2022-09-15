package resolucion;

public class Main {

	public static void main(String[] args) {
		Punto p=new Punto(); //0.0 - 0.0
		Punto param=new Punto(1,1); //1.0 - 1.0
		p.imprimir();
		param.imprimir();
		
		//Desplazar
		param.desplazar(2, 5); //3.0 - 6.0
		
		//Distancia entre 2 puntos
		Punto p1=new Punto(5,2); 
		Punto p2=new Punto(10,3); 
		double distancia = Punto.distancia(p1, p2);
		
		System.out.println("Distancia => " + distancia);
	}

}
