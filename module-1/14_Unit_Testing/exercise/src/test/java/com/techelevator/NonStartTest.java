package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTest {

    @Test
    public void getPartialString_given_two_null_strings_return_empty_string() {
        //Arrange
        NonStart sut = new NonStart();
        String a = null;
        String b = null;

        //Act
        String input = sut.getPartialString(a, b);

        //Assert
        Assert.assertEquals("", input);
    }

    @Test
    public void getPartialString_given_one_null_return_string_minus_first_char() {
        //Arrange
        NonStart sut = new NonStart();
        String a = "Hello";
        String b = null;

        //Act
        String input = sut.getPartialString(a, b);

        //Assert
        Assert.assertEquals("ello", input);
    }

    @Test
    public void getPartialString_given_two_empty_strings_return_empty_string() {
        //Arrange
        NonStart sut = new NonStart();
        String a = "";
        String b = "";

        //Act
        String input = sut.getPartialString(a, b);

        //Assert
        Assert.assertEquals("", input);
    }

    @Test
    public void getPartialString_given_one_empty_string_return_other_string_minus_first_char() {
        //Arrange
        NonStart sut = new NonStart();
        String a = "";
        String b = "Hello";

        //Act
        String input = sut.getPartialString(a, b);

        //Assert
        Assert.assertEquals("ello", input);
    }

    @Test
    public void getPartialString_given_one_string_length_one() {
        //Arrange
        NonStart sut = new NonStart();
        String a = "Hello";
        String b = "T";

        //Act
        String input = sut.getPartialString(a, b);

        //Assert
        Assert.assertEquals("ello", input);
    }

    @Test
    public void getPartialString_given_two_strings_length_greater_than_one() {
        //Arrange
        NonStart sut = new NonStart();
        String a = "Java";
        String b = "Code";

        //Act
        String input = sut.getPartialString(a, b);

        //Assert
        Assert.assertEquals("avaode", input);
    }
}
