package com.sda.testing.solution.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    @ParameterizedTest
    @EnumSource(TemperatureConverter.class)
    void shouldConvertToValueHigherThanMinInteger(TemperatureConverter converter) {
        assertTrue(converter.convertTemp(10) > Integer.MIN_VALUE);

    }

    @ParameterizedTest
    @EnumSource(TemperatureConverter.class)
    void shouldConvertToValueHigherThanMaxInteger(TemperatureConverter converter) {
        assertFalse(converter.convertTemp(5) > Integer.MAX_VALUE);

    }

    @ParameterizedTest
    @EnumSource(value = TemperatureConverter.class, names = {"CELSIUS_KELVIN", "CELSIUS_FAHRENHEIT"})
    void shouldConvertToTemperatureLowerThanMaxInteger(TemperatureConverter converter) {
        assertTrue(converter.convertTemp(10) < Integer.MAX_VALUE);
    }

    @ParameterizedTest
    @EnumSource(value = TemperatureConverter.class,
            names = {"KELVIN_CELSIUS"},
            mode = EnumSource.Mode.EXCLUDE)
    void shouldConvertTemperatureToPositiveValue(TemperatureConverter converter) {
        assertTrue(converter.convertTemp(10) > 0);
        // test zostanie uruchomiony dla wartości CELSIUS_KELVIN i CELSIUS_FAHRENHEIT
    }
}