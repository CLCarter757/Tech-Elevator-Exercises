package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTest {

    @Test
    public void haveParty_returns_false_if_cigars_less_than_40_weekend() {
        //Arrange
        int cigars = 39;
        CigarParty sut = new CigarParty();

        //Act
        boolean notEnoughCigars = sut.haveParty(cigars, true);

        //Assert
        Assert.assertFalse("Cigar minimum not met", notEnoughCigars);
    }

    @Test
    public void haveParty_returns_false_if_cigars_less_than_40_weekday() {
        //Arrange
        int cigars = 39;
        CigarParty sut = new CigarParty();

        //Act
        boolean notEnoughCigars = sut.haveParty(cigars, false);

        //Assert
        Assert.assertFalse("Cigar minimum not met", notEnoughCigars);
    }

    @Test
    public void haveParty_returns_false_if_cigars_more_than_60_on_weekday() {
        //Arrange
        int cigars = 61;
        CigarParty sut = new CigarParty();

        //Act
        boolean tooManyCigars = sut.haveParty(cigars, false);

        //Assert
        Assert.assertFalse("Cigar maximum exceeded", tooManyCigars);
    }
    @Test
    public void haveParty_returns_true_if_cigars_more_than_60_on_weekend() {
        //Arrange
        int cigars = 61;
        CigarParty sut = new CigarParty();

        //Act
        boolean cigarCount = sut.haveParty(cigars, true);

        //Assert
        Assert.assertTrue("Cigar maximum should not exist", cigarCount);
    }

    @Test
    public void haveParty_cigar_minimum_40_inclusive() {
        //Arrange
        int cigars = 40;
        CigarParty sut = new CigarParty();

        //Act
        boolean cigarCount = sut.haveParty(cigars, false);

        //Assert
        Assert.assertTrue("40 should be inclusive", cigarCount);
    }

    @Test
    public void haveParty_cigar_maximum_60_inclusive() {
        //Arrange
        int cigars = 60;
        CigarParty sut = new CigarParty();

        //Act
        boolean cigarCount = sut.haveParty(cigars, false);

        //Assert
        Assert.assertTrue("60 should be inclusive", cigarCount);
    }

    @Test
    public void haveParty_returns_true_if_cigars_between_40_and_60_on_weekday() {
        //Arrange
        int cigars = 50;
        CigarParty sut = new CigarParty();

        //Act
        boolean cigarCount = sut.haveParty(cigars, false);

        //Assert
        Assert.assertTrue("Cigars must be between 40 and 60", cigarCount);
    }


}
