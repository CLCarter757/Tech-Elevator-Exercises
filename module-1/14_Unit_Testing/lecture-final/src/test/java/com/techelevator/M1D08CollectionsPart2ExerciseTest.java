package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class M1D08CollectionsPart2ExerciseTest {

    /*
    wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
     */

    @Test
    public void wordCount_returns_ba2_black1_sheep1() {
        // Arrange
        M1D08CollectionsPart2Exercise sut = new M1D08CollectionsPart2Exercise();
        String[] words = { "ba", "ba", "black", "sheep" };
        Map<String, Integer> expected = new HashMap<>();
        expected.put("ba", 2);
        expected.put("black", 1);
        expected.put("sheep", 1);

        // Act
        Map<String, Integer> wordCount = sut.wordCount(words);

        // Assert
        Assert.assertEquals(expected, wordCount);
    }
}
