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
	
	
	public Grafica() {
		//No olvidar agregar la opcion para que no siga ejecutando despues de cerrar la ventana
		setTitle("Gestor de Libros");
		getContentPane().setLayout(null);
		
		crear_Tabla();
		
		crear_Titulo();
		crear_pestañas();
		boton_refresh();
		boton_ayuda();
		setSize(750,700); ////Tama�o ventana principal
		setVisible(true);
	
	}
	private void crear_Tabla() {
		
		
		String[] columnNames = {"ISBN", "Titulo", "Autor", "Editorial", "Edicion", "Anio de publicacion"};
		
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(columnNames);
		JTable table = new JTable(modelo);
		
		Tabla.cargar_Tabla(libros, modelo);
		
		 TableRowSorter<DefaultTableModel> ordena = new TableRowSorter<DefaultTableModel>(modelo);
		 table.setRowSorter(ordena); //Estos 2 permiten ordenar la tabla de mayor a menor o viceversa segun campo seleccionado
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(18,390,700,250); //////////////////////Posicion tabla
        getContentPane().add(scrollPane);
	}
	
	private void crear_pestañas() {
	
   	 JTabbedPane pestañas=new JTabbedPane();
       pestañas.setBounds(90, 100, 550, 250); /////////////////////Posicion pestañas
       
       JPanel panel1=new JPanel(); //Por el momento se hace de esta forma
       pestañas.addTab("Consultas", panel1);
       
       Alta alta = new Alta (panel2,ruta,modelo);
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
				Tabla.refresh_Tabla(libros, modelo);
			}
		});
	}
	
	private void boton_ayuda() {
		//Lo relacionado a la ayuda va aca
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
}
