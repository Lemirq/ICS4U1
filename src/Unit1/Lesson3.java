package Unit1;

import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) {
        Lesson3 lesson3 = new Lesson3();
        lesson3.PrimeNumberWhileLoop();

    }

    void whileLoop() {
        int i = 0;
        while (i <= 5) {
            System.out.println(i);
            i++;
        }
    }

    void DoWhileLoop() {
        int i = 0;
        do {
            System.out.println(i);
            i++;
        } while (i <= 5);
    }

    void ForLoop() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(i);
        }
    }

    void GuessGame() {
        int guessMe = 8;
        int number = 1;

        while (true) {
            if (number < guessMe) {
                System.out.println("Too low: " + number);
                number++;
            } else if (number > guessMe) {
                number--;
                System.out.println("Too high: " + number);
            } else {
                System.out.println("Guessed it: " + number);
                break;
            }
        }
    }

    void SumOfNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int x = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 1; i <= x; i++) {
            System.out.println(i);
            sum += i;
        }
        System.out.println("The sum is: " + sum);
        scanner.close();
    }

    // Write a program that uses a loop to determine all the multiples of a number
    // between 1 and 100. The loop should count each value from 1 to 100. If the
    // current count is a multiple of the number, it will print that value.
    // Otherwise, it checks the next number. Output should look like this:
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
        System.out.println("Enter an integer between 1 and 100: ");
        int x = Integer.parseInt(scanner.nextLine());
        System.out.println("The multiples of " + x + " are: ");
        for (int i = 1; i <= 100; i++) {
            if (i % x == 0) {
                System.out.println(i);
            }
        }
        scanner.close();
    }

    void AvgTestMark() {
        int total = 0;
        int count = 0;

        // while loop
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a test mark: ");
            int mark = Integer.parseInt(scanner.nextLine());
            if (mark == -1) {
                break;
            }

            if (mark == 999) {
                // quit test marks and show avf
                System.out.println("The average test mark is: " + (total / count) + "%");
                break;
            }
            total += mark;
            count++;
        }
    }

    void FactorialWithForLoop() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int x = Integer.parseInt(scanner.nextLine());
        int factorial = 1;
        for (int i = 1; i <= x; i++) {
            factorial *= i;
        }
        System.out.println(x + "! = " + factorial);
        scanner.close();
    }

    void PrimeNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int x = Integer.parseInt(scanner.nextLine());
        boolean isPrime = true;
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            System.out.println(x + " is a prime number.");
        } else {
            System.out.println(x + " is not a prime number.");
        }
        scanner.close();
    }

    void PrimeNumberWhileLoop() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int x = Integer.parseInt(sc.nextLine());
        boolean isPrime = true;
        int i = 2;
        while (i < x) {
            if (x % i == 0) {
                isPrime = false;
                break;
            }
            sc.close();
            i++;
        }
        if (isPrime) {
            System.out.println(x + " is a prime number.");
        } else {
            System.out.println(x + " is not a prime number.");
        }

    }
}
