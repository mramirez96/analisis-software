package clinica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class InterfazCambiarClave extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2101705115103533844L;
	private JPanel contentPane;
	private String contraseña;
	private JPasswordField txtNuevaContra;
	private JPasswordField txtConfirmacion;
	private JPasswordField txtAnteriorContra;
	private JTextField txtUsuario;
	private String usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazCambiarClave frame = new InterfazCambiarClave();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazCambiarClave() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("Los_Laureles.png")));
		
		try{
			FileReader input = new FileReader("./bin\\Login.txt");
			BufferedReader bufInput = new BufferedReader(input);
			
			String line;
			
			line = bufInput.readLine();
			
			String lineaDesencriptada = desencriptar(line);
			
			String [] datos;
			
			datos = lineaDesencriptada.split(" ");
			
			usuario = datos[0];
			contraseña = datos[1];
		
			bufInput.close();
			
		} catch (IOException e){
			JOptionPane.showMessageDialog(null, "Archivo Login.txt no encontrado");
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblBienbenidoAlSistema = new JLabel("Cambiar Contrase\u00F1a");
		lblBienbenidoAlSistema.setFont(new Font("Baskerville Old Face", Font.PLAIN, 35));
		lblBienbenidoAlSistema.setBounds(84, 0, 284, 47);
		contentPane.add(lblBienbenidoAlSistema);
		
		JLabel lblUsuario = new JLabel("Contrase\u00F1a anterior:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setBounds(22, 97, 207, 25);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Nueva Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasea.setBounds(37, 133, 192, 36);
		contentPane.add(lblContrasea);
		
		JLabel lblConfirmacion = new JLabel("Escribala Nuevamente:");
		lblConfirmacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConfirmacion.setBounds(10, 185, 219, 25);
		contentPane.add(lblConfirmacion);
		
		JLabel lblUsuario_1 = new JLabel("Usuario:");
		lblUsuario_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario_1.setBounds(124, 61, 98, 25);
		contentPane.add(lblUsuario_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(229, 66, 184, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtNuevaContra = new JPasswordField();
		txtNuevaContra.setBounds(229, 148, 184, 20);
		contentPane.add(txtNuevaContra);
		txtNuevaContra.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnAceptar.setBackground(new Color(0, 128, 128));
		btnAceptar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				boolean correcUsuario, correcContraseña, iguales;
				
				correcUsuario = usuario.equals(txtUsuario.getText()); 
				correcContraseña = contraseña.equals(txtAnteriorContra.getText());
				iguales = txtNuevaContra.getText().equals(txtConfirmacion.getText());
				int tam = txtNuevaContra.getText().length();
				
				if (correcUsuario) {
					if (correcContraseña) {
						
						if (iguales && tam != 0){
							
							if (JOptionPane.showConfirmDialog(rootPane, "¿Seguro desea Cambiar la clave?") == JOptionPane.YES_OPTION) {
								
								FileWriter fichero = null;
						        PrintWriter pw = null;
						        try
						        {
						            fichero = new FileWriter("./bin\\Login.txt"); //Con pasarle por parametro el true agrega al final sin borrar el contenido
						            pw = new PrintWriter(fichero);
						            
						            String linea = usuario + " " + txtNuevaContra.getText(); 
						            
						            pw.println(encriptar(linea));
						            
						            JOptionPane.showMessageDialog(null, "Se ha cambiado la contraseña con exito");
			
						        } catch (Exception e1) {
						            e1.printStackTrace();
						            JOptionPane.showMessageDialog(rootPane, "Error al intentar abrir el archivo Login.txt", "", JOptionPane.ERROR_MESSAGE, null);
						        } finally {
						           try {
						           // Nuevamente aprovechamos el finally para 
						           // asegurarnos que se cierra el fichero.
						           if (null != fichero)
						              fichero.close();
						           } catch (Exception e2) {
						              e2.printStackTrace();
						              JOptionPane.showMessageDialog(rootPane, "Error al intentar abrir el archivo Login.txt", "", JOptionPane.ERROR_MESSAGE, null);
						           }
						        }
								
						        //fin registro
						        
								InterfazCentroMedico interfazCM = new InterfazCentroMedico();
								interfazCM.setVisible(true);
								InterfazCambiarClave.this.dispose();
							}
							
						}
						else
							JOptionPane.showMessageDialog(null, "Las contraseñas no cohinciden o faltan campos por completar");
					}
					else
						JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
				}
				else
					JOptionPane.showMessageDialog(null, "Usuario incorrecto");
				
			}
		});
		
		txtAnteriorContra = new JPasswordField();
		txtAnteriorContra.setColumns(10);
		txtAnteriorContra.setBounds(229, 103, 184, 20);
		contentPane.add(txtAnteriorContra);
		
		txtConfirmacion = new JPasswordField();
		txtConfirmacion.setColumns(10);
		txtConfirmacion.setBounds(229, 191, 184, 20);
		contentPane.add(txtConfirmacion);
		btnAceptar.setBounds(74, 227, 115, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(new Color(0, 128, 128));
		btnCancelar.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				InterfazCentroMedico interfazCM = new InterfazCentroMedico();
				interfazCM.setVisible(true);
				
				InterfazCambiarClave.this.dispose();
			}
		});
		btnCancelar.setBounds(244, 227, 124, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("IntCentroMedico.png")));
		lblNewLabel.setBounds(0, 0, 434, 262);
		contentPane.add(lblNewLabel);
	}

	public String encriptar(String linea){
		
	    char array[]=linea.toCharArray(); 
	     
	    for(int i=0;i<array.length;i++){ 
	        array[i]=(char)(array[i]+(char)5); 
	    } 
	    String encriptado =String.valueOf(array);
	    
		return encriptado;
	}
	
	public String desencriptar(String lineaEncriptada) {
		
		char arrayD[]=lineaEncriptada.toCharArray(); 
        for(int i=0;i<arrayD.length;i++){ 
            arrayD[i]=(char)(arrayD[i]-(char)5); 
        } 
        
        String desencriptado =String.valueOf(arrayD); 
        
        return desencriptado;
		
	}
}
