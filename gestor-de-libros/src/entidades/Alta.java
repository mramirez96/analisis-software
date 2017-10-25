package entidades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Alta {
	
	private JTextField isbn;
	private JTextField titulo;
	private JTextField autor;
	private JTextField edicion;
	private JTextField editorial;
	private JTextField anio;
	private JButton aceptar;
	Libro libro;
	Libros libros;
	
	public Alta(JPanel panel, String ruta) { //recibe tambien la ruta, asi cada vez que se haga un alta, se trabaja
		//directamente sobre el archivo que contiene a los libros
		panel.setLayout(null);
		
		isbn = new JTextField();
		isbn.setBounds(10, 25, 100, 30);
		panel.add(isbn);
		
		titulo = new JTextField();
		titulo.setBounds(120, 25, 100, 30);
		panel.add(titulo);
		
		autor = new JTextField();
		autor.setBounds(240, 25, 100, 30);
		panel.add(autor);
		
		edicion = new JTextField();
		edicion.setBounds(360, 25, 100, 30);
		panel.add(edicion);
		
		editorial = new JTextField();
		editorial.setBounds(40, 75, 100, 30);
		panel.add(editorial);
		
		anio = new JTextField();
		anio.setBounds(180, 75, 100, 30);
		panel.add(anio);
		
		aceptar = new JButton();
		aceptar.setBounds(200, 150, 100, 30);
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
				
			}
		});
		
		
	}
	
	public String getIsbn() {
		return isbn.getText();
	}


}
