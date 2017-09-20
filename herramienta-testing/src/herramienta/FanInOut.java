package herramienta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JList;

public class FanInOut {
	// Cuenta cuantos métodos llama el método seleccionado
	public static int getFanIn(String codigo, JList<String> listaMetodos) {
		int fanIn = 0;
		String[] lineas = codigo.split("\\n");
		String[] metodos = new String[listaMetodos.getModel().getSize() - 1];

		int indice = 0, seleccionado = listaMetodos.getSelectedIndex();
		for (int i = 0; i <= metodos.length; i++) {
			String metodo = listaMetodos.getModel().getElementAt(i);
			if (i != seleccionado) {
				metodos[indice] = metodo;
				indice++;
			}
		}

		for (int i = 0; i < lineas.length; i++) {
			for (int j = 0; j < metodos.length; j++) {
				if (lineas[i].contains(metodos[j])) {
					fanIn++;
				}
			}
		}

		return fanIn;
	}

	public static int getFanOut(String codigo, JList<String> listaMetodos, JList<String> listaArchivos) {
		int contadorFanOut = 0;
		String rutaArchivo = listaArchivos.getSelectedValue();// .substring(0, listaArchivos.getSelectedValue().indexOf(".java") + 5);//.replace("\\", "\\\\");;
		String metodoSelecionado = listaMetodos.getSelectedValue();
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File(rutaArchivo);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {
				if (linea.contains(metodoSelecionado) && !linea.contains("class") && !linea.contains("public")
						&& !linea.contains("private") && !linea.contains("protected"))
					contadorFanOut++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return contadorFanOut;
	}
}
