package com.techelevator.cardexample;

public class Card {

    //FIELDS
    private String suit;             // suit -> String
    private int value;               // value -> int
    private String title;            // title -> String (King, Ace, Two)
    private String color;            // color -> String
    private boolean isFaceUp = true; // isFaceUp -> boolean

    //CONSTRUCTOR
    public Card(String suit, int value, String title) {
        this.suit = suit; //this refers to fields or broader scopes
        this.value = value;
        this.title = title;
    }

    public Card(String suit, int value, String title, boolean isFaceUp) {
        this.suit = suit;       //
        this.value = value;     // could call this(suit, value, title)
        this.title = title;     //
        this.isFaceUp = isFaceUp;
    }

    //GETTERS & SETTERS
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
            return "red";
        } return "black";
    }



    //METHODS
    // flip
    // print the representation

    public void flipCard() {
        isFaceUp = !isFaceUp;
    }

    public String cardString() {
        if(isFaceUp) {     //could instead call cardString(isFaceUp)
            return title + " of " + suit;
        } return"##";
    }

    public String cardString(boolean isFaceUp) {
        if(isFaceUp) {
            return title + " of " + suit;
        } return"##";
    }


}
