package herramienta;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Halstead {
	private int longitud;
	private int volumen;

	public int getLongitud() {
		return longitud;
	}
	public int getVolumen() {
		return volumen;
	}

	public Halstead() {
		// tomar todo lo que haga falta para calcularlo
		calcularMetricasHalstead();
	}

	private void calcularMetricasHalstead() {
		/*String[] lineas = textArea.getText().split("\\n");
		HashMap<String,Integer> operadores = new HashMap<String,Integer>();
		HashMap<String,Integer> operandos = new HashMap<String,Integer>();
		
		Reader reader = new StringReader(textArea.getText());
		StreamTokenizer st = new StreamTokenizer(reader);
		try {
			int token;
			while((token = st.nextToken()) != StreamTokenizer.TT_EOF) {
				if(st.ttype==StreamTokenizer.TT_NUMBER){
					incrementarContador(operandos, String.valueOf(st.nval), 1);
				}else if(st.ttype==StreamTokenizer.TT_WORD) {
					if (esKeyword(st.sval)) {
						incrementarContador(operadores, st.sval, 1);
					} else if (!Character.isUpperCase(st.sval.charAt(0))) {
						incrementarContador(operandos, st.sval, 1);
					}
				} else if(st.ttype != StreamTokenizer.TT_EOF && st.ttype != StreamTokenizer.TT_EOL) {
					switch ((char) token) {
						case '+':
						case '-':
						case '*':
						case '/':
						case '%':
						case '=':
						case '<':
						case '>':
						case '&':
						case '|':
						case '!':
							incrementarContador(operadores, Character.toString((char)token), 1);
							break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int operadoresUnicos = 0, operandosUnicos = 0;
		Iterator it = operadores.entrySet().iterator();
	    while (it.hasNext()) {
	        Entry entrada = (Entry)it.next();
	        if ((int)entrada.getValue() > 0) {
	        	operadoresUnicos++;
	        }
	    }
	    it = operandos.entrySet().iterator();
	    while (it.hasNext()) {
	        Entry entrada = (Entry)it.next();
	        if ((int)entrada.getValue() > 0) {
	        	operandosUnicos++;
	        }
	    }	
	    longitud = operadoresUnicos + operandosUnicos;
	    
	    float operandosTotales = 0, operadoresTotales = 0;
	    for (int v : operandos.values()) {
	        operandosTotales += v;
	    }
	    for (int v : operadores.values()) {
	    	operadoresTotales += v;
	    }
	    volumen = (float) (longitud * Math.log10(operandosTotales + operadoresTotales) / Math.log10(2));*/
	}
}
