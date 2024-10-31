package Unit1;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.net.URL;

public class RPSLS {

    public static void main(String[] args) {
        RPSLS r = new RPSLS();
        r.getScoresFromFile();
        r.showRules();
        r.playGame();
    }

    private static Scanner sc = new Scanner(System.in);
    private String[] choices = { "Rock", "Paper", "Scissors", "Lizard", "Spock" };
    private int[] beats1 = { 3, 0, 1, 4, 0 };
    private int[] beats2 = { 2, 4, 3, 1, 2 };
    int total, wins, losses, ties;

    // get scores from file if it exists
    public RPSLS() {
        getScoresFromFile();
    }

    int choice;

    // shows rules
    private void showRules() {
        System.out.println("Rock, Paper, Scissors, Lizard, Spock");
        printSeparator();
        System.out.println("Rules of the Game:\n" + //
                "You will choose your throw. I will choose my throw. The winner will be determined based on the the following rules:\n"
                + //
                "ROCK breaks SCISSORS and crushes LIZARD\n" + //
                "PAPER covers ROCK and disproves SPOCK\n" + //
                "SCISSORS cuts PAPER and decapitates LIZARD\n" + //
                "LIZARD poisons SPOCK and eats PAPER\n" + //
                "SPOCK breaks SCISSORS and vaporizes ROCK\n");
        printSeparator();
    }

    private void displayScores() {
        System.out.printf("Current Record:\n" + //
                "Total games played: %d\n" + //
                "Wins: %d\tLoses: %d\tTies: %d", total, wins, losses, ties);
    }

    private void playGame() {
        while (true) {
            displayScores();
            // get user choice, and validate as int and between 1 and 5
            choice = getChoice();
            if (choice == 0) {
                break;
            }

            // get computer choice
            int computerChoice = (int) (Math.random() * 5);
            System.out.println(computerChoice);

            findWinner(choice - 1, computerChoice);

            // ask if they still wanna play
            System.out.println("\n\nDo you want to play again? (Y/N)");
            String playAgain = sc.nextLine();
            if (playAgain.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    private void findWinner(int user, int computer) {
        // print who beats who with what
        System.out.println("You chose: " + choices[user]);
        System.out.println("Computer chose: " + choices[computer]);
        try {
            String jsonResponse = callApi(choices[user], choices[computer]);
            System.out.println(jsonResponse);
            String text = extractTextFromResponse(jsonResponse);
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // check if user wins
        if (beats1[user] == computer || beats2[user] == computer) {
            wins++;
        } else if (user == computer) {
            ties++;
        } else {
            losses++;
        }

        total++;
        writeScores();
        printSeparator();
        displayScores();

    }

    private void getScoresFromFile() {
        ArrayList<String> scores = new ArrayList<String>();
        try {
            File myObj = new File("scores.txt");
            FileReader myReader = new FileReader(myObj);
            BufferedReader br = new BufferedReader(myReader);
            String line;
            while ((line = br.readLine()) != null) {
                scores.add(line);
            }

            br.close();
            myReader.close();
            System.out.println("Read scores...");
            // add to scores values
            total = Integer.parseInt(scores.get(0));
            wins = Integer.parseInt(scores.get(1));
            losses = Integer.parseInt(scores.get(2));
            ties = Integer.parseInt(scores.get(3));
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private void writeScores() {
        try {
            FileWriter myWriter = new FileWriter("scores.txt");
            BufferedWriter bw = new BufferedWriter(myWriter);
            bw.write(total + "\n");
            bw.write(wins + "\n");
            bw.write(losses + "\n");
            bw.write(ties + "\n");
            bw.close();
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private int getChoice() {
        System.out.println("\n\nEnter your choice:\n" + //
                "1. Rock\n" + //
                "2. Paper\n" + //
                "3. Scissors\n" + //
                "4. Lizard\n" + //
                "5. Spock\n" + //
                "0. Exit");
        int choice = 0;
        while (true) {
            try {
                choice = sc.nextInt();
                if (choice >= 0 && choice <= 5) {
                    break;
                }
                System.out.println("Invalid choice. Please enter a number between 0 and 5.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please enter a number between 0 and 5.");
            }
        }
        return choice;
    }

    private void printSeparator() {
        System.out.println("====================================");
    }

    public static String callApi(String user, String computer) throws Exception {
        // Create a URL object with the API URL
        URL url = new URL(
                "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=AIzaSyD2tf2JsuYLgUIlv0U34CGH-HQhtmiEGmE");
        // Open a connection to the URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // Set the request method to POST
        connection.setRequestMethod("POST");
        // Set the request headers Content-Type: application/json
        connection.setRequestProperty("Content-Type", "application/json");
        // Enable the connection to output data
        connection.setDoOutput(true);
        // Create a JSON object with the input data
        String jsonInputString = "{\"contents\":[{\"parts\":[{\"text\":\"In a rock paper scissors lizard spock game the user picks "
                + user
                + " and the computer picks " + computer
                + " Write a funny joke about whoever lost, and praise the user if they win, also say if its a tie.\"}]}]}";
        System.out.println(jsonInputString);

        // Write the JSON payload to the request body
        try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
            wr.writeBytes(jsonInputString);
            wr.flush();
        }

        // Get the response code
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Read the response
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Return the response as a string
        // System.out.print(response.toString());
        return response.toString();
    }

    public static String extractTextFromResponse(String jsonResponse) {
        // Define the regex pattern to extract the "text" field
        Pattern pattern = Pattern.compile("\"text\":\"(.*?)\"");
        Matcher matcher = pattern.matcher(jsonResponse);

        // Find and return the first match
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "Text field not found";
        }
    }
}