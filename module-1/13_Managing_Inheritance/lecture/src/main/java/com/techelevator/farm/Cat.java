package com.techelevator.farm;

public class Cat extends FarmAnimal{

    public Cat() {
        super("Oliver", "Meow!");
    }

    @Override
    public String eat() {
        return "Eat cat food!";
    }
}
