package com.techelevator.farm;

public class Tractor implements Singable, Sellable{
    public String brandName;

    public Tractor (String brandName) {
        this.brandName = brandName;
    }
    @Override
    public String getSound() {
        return "VROOM!!!";
    }
    @Override
    public String getName() {
        return brandName;
    }

    @Override
    public double getPrice() {
        return 10_000.00;
    }

}
