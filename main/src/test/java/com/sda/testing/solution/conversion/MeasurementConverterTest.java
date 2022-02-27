package com.sda.testing.solution.conversion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementConverterTest {
    @ParameterizedTest
    @EnumSource(value = ConversionType.class, names = {"YARDS_TO_METERS", "METERS_TO_YARDS"})
    void test(ConversionType conversionType){

    }

    @ParameterizedTest
    @EnumSource(names = {"METERS_TO_YARDS","INCHES_TO_CENTIMETERS","MILES_TO_KILOMETERS"})
    public void shuldConverterToHigherValue(ConversionType conversionType){
        int i = 100;
        double converted = new MeasurementConverter().convert(i,conversionType);

        assertTrue(converted > i);

    }

}