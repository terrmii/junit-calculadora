package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.CsvFileSource;


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
	/*
	 * Fase 2
	 */
	
	@ParameterizedTest
	@DisplayName("ParameterizedTest CSV SOURCE")
	@CsvSource({"2, 3, 5", "-1, 5, 4", "0, 0, 0"})
	
	void testAddParameterizedCsvsource(int valor1, int valor2, int esperado) {
		int result = calculadora.add(valor1, valor2);
		Assert.assertEquals(result, esperado);
	}
	
	@ParameterizedTest
	@DisplayName("ParameterizedTest CSV SOURCE")
	@CsvFileSource(resources = "datos.csv")
	
	void testAddParameterizedCsvFileSource(int valor1, int valor2, int esperado) {
		int result = calculadora.add(valor1, valor2);
		Assert.assertEquals(result, esperado);
	}
	
	@ParameterizedTest
	@DisplayName("ParameterizedTest CSV SOURCE")
	@CsvFileSource(resources = "datos2.csv")
	
	void testSubtractParameterizedCsvFileSource(int valor1, int valor2, int esperado) {
		int result = calculadora.subtract(valor1, valor2);
		Assert.assertEquals(result, esperado);
	}
	
	@ParameterizedTest
	@DisplayName("ParameterizedTest CSV SOURCE")
	@CsvFileSource(resources = "datos3.csv")
	void testMultiplyParameterizedCsvFileSource(int valor1, int valor2, int esperado) {
		int result = calculadora.multiply(valor1, valor2);
		Assert.assertEquals(result, esperado);
	}
	
	@Test
	@DisplayName("Divisor cero ERROR")
	void testDivisorCero() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
			calculadora.divide(5, 0);
		});
	}
	
	/*
	 * tiempo
	 */
	
	@Test
	@Timeout(value = 1, unit = TimeUnit.NANOSECONDS)
	public void testAddTiempoMal() {
		int result = calculadora.add(2, 3);
		Assert.assertEquals(5, result);
	}
	
	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	public void testAddTiempoBien() {
		int result = calculadora.add(2, 3);
		Assert.assertEquals(5, result);
	}
	
	
}


