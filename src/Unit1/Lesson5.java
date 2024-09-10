package Unit1;

import java.util.Scanner;
import java.util.HashMap;

public class Lesson5 {
    public static void main(String[] args) {
        Lesson5 lesson5 = new Lesson5();
        lesson5.testTranslateToSpanish();

    }

    /**
     * Draws a bar of a specified length using a specified symbol.
     * 
     * @param length The length of the bar.
     * @param symbol The symbol to use to draw the bar.
     */
    void drawBar(int length, String symbol) {
        for (int i = 0; i <= length; i++) {
            System.out.print(symbol);
        }
    }

    /**
     * Draws a box of a specified width and height using a specified symbol.
     * 
     * @param width  The width of the box.
     * @param height The height of the box.
     * @param symbol The symbol to use to draw the box.
     */
    void drawBox(int width, int height, String symbol) {
        for (int i = 0; i < height; i++) {
            drawBar(width, symbol);
            System.out.println();
        }
    }

    /**
     * Draws a box outline of a specified width and height using a specified symbol.
     * 
     * @param width  The width of the box.
     * @param height The height of the box.
     * @param symbol The symbol to use to draw the box.
     */
    void drawBoxOutline(int width, int height, String symbol) {
        for (int i = 0; i < height; i++) {
            if (i == 0 || i == height - 1) {
                drawBar(width, symbol);
            } else {
                System.out.print(symbol);
                for (int j = 0; j < width - 1; j++) {
                    System.out.print(" ");
                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    /**
     * Draws a triangle of a specified height using a specified symbol.
     * 
     * @param height The height of the triangle.
     * @param symbol The symbol to use to draw the triangle.
     */
    // House program
    void addRoof() {
        System.out.println("   /\\");
        System.out.println("  /  \\");
        System.out.println(" /    \\");
        System.out.println("/______\\");
    }

    /**
     * Draws a house with a roof, base, and walkway.
     */

    void addBase() {
        System.out.println("|      |");
        System.out.println("|      |");
        System.out.println("|______|");
    }

    /**
     * Draws a walkway leading up to the house.
     */
    void addWalkway() {
        System.out.println("   **");
        System.out.println("   ********");
    }

    /**
     * Draws a house with a roof, base, and walkway.
     */
    void drawHouse() {
        addRoof();
        addBase();
        addWalkway();
    }

    /**
     * Calculates the average of a variable amount of integers.
     * 
     * @param numbers The integers to calculate the average of.
     * @return The average of the integers.
     */
    double average(int numTest) {
        Scanner input = new Scanner(System.in);
        double total = 0.0;
        for (int i = 0; i < numTest; i++) {
            System.out.print("Enter a test score:");
            double score = input.nextDouble();
            total += score;
        }
        double avg = total / (double) numTest;
        input.close();
        return avg;
    }

    /**
     * Simulates choosing a random playing card from a deck of 52 cards.
     * A = 1, J = 11, Q = 12, K = 13. Hearts are 1 - 13, Diamonds are 14 - 26,
     * Clubs are 27 - 39, and Spades are 40 - 52.
     * 
     * @return Returns the integer that corresponds to the random card.
     */
    int drawCard() {
        return (int) (Math.random() * 52) + 1;
    }

    /**
     * Calcuates value of any number raised to the fourth power
     * 
     * @return Returns the value of the number raised to the fourth power.
     */

    double fourthPower(int num) {
        return Math.pow(num, 4);
    }

    private static HashMap<Integer, String> numberToSpanishMap = new HashMap<>();

    // Static block to initialize the map
    static {
        numberToSpanishMap.put(1, "uno");
        numberToSpanishMap.put(2, "dos");
        numberToSpanishMap.put(3, "tres");
        numberToSpanishMap.put(4, "cuatro");
        numberToSpanishMap.put(5, "cinco");
        numberToSpanishMap.put(6, "seis");
        numberToSpanishMap.put(7, "siete");
        numberToSpanishMap.put(8, "ocho");
        numberToSpanishMap.put(9, "nueve");
        numberToSpanishMap.put(10, "diez");
    }

    /**
     * Translates a number to its Spanish equivalent.
     * 
     * @param number The number to translate.
     * @return The Spanish equivalent of the number.
     */
    public static String translateToSpanish(int number) {
        return numberToSpanishMap.getOrDefault(number, "Invalid input");
    }

    /**
     * Tests the translateToSpanish method.
     */
    void testTranslateToSpanish() {
        System.out.println(translateToSpanish(3)); // Output: tres
        System.out.println(translateToSpanish(11)); // Output: Invalid input
    }

    /**
     * Calculates the average of a variable amount of integers.
     * 
     * @param numbers The integers to calculate the average of.
     * @return The average of the integers.
     */

    double average(int... numbers) {
        double total = 0.0;
        for (int num : numbers) {
            total += num;
        }
        return total / numbers.length;
    }
}
