package com.sda.testing.solution.parametrized;

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
	}

	@Test
	void shouldBeDivisibleBy3NegativeNumber() {
	}

	@Test
	void shouldNotBeDivisibleBy3NegativeNumber() {
	}

	@Test
	void zeroShouldBeDivisibleBy3() {
	}
}