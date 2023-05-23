package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CalculatorTest {

	private Calculadora calculadora;
	
	@BeforeEach
	public void setUp() {
		calculadora = new Calculadora();
	}
	/*
	 * Sumar
	 */
	@Test 
	public void testAdd() {
		int result = calculadora.add(2, 3);
		Assert.assertEquals(5, result);
	}
	
	/*
	 * Restar
	 */
	@Test
	public void testSubstract() {
		int result = calculadora.subtract(6, 2);
		Assert.assertEquals(4, result);
	}
	
	@Test
	public void testMultiply() {
		int result = calculadora.multiply(8, 2);
		Assert.assertEquals(16, result);
	}
	
	@Test
	public void testDivide() {
		double result = calculadora.divide(4, 2);
		assertEquals(2, result);
	}
	
}
