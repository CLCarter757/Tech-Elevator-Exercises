package com.techelevator.farm;

public class Pig extends FarmAnimal implements Sellable {

    public Pig(String name) {
        super(name, "oink!");
    }

    @Override
    public double getPrice() {
        return 1000;
    }
}
