package usuarios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Vector;

import entidades.Log;


public class Usuarios extends Vector<Usuario> {
	private String RutaArchivo;
	
	
	public Usuarios(String ruta) {
		RutaArchivo = ruta;
		cargarUsuariosDesdeArchivo();
	}

	/**
	 * Hace la carga inicial del vector desde un archivo.
	 */
	private void cargarUsuariosDesdeArchivo() {
		Usuario us;
		String[] campos;
		try {
			Scanner entrada = new Scanner(new FileReader(RutaArchivo));
			while (entrada.hasNextLine()) {
				campos = entrada.nextLine().split("\t");
				us = new Usuario(campos[0], campos[1]);
				this.add(us);
			}
			entrada.close();
		} catch (FileNotFoundException e) {
		}
	}
	
	/**
	 * Vuelca la información del vector a un archivo.
	 */
	public void guardarUsuariosEnArchivo() {
		try {
			int i;
			PrintStream salida = new PrintStream(RutaArchivo);
			Usuario us;
			for (i = 0; i < size(); i++) {
				us = get(i);
				salida.print(us.getUsuario() + "\t");
				salida.print(us.getContrasenia() + "\n");
			}
			salida.close();
		} catch (FileNotFoundException e) {
		}
	}
	
	/**
	 * Devuelve si existe la combinación usuario - contraseña
	 * @param us
	 * @return
	 */
	public boolean existeUsuario(Usuario us) {
		return (indexOf(us) > -1);
	}
	
	/**
	 * Devuelve si existe el nombre de usuario
	 * @param user
	 * @return
	 */
	private boolean existeUsuario(String user) {
		for (Usuario us : this) {
			if (us.getUsuario().equals(user))
				return true;
		}
		return false;
	}
	
	@Override
	public synchronized boolean add(Usuario usuario) {
		if (existeUsuario(usuario.getUsuario()))
			return false;
		else
			return Usuarios.super.add(usuario);
	}
}
