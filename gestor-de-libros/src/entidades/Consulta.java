package entidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

public class Consulta {
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
	private JButton aceptar;
	private JButton limpiar;

	Libro libro;
	Libros libros;
	
	Consulta(JPanel panel, String ruta, TableRowSorter<DefaultTableModel> modeloOrdenado) {

		panel.setLayout(null);
		/******   ISBN   ******/
		try {
			maskISBN = new MaskFormatter("***-***-****-**-*");
		} catch (ParseException e1) {
			// callo la excepcion
		}
		
		maskISBN.setPlaceholderCharacter(' ');
		maskISBN.setValidCharacters("0123456789 ");
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
		
		lblTitulo = new JLabel("T\u00edtulo");
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
		
		NumberFormat numberFormat = NumberFormat.getIntegerInstance();
		numberFormat.setGroupingUsed(false);
		NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
		numberFormatter.setMinimum(0l);
		
		
		edicion = new JFormattedTextField(numberFormatter);
		edicion.setBounds(330, 60, 150, 25);
		panel.add(edicion);
		
		lblEdicion = new JLabel("Edici\u00f3n");
		lblEdicion.setBounds(270, 60, 100, 25);
		panel.add(lblEdicion);
		
		
		/******   ANIO   ******/
		try {
			maskAnio = new MaskFormatter("####");
		} catch (ParseException e1) {
			// callo la excepcion
		}
		anio = new JFormattedTextField(maskAnio);
		anio.setToolTipText("Formato esperado: AAAA");
		anio.setBounds(355, 95, 125, 25);
		//anio.setBounds(370, 95, 110, 25);
		panel.add(anio);
		
		lblAnio = new JLabel("A\u00f1o de publ.");
		lblAnio.setBounds(270, 95, 100, 25);
		panel.add(lblAnio);
		
		
		/******   ACEPTAR   ******/		
		aceptar = new JButton();
		aceptar.setBounds(100, 150, 100, 25);
		aceptar.setText("Aceptar");
		/******   ACEPTAR   ******/		
		limpiar = new JButton();
		limpiar.setBounds(275, 150, 100, 25);
		limpiar.setText("Limpiar");
		
		panel.add(limpiar);
		panel.add(aceptar);
		
		aceptar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {	
				ArrayList<RowFilter<TableModel, Object>> filtros = new ArrayList<RowFilter<TableModel, Object>>();
				if(isbn.getValue() != null) {
					String filter = "";
					if (isbn.getText().contains(" ")) {
						for (String partOfIsbn : isbn.getText().split("-")) {
							if(!partOfIsbn.trim().isEmpty())
								filter += partOfIsbn + "-";
						} 
					} else {
						filter = isbn.getText();
					}
							
					filtros.add(RowFilter.regexFilter("(?i).*" + filter + ".*", 0));
				}
				
				if(!titulo.getText().trim().isEmpty()) {
					filtros.add(RowFilter.regexFilter("(?i).*" + titulo.getText() + ".*", 1));
				}
				
				if(!autor.getText().trim().isEmpty()) {
					filtros.add(RowFilter.regexFilter("(?i).*" + autor.getText() + ".*", 2));
				}
				
				if(!editorial.getText().trim().isEmpty()) {
					filtros.add(RowFilter.regexFilter("(?i).*" + editorial.getText() + ".*", 3));
				}
				
				if(!edicion.getText().trim().isEmpty()) {
					filtros.add(RowFilter.regexFilter("(?i).*" + edicion.getText() + ".*", 4));
				}
				
				if(!anio.getText().trim().isEmpty()) {
					filtros.add(RowFilter.regexFilter("(?i).*" + anio.getText() + ".*", 5));
				}
				
				RowFilter filtroAnd = RowFilter.andFilter(filtros);
				modeloOrdenado.setRowFilter(filtroAnd);

			}
		});
		
		limpiar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {	
				isbn.setValue(null);
				isbn.setText("");
				titulo.setText("");
				autor.setText("");
				editorial.setText("");
				edicion.setValue(null);
				anio.setValue(null);
				modeloOrdenado.setRowFilter(RowFilter.regexFilter("^", 1));
			}
		});
	}
	public String getIsbn() {
		return isbn.getText();
	}
}
