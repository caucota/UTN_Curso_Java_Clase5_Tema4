package Clase5Tema4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ejercicio2 {
	public static void main(String[] args) {
		boolean esSuma = true; 
        if(args.length == 0){
            System.out.println("ERROR: No ingresaste ningún archivo como argumento!");
            System.exit(88);
        }
        int sumaNros = 0;
        if(args.length > 1){
        	if(args[1].equals("multiplicacion")) {
        		esSuma = false;
                sumaNros = 1;
        	}
        }
        
        String archivo = args[0];
        try {
			for(String linea : Files.readAllLines(Paths.get(archivo))) {
				if (esSuma) {
					sumaNros = sumaNros + Integer.parseInt(linea);
				}else {
					sumaNros = sumaNros * Integer.parseInt(linea);
				}
			}
			System.out.println(sumaNros);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	

}


