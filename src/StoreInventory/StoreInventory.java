package StoreInventory;

import java.util.Scanner;

public class StoreInventory {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        Scanner sc = new Scanner(System.in);

        // loop until user exits
        while (true) {

            // print a welcome to the store
            System.out.println("Welcome to the store inventory system!");
            // print instructions
            System.out.println("1. Add an item");
            System.out.println("2. Check low stock");
            System.out.println("3. Discontinue an item");
            System.out.println("4. Display stock");
            System.out.println("5. List stock");
            System.out.println("6. Exit");
            System.out.println("\n\nEnter your choice: ");
            int choice;
            while (true) {
                try {
                    choice = Integer.parseInt(sc.nextLine());
                    break; // Exit the loop if the input is a valid integer
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            // sc.nextLine();

            switch (choice) {
                case 1:
                    inv.addItem();
                    break;
                case 2:
                    inv.checkLowStock();
                    break;
                case 3:
                    System.out.println("Enter the stock number of the item to discontinue: ");
                    int stockNum = sc.nextInt();
                    sc.nextLine(); // consume the newline character
                    inv.discontinueItem(stockNum);
                    break;
                case 4:
                    System.out.println("Enter the stock number of the item to display: ");
                    int stockNumDisplay = sc.nextInt();
                    sc.nextLine(); // consume the newline character
                    inv.displayStock(stockNumDisplay);
                    break;
                case 5:
                    System.out.println("Listing items...");
                    inv.listInventory();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }

    }
}
