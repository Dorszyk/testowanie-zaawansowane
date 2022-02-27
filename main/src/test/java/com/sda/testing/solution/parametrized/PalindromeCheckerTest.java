package com.sda.testing.solution.parametrized;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {

    @ParameterizedTest()
    @CsvSource({"kamilś limak,true","22022022,true","costam,false"})

    void shouldCheckWheterStringIsAPalidrom(String text, boolean expected){

        //when
        boolean actual = PalindromeChecker.isPalindrome(text);

        //then
        assertEquals(expected,actual);
    }


}