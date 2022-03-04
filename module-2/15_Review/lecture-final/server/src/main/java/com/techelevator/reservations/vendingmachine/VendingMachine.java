package com.techelevator.reservations.vendingmachine;

public class VendingMachine {
    private ChangeMaker changeMaker;

    public VendingMachine(ChangeMaker changeMaker) {
        this.changeMaker = changeMaker;
    }


    public Change finishTransaction() {
        return changeMaker.makeChange();
    }
}
