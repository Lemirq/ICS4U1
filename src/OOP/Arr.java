package OOP;

import java.util.ArrayList;

/**
 * Arr
 */
public class Arr {

    public static void main(String[] args) {
        // arraylist with arraylist inside them
        ArrayList<ArrayList<ArrayList<String>>> list = new ArrayList<>();
        // Create innermost ArrayList and add elements
        ArrayList<String> innerMostList = new ArrayList<>();
        innerMostList.add("Hello");
        innerMostList.add("World");

        // Create middle ArrayList and add innermost ArrayList
        ArrayList<ArrayList<String>> middleList = new ArrayList<>();
        middleList.add(innerMostList);

        // Add middle ArrayList to the outer ArrayList
        list.add(middleList);

        // Print the nested ArrayList
        System.out.println(list);
    }
}