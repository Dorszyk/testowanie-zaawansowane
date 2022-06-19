package com.sda.testing.solution.parametrized;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumbersHelperTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
    void shouldReturnTrueForOddNumbers(int number) {
        assertTrue(NumbersHelper.isOdd(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0})
    void shouldReturnFalseForOddNumbers(int number) {
        assertFalse(NumbersHelper.isOdd(number));
    }
}