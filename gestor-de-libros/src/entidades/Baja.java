package entidades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

public class Baja {
	private JFormattedTextField isbn;
	private MaskFormatter maskISBN;
	private JLabel lblIsbn;
	private JTextField titulo;
	private JLabel lblTitulo;
	private JTextField autor;
	private JLabel lblAutor;
	private JTextField editorial;
	private JLabel lblEditorial;
	private JFormattedTextField edicion;
	private JLabel lblEdicion;
	private JFormattedTextField anio;
	private MaskFormatter maskAnio;
	private JLabel lblAnio;
	private JButton eliminar;
	private JButton buscar;
	private Libro libro;
	private Libros libros;
	
	public Baja(JPanel panel, String ruta, DefaultTableModel modelo, Libros libros) {
		panel.setLayout(null);
		this.libros = libros;
		
		/******   ISBN   ******/
		try {
			maskISBN = new MaskFormatter("###-###-####-##-#");
		} catch (ParseException e1) {
			// callo la excepcion
		}
		maskISBN.setPlaceholderCharacter('_');
		isbn = new JFormattedTextField(maskISBN);
		isbn.setBounds(70, 20, 150, 25);
		panel.add(isbn);
		
		lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(30, 20, 100, 25);
		panel.add(lblIsbn);
		
		
		/******   BUSCAR   ******/		
		buscar = new JButton();
		buscar.setBounds(250, 20, 80, 25);
		buscar.setText("Buscar");
		panel.add(buscar);
		
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isbn.getValue() == null || isbn.getText().contains("_")) {
					JOptionPane.showMessageDialog(null, "Ingrese el ISBN del libro a dar de baja");
				} else {					
					libro = new Libro();
					libro.setISBN(isbn.getText());
					libro = libros.get(libro);
					if (libro == null) {
						JOptionPane.showMessageDialog(null, "El ISBN ingresado no existe en los registros");
					} else {
						editorial.setText(libro.getEditorial());
						titulo.setText(libro.getTitulo());
						edicion.setText(String.valueOf(libro.getEdicion()));
						autor.setText(libro.getAutor());
						anio.setText(String.valueOf(libro.getAnno_de_publicacion()));
						eliminar.setEnabled(true);
					}
					
				}
			}
		});
		
		/******   TITULO   ******/
		titulo = new JTextField();
		titulo.setBounds(70, 80, 150, 25);
		titulo.setEnabled(false);
		panel.add(titulo);
		
		lblTitulo = new JLabel("T\u00edtulo");
		lblTitulo.setBounds(30, 80, 100, 25);
		panel.add(lblTitulo);
		
		
		/******   AUTOR   ******/
		autor = new JTextField();
		autor.setBounds(70, 115, 150, 25);
		autor.setEnabled(false);
		panel.add(autor);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setBounds(30, 115, 100, 25);
		panel.add(lblAutor);
		
		
		/******   EDITORIAL   ******/
		editorial = new JTextField();
		editorial.setBounds(330, 65, 150, 25);
		editorial.setEnabled(false);
		panel.add(editorial);
		
		lblEditorial = new JLabel("Editorial");
		lblEditorial.setBounds(270, 65, 100, 25);
		panel.add(lblEditorial);
		
		/******   EDICION   ******/
		NumberFormatter numberFormatter = new NumberFormatter(NumberFormat.getIntegerInstance());
		numberFormatter.setMinimum(0l); //Optional
		
		edicion = new JFormattedTextField(numberFormatter);
		edicion.setBounds(330, 100, 150, 25);
		edicion.setEnabled(false);
		panel.add(edicion);
		
		lblEdicion = new JLabel("Edici\u00f3n");
		lblEdicion.setBounds(270, 100, 100, 25);
		panel.add(lblEdicion);
		
		
		/******   ANIO   ******/
		try {
			maskAnio = new MaskFormatter("####");
		} catch (ParseException e1) {
			// callo la excepcion
		}
		anio = new JFormattedTextField(maskAnio);
		anio.setToolTipText("Formato esperado: AAAA");
		anio.setBounds(390, 135, 90, 25);
		anio.setEnabled(false);
		panel.add(anio);
		
		lblAnio = new JLabel("A\u00f1o de publicaci\u00f3n");
		lblAnio.setBounds(270, 135, 120, 25);
		panel.add(lblAnio);
		
		
		/******   ELIMINAR   ******/		
		eliminar = new JButton();
		eliminar.setBounds(200, 190, 100, 25);
		eliminar.setText("Dar de baja");
		eliminar.setEnabled(false); // habilito cuando busco
		panel.add(eliminar);
		
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isbn.getValue() == null || isbn.getText().contains("_")) {
					JOptionPane.showMessageDialog(null, "Ingrese el ISBN del libro a dar de baja");
				} else {
					
					libro = new Libro();
					libro.setISBN(isbn.getText());
					
					libros.remove(libro);
					libros.guardarLibrosEnArchivo();
					Tabla.refresh_Tabla(libros, modelo);
					
					eliminar.setEnabled(false);
					
					// Limpio controles
					isbn.setValue(null);
					titulo.setText("");
					editorial.setText("");
					autor.setText("");
					edicion.setValue(null);
					anio.setValue(null);
				}
			}
		});
	}
}
