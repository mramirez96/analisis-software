package usuarios;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Grafica;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameBienvenido extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField txtUsuario;

	String ruta = "TSV\\usuarios.tsv";

	public FrameBienvenido() {
		setTitle("Gestor de libros");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes/Icono.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 246);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(63, 100, 182, 20);
		contentPane.add(passwordField);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(63, 40, 182, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(63, 25, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00f1a");
		lblContrasea.setBounds(63, 84, 109, 14);
		contentPane.add(lblContrasea);
		
		
		JButton btnIniciar = new JButton("Iniciar sesi\u00f3n");
		btnIniciar.setBounds(28, 155, 122, 23);
		contentPane.add(btnIniciar);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios us = new Usuarios(ruta);
				Usuario user = new Usuario();
				if (usuarioValido(user)) 
				{
					boolean wasAdded = us.add(user);
					if (wasAdded) {
						txtUsuario.setText("");
						passwordField.setText("");
						us.guardarLibrosEnArchivo();
						JOptionPane.showMessageDialog(null, "El usuario fue registrado con \u00e9xito");
					} else {
						JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe en los registros");
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Complete los campos");
				}
				
			}
		});
		btnRegistrar.setBounds(160, 155, 122, 23);
		contentPane.add(btnRegistrar);
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios us = new Usuarios(ruta);
				Usuario user = new Usuario();
				if (usuarioValido(user)) {
					if (!us.existeUsuario(user)) {
						txtUsuario.setText("");
						passwordField.setText("");
						JOptionPane.showMessageDialog(null, "El usuario o contrase\u00f1a son incorrectos");
					} else {
						JOptionPane.showMessageDialog(null, "Bienvenido al gestor de libros!");
						setVisible(false);
						
						boolean adminUser = false;
						
						if (txtUsuario.getText().equals("admin") && passwordField.getText().equals("admin"))
							adminUser = true;
						
						Grafica g = new Grafica(adminUser);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Complete los campos");
				}
			}
		});
		
		setVisible(true);
	}	
	
	private boolean usuarioValido(Usuario us) {
		if (txtUsuario.getText().isEmpty() || passwordField.getText().isEmpty()) {
			return false;
		} else {
			us.setUsuario(txtUsuario.getText());
			us.setContrasenia(passwordField.getText());
			return true;
		}
	}
}
