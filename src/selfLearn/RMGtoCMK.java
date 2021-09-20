package selfLearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class RMGtoCMK {

	/**
	 * The Main class implements an application that reads lines from the standard
	 * input and prints them to the standard output.
	 */

	/**
	 * Iterate through each line of input.
	 */
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
			System.out.println(Arrays.toString(coloChng(line)));
			// System.out.println("%d,%d,%d,%d",output[0],output[1],output[2],output[3]);
		}

	}

	private static int[] coloChng(String line) {
		String[] value = line.split(",");
		int r = Integer.parseInt(value[0]);
		int g = Integer.parseInt(value[1]);
		int b = Integer.parseInt(value[2]);

		double rValue = r / 255.0;
		double gValue = g / 255.0;
		double bValue = b / 255.0;

		double k = 1 - Math.max(Math.max(rValue, gValue), bValue);
		if (k == 1) {
			return new int[] { 0, 0, 0, 255 };
		}

		int div = 1 - (int) k;
		int c = (int) ((1 - rValue - k)) / div;
		int m = (int) ((1 - gValue - k)) / div;
		int y = (int) ((1 - bValue - k)) / div;
		return new int[] { c/255, m/255, y/255, (int) k/255 }; // the output was not as expected need to include the conversion from normal int to 8 bit int
	}

}
