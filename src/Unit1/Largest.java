package Unit1;

public class Largest {
    public static void main(String[] args) {

        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int largest = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > largest) {
                largest = numbers[i];
            }
        }

        System.out.println("The largest number is: " + largest);
        // length of strig
        // String str = "Hello, World!";
        // System.out.println("The length of the string is: " + str.toup);

        int number = 10;
        int total = 1;
        for (int i = 1; i <= number; i++) {
            total *= i;
        }
        System.out.println("The factorial of " + number + " is: " + total);
    }
}
