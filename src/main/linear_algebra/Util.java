package main.linear_algebra;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Util {
	public static int numberOfDigits(Double d) {
		String text = Double.toString(Math.abs(d));
		return text.length();
	}

	public static int numberOfDigitsSign(Double d) {
		String text = Double.toString(d);
		return text.length();
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}
