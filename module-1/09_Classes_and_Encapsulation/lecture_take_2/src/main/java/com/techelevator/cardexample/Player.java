package com.techelevator.cardexample;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final double STARTING_SCORE = 0.0;

    private List<Card> hand = new ArrayList<>();
    private final String name;
    private double score = STARTING_SCORE;
    private boolean isMyTurn = false;

    public Player(String name) {
        this.name = name;
    }
    public void addCardToHand(Card card) {
        hand.add(card);
    }
}
