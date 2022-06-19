package com.sda.testing.solution.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombinedSourcesTest {
    @ParameterizedTest
    @CsvSource(value = "1, true")
    @MethodSource("provideNumbersWithInfoAboutParity")
    void shouldReturnExpectedValue(int number, boolean expected) {
        assertEquals(expected, number % 2 == 1);
    }

    private static Stream<Arguments> provideNumbersWithInfoAboutParity() {
        return Stream.of(Arguments.of(1, true),
                Arguments.of(2, false),
                Arguments.of(10, false),
                Arguments.of(11, true)
        );
    }

}
