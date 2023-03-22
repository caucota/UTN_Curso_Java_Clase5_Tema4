package Clase5Tema4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio1_a_b {

	public static void main(String[] args) {
		// Ejercicio 1 - a:  Ordenar segun parametros
		Integer nros[] = new Integer[args.length-1];
		for(int i = 0; i < args.length-1; i++ ) {
			nros[i] = Integer.parseInt(args[i]);
		}
		String orden = args[args.length-1];
		ordenar(nros, orden);
		
		
		// Ejercicio 1 - b:  Ordenar. Pedir ingreso de valores por consola
		Scanner scn = new Scanner(System.in);
		System.out.println("Ingrese A para ordenar Ascendente, o cualquier otra letra para orden Descendente:");
		orden = scn.nextLine();
		for(int i = 0; i < 3; i++) {
			System.out.println("Ingrese el valor para el elemento " + (i+1) + ": ");
			nros[i] = scn.nextInt();
		}
		ordenar(nros, orden);
		
		
	}
	
	private static void ordenar(Integer arrayNros[], String orden) {
		 
		if (orden.toUpperCase().equals("A")) {
			orden = "Ascendente";
			Arrays.sort(arrayNros);
		}else {
			orden = "Descendente";
			Arrays.sort(arrayNros, Collections.reverseOrder() );
		}
		System.out.println("Elementos ordenados de forma " + orden + ": "  + arrayNros[0] +  " " + arrayNros[1] +  " " + arrayNros[2]);
		
	}

}
