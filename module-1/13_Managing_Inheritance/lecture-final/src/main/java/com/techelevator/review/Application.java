package com.techelevator.review;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Application {
    public static void main(String[] args) {
        String s = "Walt";
        String y = "Walt";

        Review myReview = new Review();

        System.out.println(myReview.toString());

        String name = myReview.getNames()[3];


        // Math with BigDecimal
        double result = 1.3 / 0.6;

        BigDecimal onePointThree = new BigDecimal(1.3);
        BigDecimal pointSix = new BigDecimal(0.6);

        MathContext context = new MathContext(5, RoundingMode.CEILING);
        BigDecimal myResult = onePointThree.divide(pointSix, context);


        // Conversion between double and BigDecimal
        double fivePointFive = 5.5;

        BigDecimal bdFivePointFive = BigDecimal.valueOf(fivePointFive);

        fivePointFive = bdFivePointFive.doubleValue();


        // Comparing two BigDecimal
        if(fivePointFive > 5) {
            System.out.println(fivePointFive + " is greater than 5!");
        }

        if(bdFivePointFive.compareTo(onePointThree) > 0) {
            System.out.println(bdFivePointFive + " is greater than " + onePointThree);
        }

    }
}
