package Unit1;

import java.util.Scanner;

public class Lesson7 {
    public static void main(String[] args) {

    }

    void Division() {
        // Division
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the dividend: ");
        int dividend = scanner.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        try {
            if (divisor == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }

            int quotient = dividend / divisor;
            int remainder = dividend % divisor;

            System.out.println("Quotient: " + quotient);
            System.out.println("Remainder: " + remainder);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Write a program that uses a loop to determine all the multiples of a number
    // between 1 and 100. The loop should count each value from 1 to 100. If the
    // current count is a multiple of the number, it will print that value.
    // Otherwise, it continues to the next number. Use error handling to ensure the
    // user enters an integer, and that the integer is in the correct range.

    // Output should look like this:
    // Enter an integer between 1 and 100: 13
    // The multiples of 13 are:
    // 13
    // 26
    // 39
    // 52
    // 65
    // 78
    // 91
    void Multiples() {
        Scanner scanner = new Scanner(System.in);

        int number = 0;

        while (true) {
            try {
                System.out.print("Enter an integer between 1 and 100: ");
                number = scanner.nextInt();

                if (number < 1 || number > 100) {
                    throw new IllegalArgumentException("Number must be between 1 and 100.");
                }

                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }

        System.out.println("The multiples of " + number + " are:");

        for (int i = 1; i <= 100; i++) {
            if (i % number == 0) {
                System.out.println(i);
            }
        }

        scanner.close();
    }
}
