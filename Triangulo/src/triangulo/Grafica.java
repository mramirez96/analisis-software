package triangulo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Grafica extends JFrame {

	private JPanel contentPane;
	private JTextField lado1;
	private JTextField lado2;
	private JTextField lado3;
	private JTextField tipo;
	private Triangulo triangulo;
	private JLabel lblLado;
	private JLabel lblLado_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grafica frame = new Grafica();
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
	public Grafica() {
		setTitle("Clasificaci\u00F3n de Tri\u00E1ngulo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Consigna = new JLabel("Ingrese los datos");
		Consigna.setBounds(124, 27, 110, 14);
		contentPane.add(Consigna);

		lado1 = new JTextField();
		lado1.setBounds(10, 88, 86, 20);
		contentPane.add(lado1);
		lado1.setColumns(10);
		lado1.setHorizontalAlignment(JTextField.CENTER);

		lado2 = new JTextField();
		lado2.setBounds(128, 88, 86, 20);
		contentPane.add(lado2);
		lado2.setColumns(10);
		lado2.setHorizontalAlignment(JTextField.CENTER);

		lado3 = new JTextField();
		lado3.setBounds(248, 88, 86, 20);
		contentPane.add(lado3);
		lado3.setColumns(10);
		lado3.setHorizontalAlignment(JTextField.CENTER);

		tipo = new JTextField();
		tipo.setEditable(false);
		tipo.setBounds(94, 175, 152, 20);
		contentPane.add(tipo);
		tipo.setColumns(10);
		tipo.setHorizontalAlignment(JTextField.CENTER);

		JButton clasificar = new JButton("Clasificar");
		clasificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String side1 = lado1.getText();
				String side2 = lado2.getText();
				String side3 = lado3.getText();

				if (side1.equals("") || side2.equals("") || side3.equals("")) {
					JOptionPane.showMessageDialog(null, "Debe ingresar todos los datos requeridos");

				} else {
					if (esNumero(side1) && esNumero(side2) && esNumero(side3)) {
						double l1 = Double.parseDouble(side1);
						double l2 = Double.parseDouble(side2);
						double l3 = Double.parseDouble(side3);

						if (Triangulo.esTriangulo(l1, l2, l3)) {
							triangulo = new Triangulo(l1, l2, l3);
							tipo.setText(triangulo.determinarTipoDeTriangulo());
						} else
							JOptionPane.showMessageDialog(null, "Los datos ingresados no conforman un triangulo");
					} else {
						JOptionPane.showMessageDialog(null, "Debe ingresar números");
					}
				}
			}

		});
		clasificar.setBounds(128, 127, 89, 23);
		contentPane.add(clasificar);

		lblLado = new JLabel("Lado 1");
		lblLado.setBounds(37, 62, 46, 14);
		contentPane.add(lblLado);

		lblLado_1 = new JLabel("Lado 2");
		lblLado_1.setBounds(151, 63, 46, 14);
		contentPane.add(lblLado_1);

		lblNewLabel = new JLabel("Lado 3");
		lblNewLabel.setBounds(273, 62, 46, 14);
		contentPane.add(lblNewLabel);
	}

	private static boolean esNumero(String cadena) {

		try {
			Double.parseDouble(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
}
