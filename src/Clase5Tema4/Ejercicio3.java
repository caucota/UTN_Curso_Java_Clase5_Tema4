package Clase5Tema4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Ejercicio3 {

	public static void main(String[] args) {
		String letrasCodificacion = "abcdefghijklmnñopqrstuvwxyz ";
		boolean esCodificacion = args[0].equals("codificar");
		int desplazamiento = Integer.parseInt(args[1]);
		String rutaArchivoEntrada = args[2];
		String rutaArchivoSalida = args[3];
		String resultado = "";
		
		try {
			Files.writeString(Paths.get(rutaArchivoSalida), "", StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			for(String linea : Files.readAllLines(Paths.get(rutaArchivoEntrada))) {
				if (esCodificacion) {
					linea = Codificar("Hola que tal", letrasCodificacion, desplazamiento);
					//System.out.println("Ejercicio2 - Texto Codificado:" + telineaxto);
					
				}else {
					linea = Decodificar(linea, letrasCodificacion, desplazamiento);
					//System.out.println("Ejercicio2 - Texto Decodificado:" + linea);
				}
				
				Files.writeString(Paths.get(rutaArchivoSalida), linea, StandardOpenOption.APPEND);
			}
			resultado = "El proceso terminó correctamente";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado = "El proceso terminó en Error." + e.getMessage();
		}
		
		System.out.println("El resultado del Ejercicio 3 es:" + resultado);

	}

	public static String Codificar(String cadenaEntrada, String letrasCodif, int cantidadDesplazamientos) {
		String cadenaSalida = "";
		int posicion = 0;
		int totalLetras = letrasCodif.length();
		int desplazamientoCondicional = 0;
		cadenaEntrada = cadenaEntrada.toLowerCase();
		for( int i = 0; i < cadenaEntrada.length(); i++) {
			desplazamientoCondicional = cantidadDesplazamientos;
			posicion = letrasCodif.indexOf(cadenaEntrada.charAt(i));
			if ((posicion + desplazamientoCondicional) >= totalLetras-1) {
				desplazamientoCondicional = (posicion + desplazamientoCondicional) - totalLetras;
				posicion = 0;
			}
			cadenaSalida = cadenaSalida + letrasCodif.charAt(posicion + desplazamientoCondicional );
		}
		return cadenaSalida;
	}

	public static String Decodificar(String cadenaEntrada, String letrasCodif, int cantidadDesplazamientos) {
		String cadenaSalida = "";
		int posicion = 0;
		int totalLetras = letrasCodif.length();
		int desplazamientoCondicional = 0;
		cadenaEntrada = cadenaEntrada.toLowerCase();
		for( int i = 0; i < cadenaEntrada.length(); i++) {
			posicion = letrasCodif.indexOf(cadenaEntrada.charAt(i));
			desplazamientoCondicional = cantidadDesplazamientos;
			if ((posicion - desplazamientoCondicional)  < 0) {
				if ((posicion - desplazamientoCondicional)  < 0) {
					desplazamientoCondicional = desplazamientoCondicional - posicion;
				}
				posicion = totalLetras;
			}
			cadenaSalida = cadenaSalida + letrasCodif.charAt(posicion - desplazamientoCondicional );
		}
		return cadenaSalida;
	}


}


