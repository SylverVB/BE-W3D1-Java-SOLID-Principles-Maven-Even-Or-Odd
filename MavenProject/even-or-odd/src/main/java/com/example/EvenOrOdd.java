package com.example;

public class EvenOrOdd {

    /**
     * This method checks whether a number is even or odd.
     * 
     * @param number the number to be checked
     * @return "Even" if the number is even, "Odd" if the number is odd
     */
    public static String checkEvenOrOdd(int number) {
        // Check if the number is divisible by 2
        if (number % 2 == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(checkEvenOrOdd(4)); // Output: Even
        System.out.println(checkEvenOrOdd(5)); // Output: Odd
    }
}