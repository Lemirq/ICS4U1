package Unit1;

import java.util.Scanner;

public class Lesson2 {
    public static void main(String[] args) {
        Lesson2 lesson2 = new Lesson2();
        // lesson2.Guessing();
        // lesson2.nameAndAge();
        // lesson2.Voting();
        // lesson2.Grade();
        lesson2.Hungry();
    }

    void Guessing() {
        int secret = 10;
        System.out.println("Guess a number between 1 and 20: ");
        Scanner scanner = new Scanner(System.in);
        int guess = Integer.parseInt(scanner.nextLine());
        if (guess == secret) {
            System.out.println("just right!!! YOU WIN!!!");
        } else if (guess > secret) {
            System.out.println("too high");
        } else {
            System.out.println("too low");
        }
        scanner.close();
    }

    void nameAndAge() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What's your name?");
        String name = scanner.next();

        // validation of integers
        int age = -1;
        while (age < 0) {
            System.out.println("What's your age?");
            // Check if the input is an integer
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                if (age < 0) {
                    System.out.println("Please enter a valid positive age.");
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
        System.out.println("Your name is " + name + " and you are " + age + " years old.");
        // close scanner to prevent resource leak
        scanner.close();
    }

    void Voting() {
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());
        // convert from string to integer
        if (age >= 18) {
            System.out.println("You are eligible to vote.");
        } else {
            System.out.println("You are not eligible to vote.");
        }

        scanner.close();
    }

    void Grade() {
        // take input of a percentage classify as A, B, C, D, E, F (A:90-100, B:80-89,
        // C:70-79, D:60-69, E:50-59, F:0-49)
        // if the input is not a number, print "Please enter a valid number."
        // if the input is not in the range of 0-100, print "Please enter a valid
        // percentage."

        Scanner scanner = new Scanner(System.in);
        int percentage = -1;
        while (percentage < 0 || percentage > 100) {
            System.out.println("What's your percentage?");
            // Check if the input is an integer
            if (scanner.hasNextInt()) {
                percentage = scanner.nextInt();
                if (percentage < 0 || percentage > 100) {
                    System.out.println("Please enter a valid percentage.");
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }

        // give grade with a switch statement
        char grade;

        switch (percentage / 10) {
            case 10:
            case 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6:
                grade = 'D';
                break;
            case 5:
                grade = 'E';
                break;
            default:
                grade = 'F';
                break;
        }

        System.out.println("Your grade is " + grade);

    }

    void Hungry() {
        boolean small;
        boolean green;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to eat something small? (true/false)");
        small = scanner.nextBoolean();
        System.out.println("Do you want to eat something green? (true/false)");
        green = scanner.nextBoolean();

        // suggest cherry, a pea, a watermelon, or a pumpkin.
        if (small) {
            if (green) {
                System.out.println("You should eat a pea.");
            } else {
                System.out.println("You should eat a cherry.");
            }
        } else {
            if (green) {
                System.out.println("You should eat a watermelon.");
            } else {
                System.out.println("You should eat a pumpkin.");
            }
        }
    }
}
