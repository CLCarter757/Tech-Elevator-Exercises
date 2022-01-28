package com.techelevator.cardexample;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck {
    /*
        cards (52 maybe, most of the time)
        order
     */
    private Stack<Card> cards;

    public Deck() {
        cards = new Stack<>();
    }

    public Deck(List<Card> cards) {
        addCardsHelper(cards);
    }

    // Methods

    // draw next card
    public Card drawCard() {
        return this.cards.pop();
    }

    // shuffle
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // add to the deck
    public void addCards(List<Card> cards) {
        addCardsHelper(cards);
    }

    private void addCardsHelper(List<Card> cards) {
        for(Card card : cards) {
            this.cards.push(card);
        }
    }

}
