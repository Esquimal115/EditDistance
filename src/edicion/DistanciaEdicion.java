package edicion;

public class DistanciaEdicion {
	
	static int tam = OperacionesFicheros.cadena2.length() + OperacionesFicheros.cadena1.length();
	static char[] res = new char[tam];

	// Funcion para eliminar un caracter
	private static char[] eliminar(char[] palabra, int pos) {

		for (int i = pos; i < palabra.length - 1; i++) {
			res[i] = palabra[i + 1];
			res[i + 1] = 0;
		}
		return res;
	}

	// Funcion para insertar un caracter
	private static char[] insertar(char[] palabra, char a, int pos) {

		for (int i = palabra.length - 1; i >= pos; i--) {

			if (pos == i) {
				res[i] = a;
			} else {
				res[i] = palabra[i - 1];
			}
		}
		return res;
	}

	// Funcion para sustituir un caracter por otro
	private static char[] sustituir(char[] palabra, char a, int pos) {
		for (int i = 0; i < palabra.length; i++) {
			if (pos == i) {
				res[i] = a;
				break;
			}
		}

		return res;
	}

	// Funcion para hayar la tabla de distancia de edicion
	public int distanciaEdicion(char[] cadena1, char[] cadena2) {
		int tabla[][] = new int[cadena1.length + 1][cadena2.length + 1];

		for (int i = 0; i < tabla[0].length; i++) {
			tabla[0][i] = i;
		}

		for (int i = 0; i < tabla.length; i++) {
			tabla[i][0] = i;
		}

		for (int i = 1; i <= cadena1.length; i++) {
			for (int j = 1; j <= cadena2.length; j++) {
				if (cadena1[i - 1] == cadena2[j - 1]) {
					tabla[i][j] = tabla[i - 1][j - 1];
				} else {
					tabla[i][j] = 1 + min(tabla[i - 1][j - 1], tabla[i - 1][j], tabla[i][j - 1]);
				}
			}
		}
			
			imprimirEdicion(tabla, cadena1, cadena2);
			return tabla[cadena1.length][cadena2.length];
	}

	// Funcion para imprimir en cada paso la distancia de edicion
	public void imprimirEdicion(int tabla[][], char[] cadena1, char[] cadena2) {
		int i = cadena1.length;
		int j = cadena2.length;

		while (true) {

			if (i == 0 || j == 0) {
				if (j > 0) {
					for (int aux = j - 1; aux >= 0; aux--) {
						insertar(res, cadena2[aux], 0);
						System.out.print("Insertar   en  posicion " + 0);
						System.out.print(" ----> ");
						System.out.println(res);
					}
				}

				if (i > 0) {
					for (int aux = i - 1; aux >= 0; aux--) {
						eliminar(res, aux);
						System.out.print("Eliminar en  posicion " + (aux + 1));
						System.out.print(" ----> ");
						System.out.println(res);
					}
				}
				break;
			}

			// Condicion de NO hacer nada
			if (cadena1[i - 1] == cadena2[j - 1]) {
				i = i - 1;
				j = j - 1;

				// Condicion para sustituir una letra por otra
			} else if (tabla[i][j] == tabla[i - 1][j - 1] + 1) {

				sustituir(res, cadena2[j - 1], i - 1);
				System.out.print("Sustituir  en  posicion " + i);
				System.out.print(" ----> ");
				System.out.println(res);
				i = i - 1;
				j = j - 1;
				// Condicion de eliminacion de un caracter
			} else if (tabla[i][j] == tabla[i - 1][j] + 1) {
				eliminar(res, i - 1);
				System.out.print("Eliminar   en  posicion " + i);
				System.out.print(" ----> ");
				System.out.println(res);
				i = i - 1;

				// Condicion para insertar un caracter
			} else if (tabla[i][j] == tabla[i][j - 1] + 1) {

				insertar(res, cadena2[j - 1], i);

				System.out.print("Insertar   en  posicion " + (i + 1));
				System.out.print(" ----> ");
				System.out.println(res);
				j = j - 1;
			} else {
				throw new IllegalArgumentException("Error encontrado");
			}

		}
	}

	private int min(int a, int b, int c) {
		int l = Math.min(a, b);
		return Math.min(l, c);
	}
	
	public int trazaDistancia (char[] cadena1, char[] cadena2) {
		int tabla[][] = new int[cadena1.length + 1][cadena2.length + 1];

		for (int i = 0; i < tabla[0].length; i++) {
			tabla[0][i] = i;
		}

		for (int i = 0; i < tabla.length; i++) {
			tabla[i][0] = i;
		}

		for (int i = 1; i <= cadena1.length; i++) {
			for (int j = 1; j <= cadena2.length; j++) {
				if (cadena1[i - 1] == cadena2[j - 1]) {
					tabla[i][j] = tabla[i - 1][j - 1];
				} else {
					tabla[i][j] = 1 + min(tabla[i - 1][j - 1], tabla[i - 1][j], tabla[i][j - 1]);
				}
			}
		}
			
			trazaEdicion(tabla, cadena1, cadena2);
			return tabla[cadena1.length][cadena2.length];
	}
	
	public void trazaEdicion(int tabla[][], char[] cadena1, char[] cadena2) {
		int i = cadena1.length;
		int j = cadena2.length;

		while (true) {

			if (i == 0 || j == 0) {
				if (j > 0) {
					for (int aux = j - 1; aux >= 0; aux--) {
						insertar(res, cadena2[aux], 0);
						System.out.print("Insertar   el caracter " + cadena2[aux]+ " en  posicion " + 0);
						System.out.print(" ----> ");
						System.out.println(res);
					}
				}

				if (i > 0) {
					for (int aux = i - 1; aux >= 0; aux--) {
						eliminar(res, aux);
						System.out.print("Eliminamos el caracter " +cadena2[aux]+ " en  posicion " + (aux + 1));
						System.out.print(" ----> ");
						System.out.println(res);
					}
				}
				break;
			}

			// Condicion de NO hacer nada
			if (cadena1[i - 1] == cadena2[j - 1]) {
				System.out.print("No hacemos nada en la posicion " + (i));
				System.out.print(" ----> ");
				System.out.println(res);
				i = i - 1;
				j = j - 1;

				// Condicion para sustituir una letra por otra
			} else if (tabla[i][j] == tabla[i - 1][j - 1] + 1) {

				sustituir(res, cadena2[j - 1], i - 1);
				System.out.print("Sustituir  el caracter " + cadena1[i-1] + " por el caracter "+ cadena2[j-1] +  " en  posicion " + i);
				System.out.print(" ----> ");
				System.out.println(res);
				i = i - 1;
				j = j - 1;
				// Condicion de eliminacion de un caracter
			} else if (tabla[i][j] == tabla[i - 1][j] + 1) {
				eliminar(res, i - 1);
				System.out.print("Eliminamos el caracter " + cadena1[i-1] + " en la posicion " + i);
				System.out.print(" ----> ");
				System.out.println(res);
				i = i - 1;

				// Condicion para insertar un caracter
			} else if (tabla[i][j] == tabla[i][j - 1] + 1) {

				insertar(res, cadena2[j - 1], i);

				System.out.print("Insertartamos  el caracter " +cadena2[j-1] + " en la posicion " + (i + 1));
				System.out.print(" ----> ");
				System.out.println(res);
				j = j - 1;
			} else {
				throw new IllegalArgumentException("Error encontrado");
			}

		}
	}
	
}
