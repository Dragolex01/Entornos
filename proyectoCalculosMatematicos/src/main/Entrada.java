package main;
import java.util.Scanner;

public class Entrada {
	
	public static int leerInt() {
		Scanner teclado = new Scanner(System.in);
		int n;
		n=teclado.nextInt();
		return n;
	}
	
	public static char leerChar() {
		Scanner teclado = new Scanner(System.in);
		char n;
		n = teclado.next().charAt(0);
		return n;
	}
	
	public static String leerString() {
		Scanner teclado = new Scanner(System.in);
		String s;
		s=teclado.next();
		return s;
	}
	
	public static String leerFrase() {
		Scanner teclado = new Scanner(System.in);
		String s;
		s=teclado.nextLine();
		return s;
	}
	
}