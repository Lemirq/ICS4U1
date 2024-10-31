package Unit1;

import java.util.Scanner;
/*
 * A simple grade book program that allows the user to enter the names and marks of students
 * and displays the students' names, marks, and grades.
 */

public class GradeBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // infinite loop to allow the user to enter multiple classes
        while (true) {
            System.out.println("\n\nSimple Grade Book");
            System.out.println("=====================================");

            System.out.println("How many students are in the class?");
            int numStudents = scanner.nextInt();

            // arrays to store the names and marks of students
            String[] names = new String[numStudents];
            int[] marks = new int[numStudents];

            // Dummy data for testing
            // int numStudents = 5;
            // String[] names = { "James", "Mira", "Lois", "Grant", "Guillermo" };
            // int[] marks = { 88, 91, 52, 31, 75 };

            // getting the names and marks of students
            for (int i = 0; i < numStudents; i++) {
                System.out.println("Student " + (i + 1) + " name:");
                names[i] = scanner.next();
                System.out.println("Student " + (i + 1) + " mark:");
                marks[i] = scanner.nextInt();
            }

            System.out.println("=====================================");

            // printing the table of students, marks, and grades with formatting
            for (int i = 0; i < numStudents; i++) {
                System.out.printf("%-10s %-5d %-3s", names[i], marks[i], getLetterGrade(marks[i]));
                System.out.println();
            }

            System.out.println("=====================================");
            System.out.println("Would you like to enter another class? Y or N:");

            // check if the user wants to continue
            String response = scanner.next();
            if (response.equalsIgnoreCase("Y")) {
                continue;
            } else {
                System.out.println("=====================================");
                System.out.println("Session Terminated...Goodbye");
                break;
            }

        }
        scanner.close();
    }

    public static String getLetterGrade(int mark) {
        if (mark >= 90) {
            return "A+";
        } else if (mark >= 80) {
            return "A";
        } else if (mark >= 70) {
            return "B";
        } else if (mark >= 60) {
            return "C";
        } else if (mark >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}