package ejerciciosPracticas;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ejercicios6a9 {

	//---------EJERCICIO 6---------
	public static void imprimirSuma(int a, int b) {
		int sum = a+b;
		System.out.println("La suma es: " + sum);
	}
	
	//---------EJERCICIO 7---------
	public static void imprimirPromedio(int a, int b) {
		int prom = (a+b)/2;
		System.out.println("El promedio es: " + prom);
	}
	
	//---------EJERCICIO 8---------
	public static void ponerNota(double a, double b) {
		double prom = (a+b)/2;
		if(prom>=7) {
			System.out.println("PROMOCIONA");
		}else if(prom<7 && prom>=4) {
			System.out.println("APROBADO");
		}else {
			System.out.println("RECUPERAR");
		}
	}
	public static double numerosReales() {
		Scanner scan = new Scanner(System.in);
		double num = scan.nextDouble();
		return num;
	}
	
	//---------EJERCICIO 9---------
	public static void imprimirFecha(int dia,int mes, int anio) {
		String mesString="";
		switch (mes) {
		case 1:
			mesString="Enero";
			break;
		case 2:
			mesString="Febrero";
			break;
		case 3:
			mesString="Marzo";
			break;
		case 4:
			mesString="Abril";
			break;
		case 5:
			mesString="Mayo";
			break;
		case 6:
			mesString="Junio";
			break;
		case 7:
			mesString="Julio";
			break;
		case 8:
			mesString="Agosto";
			break;
		case 9:
			mesString="Septiembre";
			break;
		case 10:
			mesString="Octubre";
			break;
		case 11:
			mesString="Noviembre";
			break;
		case 12:
			mesString="Diciembre";
			break;
		default:
			System.out.println("NO EXISTE EL MES");
		}
	System.out.println(dia +" de " + mesString +" de " +anio);
	}
	
	//-----------------------------------
	//---------------MAIN----------------
	//-----------------------------------
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingresa un numero: ");
		int num1 = scan.nextInt();
		System.out.println("Ingresa otro numero: ");
		int num2 = scan.nextInt();
		
		imprimirSuma(num1,num2);
		
		imprimirPromedio(num1,num2);
		
		//-------EJ-8 
		
		System.out.println("Ingresa un numero: ");
		double num3=numerosReales();
		System.out.println("Ingresa otro numero: ");
		double num4=numerosReales();
		ponerNota(num3,num4);
		
		//-------EJ-9
		imprimirFecha(1,1,2000);
		
		
	}

}
