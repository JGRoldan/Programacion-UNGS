package resolucion;
import practica_0.Ejercicio33;

public class Fraccion {
    int numerador;
    int denominador;

	//CONSTRUCTOR
    public Fraccion(int numerador,int denominador) {
    	this.numerador=numerador;
    	this.denominador=denominador;
    }
   
    //METODO DE INSTANCIA VOID
    public void imprimir() {
    	System.out.println(numerador+"/"+denominador+" = "+ numerador/denominador);
    }
    
    public void invertirSigno() {
    	System.out.println("Resultado signo invertido: " + -1 * numerador/denominador);
    }
    
    public void invertir() {
    	System.out.println("Fraccion invertida: " + denominador+"/"+numerador);
    }
    
    public double aDouble() {
    	return numerador/denominador;
    }
    
    		//---MCD OBTENIDO DE LA PRACTICA 0 EJERCICIO 33---
    public void reducir() {
    	int mcd=Ejercicio33.mcd(numerador, denominador);
    	System.out.println(numerador+"/"+mcd + " = " + numerador/mcd);
    	System.out.println(denominador+"/"+mcd + " = " + denominador/mcd);
    }
    
}
