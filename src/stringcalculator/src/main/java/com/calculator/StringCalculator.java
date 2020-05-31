package stringcalculator.src.main.java.com.calculator;

public class StringCalculator {
	public static int add(final String input) throws Exception {
		if (input.isEmpty()) {
			return 0;
		} else if (isNumeric(input)) {
			return Integer.parseInt(input);
		} else {
			final String[] numbers = input.split(",");
			return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
		}
	}

	public static boolean isNumeric(final String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			final double d = Double.parseDouble(strNum);
		} catch (final NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
