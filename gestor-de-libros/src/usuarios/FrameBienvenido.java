package usuarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Grafica;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameBienvenido extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField txtUsuario;
	
	private JRadioButton rdbtnUsuarioExiste;
	private JRadioButton rdbtnNuevoUsuario;
	private ButtonGroup bg;

	String ruta = "usuarios.tsv";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameBienvenido frame = new FrameBienvenido();
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
	public FrameBienvenido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 301, 50);
		contentPane.add(panel);
		
		rdbtnUsuarioExiste = new JRadioButton("Tengo un usario");
		panel.add(rdbtnUsuarioExiste);
		rdbtnNuevoUsuario = new JRadioButton("No tengo un usuario");
		panel.add(rdbtnNuevoUsuario);
		
		bg = new ButtonGroup();
		bg.add(rdbtnNuevoUsuario);
		bg.add(rdbtnUsuarioExiste);
		rdbtnUsuarioExiste.setSelected(true);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(67, 147, 182, 20);
		contentPane.add(passwordField);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(67, 87, 182, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(67, 72, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(67, 131, 109, 14);
		contentPane.add(lblContrasea);
		
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(112, 202, 89, 23);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios us = new Usuarios(ruta);
				Usuario user = new Usuario(txtUsuario.getText(), passwordField.getText());
				if (rdbtnNuevoUsuario.isSelected()) {
					us.add(user);
					us.guardarLibrosEnArchivo();
					JOptionPane.showMessageDialog(null, "El usuario fue registrado con éxito");
				} else {
					if (!us.existeUsuario(user)) {
						JOptionPane.showMessageDialog(null, "El usuario o contraseña son incorrectos");
					} else {
						JOptionPane.showMessageDialog(null, "Bienvenido al gestor de libros!");
						setVisible(false);
						Grafica g = new Grafica();
					}
				}
				
			}
		});
	}
}
