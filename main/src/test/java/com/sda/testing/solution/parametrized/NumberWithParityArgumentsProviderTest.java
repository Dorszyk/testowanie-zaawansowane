package com.sda.testing.solution.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberWithParityArgumentsProviderTest {
    @ParameterizedTest
    @ArgumentsSource(NumberWithParityArgumentsProvider.class)
    void shouldReturnExpectedValue(int number, boolean expectedResult) {
        assertEquals(expectedResult, number % 2 == 1);
    }

}