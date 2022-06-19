package com.sda.testing.solution.mockito;

import java.util.Random;

public class RandomIntGenerator {
    public int generate() {
        return new Random().nextInt();
    }
}

