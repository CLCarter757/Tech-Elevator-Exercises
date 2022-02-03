package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class M1D04LoopsArraysExerciseTest {
    private M1D04LoopsArraysExercise loopsArraysExercise;


    @Before
    public void setup() {
        loopsArraysExercise = new M1D04LoopsArraysExercise();
    }

    /*
     null -> 0
	 [] -> 0
     [2] -> 1
     [1, 2] -> 1
     [0, -1, -2] -> 2
     */

    @Test
    public void countEvens_returns_zero_given_null() {
        // Arrange
        int[] nums = null;

        // Act
        int numberOfEvens = loopsArraysExercise.countEvens(nums);

        // Assert
        Assert.assertEquals(1, numberOfEvens);
    }

    @Test
    public void countEvens_returns_zero_given_empty() {
        // Arrange
        int[] nums = new int[0];

        // Act
        int numberOfEvens = loopsArraysExercise.countEvens(nums);

        // Assert
        Assert.assertEquals(0, numberOfEvens);
    }

    @Test
    public void countEvens_returns_1_given_1_even_1_odd() {
        // Arrange
        int[] nums = { 1, 2 };

        // Act
        int numberOfEvens = loopsArraysExercise.countEvens(nums);

        // Assert
        Assert.assertEquals(1, numberOfEvens);
    }
}
