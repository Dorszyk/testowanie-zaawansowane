package com.sda.testing.solution.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


class DivisibilityCheckerTest {

    @ParameterizedTest(name = "run #{index} with [{arguments}]" )
    @ValueSource(ints = {0,3,9,12,15,-3,-6})

    void shouldBeDivisibleBy3(int i){

        //when
        boolean actual = DivisibilityChecker.isDivisibleBy3(i);

        //then
        assertTrue(actual);
    }

    @ParameterizedTest(name = "run #{index} with [{arguments}]" )
    @ValueSource(ints = {-1,1,2,5,7,10,11,13})

    void shouldBeNotDivisibleBy3(int i){

        //when
        boolean actual = DivisibilityChecker.isDivisibleBy3(i);

        //then
        assertFalse(actual);
    }

    @ParameterizedTest(name = "run #{index} with [{arguments}]" )
    @CsvSource({"0,true","1,false","3, true","4,false"})

    void shouldCheckDivisibility(int number, boolean expected){

        //when
        boolean actual = DivisibilityChecker.isDivisibleBy3(number);

        //then
        assertEquals(expected,actual);
    }

}