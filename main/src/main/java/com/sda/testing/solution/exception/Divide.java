package com.sda.testing.solution.exception;

public class Divide {

    public static float divide(float a, float b) {
        if (b == 0) {
            throw new IllegalArgumentException("dividend can't be 0");
        }
        return a / b;
    }
}
