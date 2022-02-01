package com.techelevator;

public class CheckingAccount extends BankAccount{
    private static final int OVERDRAFT_FEE = 10;

    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }
    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
       super(accountHolderName, accountNumber, balance); //multiple super have to be in same ()
   }

    @Override
    public int withdraw(int amountToWithdraw) {
        int balance = super.getBalance();

        if(balance - amountToWithdraw < 0 && balance - amountToWithdraw > -100) {
            return super.withdraw(amountToWithdraw + OVERDRAFT_FEE);

        } if (balance - amountToWithdraw > 0) {
            return super.withdraw(amountToWithdraw);
        }
        return balance;
    }
}
