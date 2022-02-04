package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {

    @Test
    public void isLessThanMultipleOf20_n_is_not_negative() {
        //Arrange
        Less20 sut = new Less20();
        int n = -1;

        //Act
        boolean intIsPositive = sut.isLessThanMultipleOf20(n);

        //Assert
        Assert.assertFalse("n should not be negative", intIsPositive);
    }

    @Test
    public void isLessThanMultipleOf20_returns_true_if_one_less() {
        //Arrange
        Less20 sut = new Less20();
        int n = 19;

        //Act
        boolean input = sut.isLessThanMultipleOf20(n);

        //Assert
        Assert.assertTrue("Numbers one less than a multiple of 20 should return true.", input);
    }

    @Test
    public void isLessThanMultipleOf20_returns_true_if_two_less() {
        //Arrange
        Less20 sut = new Less20();
        int n = 38;

        //Act
        boolean input = sut.isLessThanMultipleOf20(n);

        //Assert
        Assert.assertTrue("Numbers two less than a multiple of 20 should return true.", input);
    }

    @Test
    public void isLessThanMultipleOf20_returns_false_if_more_than_two_less() {
        //Arrange
        Less20 sut = new Less20();
        int n = 57;

        //Act
        boolean input = sut.isLessThanMultipleOf20(n);

        //Assert
        Assert.assertFalse("Numbers more than 2 less a multiple of 20 should return false.", input);
    }

    @Test
    public void isLessThanMultipleOf20_returns_false_if_40() {
        //Arrange
        Less20 sut = new Less20();
        int n = 40;

        //Act
        boolean input = sut.isLessThanMultipleOf20(n);

        //Assert
        Assert.assertFalse("Numbers that are a multiple of 20 should return false.", input);
    }
}
