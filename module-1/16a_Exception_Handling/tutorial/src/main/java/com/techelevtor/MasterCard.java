package com.techelevtor;

public class MasterCard extends CreditCard{

    @Override
    public void validate() throws CreditCardValidationException {
        super.validate();
        if (getNumber().charAt(0) != '5') {
            throw new CreditCardValidationException("'" + getNumber() +
                    "' - Invalid MasterCard card number, must begin with '5'.");
        }
    }
}
