package herramienta;

import java.text.DecimalFormat;

import javax.swing.JList;


public class Analisis {
	private String codigo;
	private int lineasMetodo;
	private int lineasComentadas;
	private int complejidad;
	private int fanIn;
	private int fanOut;
	private int longHalstead;
	private int volHalstead;
	

	public int getLineasMetodo() {
		return lineasMetodo;
	}
	public int getLineasComentadas() {
		return lineasComentadas;
	}
	public String getPorcentajeLineasComentadas() {
		DecimalFormat df = new DecimalFormat("0.00");
		return String.valueOf(df.format(((float) lineasComentadas / lineasMetodo) * 100) + "%");
	}
	public int getComplejidad() {
		return complejidad;
	}
	public int getFanIn() {
		return fanIn;
	}
	public int getFanOut() {
		return fanOut;
	}
	public int getLongHalstead() {
		return longHalstead;
	}
	public int getVolHalstead() {
		return volHalstead;
	}

	public Analisis(String codigo, JList<String> listaMetodos, JList<String> listaArchivos) {
		super();
		this.codigo = codigo;
		actualizarDatosAnalisis(listaMetodos, listaArchivos);
	}

	private void actualizarDatosAnalisis(JList<String> listaMetodos, JList<String> listaArchivos){
		lineasMetodo = LineaCodigo.cantidadLineas(codigo);
		lineasComentadas = LineaCodigo.cantidadLineasComentadas(codigo);
		complejidad = ComplejidadCiclomatica.obtener(codigo);
		fanIn = FanInOut.getFanIn(codigo, listaMetodos); 
		fanOut = FanInOut.getFanOut(codigo, listaMetodos, listaArchivos);
		
		Halstead h = new Halstead(); // falta
		longHalstead = h.getLongitud();
		volHalstead = h.getVolumen();
	}

	
}
