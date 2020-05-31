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
			assertEquals(5, StringCalculator.add("5"));
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

}
