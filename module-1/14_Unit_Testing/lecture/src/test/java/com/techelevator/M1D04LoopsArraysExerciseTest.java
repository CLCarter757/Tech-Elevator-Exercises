package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class M1D04LoopsArraysExerciseTest {



    @Test
    public void countEvens_returns_zero_given_null() {
        //Arrange
        int[] nums = null;
        M1D04LoopsArraysExercise sut = new M1D04LoopsArraysExercise(); //sut = service under test
        //Act
        int numberOfEvens = sut.countEvens(nums);
        //Assert
        Assert.assertEquals(0, numberOfEvens);
    }

    @Test
    public void countEvens_returns_zero_given_empty() {
        //Arrange
        int[] nums = new int[0];
        M1D04LoopsArraysExercise sut = new M1D04LoopsArraysExercise();
        //Act
        int numberOfEvens = sut.countEvens(nums);
        //Assert
        Assert.assertEquals(0,numberOfEvens);
    }

    @Test
    public void countsEvens_returns_1_given_1_even_1_odd(){
        //Arrange
        int[] nums = {1, 2};
        M1D04LoopsArraysExercise sut = new M1D04LoopsArraysExercise();
        //Act
        int numberOfEvens = sut.countEvens(nums);
        //Assert
        Assert.assertEquals(1,numberOfEvens);
    }

}