package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.Enumeration;

public class DateFashionTest {

    @Test
    public void getATable_no_if_you_yes_date_no() {
        //Arrange
        int you = 8;
        int date = 2;
        DateFashion sut = new DateFashion();

        //Act
        int input = sut.getATable(you, date);

        //Assert
        Assert.assertEquals(0, input);
    }

    @Test
    public void getATable_no_if_you_no_date_yes() {
        //Arrange
        int you = 2;
        int date = 8;
        DateFashion sut = new DateFashion();

        //Act
        int input = sut.getATable(you, date);

        //Assert
        Assert.assertEquals(0, input);
    }

    @Test
    public void getATable_no_if_both_are_no() {
        //Arrange
        int you = 1;
        int date = 2;
        DateFashion sut = new DateFashion();

        //Act
        int input = sut.getATable(you, date);

        //Assert
        Assert.assertEquals(0, input);
    }

    @Test
    public void getATable_yes_if_you_yes_date_yes() {
        //Arrange
        int you = 8;
        int date = 10;
        DateFashion sut = new DateFashion();

        //Act
        int input = sut.getATable(you, date);

        //Assert
        Assert.assertEquals(2, input);
    }

    @Test
    public void getATable_no_if_you_maybe_date_no() {
        //Arrange
        int you = 6;
        int date = 2;
        DateFashion sut = new DateFashion();

        //Act
        int input = sut.getATable(you, date);

        //Assert
        Assert.assertEquals(0, input);
    }

    @Test
    public void getATable_maybe_if_you_both_maybe() {
        //Arrange
        int you = 6;
        int date = 7;
        DateFashion sut = new DateFashion();

        //Act
        int input = sut.getATable(you, date);

        //Assert
        Assert.assertEquals(1, input);
    }
    @Test
    public void getATable_yes_if_you_yes_date_maybe() {
        //Arrange
        int you = 9;
        int date = 6;
        DateFashion sut = new DateFashion();

        //Act
        int input = sut.getATable(you, date);

        //Assert
        Assert.assertEquals(2, input);
    }
}
