package com.sda.testing.solution.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RandomIntGeneratorTest {
    @Mock
    private RandomIntGenerator randomIntGenerator;

    @Test
    void shouldDemoHowWhenFromMockitoWorks() {
        when(randomIntGenerator.generate()); // when z klasy Mockito
    }
}
