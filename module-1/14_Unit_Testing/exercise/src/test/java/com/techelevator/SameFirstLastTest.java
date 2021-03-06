package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTest {

    @Test
    public void isItTheSame_null_array_returns_false() {
        //Arrange
        SameFirstLast sut = new SameFirstLast();
        int[] nums = null;

        //Act
        boolean input = sut.isItTheSame(nums);

        //Assert
        Assert.assertFalse("Null array should return false.", input);
    }

    @Test
    public void isItTheSame_empty_array_returns_false() {
        //Arrange
        SameFirstLast sut = new SameFirstLast();
        int[] nums = {};

        //Act
        boolean input = sut.isItTheSame(nums);

        //Assert
        Assert.assertFalse("Empty array should return false.", input);
    }

    @Test
    public void isItTheSame_same_first_last_returns_true() {
        //Arrange
        SameFirstLast sut = new SameFirstLast();
        int[] nums = {1, 2, 3, 1};

        //Act
        boolean input = sut.isItTheSame(nums);

        //Assert
        Assert.assertTrue("Array with the same first and last elements should return true.", input);
    }

    @Test
    public void isItTheSame_different_first_last_returns_false() {
        //Arrange
        SameFirstLast sut = new SameFirstLast();
        int[] nums = {1, 2, 3};

        //Act
        boolean input = sut.isItTheSame(nums);

        //Assert
        Assert.assertFalse("Array without the same first and last elements should return false.", input);
    }

    @Test
    public void isItTheSame_length_one_returns_true() {
        //Arrange
        SameFirstLast sut = new SameFirstLast();
        int[] nums = {1};

        //Act
        boolean input = sut.isItTheSame(nums);

        //Assert
        Assert.assertTrue("Array with only one element should return true.", input);
    }
}
