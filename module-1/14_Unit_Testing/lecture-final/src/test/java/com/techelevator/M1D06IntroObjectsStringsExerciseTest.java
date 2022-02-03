package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class M1D06IntroObjectsStringsExerciseTest {

    /*
     hasBad("badxx") → true
	 hasBad("xbadxx") → true
	 hasBad("xxbadxx") → false
     */

    @Test
    public void hasBad_returns_false_given_null() {
        // Arrange
        M1D06IntroObjectsStringsExercise sut = new M1D06IntroObjectsStringsExercise();
        String input = null;

        // Act
        boolean hasBad = sut.hasBad(input);

        // Assert
        Assert.assertFalse("null does have 'bad' at position 0 or 1", hasBad);
    }

    @Test
    public void hasBad_returns_true_given_badxx() {
        // Arrange
        M1D06IntroObjectsStringsExercise sut = new M1D06IntroObjectsStringsExercise();
        String input = "badxx";

        // Act
        boolean hasBad = sut.hasBad(input);

        // Assert
        Assert.assertTrue(input + " does not have 'bad' at position 0 or 1", hasBad);
    }

    @Test
    public void hasBad_returns_true_given_xbadxx() {
        // Arrange
        M1D06IntroObjectsStringsExercise sut = new M1D06IntroObjectsStringsExercise();
        String input = "xbadxx";

        // Act
        boolean hasBad = sut.hasBad(input);

        // Assert
        Assert.assertTrue(input + " does not have 'bad' at position 0 or 1", hasBad);
    }

    @Test
    public void hasBad_returns_false_given_xxbadxx() {
        // Arrange
        M1D06IntroObjectsStringsExercise sut = new M1D06IntroObjectsStringsExercise();
        String input = "xxbadxx";

        // Act
        boolean hasBad = sut.hasBad(input);

        // Assert
        Assert.assertFalse(input + " does have 'bad' at position 0 or 1", hasBad);
    }
}
