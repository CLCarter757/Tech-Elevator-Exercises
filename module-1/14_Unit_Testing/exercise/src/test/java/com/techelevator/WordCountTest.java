package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {
    private WordCount sut;

    @Before
    public void setup() {
        sut = new WordCount();
    }

    @Test
    public void getCount_empty_array_returns_empty_map(){
        //Arrange
        String[] words = {};
        Map<String, Integer> expected= new HashMap<>();

        //Act
        Map<String, Integer> wordCount = sut.getCount(words);

        //Assert
        Assert.assertEquals(expected, wordCount);
    }

    @Test
    public void getCount_null_array_returns_empty_map(){
        //Arrange
        String[] words = null;
        Map<String, Integer> expected= new HashMap<>();

        //Act
        Map<String, Integer> wordCount = sut.getCount(words);

        //Assert
        Assert.assertEquals(expected, wordCount);
    }

    @Test
    public void getCount_returns_ba2_black1_sheep1() {
        //Arrange
        String[] words = {"ba" , "ba", "black", "sheep"};
        Map<String, Integer> expected= new HashMap<>();
        expected.put("ba", 2);
        expected.put("black", 1);
        expected.put("sheep", 1);

        //Act
        Map<String, Integer> wordCount = sut.getCount(words);

        //Assert
        Assert.assertEquals(expected, wordCount);
    }

    @Test
    public void getCount_returns_a2_b2_c1() {
        //Arrange
        String[] words = {"a", "b", "a", "c", "b"};
        Map<String, Integer> expected= new HashMap<>();
        expected.put("a", 2);
        expected.put("b", 2);
        expected.put("c", 1);

        //Act
        Map<String, Integer> wordCount = sut.getCount(words);

        //Assert
        Assert.assertEquals(expected, wordCount);
    }

}
