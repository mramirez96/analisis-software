package test;


import org.junit.Assert;
import org.junit.Test;


import triangulo.Triangulo;

public class TestTriangulo {

	@Test
	public void testTipoTriangulo() {
		Triangulo t1 = new Triangulo(1,1,1);
		Assert.assertEquals("Equilatero", t1.determinarTipoDeTriangulo());

		Triangulo t2 = new Triangulo(3,2,2);
		Assert.assertEquals("Isosceles", t2.determinarTipoDeTriangulo());

		Triangulo t3 = new Triangulo(1,2,3);
		Assert.assertEquals("Escaleno", t3.determinarTipoDeTriangulo());
	}

}
