package com.sda.testing.solution.parametrized;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {

    @ParameterizedTest()
    @CsvSource({"Kamil ślimak,true","22022022,true","costam,false","kobyła ma mały bok,true"})

    void shouldCheckWheterStringIsAPalidrom(String text, boolean expected){

        //when
        boolean actual = PalindromeChecker.isPalindrome(text);

        //then
        assertEquals(expected,actual);
    }
    @ParameterizedTest()
    @CsvFileSource(resources = "/testdata/palindroms.csv")

    void shouldCheckWheterStringIsAPalidromFile(String text, boolean expected, String message){

        //when
        boolean actual = PalindromeChecker.isPalindrome(text);

        //then
        assertEquals(expected,actual,message);
    }



}