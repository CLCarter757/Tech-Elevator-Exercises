package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Test {

    @Test
    public void getLucky_null_returns_true() {
        //Arrange
        Lucky13 sut = new Lucky13();
        int[] nums = null;

        //Act
        boolean input = sut.getLucky(nums);

        //Assert
        Assert.assertTrue("Null should return true.", input);
    }

    @Test
    public void getLucky_returns_true_if_no_1s_or_3s() {
        //Arrange
        Lucky13 sut = new Lucky13();
        int[] nums = {0, 2, 4, 5};

        //Act
        boolean input = sut.getLucky(nums);

        //Assert
        Assert.assertTrue("Should return true if array does not contain 1 or 3.", input);
    }

    @Test
    public void getLucky_returns_false_if_1s_and_3s() {
        //Arrange
        Lucky13 sut = new Lucky13();
        int[] nums = {1, 2, 3, 4, 5};

        //Act
        boolean input = sut.getLucky(nums);

        //Assert
        Assert.assertFalse("Should return false if array contains 1 or 3.", input);
    }

    @Test
    public void getLucky_returns_false_if_1s() {
        //Arrange
        Lucky13 sut = new Lucky13();
        int[] nums = {1, 2, 4, 5};

        //Act
        boolean input = sut.getLucky(nums);

        //Assert
        Assert.assertFalse("Should return false if array contains 1.", input);
    }

    @Test
    public void getLucky_returns_false_if_3s() {
        //Arrange
        Lucky13 sut = new Lucky13();
        int[] nums = {0, 2, 3, 4, 5};

        //Act
        boolean input = sut.getLucky(nums);

        //Assert
        Assert.assertFalse("Should return false if array contains 3.", input);
    }

    @Test
    public void getLucky_returns_true_if_contains_13() {
        //Arrange
        Lucky13 sut = new Lucky13();
        int[] nums = {0, 2, 4, 13};

        //Act
        boolean input = sut.getLucky(nums);

        //Assert
        Assert.assertTrue("Should only return false if array contains 1 or 3.", input);
    }
}
