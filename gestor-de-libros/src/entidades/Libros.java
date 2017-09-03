package entidades;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Libros extends Vector<Libro> {

	private String RutaArchivo;

	public Libros(String ruta) {
		RutaArchivo = ruta;
		cargarLibrosDesdeArchivo();
	}

	/**
	 * Hace la carga inicial del vector desde un archivo.
	 */
	private void cargarLibrosDesdeArchivo() {
		Libro libro;
		String[] campos;
		try {
			Scanner entrada = new Scanner(new FileReader(RutaArchivo));
			while (entrada.hasNextLine()) {
				campos = entrada.nextLine().split("\t");
				libro = new Libro();
				libro.setISBN(campos[0]);
				libro.setTitulo(campos[1]);
				libro.setAutor(campos[2]);
				libro.setEditorial(campos[3]);
				libro.setEdicion(Integer.parseInt(campos[4]));
				libro.setAnno_de_publicacion(Integer.parseInt(campos[5]));
				this.add(libro);
			}
			entrada.close();
		} catch (FileNotFoundException e) {
		}
	}

	/**
	 * Vuelca la información del vector a un archivo.
	 */
	public void guardarLibrosEnArchivo() {
		try {
			int i;
			PrintStream salida = new PrintStream(RutaArchivo);
			for (i = 0; i < size(); i++)
				imprimirEnArchivo.funcion(get(i), salida);
			salida.close();
		} catch (FileNotFoundException e) {
		}
	}

	/**
	 * Si encuentra coincidencia en ISBN devuelve la instancia ya guardada en el vector.
	 * En caso contrario devuelve null.
	 *
	 * @param libro instancia a buscar en el vector
	 * @return instancia ya cargada, null si no lo encontró
	 */
	public Libro get(Libro libro) {
		int pos = indexOf(libro);
		return pos < 0 ? null : get(pos);
	}

	/**
	 * Ordena el vector según la comparación definida en clase Libro
	 */
	public void ordenar() {
		Collections.sort(this);
	}

	Funcion<Libro> imprimirEnArchivo = new Funcion<Libro>() {
		@Override
		public void funcion(Libro libro, Object parametros) {
			PrintStream archivo = (PrintStream) parametros;
			archivo.print(libro.getISBN() + "\t");
			archivo.print(libro.getTitulo() + "\t");
			archivo.print(libro.getAutor() + "\t");
			archivo.print(libro.getEditorial() + "\t");
			archivo.print(libro.getEdicion() + "\t");
			archivo.print(libro.getAnno_de_publicacion() + "\n");
		}
	};
}
