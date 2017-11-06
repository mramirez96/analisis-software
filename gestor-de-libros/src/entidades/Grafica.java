package entidades;

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
	
	private DefaultTableModel modelo;
	private JTable table;
	String ruta = "TSV\\libros.tsv";
	private Libros libros = new Libros(ruta);
	JPanel panel2=new JPanel();
	private TableRowSorter<DefaultTableModel> modeloOrdenado;
	
	public Grafica() {
		//No olvidar agregar la opcion para que no siga ejecutando despues de cerrar la ventana
		
		setTitle("Gestor de Libros");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes/Icono.png"));
		getContentPane().setLayout(null);
		
		crear_Tabla();
		
		crear_Titulo();
		crear_pestañas();
		boton_ayuda();
		setSize(750,700); ////Tama�o ventana principal
		setVisible(true);
	
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
       JPanel panel1 = new JPanel(); //Por el momento se hace de esta forma
       Consulta consulta = new Consulta (panel1,ruta,this.modeloOrdenado);
       pestañas.addTab("Consultas", panel1);
       
       Alta alta = new Alta (panel2,ruta,modelo);
       pestañas.addTab("Altas", panel2);
       
       JPanel panel3 = new JPanel();
       Baja baja = new Baja(panel3,ruta,modelo);
       pestañas.addTab("Bajas", panel3);

       JPanel panel4 = new JPanel();
       Modificacion modif = new Modificacion(panel4,ruta,modelo);
       pestañas.addTab("Modificaciones", panel4);
       
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
		getContentPane().add(botonAyuda);
		
		botonAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("aiudaaaaa"); 
			}
		});
		
	}
}
