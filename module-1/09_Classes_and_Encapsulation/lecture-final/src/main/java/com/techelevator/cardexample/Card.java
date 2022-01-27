package com.techelevator.cardexample;

public class Card {
    // Fields
    // suit -> String
    // value -> int
    // title -> String e.g. King, Ace, Two
    // color -> String
    // isFaceUp -> boolean

    private String suit = "Some Default Value";
    public int value;
    private String title;
    private boolean isFaceUp = true;

    public Card(String suit, int value, String title, boolean isFaceUp) {
        this(suit, value, title);
        this.isFaceUp = isFaceUp;
    }

    public Card(String suit, int value, String title) {
        this.suit = suit;
        this.value = value;
        this.title = title;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getColor() {
        if(suit.equalsIgnoreCase("Hearts") || suit.equalsIgnoreCase("Diamonds")) {
            return "Red";
        }

        return "Black";
    }


    // Methods
    // flip
    // print the representation

    public void flipCard() {
        isFaceUp = !isFaceUp;
    }

    public String cardString() {
        return cardString(isFaceUp);
    }

    public String cardString(boolean isFaceUp) {
        if(isFaceUp) {
            return title + " of " + suit;
        }

        return "##";
    }
}
