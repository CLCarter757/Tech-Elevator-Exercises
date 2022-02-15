package com.techelevator;

public class ChangeMaker {

    public static void main(String[] args) {

        double currentBalance = 2.40;

        int numberQuarters = (int)Math.floor(currentBalance / 0.25);
        int numberDimes = (int)Math.floor((currentBalance - (0.25 * numberQuarters)) / 0.10);
        int numberNickels = (int)Math.round((currentBalance - ((0.25 * numberQuarters) + (0.10 * numberDimes))) / 0.05);

        String returnString = "Your change is: $" + currentBalance + ". You receive: " + numberQuarters + " quarter(s), " + numberDimes + " dime(s), and " + numberNickels + " nickel(s).";
        currentBalance = 0;

        System.out.println(returnString);

    }
}
