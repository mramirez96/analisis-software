package entidades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;


public class Alta {
	
	private JFormattedTextField isbn;
	private MaskFormatter maskISBN;
	private JLabel lblIsbn;
	private JTextField titulo;
	private JLabel lblTitulo;
	private JTextField autor;
	private JLabel lblAutor;
	private JTextField editorial;
	private JLabel lblEditorial;
	private JTextField edicion;
	private JLabel lblEdicion;
	private JFormattedTextField anio;
	private JLabel lblAnio;
	private JButton aceptar;
	Libro libro;
	Libros libros;
	
	public Alta(JPanel panel, String ruta, DefaultTableModel modelo) { //recibe tambien la ruta, asi cada vez que se haga un alta, se trabaja
		//directamente sobre el archivo que contiene a los libros
		panel.setLayout(null);
		
		
		/******   ISBN   ******/
		try {
			maskISBN = new MaskFormatter("###-###-####-##-#");
		} catch (ParseException e1) {
			// callo la excepción
		}
		maskISBN.setPlaceholderCharacter('_');
		isbn = new JFormattedTextField(maskISBN);
		isbn.setBounds(70, 25, 150, 25);
		panel.add(isbn);
		
		lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(30, 25, 100, 25);
		panel.add(lblIsbn);
		
		
		/******   TITULO   ******/
		titulo = new JTextField();
		titulo.setBounds(70, 60, 150, 25);
		panel.add(titulo);
		
		lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(30, 60, 100, 25);
		panel.add(lblTitulo);
		
		
		/******   AUTOR   ******/
		autor = new JTextField();
		autor.setBounds(70, 95, 150, 25);
		panel.add(autor);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setBounds(30, 95, 100, 25);
		panel.add(lblAutor);
		
		
		/******   EDITORIAL   ******/
		editorial = new JTextField();
		editorial.setBounds(330, 25, 150, 25);
		panel.add(editorial);
		
		lblEditorial = new JLabel("Editorial");
		lblEditorial.setBounds(270, 25, 100, 25);
		panel.add(lblEditorial);
		
		/******   EDICION   ******/
		edicion = new JTextField();
		edicion.setBounds(330, 60, 150, 25);
		panel.add(edicion);
		
		lblEdicion = new JLabel("Edicion");
		lblEdicion.setBounds(270, 60, 100, 25);
		panel.add(lblEdicion);
		
		
		/******   ANIO   ******/
		try {
			anio = new JFormattedTextField(new MaskFormatter("####"));
		} catch (ParseException e1) {
			// callo la excepcion
		}
		anio.setBounds(370, 95, 110, 25);
		panel.add(anio);
		
		lblAnio = new JLabel("Año publicación");
		lblAnio.setBounds(270, 95, 100, 25);
		panel.add(lblAnio);
		
		
		/******   ACEPTAR   ******/		
		aceptar = new JButton();
		aceptar.setBounds(200, 150, 100, 25);
		aceptar.setText("Aceptar");
	
		panel.add(aceptar);
		
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //falta hacer todos los gets, las validaciones, etc.
				//esta hecho de esta forma solo para probar que agrege correctamente un libro.
				libros = new Libros(ruta);
				
				libro = new Libro();
				
				libro.setISBN(isbn.getText());
				libro.setTitulo(titulo.getText());
				libro.setAutor(autor.getText());
				libro.setEditorial(editorial.getText());
				libro.setEdicion(Integer.parseInt(edicion.getText()));
				libro.setAnno_de_publicacion(Integer.parseInt(anio.getText()));
				
				libros.add(libro);
				libros.guardarLibrosEnArchivo();
				Tabla.refresh_Tabla(libros, modelo);
			}
		});
		
		
	}
	
	public String getIsbn() {
		return isbn.getText();
	}


}