package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Test {

    @Test
    public void makeArray_returns_first_element_when_largest() {
        //Arrange
        MaxEnd3 sut = new MaxEnd3();
        int[] nums = {11, 5, 9};
        int[] answer = {11, 11, 11};

        //Act
        int [] input = sut.makeArray(nums);

        //Assert
        Assert.assertArrayEquals(answer, input);
    }

    @Test
    public void makeArray_returns_last_element_when_largest() {
        //Arrange
        MaxEnd3 sut = new MaxEnd3();
        int[] nums = {1, 2, 3};
        int[] answer = {3, 3, 3};

        //Act
        int [] input = sut.makeArray(nums);

        //Assert
        Assert.assertArrayEquals(answer, input);
    }

    @Test
    public void makeArray_ignores_second_element() {
        //Arrange
        MaxEnd3 sut = new MaxEnd3();
        int[] nums = {1, 5, 3};
        int[] answer = {3, 3, 3};

        //Act
        int [] input = sut.makeArray(nums);

        //Assert
        Assert.assertArrayEquals(answer, input);
    }

    @Test
    public void makeArray_returns_when_first_and_last_elements_are_equal() {
        //Arrange
        MaxEnd3 sut = new MaxEnd3();
        int[] nums = {11, 2,11};
        int[] answer = {11,11,11};

        //Act
        int [] input = sut.makeArray(nums);

        //Assert
        Assert.assertArrayEquals(answer, input);
    }
}
