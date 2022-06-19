package com.sda.testing.solution.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

class StringsTest {

    @ParameterizedTest
    @CsvSource({"  test  ,TEST", "tEst ,TEST", "   Java,JAVA"})
    void shouldTrimAndUppercaseInput(String input , String expected ){
        String actualValue = Strings.toUpperCase(input);
        assertEquals(expected,actualValue);
    }

    @ParameterizedTest
    @CsvSource(value = {"  test  ;TEST", "tEst ;TEST", "   Java;JAVA"}, delimiter = ';')
    void shouldTrimAndUppercaseInputDelimiter(String input, String expected) {
        String actualValue = Strings.toUpperCase(input);
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testdata/data.csv", numLinesToSkip = 1) // plik data.csv musi znaleźć się w roocie classpath, pomijamy pierwszą linię w pliku
    void shouldUppercaseAndBeEqualToExpected(String input, String expected) {
        String actualValue = Strings.toUpperCase(input);
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @NullSource
    void shouldbeBlankForNull(String input) {
        assertTrue(Strings.isBlank(input));
    }

}