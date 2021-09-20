package selfLearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.*;

public class PasswordChk {

	/**
	 * The Main class implements an application that reads lines from the standard
	 * input and prints them to the standard output.
	 */

	/**
	 * A Iterate through each line of input. Nj1@3knui) strong
	 * 
	 * weak nh jk invalid nhuiedml9 weak amdjA1 weak Aa3$ medium
	 * 
	 */
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		while ((line = in.readLine()) != null) {
			// Sstem.out.println(line);
			System.out.println(pwdChk(line));
		}
	}

	private static String pwdChk(String line) {
		String regEx = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-+_!@#$%^&*.,?]).+$";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(line);
		String regEx1 = "^(?=.*[a-z])(?=.[A-Z])(?=.*\\d).+$";
		Pattern p1 = Pattern.compile(regEx1);
		Matcher m1 = p1.matcher(line);
		if (line.contains(" ")) {
			return "invalid";
		} else if (m.matches() && line.length() >= 10) {

			return "strong ";
		} else if (m1.matches() || m.matches() && line.length() < 10) {
			return "medium ";
		}

		return "weak";
	}
}
