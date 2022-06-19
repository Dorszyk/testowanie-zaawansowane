package com.sda.testing.solution.parametrized;

import org.junit.jupiter.params.ParameterizedTest;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MethodSource {

    @ParameterizedTest
    @org.junit.jupiter.params.provider.MethodSource("provideNumbers")
    void shouldBeOdd(final Integer number) {
        assertThat(number % 2).isEqualTo(1);
    }

    static Stream<Integer> provideNumbers() {
        return Stream.of(1, 13, 101, 11, 121);
    }

}
