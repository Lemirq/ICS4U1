package Unit1;

import java.util.Scanner;

public class Lesson4 {
    public static void main(String[] args) {
        Lesson4 lesson4 = new Lesson4();
        lesson4.evensAndOdds();
    }

    void account() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String inputUsername = scanner.nextLine();
        System.out.println("Enter password: ");
        String inputPassword = scanner.nextLine();

        System.out.printf("Username: %s, Password: %s\n", inputUsername.toUpperCase(), inputPassword.toLowerCase());
        scanner.close();
    }

    void monogram() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter your middle name: ");
        String middleName = scanner.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Monogram: " + firstName.toLowerCase().charAt(0) + middleName.toUpperCase().charAt(0)
                + lastName.toLowerCase().charAt(0));

        scanner.close();
    }

    void StringWhile() {
        String str = "";
        Scanner sc = new Scanner(System.in);
        while (str.length() < 9) {
            System.out.println("Enter an eight character string:");
            str = sc.nextLine();

        }

        System.out.println("First three: " + str.substring(0, 3));
        System.out.println("Second three: " + str.substring(3, 6));
        System.out.println("Last three: " + str.substring(6, 9));
        sc.close();
    }

    void vowels() {
        char[] arr = { 'a', 'e', 'i', 'o', 'u' };
        int total = 0;

        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        System.out.println(inp);

        for (int i = 0; i < inp.length(); i++) {
            for (char string : arr) {
                if (inp.toLowerCase().charAt(i) == string) {
                    total += 1;
                }
            }
        }

        System.out.printf("The number of vowels in %s is %d vowels \n", inp, total);

        sc.close();

    }

    void GroupAssignment() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String firstName = sc.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = sc.nextLine();

        char firstLetter = lastName.toLowerCase().charAt(0);
        String group = "";

        if (firstLetter >= 'a' && firstLetter <= 'i') {
            group = "Group 1";
        } else if (firstLetter >= 'j' && firstLetter <= 's') {
            group = "Group 2";
        } else if (firstLetter >= 't' && firstLetter <= 'z') {
            group = "Group 3";
        }

        System.out.printf("%s %s is assigned to %s\n", firstName, lastName, group);
        sc.close();
    }

    void array() {
        int[] arr = new int[5];
        arr[3] = 7;
        System.out.println(arr[3]);
    }

    void duckArray() {
        String[] ducks = { "Donald", "Huey", "Dewey", "Louis" };
        for (String duck : ducks) {
            System.out.println(duck);
        }
    }

    void friendsArray() {
        String[] friends = new String[3];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < friends.length; i++) {
            System.out.println("Enter the name of a friend: ");
            friends[i] = sc.nextLine();
        }

        System.out.println("The names of your friends are:");
        for (String friend : friends) {
            System.out.println(friend);
        }
        sc.close();
    }

    void squareArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * i;
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }

    void countdown() {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println("Countdown:");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
        System.out.println("GO!");
    }

    void evensAndOdds() {
        int[] arr = new int[25];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        System.out.print("ODD: ");
        for (int i : arr) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println();

        System.out.print("EVEN: ");
        for (int i : arr) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    }
}