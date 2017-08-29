package triangulo;

public class Triangulo {

	private double lado1;
	private double lado2;
	private double lado3;

	public Triangulo(double lado1, double lado2, double lado3) {
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
	}

	public boolean esEquilatero() {
		if (lado1 == lado2 && lado2 == lado3)
			return true;
		else
			return false;
	};

	public boolean esEscaleno() {
		if (lado1 != lado2 && lado1 != lado3 && lado2 != lado3)
			return true;
		else
			return false;
	};

	public String determinarTipoDeTriangulo() {
		String tipo;

		if (esEscaleno())
			tipo = "Escaleno";
		else if (esEquilatero())
			tipo = "Equilatero";
		else
			tipo = "Isosceles";

		return tipo;
	}

	public static boolean esTriangulo(double lado1, double lado2, double lado3) {
		if ((Math.abs(lado1 - lado3) < lado2) && (lado2 < (lado1 + lado3)))
			return true;
		else
			return false;
	}
}
