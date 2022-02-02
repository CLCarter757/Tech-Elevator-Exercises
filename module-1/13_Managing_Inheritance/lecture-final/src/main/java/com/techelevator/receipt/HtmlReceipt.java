package com.techelevator.receipt;

public class HtmlReceipt extends Receipt{
    public HtmlReceipt(boolean isVip) {
        super(isVip);
    }

    @Override
    public String printHeading() {
        return "<h1>Here is your receipt!</h1>";
    }

    @Override
    public String printVipHeading() {
        return "<h1>Hey VIP! Thanks for being a valued customer! Here is your receipt!</h1>";
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
