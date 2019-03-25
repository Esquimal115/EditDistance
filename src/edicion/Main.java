package edicion;

import java.io.File;

public class Main {

	public static boolean ficheroEntradaCorrecto;
	public static boolean traza;

	public static void main(String args[]) {
		
		if (args.length == 0) {
			OperacionesFicheros.entradaPorPantalla();
			System.exit(1);
		}
		
		for (int i = 0; i < args.length; i++) {

			File ficheroEntrada = new File(args[i]);

			if ("-h".equals(args[i])) {
				System.out.println("");
				System.out.println("SINTAXIS: ");
				System.out.println("edicion.jar [-t] [-h] [fichero_entrada] ");
				System.out.println("-t              Traza  ");
				System.out.println("-h              Muestra esta ayuda ");
			
				System.exit(1);
			}
			
			if ("-t".equals(args[i]) ) {
				traza = true; 
			}
			
			if (ficheroEntrada.exists()) {
				OperacionesFicheros fichero = new OperacionesFicheros();
				ficheroEntradaCorrecto = fichero.leerFicheros(ficheroEntrada);
			
			}
		
		}
		
			if (traza && ficheroEntradaCorrecto) {
				OperacionesFicheros.trazaEntradaPorFichero();
				System.exit(1);
			}
			
			if (traza && !ficheroEntradaCorrecto) {
				OperacionesFicheros.trazaPorPantalla();
				System.exit(1);
			}
			
			if (ficheroEntradaCorrecto) {
				OperacionesFicheros.entradaPorFichero();
				System.exit(1);
			}
		// En caso de que el fichero no exista introduciremos los datos por pantalla
			if (!ficheroEntradaCorrecto){
			OperacionesFicheros.entradaPorPantalla();
		}
	}
}
