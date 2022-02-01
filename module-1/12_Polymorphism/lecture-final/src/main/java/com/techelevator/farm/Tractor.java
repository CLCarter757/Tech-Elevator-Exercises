package com.techelevator.farm;

public class Tractor implements Sellable, Singable {
    private String color;
    private String brandName;

    public Tractor(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String getSound() {
        return "VROOM VROOM!!!";
    }

    @Override
    public String getName() {
        return brandName;
    }

    @Override
    public double getPrice() {
        return 10_000.0;
    }

}
