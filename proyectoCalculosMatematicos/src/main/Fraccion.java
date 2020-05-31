package main;

public class Fraccion {
	private int numerador;
	private int denominador;

	public Fraccion(int numerador, int denominador) {
		super();
		this.numerador = numerador;
		this.denominador = denominador;
	}
/*
 * 	Añadir las siguientes operaciones a Fracción
 * 
 * 
 * 
	public static Fraccion simplifica(Fraccion entrada) {
	}
	
	public static Fraccion suma(Fraccion sumando1, Fraccion sumando2) {
	}
	public static Fraccion multiplicacion(Fraccion sumando1, Fraccion sumando2) {
	}
	public static Fraccion division(Fraccion sumando1, Fraccion sumando2) {
	}
*/
	public void simplificarFraccion() {
		int numerador = this.getNumerador();
		int denominador = this.getDenominador();
		
		while(numerador%2 == 0 && denominador%2 == 0) {
			numerador = numerador/2;
			denominador = denominador/2;
		}
		
		while(numerador%3 == 0 && denominador%3 == 0) {
			numerador = numerador/3;
			denominador = denominador/3;
		}
		
		while(numerador%5 == 0 && denominador%5 == 0) {
			numerador = numerador/5;
			denominador = denominador/5;
		}
		
		if(numerador%denominador == 0) {
			numerador = 1;
			denominador = 1;
		}
		
		this.setNumerador(numerador);
		this.setDenominador(denominador);
		
	}
	
	public int getNumerador() {
		return numerador;
	}

	public int getDenominador() {
		return denominador;
	}


	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(numerador).append(" / ").append(denominador);
		return sb.toString();
	}

}
