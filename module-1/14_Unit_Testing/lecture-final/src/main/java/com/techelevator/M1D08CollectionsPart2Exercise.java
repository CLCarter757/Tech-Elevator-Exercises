package com.techelevator;

import java.util.Map;
import java.util.HashMap;

public class M1D08CollectionsPart2Exercise {

    /*
     * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
     * number of times that String appears in the array.
     *
     * ** A CLASSIC **
     *
     * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
     *
     */
    public Map<String, Integer> wordCount(String[] words) {
        Map<String, Integer> wordCount = new HashMap<>();

        for(String word : words) {
            if(wordCount.containsKey(word)) {
                // if contains, increment within the map
                Integer currentCount = wordCount.get(word);
                wordCount.put(word, currentCount + 1);
            } else {
                // if not, add it to the map
                wordCount.put(word, 1);
            }
        }

        return wordCount;
    }
}
