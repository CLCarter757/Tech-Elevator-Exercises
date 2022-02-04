package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void equals_returns_true_for_two_johnnys() {
        // Arrange

        // Act
        Person johnny1 = new Person("Johnny", 25);
        Person johnny2 = new Person("Johnny", 25);

        // Assert
        Assert.assertEquals(johnny1, johnny2);

    }

}
