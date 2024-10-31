package Unit1;

import java.util.ArrayList;

import java.io.*;

public class Lesson8 {
    public static void main(String[] args) {
        Haiku l = new Lesson8().new Haiku();
        l.readFile();
    }

    class Grades {
        String[] grades = { "Rhys - ABCCBA", "Emily - ABADBB", "Lukas - BAADCB", "Hadi - ABADCD", "Mei - ABADBA" };

        void writeToFile() {
            File file = new File("grades.txt");
            try {
                FileWriter f = new FileWriter(file);
                BufferedWriter w = new BufferedWriter(f);

                for (String line : grades) {
                    w.write(line.split(" - ")[0] + "\n" + line.split(" - ")[1]);
                    w.newLine();
                }

                w.close();
                f.close();
                System.out.println("File written successfully.");
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Revisit your program from Q13. Modify it so that it checks each students’
        // answers against the correct answers: ABADCB. In your file output, also
        // include the student’s score out of 6. File output should look like this:
        // Rhys
        // A
        // B
        // C
        // C
        // B
        // A
        // 2
        // Emily
        // …

        void readFile() {
            File file = new File("grades.txt");
            try {
                FileReader f = new FileReader(file);
                BufferedReader r = new BufferedReader(f);

                String line = r.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = r.readLine();
                }

                r.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        void calculateScore() {
            File file = new File("grades.txt");
            try {
                FileReader f = new FileReader(file);
                BufferedReader r = new BufferedReader(f);

                String line = r.readLine();
                while (line != null) {
                    String name = line;
                    String answers = r.readLine();
                    int score = 0;
                    for (int i = 0; i < answers.length(); i++) {
                        if (answers.charAt(i) == "ABADCB".charAt(i)) {
                            score++;
                        }
                    }
                    System.out.println(name + "\n" + score);
                    line = r.readLine();
                }

                r.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    class Haiku {

        ArrayList<String> haiku = new ArrayList<String>();

        void writeToFile() {
            haiku.add("A Haiku:");
            haiku.add("Line 1: Three things are certain:");
            haiku.add("Line 2: Death, taxes, and lost data.");
            haiku.add("Line 3: Guess which has occurred.");
            haiku.add("The End");

            File file = new File("haiku.txt");
            try {
                FileWriter f = new FileWriter(file);
                BufferedWriter w = new BufferedWriter(f);

                for (String line : haiku) {
                    w.write(line);
                    w.newLine();
                }

                w.close();
                f.close();
                System.out.println("File written successfully.");
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        void readFile() {
            File file = new File("haiku.txt");
            try {
                FileReader f = new FileReader(file);
                BufferedReader r = new BufferedReader(f);

                String line = r.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = r.readLine();
                }

                r.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        void averageLineLength() {
            int totalChars = 0;
            int totalLines = 0;

            File file = new File("haiku.txt");
            try {
                FileReader f = new FileReader(file);
                BufferedReader r = new BufferedReader(f);

                String line = r.readLine();
                while (line != null) {
                    totalChars += line.length();
                    totalLines++;
                    line = r.readLine();
                }

                r.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }

            double average = (double) totalChars / totalLines;
            System.out.println("Average line length: " + String.format("%.2f", average));
        }
    }
}