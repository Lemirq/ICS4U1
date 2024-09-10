package Unit1;

/**
 * A simple calculator program that can perform addition and subtraction
 * on both integers and floating-point numbers.
 */
public class Calculator {
    /**
     * Adds two integers and returns the result.
     * 
     * @param a the first integer
     * @param b the second integer
     * @return the sum of a and b
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /**
     * Adds two floating-point numbers and returns the result.
     * 
     * @param a the first floating-point number
     * @param b the second floating-point number
     * @return the sum of a and b
     */
    public static double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts the second integer from the first and returns the result.
     * 
     * @param a the first integer
     * @param b the second integer
     * @return the result of subtracting b from a
     */
    public static int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Subtracts the second floating-point number from the first and returns the
     * result.
     * 
     * @param a the first floating-point number
     * @param b the second floating-point number
     * @return the result of subtracting b from a
     */
    public static double subtract(double a, double b) {
        return a - b;
    }

    public static void main(String[] args) {
        // Test integer operations
        System.out.println("Integer Addition: 5 + 3 = " + add(5, 3));
        System.out.println("Integer Subtraction: 5 - 3 = " + subtract(5, 3));

        // Test floating-point operations
        System.out.println("Floating-point Addition: 5.5 + 3.2 = " + add(5.5, 3.2));
        System.out.println("Floating-point Subtraction: 5.5 - 3.2 = " + subtract(5.5, 3.2));
    }
}
