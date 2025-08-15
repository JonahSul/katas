package com.katas;

/**
 * FizzBuzz Kata
 * 
 * Write a program that prints the numbers from 1 to 100. 
 * But for multiples of three print "Fizz" instead of the number 
 * and for the multiples of five print "Buzz". 
 * For numbers which are multiples of both three and five print "FizzBuzz".
 */
public class FizzBuzz {
    
    public String convert(int number) {
        if (number % 15 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(number);
        }
    }
    
    public String[] generateSequence(int limit) {
        String[] result = new String[limit];
        for (int i = 1; i <= limit; i++) {
            result[i - 1] = convert(i);
        }
        return result;
    }
}
