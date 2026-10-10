package fr.school42.numbers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvFileSource;

public class NumberWorkerTest {
	private final NumberWorker numberWorker = new NumberWorker();

	@Test
	public void isPrimeForPrimes() {
		assertTrue(numberWorker.isPrime(2), "2 should be prime");
		assertTrue(numberWorker.isPrime(7), "7 should be prime");
		assertTrue(numberWorker.isPrime(13), "13 should be prime");
	}

	@Test
	public void isPrimeForNotPrimes() {
		assertFalse(numberWorker.isPrime(4), "4 is a composite number");
		assertFalse(numberWorker.isPrime(6), "6 is a composite number");
		assertFalse(numberWorker.isPrime(9), "9 is a composite number");
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, -7, 0 })
	public void isPrimeForIncorrectNumbers(int number) {
		assertThrows(IllegalNumberException.class, () -> {numberWorker.isPrime(number);});
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
	public void checkDigitsSum(int num, int result) {
		assertEquals(result, numberWorker.digitsSum(num),
				"Sum of digits for " + num + " should be " + result);
	}
}
