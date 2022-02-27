package com.sda.testing.solution.conversion;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementConverterTest {


    @ParameterizedTest
    @EnumSource(value = ConversionType.class, names = {"YARDS_TO_METERS", "METERS_TO_YARDS"})
    void test(ConversionType conversionType) {

    }

    @ParameterizedTest
    @EnumSource(names = {"METERS_TO_YARDS", "INCHES_TO_CENTIMETERS", "MILES_TO_KILOMETERS"})
    public void shouldConverterToHigherValue(ConversionType conversionType) {
        int i = 100;
        double converted = new MeasurementConverter().convert(i, conversionType);

        assertTrue(converted > i);
    }

    @ParameterizedTest
    @MethodSource
    void sameOperationsShouldBeReversible(ConversionType c1, ConversionType c2) {
        double initialValue = 12345;

        MeasurementConverter measurementConverter = new MeasurementConverter();
        double converted1 = measurementConverter.convert(initialValue, c1);
        double converted2 = measurementConverter.convert(converted1, c2);

        assertEquals(initialValue, converted2);
    }

    public static Stream<Arguments> sameOperationsShouldBeReversible() {
        return Stream.of(
                Arguments.of(ConversionType.METERS_TO_YARDS, ConversionType.YARDS_TO_METERS),
                Arguments.of(ConversionType.CENTIMETERS_TO_INCHES, ConversionType.INCHES_TO_CENTIMETERS),
                Arguments.of(ConversionType.KILOMETERS_TO_MILES, ConversionType.MILES_TO_KILOMETERS),
                Arguments.of(ConversionType.INCHES_TO_CENTIMETERS, ConversionType.CENTIMETERS_TO_INCHES),
                Arguments.of(ConversionType.MILES_TO_KILOMETERS, ConversionType.KILOMETERS_TO_MILES)
        );
    }
}