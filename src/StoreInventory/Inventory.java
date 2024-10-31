package StoreInventory;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    Scanner sc = new Scanner(System.in);
    ArrayList<Item> stock = new ArrayList<Item>();

    void listInventory() {
        printItems(stock);
    }

    void addItem() {
        System.out.println("Pick an item type: ");
        System.out.println("1. General Item");
        System.out.println("2. Electronic Item (includes voltage property)");
        int choice;
        Item i;

        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                break; // Exit the loop if the input is a valid integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        System.out.println("Enter new item's name: ");
        String itemName = sc.nextLine();

        switch (choice) {
            case 1:
                i = new Item(itemName);
                break;
            case 2:
                int voltage;
                System.out.println("Enter voltage: ");
                while (true) {
                    try {
                        voltage = Integer.parseInt(sc.nextLine());
                        break; // Exit the loop if the input is a valid integer
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                    }
                }

                i = new ElectronicItem(itemName, voltage);
                break;

            default:
                return;
        }

        stock.add(i);
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(stock.get(stock.size() - 1));
        System.out.println("Item has been added:");
        printItems(items);
    }

    void printItems(ArrayList<Item> items) {
        System.out.println("\n\n\t ID \t Name \t Stock Amount");
        items.forEach((Item i) -> {
            int index = items.indexOf(i);
            System.out.println(index + 1 + ". \t " + i.getStockNum() + " \t " + i.getName() + " \t " + i.getStockAmt());
        });
        System.out.println();
        System.out.println();
    }

    void checkLowStock() {
        System.out.println("Enter limit to check (all items with stock amount under this will be returned): ");
        ArrayList<Item> lowStock = new ArrayList<Item>();
        int limit;
        while (true) {
            try {
                limit = Integer.parseInt(sc.nextLine());
                break; // Exit the loop if the input is a valid integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        // Add logic to check items with stock amount under the limit
        // For example:
        for (Item item : stock) {
            if (item.getStockAmt() < limit) {
                lowStock.add(item);
            }
        }

        printItems(lowStock);
    }

    void discontinueItem(int stockNum) {

        stock.forEach((Item i) -> {
            if (stockNum == i.getStockNum()) {
                i.discontinueItem();
            }
        });
    }

    void displayStock(int stockNum) {
        stock.forEach((Item i) -> {
            if (i.getStockNum() == stockNum) {
                System.out.printf("Stock amount is: %d", i.getStockAmt());
            }
        });

    }
}
