package com.techelevator.cardexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		List<String> names = new ArrayList<>();


		Card myCard = new Card(Card.SUIT_SPADES, 1, "Ace", false);
		Card myOtherCard = new Card("Hearts", 13, "King");

		System.out.println(myCard.getSuit());

		myCard.setSuit("Diamonds");

		System.out.println(myCard.getSuit());

		System.out.println(myOtherCard.cardString());
		myOtherCard.flipCard();
		System.out.println(myOtherCard.cardString());

		myCard.setValue(12);

		myCard.value = 12;

		String myString = "blahblahblah";

		StringFormat.toTitleCase(myString);
	}


	public  void testMethod(int input) {

	}

}
