package com.techelevator;

public class Customer extends Person {
    private String phoneNumber;

    public Customer(String firstName, String lastName, String phoneNumber) {
        super(firstName,lastName);
        this.phoneNumber = phoneNumber;
    }

    public Customer(String firstName, String lastName) {
        super(firstName,lastName);
        this.phoneNumber = "";
    }

}
