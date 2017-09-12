package herramienta;

public class LineaCodigo {
	
	public static int cantidadLineas(String codigo) {
		int posicion, contador = 0;
		// se busca la primera vez que aparece
		posicion = codigo.indexOf('\n');
		while (posicion != -1) { // mientras se encuentre el caracter
			contador++; // se cuenta
			// se sigue buscando a partir de la posición siguiente a la encontrada
			posicion = codigo.indexOf('\n', posicion + 1);
		}

		return contador + 1;
	}
	
	public static int cantidadLineasComentadas(String codigo) {
		int posicion, posicionSalto = 0, contador = 0;
		// se busca la primera vez que aparece
		posicion = codigo.indexOf("//");

		while (posicion != -1) { // mientras se encuentre el caracter
			contador++; // se cuenta
			posicionSalto = codigo.indexOf('\n', posicion + 1);
			// se sigue buscando a partir de la posición siguiente a la encontrada
			posicion = codigo.indexOf("//", posicionSalto + 1);
		}

		return contador;
	}

	public static int contarOcurrencias(String string, char caracter) {
		int c = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == caracter) {
				c++;
			}
		}
		return c;
	}
}
