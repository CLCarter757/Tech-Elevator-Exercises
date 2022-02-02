package com.techelevator.receipt;

public abstract class Receipt {
    private final boolean isVip;

    public Receipt(boolean isVip) {
        this.isVip = isVip;
    }

    public final String print() {
        String s = "";

        if(isVip) {
            s += printVipHeading();
        } else {
            s += printHeading();
        }

        s += printLineItems();

        s += printTotal();

        return s;
    }

    public abstract String printHeading();
    public abstract String printVipHeading();

    public abstract String printLineItems();

    public abstract String printTotal();
}
