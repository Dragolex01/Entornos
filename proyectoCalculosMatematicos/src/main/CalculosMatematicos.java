package main;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class CalculosMatematicos {
	public static boolean esPar(int numero) {
		return numero % 2 == 0;
	}

	/*
	 * 
	 * Este método se usa para descomponer un número en sus factores primos Genera
	 * un mapa ordenado donde cada clave es un divisor primo del número y cuyo valor
	 * es el número de veces que incluye ese divisor primo.
	 * 
	 */
	public static SortedMap<Integer, Integer> divisores(int numero) {
		SortedMap<Integer, Integer> divisores = new TreeMap<Integer, Integer>();
		int numeroIntermedio = numero;
		Integer divisor = 2;
		while (numeroIntermedio >= divisor) {
			while (numeroIntermedio % divisor == 0) {
				Integer clave = divisor;
				divisores.putIfAbsent(divisor, 0);
				divisores.computeIfPresent(clave, (key, val) -> (val + 1));
				numeroIntermedio = numeroIntermedio / divisor;
			}

			divisor++;
		}
		return divisores;
	}

	public static ArrayList<Integer> listaDePrimosHasta(int numero) {
		ArrayList<Integer> listaDePrimos = new ArrayList<Integer>();
		listaDePrimos.add(1);
		listaDePrimos.add(2);
		listaDePrimos.add(3);
		for (int i = 5; i <= numero; i += 2) {
			if (esPrimo(i))
				listaDePrimos.add(i);
		}
		return listaDePrimos;
	}

	public static int potencia(int base, int exponente) {

		int resul = 1;
		if (exponente > 0)
			resul = base * potencia(base, exponente - 1);
		return resul;
	}

	public static boolean esPrimo(int numero) {

		boolean primo = true;
		int divisor = 3;
		if (numero != 2 && numero % 2 == 0)
			primo = false;
		while (primo && divisor <= Math.sqrt(numero)) {
			if (numero % divisor == 0)
				primo = false;
			divisor += 2;
		}
		return primo;
	}
	
	public static int[] descomposicionFactoresPrimos(int numero) {
		int divisores[] = new int[25];
		int solucion = 0;
		int i = 0;
		
		while(numero != 1) {
			solucion = numero%2;
			if(solucion == 0) {
				divisores[i] = 2;
				i++;
				numero = numero/2;
			}else {
				solucion = numero%3;
				if(solucion == 0) {
					divisores[i] = 3;
					i++;
					numero = numero/3;
				}else {
					solucion = numero%5;
					if(solucion == 0) {
						divisores[i] = 5;
						i++;
						numero = numero/5;
					}else {
						divisores[i] = numero;
						numero = numero/numero;
					}
				}
			}
		}
		
		return divisores;
	}
	
	public static boolean comprobacionFactoresPrimos(int resultado, int numero) {
		boolean solucion = false;
		int factoresPrimos[] = CalculosMatematicos.descomposicionFactoresPrimos(numero);
		int cont = 1;
		int i = factoresPrimos.length;
		int numeroCorrecto = 0;
		
		while(i <= factoresPrimos.length) {
			numeroCorrecto = numeroCorrecto + (factoresPrimos[i]*cont);
			i++;
			cont = cont*10;
		}
		
		if(numeroCorrecto == resultado) {
			solucion = true;
		}else {
			solucion = false;
		}
		
		return solucion;
	}
	
	public static int maximoComunDivisor(int numero1, int numero2) {
		int divisores1[] = CalculosMatematicos.descomposicionFactoresPrimos(numero1);
		int divisores2[] = CalculosMatematicos.descomposicionFactoresPrimos(numero2);
		int i = 0;
		int resultado = 0;
		int solucion = 0;
		int cont1 = 0;
		int cont2 = 0;
		
		while(i < divisores1.length || i < divisores2.length) {
		
			while(divisores1[i] == 2) {
					cont1++;
					i++;
			}
			while(divisores2[i] == 2) {
				cont2++;
				i++;
			}
			if(cont1 != 0 && cont2 != 0) {
				if(cont1 < cont2) {
					resultado = resultado * (2*cont1);
				}else {
					resultado = resultado * (2*cont2);
				}
			}
			cont1 = 0;
			cont2 = 0;
			
			while(divisores1[i] == 3) {
				cont1++;
				i++;
			}
			while(divisores2[i] == 3) {
				cont2++;
				i++;
			}
			if(cont1 != 0 && cont2 != 0) {
				if(cont1 < cont2) {
					resultado = resultado * (3*cont1);
				}else {
					resultado = resultado * (3*cont2);
				}
			}
			cont1 = 0;
			cont2 = 0;
			
			while(divisores1[i] == 5) {
				cont1++;
				i++;
			}
			while(divisores2[i] == 5) {
				cont2++;
				i++;
			}
			if(cont1 != 0 && cont2 != 0) {
				if(cont1 < cont2) {
					resultado = resultado * (5*cont1);
				}else {
					resultado = resultado * (5*cont2);
				}
			}
			i++;
		}
		
		if(numero1 == numero2) {
			resultado = resultado * numero1;
		}
		
		return resultado;
	}
	
	
	public static int minimoComunMultiplo(int numero1, int numero2) {
		int divisores1[] = new int[25];
		int divisores2[] = new int[25];
		int i = 0;
		int resultado = 0;
		int solucion = 0;
		int cont1 = 0;
		int cont2 = 0;
		
		while(numero1 != 1) {
			solucion = numero1%2;
			if(solucion == 0) {
				divisores1[i] = 2;
				i++;
				numero1 = numero1/2;
			}else {
				solucion = numero1%3;
				if(solucion == 0) {
					divisores1[i] = 3;
					i++;
					numero1 = numero1/3;
				}else {
					solucion = numero1%5;
					if(solucion == 0) {
						divisores1[i] = 5;
						i++;
						numero1 = numero1/5;
					}else {
						divisores1[i] = numero1;
						numero1 = numero1/numero1;
					}
				}
			}
		}
		i = 0;
		while(numero2 != 1) {
			solucion = numero2%2;
			if(solucion == 0) {
				divisores2[i] = 2;
				i++;
				numero2 = numero2/2;
			}else {
				solucion = numero2%3;
				if(solucion == 0) {
					divisores2[i] = 3;
					i++;
					numero2 = numero2/3;
				}else {
					solucion = numero2%5;
					if(solucion == 0) {
						divisores2[i] = 5;
						i++;
						numero2 = numero2/5;
					}else {
						divisores2[i] = numero2;
						numero2 = numero2/numero2;
					}
				}
			}
		}
		i = 0;
		
		while(i < divisores1.length || i < divisores2.length) {
		
			while(divisores1[i] == 2) {
					cont1++;
					i++;
			}
			while(divisores2[i] == 2) {
				cont2++;
				i++;
			}
			if(cont1 > cont2) {
				resultado = resultado * (2*cont1);
			}else {
				resultado = resultado * (2*cont2);
			}
			cont1 = 0;
			cont2 = 0;
			
			while(divisores1[i] == 3) {
				cont1++;
				i++;
			}
			while(divisores2[i] == 3) {
				cont2++;
				i++;
			}
			if(cont1 > cont2) {
				resultado = resultado * (3*cont1);
			}else {
				resultado = resultado * (3*cont2);
			}
			cont1 = 0;
			cont2 = 0;
			
			while(divisores1[i] == 5) {
				cont1++;
				i++;
			}
			while(divisores2[i] == 5) {
				cont2++;
				i++;
			}
			if(cont1 > cont2) {
				resultado = resultado * (5*cont1);
			}else {
				resultado = resultado * (5*cont2);
			}
			i++;
		}
		resultado = resultado * numero1 * numero2;
		
		return resultado;
	}
	
	
}