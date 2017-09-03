package main;

import java.io.*;
import java.util.*;

import entidades.Libro;
import entidades.Libros;
import entidades.Funcion;

public class Main {

	public static Scanner teclado = new Scanner(System.in);
	public static PrintStream out = System.out;

	public static void pausar(String mensage) {
		out.print(mensage + "\nPresione <ENTER> para continuar . . . ");
		teclado.nextLine();
		out.println();
	}

	public static String leer_cadena(String mensaje) {
		out.print(mensaje + ": ");
		return teclado.nextLine();
	}

	public static int leer_entero(String mensaje) {
		try {
			return Integer.parseInt(leer_cadena(mensaje));
		} catch (NumberFormatException e) {
			out.print("N\u00FAmero incorrecto.");
			return leer_entero(mensaje);
		}
	}

	public static String ruta = "libros.tsv";

	public static void main(String[] args) {

		Funcion<Libro> imprimir = new Funcion<Libro>() {
			@Override
			public void funcion(Libro libro, Object parametros) {
				out.println(libro);
				int[] contador = (int[]) parametros;
				contador[0]++;
			}
		};

		if (!System.getProperties().get("os.name").equals("Linux") && System.console() != null)
			try {
				out = new PrintStream(System.out, true, "CP850");
				teclado = new Scanner(System.in, "CP850");
			} catch (UnsupportedEncodingException e) {
			}

		int i, n;
		Libro dato = null, libro;
		int[] contador = { 0 };
		int opcion, subopcion;

		Libros libros = new Libros(ruta);
		libro = new Libro();
		do {
			out.println("MEN\u00DA");
			out.println("1.- Altas");
			out.println("2.- Consultas");
			out.println("3.- Actualizaciones");
			out.println("4.- Bajas");
			out.println("5.- Ordenar registros");
			out.println("6.- Listar registros");
			out.println("7.- Salir");

			// Cuando esto se haga pantalla, dudo que sirva.
			do {
				opcion = leer_entero("Seleccione una opci\u00F3n");
				if (opcion < 1 || opcion > 7)
					out.println("Opci\u00F3n no v\u00E1lida.");
			} while (opcion < 1 || opcion > 7);
			out.println();
			if (libros.isEmpty() && opcion != 1 && opcion != 7) {
				pausar("No hay registros.\n");
				continue;
			}
			if (opcion < 5) { // Alta, consulta, actualizaciones, bajas
				libro.setISBN(leer_cadena("Ingrese el ISBN del libro"));
				dato = libros.get(libro);
				if (dato != null) {
					out.println();
					imprimir.funcion(dato, contador);
				}
			}
			if (opcion == 1 && dato != null) // Alta
				out.println("El registro ya existe.");
			else if (opcion >= 2 && opcion <= 4 && dato == null) // Consulta, actualizacion, baja
				out.println("\nRegistro no encontrado.");
			else
				switch (opcion) {
				case 1: // Alta
					libro.setTitulo(leer_cadena("Ingrese el titulo"));
					libro.setAutor(leer_cadena("Ingrese el autor"));
					libro.setEditorial(leer_cadena("Ingrese el editorial"));
					libro.setEdicion(leer_entero("Ingrese el edicion"));
					libro.setAnno_de_publicacion(leer_entero("Ingrese el anno de publicacion"));
					libros.add(libro);
					libro = new Libro();
					out.println("\nRegistro agregado correctamente.");
					break;
				case 3: // Actualizacion
					out.println("Men\u00FA de modificaci\u00F3n de campos");
					out.println("1.- titulo");
					out.println("2.- autor");
					out.println("3.- editorial");
					out.println("4.- edicion");
					out.println("5.- anno de publicacion");
					do {
						subopcion = leer_entero("Seleccione un n\u00FAmero de campo a modificar");
						if (subopcion < 1 || subopcion > 5)
							out.println("Opci\u00F3n no v\u00E1lida.");
					} while (subopcion < 1 || subopcion > 5);
					switch (subopcion) {
					case 1:
						dato.setTitulo(leer_cadena("Ingrese el nuevo titulo"));
						break;
					case 2:
						dato.setAutor(leer_cadena("Ingrese el nuevo autor"));
						break;
					case 3:
						dato.setEditorial(leer_cadena("Ingrese el nuevo editorial"));
						break;
					case 4:
						dato.setEdicion(leer_entero("Ingrese el nuevo edicion"));
						break;
					case 5:
						dato.setAnno_de_publicacion(leer_entero("Ingrese el nuevo anno de publicacion"));
						break;
					}
					out.println("\nRegistro actualizado correctamente.");
					break;
				case 4: // Baja
					libros.remove(dato);
					out.println("Registro borrado correctamente.");
					break;
				case 5: // Ordenar registros
					libros.ordenar();
					out.println("Registros ordenados correctamente.");
					break;
				case 6: // Listar registros
					n = libros.size();
					contador[0] = 0;
					for (i = 0; i < n; i++)
						imprimir.funcion(libros.get(i), contador);
					out.println("Total de registros: " + contador[0] + ".");
					break;
				}
			if (opcion < 7 && opcion >= 1)
				pausar("");
		} while (opcion != 7);
		libros.guardarLibrosEnArchivo();
	}
}
