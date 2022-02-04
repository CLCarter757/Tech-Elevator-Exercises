package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringBitsTest {
    StringBits sut = new StringBits();

    @Test
    public void getBits_null_string_returns_empty_string(){
        //Arrange
        String str = null;

        //Act
        String input = sut.getBits(str);

        //Assert
        Assert.assertEquals("", input);
    }

    @Test
    public void getBits_empty_string_returns_empty_string(){
        //Arrange
        String str = "";

        //Act
        String input = sut.getBits(str);

        //Assert
        Assert.assertEquals("", input);
    }

    @Test
    public void getBits_string_returns_every_other_letter(){
        //Arrange
        String str = "Hello";

        //Act
        String input = sut.getBits(str);

        //Assert
        Assert.assertEquals("Hlo", input);
    }

    @Test
    public void getBits_long_string_returns_every_other_letter(){
        //Arrange
        String str = "BallBallBallBallBallBall";

        //Act
        String input = sut.getBits(str);

        //Assert
        Assert.assertEquals("BlBlBlBlBlBl", input);
    }

    @Test
    public void getBits_short_string_returns_one_letter(){
        //Arrange
        String str = "Hi";

        //Act
        String input = sut.getBits(str);

        //Assert
        Assert.assertEquals("H", input);
    }

}
