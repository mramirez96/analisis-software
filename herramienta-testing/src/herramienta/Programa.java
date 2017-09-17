package herramienta;

import java.awt.EventQueue;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.AbstractListModel;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionListener;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import javax.swing.event.ListSelectionEvent;
import javax.swing.ScrollPaneConstants;

public class Programa extends JFrame {

	private JPanel contentPane;

	private JList<String> listaArchivos;
	private JList<String> listaClases;
	private JList<String> listaMetodos;
	private JTextArea textArea;

	private JLabel lbLineasTotales;
	private JLabel lbComentarios;
	private JLabel lbPorcentaje;
	private JLabel lbComplejidad;
	private JLabel lbFanIn;
	private JLabel lbFanOut;
	private JLabel lbLongitud;
	private JLabel lbVolumen;

	private int lineasMetodo;
	private int lineasComentadas;
	private int fanIn;
	private int fanOut;
	private int longitud;
	private float volumen;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Programa frame = new Programa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Programa() {
		setTitle("Herramienta de testing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 690);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// MENU //
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 805, 21);
		contentPane.add(menuBar);

		JMenu mnArchivo = new JMenu("Inicio");
		menuBar.add(mnArchivo);

		JMenuItem mntmAbrir = new JMenuItem("Seleccionar carpeta");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onEventElegirCarpeta();
			}
		});
		mnArchivo.add(mntmAbrir);

		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		mntmCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmCerrar);
		// MENU //

		// LISTA DE ARCHIVOS //
		JLabel lbArchivos = new JLabel("Archivos");
		lbArchivos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbArchivos.setBounds(15, 31, 57, 14);
		contentPane.add(lbArchivos);

		listaArchivos = new JList<String>();
		listaArchivos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				onArchivoValueChanged();
			}
		});
		String[] mensaje = new String[] {
				"Selecciona una carpeta que contenga archivos .java desde el men\u00FA Inicio -> Seleccionar carpeta" };
		actualizarLista(listaArchivos, mensaje);
		listaArchivos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaArchivos.setBounds(15, 47, 485, 98);

		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 49, 774, 112);
		scrollPane1.setViewportView(listaArchivos);
		contentPane.add(scrollPane1);
		// LISTA DE ARCHIVOS //

		// LISTA DE CLASES //
		JLabel lbClases = new JLabel("Clases");
		lbClases.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbClases.setBounds(487, 169, 302, 14);
		contentPane.add(lbClases);

		listaClases = new JList<String>();
		listaClases.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				onClasesValueChanged();
			}
		});
		listaClases.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaClases.setBounds(15, 173, 235, 181);

		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(487, 185, 302, 100);
		scrollPane2.setViewportView(listaClases);
		contentPane.add(scrollPane2);
		// LISTA DE CLASES //

		// LISTA DE METODOS //
		JLabel lbMetodos = new JLabel("Métodos");
		lbMetodos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbMetodos.setBounds(487, 296, 302, 14);
		contentPane.add(lbMetodos);

		listaMetodos = new JList<String>();
		listaMetodos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				onMetodosValueChanged();
			}
		});
		listaMetodos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaMetodos.setBounds(265, 173, 235, 181);

		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(487, 310, 302, 100);
		scrollPane3.setColumnHeaderView(listaMetodos);
		contentPane.add(scrollPane3);
		// LISTA DE METODOS //

		// ANALISIS //
		JPanel panelAnalisis = new JPanel();
		panelAnalisis.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)),
				"An\u00E1lisis del m\u00E9todo", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		((TitledBorder) panelAnalisis.getBorder())
				.setTitleFont(((TitledBorder) panelAnalisis.getBorder()).getTitleFont().deriveFont(Font.BOLD));
		panelAnalisis.setBounds(6, 179, 471, 231);
		contentPane.add(panelAnalisis);
		panelAnalisis.setLayout(null);

		JLabel lblLneasDeCdigo = new JLabel("Líneas de código totales");
		lblLneasDeCdigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLneasDeCdigo.setBounds(-19, 41, 254, 14);
		panelAnalisis.add(lblLneasDeCdigo);

		lbLineasTotales = new JLabel("-");
		lbLineasTotales.setForeground(Color.BLUE);
		lbLineasTotales.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbLineasTotales.setHorizontalAlignment(SwingConstants.CENTER);
		lbLineasTotales.setBounds(-19, 55, 254, 14);
		panelAnalisis.add(lbLineasTotales);

		JLabel lblLneasDeCdigo_1 = new JLabel("Líneas de código comentadas");
		lblLneasDeCdigo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLneasDeCdigo_1.setBounds(207, 41, 254, 14);
		panelAnalisis.add(lblLneasDeCdigo_1);

		lbComentarios = new JLabel("-");
		lbComentarios.setHorizontalAlignment(SwingConstants.CENTER);
		lbComentarios.setForeground(Color.BLUE);
		lbComentarios.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbComentarios.setBounds(207, 55, 254, 14);
		panelAnalisis.add(lbComentarios);

		JLabel lblPorcentajeDeLneas = new JLabel("Porcentaje de líneas de código comentadas");
		lblPorcentajeDeLneas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorcentajeDeLneas.setBounds(207, 80, 254, 14);
		panelAnalisis.add(lblPorcentajeDeLneas);

		lbPorcentaje = new JLabel("-");
		lbPorcentaje.setHorizontalAlignment(SwingConstants.CENTER);
		lbPorcentaje.setForeground(Color.BLUE);
		lbPorcentaje.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbPorcentaje.setBounds(207, 94, 254, 14);
		panelAnalisis.add(lbPorcentaje);

		JLabel lblComplejidadCiclomtica = new JLabel("Complejidad ciclomática");
		lblComplejidadCiclomtica.setHorizontalAlignment(SwingConstants.CENTER);
		lblComplejidadCiclomtica.setBounds(-19, 80, 254, 14);
		panelAnalisis.add(lblComplejidadCiclomtica);

		lbComplejidad = new JLabel("-");
		lbComplejidad.setHorizontalAlignment(SwingConstants.CENTER);
		lbComplejidad.setForeground(Color.BLUE);
		lbComplejidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbComplejidad.setBounds(-19, 94, 254, 14);
		panelAnalisis.add(lbComplejidad);

		JLabel lblFanIn = new JLabel("Fan in");
		lblFanIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblFanIn.setBounds(-19, 157, 254, 14);
		panelAnalisis.add(lblFanIn);

		lbFanIn = new JLabel("-");
		lbFanIn.setHorizontalAlignment(SwingConstants.CENTER);
		lbFanIn.setForeground(Color.BLUE);
		lbFanIn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbFanIn.setBounds(-19, 171, 254, 14);
		panelAnalisis.add(lbFanIn);

		JLabel lblFanOut = new JLabel("Fan out");
		lblFanOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblFanOut.setBounds(207, 157, 254, 14);
		panelAnalisis.add(lblFanOut);

		lbFanOut = new JLabel("-");
		lbFanOut.setHorizontalAlignment(SwingConstants.CENTER);
		lbFanOut.setForeground(Color.BLUE);
		lbFanOut.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbFanOut.setBounds(207, 171, 254, 14);
		panelAnalisis.add(lbFanOut);

		JLabel lblHalsteadLongitud = new JLabel("Halstead longitud");
		lblHalsteadLongitud.setHorizontalAlignment(SwingConstants.CENTER);
		lblHalsteadLongitud.setBounds(207, 118, 254, 14);
		panelAnalisis.add(lblHalsteadLongitud);

		lbLongitud = new JLabel("-");
		lbLongitud.setHorizontalAlignment(SwingConstants.CENTER);
		lbLongitud.setForeground(Color.BLUE);
		lbLongitud.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbLongitud.setBounds(207, 132, 254, 14);
		panelAnalisis.add(lbLongitud);

		JLabel lblHalsteadVolumen = new JLabel("Halstead volumen");
		lblHalsteadVolumen.setHorizontalAlignment(SwingConstants.CENTER);
		lblHalsteadVolumen.setBounds(-19, 119, 254, 14);
		panelAnalisis.add(lblHalsteadVolumen);

		lbVolumen = new JLabel("-");
		lbVolumen.setHorizontalAlignment(SwingConstants.CENTER);
		lbVolumen.setForeground(Color.BLUE);
		lbVolumen.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbVolumen.setBounds(-19, 133, 254, 14);
		panelAnalisis.add(lbVolumen);
		// ANALISIS //

		// CODIGO //
		JLabel lbCodigo = new JLabel("Código del método seleccionado");
		lbCodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbCodigo.setBounds(15, 418, 194, 14);
		contentPane.add(lbCodigo);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Arial", Font.PLAIN, 12));
		textArea.setBounds(15, 381, 769, 279);

		JScrollPane scrollPane4 = new JScrollPane();
		scrollPane4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane4.setBounds(15, 439, 769, 209);
		scrollPane4.setViewportView(textArea);
		contentPane.add(scrollPane4);
		// CODIGO //
	}

	protected void actualizaDatosAnalisis(String codigo) {
		lineasMetodo = obtieneLineasCodigo(codigo);
		lineasComentadas = obtieneLineasComentadas(codigo);
		int complejidad = obtenerComplejidadCiclomatica(codigo);
		fanIn = obtieneFanIn(codigo);
		fanOut = obtieneFanOut();

		lbLineasTotales.setText(String.valueOf(lineasMetodo));
		lbComentarios.setText(String.valueOf(lineasComentadas));

		DecimalFormat df = new DecimalFormat("0.00");
		lbPorcentaje.setText(String.valueOf(df.format(((float) lineasComentadas / lineasMetodo) * 100) + "%"));

		lbComplejidad.setText(String.valueOf(complejidad));

		lbFanIn.setText(String.valueOf(fanIn));
		lbFanOut.setText(String.valueOf(fanOut));
		
		calcularMetricasHalstead();
		lbLongitud.setText(String.valueOf(longitud));
		lbVolumen.setText(String.valueOf(volumen));
	}

	private int obtieneFanIn(String codigo) {
		int fanIn = 0;
		String[] lineas = textArea.getText().split("\\n");
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

	private int obtieneFanOut() {
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

	private int obtenerComplejidadCiclomatica(String codigo) {
		int c = 1;
		String[] lineas = codigo.split("\\n");
		for (int i = 0; i < lineas.length; i++) {
			c += (contarOcurrencias(lineas[i], '&') + contarOcurrencias(lineas[i], '|')) / 2;

			if (lineas[i].contains("if (") || lineas[i].contains("while (") || lineas[i].contains("for (")
					|| lineas[i].contains("case ") || lineas[i].contains("catch ")) {
				c++;
			}
		}

		return c;
	}

	private int obtieneLineasComentadas(String codigo) {
		int posicion, posicionSalto = 0, contador = 0;
		// se busca la primera vez que aparece
		posicion = codigo.indexOf("//");

		while (posicion != -1) { // mientras se encuentre el caracter
			contador++; // se cuenta
			posicionSalto = codigo.indexOf('\n', posicion + 1);
			// se sigue buscando a partir de la posici�n siguiente a la
			// encontrada
			posicion = codigo.indexOf("//", posicionSalto + 1);
		}

		return contador;
	}

	private int obtieneLineasCodigo(String codigo) {
		int posicion, contador = 0;
		// se busca la primera vez que aparece
		posicion = codigo.indexOf('\n');
		while (posicion != -1) { // mientras se encuentre el caracter
			contador++; // se cuenta
			// se sigue buscando a partir de la posici�n siguiente a la
			// encontrada
			posicion = codigo.indexOf('\n', posicion + 1);
		}

		return contador + 1;
	}

	private static void actualizarLista(JList<String> lista, String[] elementos) {
		lista.setModel(new AbstractListModel<String>() {
			String[] values = elementos;

			public int getSize() {
				return values.length;
			}

			public String getElementAt(int index) {
				return values[index];
			}
		});
	}

	private static String obtenerCodigo(String rutaArchivo, String nombre, int i) {
		String codigo = "";
		try {
			String[] archivo = leerArchivo(rutaArchivo);

			int inicio = -1;
			while (i != 0) {
				if (archivo[inicio + 1].contains(" " + nombre + "(") && archivo[inicio + 1].endsWith("{")) {
					i--;
				}
				inicio++;
			}

			int fin = inicio + 1, contadorLlaves = 1;
			while (contadorLlaves != 0) {
				contadorLlaves += contarOcurrencias(archivo[fin], '{');
				contadorLlaves -= contarOcurrencias(archivo[fin], '}');
				fin++;
			}

			// Quitamos una tabulacion al comienzo de cada linea para mejorar la
			// visualizaci�n del c�digo.
			String[] arrayCodigo = Arrays.copyOfRange(archivo, inicio, fin);
			for (int j = 0; j < arrayCodigo.length; j++) {
				try {
					arrayCodigo[j] = arrayCodigo[j].substring(1);
				} catch (Exception e) {
				}
			}

			codigo = String.join("\n", arrayCodigo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return codigo;
	}

	private static int obtenerOverloading(int index, ListModel lista) {
		// Averiguamos si hay varios metodos con el mismo nombre y, de ser as�,
		// obtenemos el numero del que seleccionamos.
		int c = 1;
		String nombre = (String) lista.getElementAt(index);
		for (int i = 0; i < index; i++) {
			if (nombre.compareTo((String) lista.getElementAt(i)) == 0) {
				c++;
			}
		}
		return c;
	}

	private static String[] leerArchivo(String rutaArchivo) throws IOException {
		FileReader fileReader = new FileReader(rutaArchivo);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<String> lines = new ArrayList<String>();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			lines.add(line);
		}
		bufferedReader.close();
		return lines.toArray(new String[lines.size()]);
	}

	private static int contarOcurrencias(String string, char caracter) {
		int c = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == caracter) {
				c++;
			}
		}
		return c;
	}
	
	private void calcularMetricasHalstead() {
		String[] lineas = textArea.getText().split("\\n");
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
	    volumen = (float) (longitud * Math.log10(operandosTotales + operadoresTotales) / Math.log10(2));
	}
	
	private static void incrementarContador(HashMap<String, Integer> mapa, String key, int incremento) {
		int actual = (mapa.containsKey(key)) ? mapa.get(key) : 0;
		mapa.put(key, actual + incremento );
	}
	
	private static boolean esKeyword(String s) {
		switch(s) {
			case "abstract":
			case "for":
			case "new":
			case "switch":
			case "default":
			case "continue":
			case "synchronized":
			case "boolean":
			case "do":
			case "if":
			case "private":
			case "this":
			case "break":
			case "double":
			case "implements":
			case "protected":
			case "throw":
			case "byte":
			case "else":
			case "public":
			case "throws":
			case "case":
			case "enum":
			case "return":
			case "catch":
			case "extends":
			case "int":
			case "short":
			case "try":
			case "char":
			case "interface":
			case "static":
			case "final":
			case "void":
			case "class":
			case "finally":
			case "long":
			case "const":
			case "float":
			case "super":
			case "while":
				return true;
		default:
				return false;
		}
	}
	
	private void onEventElegirCarpeta() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		if (chooser.showOpenDialog(Programa.this) == JFileChooser.APPROVE_OPTION) {

			// Buscamos todos los archivos .java en la carpeta
			// seleccionada
			File[] archivos = chooser.getSelectedFile().listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.toLowerCase().endsWith(".java");
				}
			});

			// Obtenemos la ruta de cada archivo y actualizamos la
			// lista.
			// Si la carpeta no contiene ningun archivo .java, mostramos
			// un mensaje de error.
			if (archivos.length > 0) {
				String[] nombres = new String[archivos.length];
				for (int i = 0; i < archivos.length; i++) {
					nombres[i] = archivos[i].getPath();
				}
				actualizarLista(listaArchivos, nombres);
				textArea.setText("");
				actualizarLista(listaClases, new String[1]);
				actualizarLista(listaMetodos, new String[1]);						
			} else {
				JOptionPane.showMessageDialog(Programa.this,
						"La carpeta seleccionada no contiene archivos .java", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void onArchivoValueChanged() {
		try {
			// Cuando el usuario selecciona un archivo, actualizamos la
			// lista de clases (por ahora se muestra solo la primera)
			String archivo = listaArchivos.getSelectedValue();
			if (!archivo.contains(
					"Selecciona una carpeta que contenga archivos .java desde el men\u00FA An\u00E1lisis -> Seleccionar carpeta")) {
				String[] clases = new String[1];
				clases[0] = archivo.substring(archivo.lastIndexOf("\\") + 1, archivo.lastIndexOf("."));
				actualizarLista(listaClases, clases);
				actualizarLista(listaMetodos, new String[1]);
				textArea.setText("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void onClasesValueChanged() {
		// Aca se actualiza la lista de metodos cuando el usuario
		// selecciona una clase.
		try {
			FileInputStream in = new FileInputStream(listaArchivos.getSelectedValue());
			CompilationUnit cu = JavaParser.parse(in);
			ClassOrInterfaceDeclaration clase = cu.getClassByName(listaClases.getSelectedValue()).get();

			// Class clase =
			// obtenerClaseDesdeArchivo(listaArchivos.getSelectedValue(),
			// listaClases.getSelectedValue());

			List<MethodDeclaration> metodos = clase.getMethods();
			List<ConstructorDeclaration> constructores = clase.getConstructors();

			String nombres[] = new String[metodos.size() + constructores.size()];
			for (int i = 0; i < constructores.size(); i++) {
				nombres[i] = constructores.get(i).getName().toString();
			}
			for (int i = 0; i < metodos.size(); i++) {
				nombres[i + constructores.size()] = metodos.get(i).getName().toString();
			}

			actualizarLista(listaMetodos, nombres);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void onMetodosValueChanged() {
		// Aca se muestran el c�digo del m�todo y los resultados del
		// an�lisis.
		String codigo = obtenerCodigo(listaArchivos.getSelectedValue(), listaMetodos.getSelectedValue(),
				obtenerOverloading(listaMetodos.getSelectedIndex(), listaMetodos.getModel()));
		textArea.setText(codigo);
		textArea.setCaretPosition(0);

		// Lo nuevo
		Analisis a = new Analisis(codigo, listaMetodos);
		lbLineasTotales.setText(String.valueOf(a.getLineasMetodo()));
		lbComentarios.setText(String.valueOf(a.getLineasComentadas()));
		lbPorcentaje.setText(a.getPorcentajeLineasComentadas());
		lbComplejidad.setText(String.valueOf(a.getComplejidad()));
		lbFanIn.setText(String.valueOf(a.getFanIn()));
		lbFanOut.setText(String.valueOf(a.getFanOut()));
		lbLongitud.setText(String.valueOf(a.getLongHalstead()));
		lbVolumen.setText(String.valueOf(a.getVolHalstead()));
	}
}

