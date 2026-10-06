
package ex02;

import java.util.Scanner;

public class Program {

	static int steps = 0;

	public static boolean isPrimeNumber(int num) {
		int i = 3;

		if (num == 2) {
			steps++;
			return true;
		} else if (num % 2 == 0) {
			steps++;
			return false;
		}

		while (i * i <= num) {
			steps++;
			if (num % i == 0)
				return false;
			i++;
		}
		return true;
	}

	public static int sumOfDigits(int num) {
		int sum = 0;

		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		int reqs = 0;
		int num;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Print a number");

		while ((num = scanner.nextInt()) != 42) {
			if (isPrimeNumber(sumOfDigits(num)))
				reqs++;
		}

		System.out.println("Count of coffee-request : " + reqs);

		scanner.close();

	}
}