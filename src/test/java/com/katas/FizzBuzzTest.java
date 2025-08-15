package com.katas;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {
    
    private final FizzBuzz fizzBuzz = new FizzBuzz();
    
    @Test
    void shouldReturnNumberAsStringWhenNotDivisibleByThreeOrFive() {
        assertThat(fizzBuzz.convert(1)).isEqualTo("1");
        assertThat(fizzBuzz.convert(2)).isEqualTo("2");
        assertThat(fizzBuzz.convert(4)).isEqualTo("4");
    }
    
    @Test
    void shouldReturnFizzWhenDivisibleByThree() {
        assertThat(fizzBuzz.convert(3)).isEqualTo("Fizz");
        assertThat(fizzBuzz.convert(6)).isEqualTo("Fizz");
        assertThat(fizzBuzz.convert(9)).isEqualTo("Fizz");
    }
    
    @Test
    void shouldReturnBuzzWhenDivisibleByFive() {
        assertThat(fizzBuzz.convert(5)).isEqualTo("Buzz");
        assertThat(fizzBuzz.convert(10)).isEqualTo("Buzz");
        assertThat(fizzBuzz.convert(20)).isEqualTo("Buzz");
    }
    
    @Test
    void shouldReturnFizzBuzzWhenDivisibleByBothThreeAndFive() {
        assertThat(fizzBuzz.convert(15)).isEqualTo("FizzBuzz");
        assertThat(fizzBuzz.convert(30)).isEqualTo("FizzBuzz");
        assertThat(fizzBuzz.convert(45)).isEqualTo("FizzBuzz");
    }
    
    @Test
    void shouldGenerateCorrectSequence() {
        String[] sequence = fizzBuzz.generateSequence(15);
        
        assertThat(sequence).hasSize(15);
        assertThat(sequence[0]).isEqualTo("1");
        assertThat(sequence[2]).isEqualTo("Fizz");
        assertThat(sequence[4]).isEqualTo("Buzz");
        assertThat(sequence[14]).isEqualTo("FizzBuzz");
    }
}
