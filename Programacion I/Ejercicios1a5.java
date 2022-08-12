package ejerciciosPracticas;

import java.util.Scanner;

public class Ejercicios1a5 {

	
	public static void ej_1() {
		System.out.println("Hello world");
	}
	//-------------------------

	public static void ej_2() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingresa tu nombre: ");
		System.out.println("Hola " + scan.nextLine());
	}
	//-------------------------

	public static void ej_3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingresa un numero: ");
		int num1 = scan.nextInt();
		System.out.println("Ingresa otro numero: ");
		int num2 = scan.nextInt();
		System.out.println("La suma de " + num1 + " + " + num2 + " es: " + (num1+num2));
	}
	//-------------------------

	public static void ej_5() {
		int num1 = retornaNumber();
		int num2 = retornaNumber();
		double promedio = (num1+num2)/2;
		System.out.println("El promedio es " + promedio);
	}
	
	public static int retornaNumber() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingresa un numero: ");
		int num = scan.nextInt();
		return num;
	}
	public static void main(String[] args) {
		ej_1();
		ej_2();
		ej_3();
		ej_5();
	}

}
