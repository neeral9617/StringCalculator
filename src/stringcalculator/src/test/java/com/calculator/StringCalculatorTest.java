package stringcalculator.src.test.java.com.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import stringcalculator.src.main.java.com.calculator.StringCalculator;

class StringCalculatorTest {

	@Test
	void isEmpty() {
		try {
			assertEquals(0, StringCalculator.add(""));
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void singleNumber() {
		try {
			assertEquals(1, StringCalculator.add("1"));
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void doubleNumber() {
		try {
			assertEquals(3, StringCalculator.add("1,2"));
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void nNumber() {
		try {
			assertEquals(6, StringCalculator.add("1,2,3"));
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void delimeterNewLine() {
		try {
			assertEquals(6, StringCalculator.add("1\n2,3"));
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void multipleNumbersWithDifferentDelimeters() {
		try {
			assertEquals(6, StringCalculator.add("//;\n1;2;3"));
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
