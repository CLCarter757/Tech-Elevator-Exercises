package com.techelevator.reservations.vendingmachine;

public class Application {
    public static void main(String[] args) {

        ChangeMaker minimumChangeMaker = new MinimumChangeMaker();
        VendingMachine vendingMachine = new VendingMachine(minimumChangeMaker);

    }
}
