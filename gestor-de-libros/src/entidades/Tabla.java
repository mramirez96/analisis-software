package entidades;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Tabla {
	
	public static void cargar_Tabla(Libros libros, DefaultTableModel modelo) {
		//Para cargar la tabla de entrada, o cada vez que se aprieta el boton de actualizar
		libros = new Libros("TSV\\libros.tsv"); //Carga cada linea del archivo
		
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
	
	public static void refresh_Tabla(Libros libros, DefaultTableModel modelo) {
		while (modelo.getRowCount() > 0) { //No me fije mucho en esto asi que lo hice de esta forma, para "actualizar" 
			//en realida borra todo lo que tenga la tabla y carga de vuelta todo lo que hay en el archivo
			modelo.removeRow(0);			
		}
		cargar_Tabla(libros, modelo);
	}
	
	public static void delete_filter(TableRowSorter<DefaultTableModel> modeloOrdenado) {
		modeloOrdenado.setRowFilter(RowFilter.regexFilter("^", 1));
	}
}
