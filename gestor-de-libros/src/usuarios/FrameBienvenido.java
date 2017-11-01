package usuarios;

import java.awt.EventQueue;

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
		setTitle("Gestor de libros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 246);
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
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(63, 84, 109, 14);
		contentPane.add(lblContrasea);
		
		
		JButton btnIniciar = new JButton("Iniciar sesión");
		btnIniciar.setBounds(28, 155, 122, 23);
		contentPane.add(btnIniciar);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios us = new Usuarios(ruta);
				Usuario user = new Usuario();
				if (usuarioValido(user)) 
				{
					us.add(user);
					us.guardarLibrosEnArchivo();
					JOptionPane.showMessageDialog(null, "El usuario fue registrado con éxito");
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
						JOptionPane.showMessageDialog(null, "El usuario o contraseña son incorrectos");
					} else {
						JOptionPane.showMessageDialog(null, "Bienvenido al gestor de libros!");
						setVisible(false);
						Grafica g = new Grafica();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Complete los campos");
				}
			}
		});
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
