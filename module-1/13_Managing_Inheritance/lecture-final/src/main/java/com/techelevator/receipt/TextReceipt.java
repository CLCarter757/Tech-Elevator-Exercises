package com.techelevator.receipt;

public class TextReceipt extends Receipt {
    public TextReceipt(boolean isVip) {
        super(isVip);
    }

    @Override
    public String printHeading() {
        return "Here is your receipt";
    }

    @Override
    public String printVipHeading() {
        return "Hey VIP! Thanks for being a valued customer! Here is your receipt!";
    }

    @Override
    public String printLineItems() {
        return null;
    }

    @Override
    public String printTotal() {
        return null;
    }
}
