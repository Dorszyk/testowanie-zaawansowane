package com.sda.testing.solution.parametrized;

public class Strings {
    public static String toUpperCase(String input) {
        return input.trim().toUpperCase();
    }

    public static boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

}
