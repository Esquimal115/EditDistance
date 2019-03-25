package edicion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class OperacionesFicheros {

	public static String cadena1;
	public static String cadena2;
	public static int numeroLineas = 1;
	public static Scanner sc;

	public OperacionesFicheros() {

	}

	public boolean leerFicheros(File ficheroEntrada) {

		FileReader fr = null;
		BufferedReader br = null;

		try {

			fr = new FileReader(ficheroEntrada);
			br = new BufferedReader(fr);

			String linea = br.readLine();

			while (linea != null) {

				if (numeroLineas == 1) {					
					cadena1= linea; 				
				} else{
					cadena2 = linea; 				
				}
				numeroLineas++;
				linea = br.readLine();

			} // Final bucle while
		} // Final del try

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}
	
	//Metodo que pasa los parametros por fichero
	public static void entradaPorFichero() {
		System.out.print("La palabra incial es --> ");
		System.out.println(cadena1);
		System.out.print("La cadena a la que deseamos llegar es --> ");
		System.out.println(cadena2);

		for (int i = 0; i < cadena1.length(); i++) {
			DistanciaEdicion.res[i] = cadena1.charAt(i);
		}
		System.out.println("");
		System.out.println("Las ediciones pertinentes son: ");
		DistanciaEdicion editDistance = new DistanciaEdicion();
		System.out.println("");
		int result = editDistance.distanciaEdicion(cadena1.toCharArray(), cadena2.toCharArray());
		System.out.println("");
		System.out.println("Se han necesitado ----> " + result + " ediciones");
	}
	
	//Le pasamos un fichero para que nos realice la traza
	public static void trazaEntradaPorFichero() {
		System.out.println("");
		System.out.println("MODO TRAZA ACTIVADO");
		System.out.println("");
		System.out.print("La palabra incial es ----> ");
		System.out.println(cadena1);
		System.out.print("La cadena a la que deseamos llegar es ----> ");
		System.out.println(cadena2);

		for (int i = 0; i < cadena1.length(); i++) {
			DistanciaEdicion.res[i] = cadena1.charAt(i);
		}
		
		DistanciaEdicion distanciaEdicion = new DistanciaEdicion();
		System.out.println("");
		int result = distanciaEdicion.trazaDistancia(cadena1.toCharArray(), cadena2.toCharArray());
		System.out.println("");
		System.out.println("Se han necesitado ----> " + result + " ediciones");
	}
	
	
	//En caso de que el fichero no exista solicita los datos por pantalla
	public static void entradaPorPantalla () {
		System.out.println("");
		System.out.println("El fichero introducido no existe...");
		System.out.println("");
		System.out.print("Intruduzca la primera palabra --> ");
		sc = new Scanner(System.in);

		String cadena1 = sc.nextLine();
		OperacionesFicheros.cadena1 = cadena1; 

		System.out.print("Introduzca la palabra a la que desea llegar --> ");
		String cadena2 = sc.nextLine();
		OperacionesFicheros.cadena2 = cadena2;

		System.out.println("Los ediciones pertinentes son: ");
		System.out.println("");
		
		for (int i = 0; i < cadena1.length(); i++) {
			DistanciaEdicion.res[i] = cadena1.charAt(i);
		}
		
		DistanciaEdicion distanciaEdicion = new DistanciaEdicion();
		int result = distanciaEdicion.distanciaEdicion(cadena1.toCharArray(), cadena2.toCharArray());
		System.out.println("");
		System.out.println("Se han necesitado ----> " + result + " ediciones");
	}
	
	//Llamada el metodo que solicita la traza por pantalla
	
	public static void trazaPorPantalla () {
		System.out.println("");
		System.out.println("MODO TRAZA ACTIVADO!!");
		System.out.println("");
		System.out.println("El fichero introducido no existe...");
		System.out.println("");
		System.out.print("Intruduzca la primera palabra --> ");
		sc = new Scanner(System.in);

		String cadena1 = sc.nextLine();
		OperacionesFicheros.cadena1 = cadena1; 

		System.out.print("Introduzca la palabra a la que desea llegar --> ");
		String cadena2 = sc.nextLine();
		OperacionesFicheros.cadena2 = cadena2;

		System.out.println("Los ediciones pertinentes son: ");
		System.out.println("");
		
		for (int i = 0; i < cadena1.length(); i++) {
			DistanciaEdicion.res[i] = cadena1.charAt(i);
		}
		
		DistanciaEdicion distanciaEdicion = new DistanciaEdicion();
		System.out.println("");
		int result = distanciaEdicion.trazaDistancia(cadena1.toCharArray(), cadena2.toCharArray());
		System.out.println("");
		System.out.println("Se han necesitado ----> " + result + " ediciones");
	}
}