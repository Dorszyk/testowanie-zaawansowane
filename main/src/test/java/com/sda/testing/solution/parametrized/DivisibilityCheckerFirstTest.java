package com.sda.testing.solution.parametrized;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DivisibilityCheckerFirstTest {

	@Test
	void shouldBeDivisibleBy3() {
		//given
		int i = 9;

		//when
		boolean actual = DivisibilityChecker.isDivisibleBy3(i);

		//then
		assertTrue(actual);
	}

	@Test
	void shouldNotBeDivisibleBy3() {
		int i = 10;

		//when
		boolean actual = DivisibilityChecker.isDivisibleBy3(i);

		//then
		assertFalse(actual);
	}

	@Test
	void shouldBeDivisibleBy3NegativeNumber() {
		int i = -12;

		//when
		boolean actual = DivisibilityChecker.isDivisibleBy3(i);

		//then
		assertTrue(actual);
	}

	@Test
	void shouldNotBeDivisibleBy3NegativeNumber() {

		int i = -11;

		//when
		boolean actual = DivisibilityChecker.isDivisibleBy3(i);

		//then
		assertFalse(actual);
	}

	@Test
	void zeroShouldBeDivisibleBy3() {
		int i = 0;

		//when
		boolean actual = DivisibilityChecker.isDivisibleBy3(i);

		//then
		assertTrue(actual);

	}
}