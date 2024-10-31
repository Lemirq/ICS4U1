package Unit1;

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class Review {
    public static void main(String[] args) {
        new Review().Password();

    }

    // A Mad-Lib story is a story where nouns and verbs in a paragraph are randomly
    // replaced with other nouns and verbs, usually with funny results. Create a
    // MadLib application that displays a Mad-Lib story, then writes the story to a
    // file. (Extension: Read the fill-in-the-blank story lines in from a file)

    void MadLib() {
        Scanner sc = new Scanner(System.in);

        // Step 1: Define a story template with placeholders
        String[] fill = { "[noun1]", "[verb1]", "[noun1]", "[verb2]", "[noun2]", "[verb3]" };

        String storyTemplate = "Once upon a time, there was a [noun1] who loved to [verb1].\n"
                + "Every day, the [noun1] would [verb2] with a [noun2].\n"
                + "They had a great time [verb3] together.\n";

        // Step 2: Ask the user for nouns and verbs
        // System.out.print("Enter a noun: ");
        // String noun1 = sc.nextLine();
        // System.out.print("Enter another noun: ");
        // String noun2 = sc.nextLine();
        // System.out.print("Enter a verb: ");
        // String verb1 = sc.nextLine();
        // System.out.print("Enter another verb: ");
        // String verb2 = sc.nextLine();
        // System.out.print("Enter one more verb: ");
        // String verb3 = sc.nextLine();

        // // Step 3: Replace placeholders with user input
        // String filledStory = storyTemplate.replace("[noun1]", noun1)
        // .replace("[noun2]", noun2)
        // .replace("[verb1]", verb1)
        // .replace("[verb2]", verb2)
        // .replace("[verb3]", verb3);

        File madlib = new File("mad_lib.txt");
        try {
            FileWriter f = new FileWriter(madlib);
            BufferedWriter b = new BufferedWriter(f);
            b.write(storyTemplate);

            b.close();
            f.close();
            System.out.println("File has been written.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found...");
        } catch (IOException e) {
            System.out.println("An error ocurred: " + e.getMessage());
        }

        sc.close();

    }

    // Create a program that generates a random password for a user. The program
    // asks the user for the password length, then suggests a random password of the
    // correct length. Each character in the password is generated using the
    // following rules:
    // There is a 40% chance to add a lowercase letter
    // There is a 30% chance to add an uppercase letter
    // There is a 20% chance to add a digit (0 - 9)
    // There is a 10% chance to add one of the following symbols: !@#$%^&*()-_=+?
    void Password() {
        String symbols = "!@#$%^&*()-_=+?";
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the password: ");
        int length = sc.nextInt();

        String[] bro = new String[length];

        for (int i = 0; i < length; i++) {
            int LChance = rand.nextInt(10);

            if (LChance <= 3) {
                System.out.println("Adding lowercase letter...");
                char character = (char) ('a' + rand.nextInt(26));
                bro[i] = String.valueOf(character).toLowerCase();

            } else if (LChance == 4 || LChance == 5 || LChance == 6) {
                char character = (char) ('a' + rand.nextInt(26));
                System.out.println("Adding uppercase letter...");
                bro[i] = String.valueOf(character).toUpperCase();

            } else if (LChance == 7 || LChance == 8) {
                System.out.println("Adding digit...");
                int digit = rand.nextInt(9);
                bro[i] = String.valueOf(digit);

            } else {
                System.out.println("Adding symbol...");
                int index = rand.nextInt(symbols.length());
                bro[i] = String.valueOf(symbols.charAt(index));

            }

        }

        System.out.println("Your password: " + String.join("", bro));

        sc.close();
    }
}
