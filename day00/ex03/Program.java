
package ex03;

import java.util.Scanner;

public class Program {

	public static final int LOWEST_GRADE = 1;
	public static final int HEIGHTEST_GRADE = 9;
	public static final int WEEK_LENGTH = 9;

	static int result = 0;

	public static void printErr() {

		System.err.println("IllegalArgument");
		System.exit(-1);
	}

	public static void parseDigitsLine(String line) { // needs better parsing logic
		int digit = 0;
		int lowest = 100_000_000;

		if (line.length() != WEEK_LENGTH)
			printErr();

		for (int i = 0; i < WEEK_LENGTH; i += 2) {
			digit = line.charAt(i) - '0';
			if (digit < LOWEST_GRADE || digit > HEIGHTEST_GRADE)
				printErr();
			lowest = (lowest > digit) ? digit : lowest;
		}
		result = result * 10 + lowest;
	}

	public static void printOutPut(int weeks) {
		int i = 1;
		int divisor = 1;
		while (result / divisor >= 10) {
			divisor *= 10;
		}

		while (divisor > 0) {
			int digit = result / divisor;
			System.out.println("Week " + i + "=".repeat(digit) + ">");
			result = result % divisor;
			divisor /= 10;
			i++;
		}
	}

	public static void main(String[] args) {
		int weeks = 1;
		String str;
		Scanner scanner = new Scanner(System.in);

		while (!(str = scanner.nextLine()).equals("42")) {
			if (weeks == 18)
				printErr();
			if (!str.equals("Week " + weeks))
				printErr();

			str = scanner.nextLine();
			parseDigitsLine(str);
			weeks++;
		}
		printOutPut(weeks);
		scanner.close();
	}
}