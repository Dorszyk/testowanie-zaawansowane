package com.sda.testing.solution.parametrized.romannumeral;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;


import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralConverterTest {
    @ParameterizedTest
    @EnumSource
    void shouldUseRomanValuesFromEnum(RomanNumeralConverter.ArabicToRoman arabicToRoman) {
      String roman = RomanNumeralConverter.romanFor(arabicToRoman.getArabic());
      assertEquals(arabicToRoman.getRoman(),roman);
    }

    @ParameterizedTest
    @CsvSource({"4999, MMMMCMXCIX", "3462, MMMCDLXII","538, DXXXVIII",
            "1000, M", "900,CM", "500,D", "400,CD", "100,C",
            "90,XC","50,L","40,XL","10,X","9,IX","5,V","4,IV","1,I" })
    public void dummy(int arabic, String expected) {
        String roman = RomanNumeralConverter.romanFor(arabic);
        assertEquals(expected,roman);


    }
}