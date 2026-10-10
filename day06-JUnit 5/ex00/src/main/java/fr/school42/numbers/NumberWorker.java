package fr.school42.numbers;

public class NumberWorker {
	public static boolean isPrime(int number) {
		if (number <= 1) {
			throw new IllegalNumberException("Number must be a natural number greater than 1. Received: " + number);
		}

		if (number == 2) {
			return true;
		}

		if (number % 2 == 0) {
			return false;
		}

		int boundary = (int) Math.sqrt(number);
		for (int i = 3; i <= boundary; i += 2) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}

	public static int digitsSum(int number) {
		number = Math.abs(number);

		int sum = 0;

		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}

		return sum;
	}
}
