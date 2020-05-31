package stringcalculator.src.main.java.com.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringCalculator {
	public static int add(final String input) throws Exception {
		if (input.isEmpty()) {
			return 0;
		} else if (isNumeric(input)) {
			return Integer.parseInt(input);
		} else {
			final String[] sArrInput = splitInput(input);
			final int[] iArrInput = convertToIntegerArray(sArrInput);
			return getSum(iArrInput);
		}
	}

	public static String[] splitInput(final String input) {
		if (input.startsWith("//")) {
			final Pattern pattern = Pattern.compile("//(.*)\n(.*)");
			final Matcher matcher = pattern.matcher(input);
			matcher.matches();
			final String delimeter = matcher.group(1); // first group
			final String numbers = matcher.group(2);// second group
			return numbers.split(delimeter);
		} else {
			return input.split(",|\n");
		}
	}

	public static int[] convertToIntegerArray(final String[] arrInput) {
		try {
			return Stream.of(arrInput).mapToInt(Integer::parseInt).toArray();
		} catch (final Exception e) {
			throw e;
		}

	}

	private static int getSum(final int[] arrIntInput) {
		try {
			return Arrays.stream(arrIntInput).sum();
		} catch (final Exception e) {
			throw e;
		}
	}

	public static boolean isNumeric(final String strNum) {
		try {
			if (strNum == null) {
				return false;
			}
			try {
				final double d = Double.parseDouble(strNum);
			} catch (final NumberFormatException nfe) {
				return false;
			}
			return true;
		} catch (final Exception e) {
			throw e;
		}
	}
}
