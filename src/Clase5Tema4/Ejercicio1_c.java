package Clase5Tema4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio1_c {

	public static void main(String[] args) {
		// Ejercicio 1 - c:  Ordenar segun parametros o ingreso por consola
		Integer nros[] = new Integer[3];
		int cantNros = 0;
		String orden = "";
		
		
		for(int i = 0; i < args.length; i++ ) {
			try {
				nros[i] = Integer.parseInt(args[i]);
				cantNros++;
			}
			catch(Exception e) {
				orden = args[i];
			}
			
		}
		
		Scanner scn = new Scanner(System.in);
		if (orden.equals("")) {
			System.out.println("Ingrese A para ordenar Ascendente, o cualquier otra letra para orden Descendente:");
			orden = scn.nextLine();
		}
		
		for(int i = cantNros; i < 3; i++) {
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


