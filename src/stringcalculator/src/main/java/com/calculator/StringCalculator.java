package stringcalculator.src.main.java.com.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
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
			final IntStream negativeNumbersStream = checkNegative(iArrInput);
			if (negativeNumbersStream != null) {
				final int[] negativeNumbers = negativeNumbersStream.toArray();
				if (negativeNumbers.length > 0) {
					throwNegativeNumberException(negativeNumbers);
					return 0;
				}
			}

			return getSum(iArrInput);
		}
	}

	public static String[] splitInput(final String input) {
		if (input.startsWith("//")) {
			final Pattern pattern = Pattern.compile("//(.*)\n(.*)");
			final Matcher matcher = pattern.matcher(input);
			matcher.matches();
			String delimeter = matcher.group(1); // first group
			final String numbers = matcher.group(2);// second group

			delimeter = delimeter.trim();
			if (delimeter.startsWith("[") && delimeter.endsWith("]")) {

				delimeter = delimeter.substring(1, delimeter.length() - 1);
				delimeter = delimeter.replace("[", "");
				final String[] arrDelimeter = delimeter.split("]");
				final StringBuilder dynamicDelimeter = new StringBuilder();
				for (final String delim : arrDelimeter) {
					if (dynamicDelimeter.length() < 1) {

					} else {
						dynamicDelimeter.append("|");
					}
					dynamicDelimeter.append(delim);
				}

				return numbers.split(dynamicDelimeter.toString());
			} else {
				return numbers.split(delimeter);
			}

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

	private static int getSum(final int[] iArrInput) {
		try {
			return Arrays.stream(iArrInput).filter(ele -> ele <= 1000).sum();
		} catch (final Exception e) {
			throw e;
		}
	}

	private static void throwNegativeNumberException(final int[] numbers) throws java.lang.Exception {
		throw new Exception("negatives not allowed " + Arrays.toString(numbers));
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

	private static IntStream checkNegative(final int[] iArrInput) {
		return Arrays.stream(iArrInput).filter(ele -> ele < 0);

	}
}
