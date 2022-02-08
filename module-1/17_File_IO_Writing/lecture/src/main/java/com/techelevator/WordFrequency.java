package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {

    /*

    Make a Map - key is word(String), value is frequency (int)

    Read entire file into List<String>

    Loop over each String (line)
       - replace punctuation with empty String so we ignore it
       - split the text from the file (won't account for punctuation) into words (by space)

       Loop over each word
       - check if word exists, add 1 if so, set to 1 if not

       Write to file
       - Loop through the Map
       - get key and value
       - write them to file

     */

    public static void main(String[] args) {

        Map<String, Integer> wordFrequency = new LinkedHashMap<>();

        try {
            List<String> lines = Files.readAllLines(Path.of("input.txt"));

            for(String line : lines) {
                line = line.replaceAll("\\.", ""); // \\replace period
                String[] words = line.split(" ");

                for(String word : words) {
                    word = word.toLowerCase();
                    if(wordFrequency.containsKey(word)) {
                        Integer frequency = wordFrequency.get(word) + 1;
                        wordFrequency.put(word, frequency);
                    } else {
                        wordFrequency.put(word, 1);
                    }
                }
            }

            try(PrintWriter writer = new PrintWriter("output.txt")) {
                for(String word : wordFrequency.keySet()) {
                    writer.println(word + " " + wordFrequency.get(word));
            }
        }

        } catch(IOException e) {
            System.out.println("Sorry, there was an error");
        }


    }
}
