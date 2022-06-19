package com.sda.testing.solution.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValueSourceExamplesTest {

    @ParameterizedTest
    @ValueSource(doubles = {1, 2.3, 4.1})
    void shouldPassDoubleToParam(double param) {
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ala", "ma", "kota"})
    void shouldPassStringToTest(String word) {
    }

    @ParameterizedTest
    @ValueSource(classes = {String.class, Integer.class, Double.class})
    void shouldPassClassTypeAsParam(Class<?> clazz) {

    }
}
