package com.techelevator.cardexample;

public class MainProgram {

	public static void main(String[] args) {

		Card myCard = new Card("Spades", 1, "Ace", false);
		Card myOtherCard = new Card("Hearts", 13, "King");

		System.out.println(myCard.getSuit());

		myCard.setSuit("Diamonds");
		System.out.println(myCard.getSuit());

		System.out.println(myOtherCard.cardString());
		myOtherCard.flipCard();
		System.out.println(myOtherCard.cardString());

	}

}
