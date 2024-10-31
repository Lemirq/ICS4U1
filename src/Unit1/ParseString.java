package Unit1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseString {
    String tatti = "{\"contents\":[{\"parts\":[{\"text\":\"In a rock paper scissors lizard spock game the user picks Scissors and the computer picks Paper Write a funny joke about whoever lost, and praise the user if they win, also say if its a tie.\"}]}]}\n"
            + //
            "Response Code: 200\n" + //
            "{  \"candidates\": [    {      \"content\": {        \"parts\": [          {            \"text\": \"Okay, here's a funny joke and some responses for the Rock Paper Scissors Lizard Spock game:\\n"
            + //
            "\\n" + //
            "**User picks Scissors, Computer picks Paper**\\n" + //
            "\\n" + //
            "* **If the user loses:**  \\\"Oh no! Your scissors got flattened like a pancake by the computer's paper! Guess you'll have to stick with the blunt end of the joke today.\\\" \\n"
            + //
            "* **If the user wins:** \\\"Ha! Looks like your scissors sliced through the computer's paper with ease! You're a sharp operator! Congratulations!\\\" \\n"
            + //
            "* **If it's a tie:** \\\"Well, that was a close one! It seems your scissors and the computer's paper are in a stalemate.  Guess you'll both have to keep playing until someone gets the upper hand!\\\" \\n"
            + //
            "\"          }        ],        \"role\": \"model\"      },      \"finishReason\": \"STOP\",      \"index\": 0,      \"safetyRatings\": [        {          \"category\": \"HARM_CATEGORY_SEXUALLY_EXPLICIT\",          \"probability\": \"NEGLIGIBLE\"        },        {          \"category\": \"HARM_CATEGORY_HATE_SPEECH\",          \"probability\": \"NEGLIGIBLE\"        },        {          \"category\": \"HARM_CATEGORY_HARASSMENT\",          \"probability\": \"NEGLIGIBLE\"        },        {          \"category\": \"HARM_CATEGORY_DANGEROUS_CONTENT\",          \"probability\": \"NEGLIGIBLE\"        }      ]    }  ],  \"usageMetadata\": {    \"promptTokenCount\": 41,    \"candidatesTokenCount\": 160,    \"totalTokenCount\": 201  }}";

    // parse whole text field with regex
    Pattern pattern = Pattern.compile("\"text\":\"(.*?)\"");
    Matcher matcher = pattern.matcher(tatti);

    // Find and return the first match
    if(matcher.find())
    {
        return matcher.group(1);
    }else
    {
        return "Text field not found";
    }
}
