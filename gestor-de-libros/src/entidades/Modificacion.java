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

public class Modificacion {
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
	private JButton modificar;
	private JButton buscar;
	Libro libro;
	Libros libros;
	
	public Modificacion(JPanel panel, String ruta, DefaultTableModel modelo) {
		panel.setLayout(null);
		
		
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
					JOptionPane.showMessageDialog(null, "Ingrese el ISBN del libro a modificar");
				} else {
					libros = new Libros(ruta);
					
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
						anio.setValue(String.valueOf(libro.getAnno_de_publicacion()));
						modificar.setEnabled(true);
					}
					
				}
			}
		});
		
		/******   TITULO   ******/
		titulo = new JTextField();
		titulo.setBounds(70, 80, 150, 25);
		panel.add(titulo);
		
		lblTitulo = new JLabel("T\u00edtulo");
		lblTitulo.setBounds(30, 80, 100, 25);
		panel.add(lblTitulo);
		
		
		/******   AUTOR   ******/
		autor = new JTextField();
		autor.setBounds(70, 115, 150, 25);
		panel.add(autor);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setBounds(30, 115, 100, 25);
		panel.add(lblAutor);
		
		
		/******   EDITORIAL   ******/
		editorial = new JTextField();
		editorial.setBounds(330, 65, 150, 25);
		panel.add(editorial);
		
		lblEditorial = new JLabel("Editorial");
		lblEditorial.setBounds(270, 65, 100, 25);
		panel.add(lblEditorial);
		
		/******   EDICION   ******/
		NumberFormat numberFormat = NumberFormat.getIntegerInstance();
		numberFormat.setGroupingUsed(false);
		NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
		numberFormatter.setMinimum(0l);
		
		edicion = new JFormattedTextField(numberFormatter);
		edicion.setBounds(330, 100, 150, 25);
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
		panel.add(anio);
		
		lblAnio = new JLabel("A\u00f1o de publicaci\u00f3n");
		lblAnio.setBounds(270, 135, 120, 25);
		panel.add(lblAnio);
		
		
		/******   MODIFICAR   ******/		
		modificar = new JButton();
		modificar.setBounds(200, 190, 100, 25);
		modificar.setText("Modificar");
		modificar.setEnabled(false); // habilito cuando busco
		panel.add(modificar);
		
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isbn.getValue() == null || isbn.getText().contains("_")) {
					JOptionPane.showMessageDialog(null, "Ingrese el ISBN del libro a modificar");
				} else {
					libros = new Libros(ruta);
					
					libro = new Libro();
					libro.setISBN(isbn.getText());
					
					if (editorial.getText().trim().isEmpty()
							|| titulo.getText().trim().isEmpty() || edicion.getText().trim().isEmpty() 
							|| autor.getText().trim().isEmpty() || anio.getValue() == null) {
						JOptionPane.showMessageDialog(null, "Hay campos que no tienen valores v\u00e1lidos");
					} else {
						libro = libros.get(libro);
						if (libro != null) {
							libro.setTitulo(titulo.getText());
							libro.setAutor(autor.getText());
							libro.setEditorial(editorial.getText());
							libro.setEdicion(Integer.parseInt(edicion.getText()));
							libro.setAnno_de_publicacion(Integer.parseInt(anio.getText()));
						}
						libros.guardarLibrosEnArchivo();
						Tabla.refresh_Tabla(libros, modelo);
						
						modificar.setEnabled(false);
					}
				
				}
			}
		});
	}

}
