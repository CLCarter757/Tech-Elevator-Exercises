package com.techelevator.review;

import java.util.List;
import java.util.Objects;

public class Review {
    private List<String> names;

    private final String myName = "Walt";

    public String[] getNames() {
        return new String[5];
    }

    public String blahblahblah(int xyz) {
        return "blah blah blah";
    }

    @Override
    public String toString() {
        return "Printing a review object!";
    }
}

