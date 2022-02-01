package com.techelevator;

public class SavingsAccount extends BankAccount{
    private static final int SERVICE_FEE = 2;

    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }
    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance); //multiple super have to be in same ()
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        int balance = super.getBalance();

        if (balance - amountToWithdraw >= 150) {
            return super.withdraw(amountToWithdraw);
        }
        if (balance - amountToWithdraw < 150 && (balance - amountToWithdraw - SERVICE_FEE) >= 0) {
            return super.withdraw(amountToWithdraw + SERVICE_FEE);
        }
        return balance;
    }
}