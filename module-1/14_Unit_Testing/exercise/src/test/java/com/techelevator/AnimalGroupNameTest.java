package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTest {

    @Test
    public void getHerd_returns_unknown_given_null() {
        //Arrange
        String animalName = null;
        AnimalGroupName sut = new AnimalGroupName();

        //Act
        String groupName = sut.getHerd(animalName);

        //Assert
        Assert.assertEquals("unknown", groupName);
    }

    @Test
    public void getHerd_returns_unknown_given_empty_string() {
        //Arrange
        String animalName = "";
        AnimalGroupName sut = new AnimalGroupName();

        //Act
        String groupName = sut.getHerd(animalName);

        //Assert
        Assert.assertEquals("unknown", groupName);
    }
    @Test
    public void getHerd_returns_unknown_if_animal_not_found() {
        //Arrange
        String animalName = "walrus";
        AnimalGroupName sut = new AnimalGroupName();

        //Act
        String groupName = sut.getHerd(animalName);

        //Assert
        Assert.assertEquals("unknown", groupName);
    }

    @Test
    public void getHerd_returns_herd_given_animal_name() {
        //Arrange
        String animalName = "Rhino";
        AnimalGroupName sut = new AnimalGroupName();

        //Act
        String groupName = sut.getHerd(animalName);

        //Assert
        Assert.assertEquals("Crash", groupName);
    }

    @Test
    public void getHerd_returns_herd_given_lowercase_name() {
        //Arrange
        String animalName = "rhino";
        AnimalGroupName sut = new AnimalGroupName();

        //Act
        String groupName = sut.getHerd(animalName);

        //Assert
        Assert.assertEquals("Crash", groupName);
    }

    @Test
    public void getHerd_returns_herd_given_uppercase_name() {
        //Arrange
        String animalName = "ELEPHANT";
        AnimalGroupName sut = new AnimalGroupName();

        //Act
        String groupName = sut.getHerd(animalName);

        //Assert
        Assert.assertEquals("Herd", groupName);
    }

    @Test
    public void getHerd_returns_unknown_given_plural() {
        //Arrange
        String animalName = "Elephants";
        AnimalGroupName sut = new AnimalGroupName();

        //Act
        String groupName = sut.getHerd(animalName);

        //Assert
        Assert.assertEquals("unknown", groupName);
    }
}
