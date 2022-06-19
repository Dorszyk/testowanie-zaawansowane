package com.sda.testing.solution.exception;

import org.junit.jupiter.api.Test;

import static com.sda.testing.solution.exception.Divide.divide;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DivideTest {

    @Test
    void shouldThrowIllegalArgumentException() {
        final IllegalArgumentException
                exception = assertThrows(IllegalArgumentException.class,
                () -> divide(10, 0));

        assertThat(exception).hasMessage("dividend can't be 0")
                .hasNoCause();
    }
    @Test
    void shouldThrowIllegalArgumentException1() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> divide(10, 0))
                .withMessage("dividend can't be 0")
                .withNoCause();
    }
    @Test
    void shouldThrowIllegalArgumentException2() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> divide(10, 0))
                .withMessage("dividend can't be 0")
                .withNoCause();
    }

    @Test
    void shouldThrowIllegalArgumentException3() {
        assertThatThrownBy(() -> divide(10, 0))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("dividend can't be 0")
                .hasNoCause();
    }

}