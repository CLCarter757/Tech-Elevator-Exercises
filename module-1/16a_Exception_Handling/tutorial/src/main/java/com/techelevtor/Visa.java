package com.techelevtor;

public class Visa extends CreditCard{

    @Override
    public void validate() throws CreditCardValidationException {
        super.validate();
        if (getNumber().charAt(0) != '4') {
            throw new CreditCardValidationException("'" + getNumber() +
                    "' - Invalid Visa card number, must begin with '4'.");
        }
    }
}
