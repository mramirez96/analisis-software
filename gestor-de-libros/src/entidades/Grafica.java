package entidades;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Toolkit;

public class Grafica extends JFrame{
	
	private boolean adminUser;
	private DefaultTableModel modelo;
	private JTable table;
	String ruta = "TSV\\libros.tsv";
	private Libros libros = new Libros(ruta);
	JPanel panel1=new JPanel();
	JPanel panel2=new JPanel();
	JPanel panel3=new JPanel();
	JPanel panel4=new JPanel();
	private TableRowSorter<DefaultTableModel> modeloOrdenado;
	
	public Grafica(boolean adminUser) {
		//No olvidar agregar la opcion para que no siga ejecutando despues de cerrar la ventana
		
		setTitle("Gestor de Libros");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes/Icono.png"));
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(222,184,135));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.adminUser = adminUser;
		
		crear_Tabla();
		crear_Titulo();
		crear_pestañas();
		boton_ayuda();
		setSize(750,700); ////Tama�o ventana principal
		setVisible(true);
		
		setLocationRelativeTo(null);
	}
	private void crear_Tabla() {
		
		
		String[] columnNames = {"ISBN", "Titulo", "Autor", "Editorial", "Edicion", "Anio de publicacion"};
		
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(columnNames);
		JTable table = new JTable(modelo);
		table.setEnabled(false);
		
		Tabla.cargar_Tabla(libros, modelo);
		
		 this.modeloOrdenado = new TableRowSorter<DefaultTableModel>(modelo);
		 table.setRowSorter(this.modeloOrdenado); //Estos 2 permiten ordenar la tabla de mayor a menor o viceversa segun campo seleccionado
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(18,390,700,250); //////////////////////Posicion tabla
        getContentPane().add(scrollPane);
	}
	
	private void crear_pestañas() {
	TableRowSorter<DefaultTableModel> modeloOrdenado = this.modeloOrdenado;
   	   JTabbedPane pestañas = new JTabbedPane();
       pestañas.setBounds(90, 100, 550, 250); /////////////////////Posicion pestañas
       pestañas.addChangeListener(new ChangeListener() { 
    	   	//Detecto el cambio entre pestañas para actualizar la tabla
			@Override
			public void stateChanged(ChangeEvent e) {
				Tabla.delete_filter(modeloOrdenado);
			}
    	});
       
       Consulta consulta = new Consulta (panel1,ruta,this.modeloOrdenado);
       pestañas.addTab("Consultas", panel1);
       panel1.setBackground(new Color(218,165,32));
       
       if (adminUser) {
    	   
       Alta alta = new Alta (panel2,ruta,modelo);
       pestañas.addTab("Altas", panel2);
       panel2.setBackground(new Color(218,165,32));
       
       Baja baja = new Baja(panel3,ruta,modelo);
       pestañas.addTab("Bajas", panel3);
       panel3.setBackground(new Color(218,165,32));

       Modificacion modif = new Modificacion(panel4,ruta,modelo);
       pestañas.addTab("Modificaciones", panel4);
       panel4.setBackground(new Color(218,165,32));
       }
       
       getContentPane().add(pestañas);
	}
	
	private void crear_Titulo() {
		ImageIcon imagen = new ImageIcon("Imagenes/Titulo.jpg");
		JLabel etiqueta = new JLabel(imagen);
		etiqueta.setBounds(0,5,1024,90);
		getContentPane().add(etiqueta);	
	}
	
	private void boton_ayuda() {
		//Lo relacionado a la ayuda va aca
		JButton botonAyuda = new JButton();
		ImageIcon ayuda = new ImageIcon ("Imagenes/ayuda.jpg");
		botonAyuda.setIcon(ayuda);
		botonAyuda.setBounds(20,320,50,50);
		botonAyuda.setBackground(Color.blue);
		getContentPane().add(botonAyuda);
		
		botonAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("aiudaaaaa"); 
			}
		});
		
	}
}
