package entidades;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Grafica extends JFrame{
	
	private DefaultTableModel modelo;
	private JTable table;
	String ruta = "libros.tsv";
	private Libros libros = new Libros(ruta);
	JPanel panel2=new JPanel();
	
	
	public Grafica() { //No olvidar agregar la opcion para que no siga ejecutando despues de cerrar la ventana
		
		setTitle("Gestor de Libros");
		getContentPane().setLayout(null);
		
		crear_Titulo();
		crear_Pestañas();
		crear_Tabla();
		boton_refresh();
		boton_ayuda();
		setSize(750,700); ////Tamaño ventana principal
		setVisible(true);
	
	}
	private void crear_Tabla() {
		
		
		String[] columnNames = {"ISBN", "Titulo", "Autor", "Editorial", "Edicion", "Anio de publicacion"};
		
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(columnNames);
		JTable table = new JTable(modelo);
		
		cargar_Tabla();
		
		 TableRowSorter<DefaultTableModel> ordena = new TableRowSorter<DefaultTableModel>(modelo);
		 table.setRowSorter(ordena); //Estos 2 permiten ordenar la tabla de mayor a menor o viceversa segun campo seleccionado
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(18,390,700,250); //////////////////////Posicion tabla
        getContentPane().add(scrollPane);
	}
	
	private void crear_Pestañas() {
	
   	 JTabbedPane pestañas=new JTabbedPane();
       pestañas.setBounds(90, 100, 550, 250); /////////////////////Posicion pestañas
       
       JPanel panel1=new JPanel(); //Por el momento se hace de esta forma
       pestañas.addTab("Consultas", panel1);
       
       Alta alta = new Alta (panel2,ruta);
       pestañas.addTab("Altas", panel2);
       
       JPanel panel3=new JPanel();
       pestañas.addTab("Bajas", panel3);

       JPanel panel4=new JPanel();
       pestañas.addTab("Modificaciones", panel4);
       
       getContentPane().add(pestañas);	
	}
	
	private void crear_Titulo() {
		ImageIcon imagen = new ImageIcon("Imagenes/Titulo.jpg");
		JLabel etiqueta = new JLabel(imagen);
		etiqueta.setBounds(0,5,1024,90);
		getContentPane().add(etiqueta);	
	}
	
	private void boton_refresh() {
		JButton botonRefresh = new JButton();
		ImageIcon refresh = new ImageIcon ("Imagenes/Refresh.jpg");
		botonRefresh.setIcon(refresh);
		botonRefresh.setBounds(667,320,50,50);
		//(595,200,50,50)
		getContentPane().add(botonRefresh);
		
		botonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while (modelo.getRowCount() > 0) { //No me fije mucho en esto asi que lo hice de esta forma, para "actualizar" 
					//en realida borra todo lo que tenga la tabla y carga de vuelta todo lo que hay en el archivo
					modelo.removeRow(0);			
				}
				cargar_Tabla();
			}
		});
		
	}
	
	private void boton_ayuda() { //Lo relacionado a la ayuda va aca
		JButton botonAyuda = new JButton();
		ImageIcon ayuda = new ImageIcon ("Imagenes/ayuda.jpg");
		botonAyuda.setIcon(ayuda);
		botonAyuda.setBounds(20,320,50,50);
		getContentPane().add(botonAyuda);
		
		botonAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("aiudaaaaa"); 
			}
		});
		
	}
	
	private void cargar_Tabla () { //Para cargar la tabla de entrada, o cada vez que se aprieta el boton de actualizar
		libros = new Libros("libros.tsv"); //Carga cada linea del archivo
		
		Object []data = new Object[6]; //el tam representa la cantidad de columnas, isbn, titulo.....
		
		for(int i=0; i< libros.size(); i++) {
			
			data[0] = libros.get(i).getISBN();
			data[1] = libros.get(i).getTitulo();
			data[2] = libros.get(i).getAutor();
			data[3] = libros.get(i).getEditorial();
			data[4] = libros.get(i).getEdicion();
			data[5] = libros.get(i).getAnno_de_publicacion();
			modelo.addRow(data); //lo agrego al modelo en lugar de a la tabla directamente
		}
	}
}
