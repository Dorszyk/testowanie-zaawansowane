package com.sda.testing.solution.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArraysTest {
    @ParameterizedTest
    @EmptySource
    void shouldNotBeValid(List<String> input) {
        assertFalse(Arrays.isValid(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void nullAndEmptyShouldBeBlank(String input) {
        assertTrue(Strings.isBlank(input));
    }

}