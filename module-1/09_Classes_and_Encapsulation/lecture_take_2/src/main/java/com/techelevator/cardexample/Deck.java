package com.techelevator.cardexample;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck {
    /*
    cards (52?)
    order
     */
    private Stack<Card> cards;

    //CONSTRUCTOR
    public Deck() {
        cards = new Stack<>();
    }

    public Deck(List<Card> cards) {
        for (Card card : cards) {    //or cards.addAll(cards);
            this.cards.push(card);
        }
    }

    //METHODs
    public Card drawCard() {
        return this.cards.pop();
    }

    public void addCards(List<Card> cards) {
        addCardsHelper(cards);
    }

    public void addCardsHelper(List<Card> cards) {
        for (Card card: cards) {
            this.cards.push(card);
        }
    }
    //shuffle
    public void shuffle(){
        Collections.shuffle(cards);
    }




}
