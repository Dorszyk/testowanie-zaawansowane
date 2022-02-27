package com.sda.testing.solution.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


class DivisibilityCheckerTest {

    @ParameterizedTest
    @ValueSource(ints = {0,3,9,12,15,-3,-6})

    void shouldBeDivisibleBy3(int i){

        //when
        boolean actual = DivisibilityChecker.isDivisibleBy3(i);

        //then
        assertTrue(actual);
    }

}