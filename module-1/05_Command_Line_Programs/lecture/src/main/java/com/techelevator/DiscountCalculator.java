package com.techelevator;

import java.sql.SQLOutput;
import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");
        String userInput = scanner.nextLine();
        double discountAmount = Double.parseDouble(userInput);


        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        userInput = scanner.nextLine();
        String[] stringPrices = userInput.split(" ");

        double totalPrice = 0;
        double totalSalePrice = 0;
        double totalDiscount = 0;

        for(String price : stringPrices) {
            double originalPrice = Double.parseDouble(price); //convert price to a double.
            double amountOff = originalPrice * discountAmount; //calculate discount to give.

            totalDiscount += amountOff;
            double salePrice = originalPrice;
            if(totalDiscount <= 15) {
                salePrice = originalPrice - amountOff;
            }



            System.out.println("Original price: " + originalPrice + " Sale price: " + salePrice);

            totalPrice += originalPrice;
            totalSalePrice += salePrice;


        }
        //If discount can't be more than $15.
     /*   if (totalPrice - totalSalePrice > 15) {
            totalPrice = totalPrice - 15;
         }
     */

        // print total original price and total sale price.
        System.out.println("Total: " + totalPrice + " Sale Total: " + totalSalePrice);



    }

}