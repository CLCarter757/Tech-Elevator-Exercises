package com.techelevator.cardexample;

import java.util.ArrayList;
import java.util.List;

public class Game {
    //FIELDS
    private static final int HOW_MANY_CARDS = 7;
    private Deck deck; //Deck
    private Player player1; //Players -> Hand
    private Player player2;

    public Game() {

        Card aceOfSpades = new Card(Card.SUIT_SPADES, 1, "Ace");
        Card twoOfSpades = new Card(Card.SUIT_SPADES, 1, "Two");

        List<Card> pokerDeck = new ArrayList<>();
        pokerDeck.add(aceOfSpades);
        pokerDeck.add(twoOfSpades);

        this.deck = new Deck(pokerDeck);

        this.player1 = new Player("Beth");
        this.player2 = new Player("Tom");
    }

    //METHODS
    public void playNextHand() {
        deck.shuffle();

        for (int i = 0; i < HOW_MANY_CARDS; i++) {
            Card nextCard = deck.drawCard();
            this.player1.addCardToHand(nextCard);

            nextCard = deck.drawCard();
            this.player2.addCardToHand(nextCard);
        }
    }

}
