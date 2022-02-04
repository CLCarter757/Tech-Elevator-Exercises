package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ReviewTest {
    private Review myReview;

    @Before
    public void setup() {
        myReview = new Review();
    }

    @Test
    public void getNullArray_returns_null() {
        // Arrange


        // Act
        int[] array = myReview.getNullArray();

        // Assert
        Assert.assertNull(array);
    }

    @Test
    public void some_other_test() {

    }

    @Test
    public void getRange_returns_five_through_ten() {
        // Arrange

        // Act
        List<Integer> range = myReview.getRange(5, 10);

        // Assert
        Assert.assertNotNull("The array is null", range);
        Assert.assertEquals("The size of the array is not 6", 6, range.size());
        Assert.assertEquals(Integer.valueOf(5), range.get(0));
        Assert.assertEquals(Integer.valueOf(6), range.get(1));
        Assert.assertEquals(Integer.valueOf(7), range.get(2));
        Assert.assertEquals(Integer.valueOf(8), range.get(3));
        Assert.assertEquals(Integer.valueOf(9), range.get(4));
        Assert.assertEquals(Integer.valueOf(10), range.get(5));
    }
}
