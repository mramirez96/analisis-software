package entidades;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.Scanner;


public class Log {
	private static String _RUTA = "TSV\\log.txt";
			
	public static void writeLog(String mensaje) {
		String existingLogs = getLogs();
		try {
			PrintStream salida = new PrintStream(_RUTA);
			salida.print(existingLogs + (LocalDateTime.now()).toString() + " | " + mensaje);
			salida.close();
		} catch (FileNotFoundException e) {
		}
	}
	
	private static String getLogs() {
		String text = "";
		try {
			Scanner entrada = new Scanner(new FileReader(_RUTA));
			while (entrada.hasNextLine()) {
				text += entrada.nextLine() + "\n";
			}
			entrada.close();
		} catch (FileNotFoundException e) {
		}
		return text;
	}
}
