package Unit1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class FileReaderExample {
    public static void main(String[] args) {
        FileReaderExample fileReader = new FileReaderExample();

        // fileReader.readFile("assets/Example.txt");
        fileReader.readURL("https://www.hack49.com");
    }

    public void readFile(String filePath) {
        // Use BufferedReader to read the file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public void readURL(String url) {
        URL myUrl;
        try {
            myUrl = new URL(url);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(myUrl.openStream()))) {
                String html;
                StringBuilder sb = new StringBuilder();
                while ((html = br.readLine()) != null) {
                    sb.append(html);
                }
                String line = sb.toString();

                // write to an html file
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("assets/hack49.html"))) {
                    bw.write(line);
                } catch (IOException e) {
                    System.err.println("Error writing to the file: " + e.getMessage());
                }

            } catch (IOException e) {
                System.err.println("Error reading the URL: " + e.getMessage());
            }
        } catch (MalformedURLException e) {
            System.err.println("Error reading the URL: " + e.getMessage());
        }
    }

}