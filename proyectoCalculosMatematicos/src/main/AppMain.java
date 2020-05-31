package main;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


public class AppMain {

	public static void main(String[] args) {
		/*
		 * Ejemplo de uso del m√©todo CalculosMatematicos.divisores
		 * Este m√©todo descompone un n√∫mero en factores primos
		 * Retornando un mapa con los factores primos
		 
		int num = 180;
		SortedMap<Integer,Integer> divisores = new TreeMap<>();
		divisores=CalculosMatematicos.divisores(num);
		for(Map.Entry<Integer, Integer> entrada: divisores.entrySet()) {
			int divisor=entrada.getKey();
			int numeroVeces=entrada.getValue();
			for(int i=1;i<=numeroVeces;i++) {
			System.out.println(num+"\t|\t"+divisor);
			num=num/divisor;
			}
		}
				
		Fraccion ejempoFraccion = new Fraccion(3, 100);		
		System.out.println("\n\nPara ver como funciona toString en Fraccion:\t"+ejempoFraccion);
		*/
		int seleccion = 0;
		int numero1 = 0;
		int numero2 = 0;
		int resultado = 0;
		int resultadoCorrecto = 0;
		boolean solucion = false;
		
		System.out.println("Selecciona 1 para hacer el M.C.M");
		System.out.println("Selecciona 2 para hacer el M.C.D");
		System.out.println("Selecciona 3 descomponer en factores primos");
		System.out.print("Selecciona el ejercicio que quieres realizar: ");
		seleccion = Entrada.leerInt();
		
		if(seleccion == 1 || seleccion == 2) {
			System.out.print("Introduce dos numeros: ");
			numero1 = Entrada.leerInt();
			numero2 = Entrada.leerInt();
			
			System.out.print("Introduce el resultado siendo los numeros " + numero1 + " y " + numero2);
			resultado = Entrada.leerInt();
			
			if(seleccion == 1) {
				resultadoCorrecto = CalculosMatematicos.minimoComunMultiplo(numero1, numero2);
			}else {
				resultadoCorrecto = CalculosMatematicos.maximoComunDivisor(numero1, numero2);
			}
			
			if(resultado == resultadoCorrecto) {
				System.out.println("La soluciÛn es correcta");
				System.out.println("La soluciÛn no es correcta");
			}
			
		}else if(seleccion == 3) {
			System.out.print("Introduce un numero: ");
			numero1 = Entrada.leerInt();
			
			System.out.print("Introduce el resultado con todos los numeros juntos: ");
			resultado = Entrada.leerInt();
			
			solucion = CalculosMatematicos.comprobacionFactoresPrimos(resultado, numero1);
			
			if(solucion == true) {
				System.out.println("El resultado es correcto");
			}else {
				System.out.println("El resultado no es correcto");
			}
			
			
			
		}
		
	}

}
