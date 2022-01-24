package com.techelevator;

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
        double discountAmount = Double.parseDouble(userInput); // 0.25

        // double discountAmount = Double.parseDouble(scanner.nextLine());

        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");

        userInput = scanner.nextLine(); // "5.00 4.50 90.00" -> [5.0, 4.5, 90.0]
        String[] stringPrices = userInput.split(" "); // ["5.00", "4.50", "90.00"]
                                                      //                     ^

        double totalPrice = 0;
        double totalSalePrice = 0;
        double totalDiscount = 0;
//
        for(String price : stringPrices) {
            // convert price to a double
            double originalPrice = Double.parseDouble(price); // "5.00" -> 5.0

            // calculate how much of discount we will give
            double amountOff = originalPrice * discountAmount; // 5.0 * .2 = 1.0

            totalDiscount += amountOff;

            double salePrice = originalPrice;

            // apply the discount to produce the sale price
            if(totalDiscount <= 15) {
                salePrice = originalPrice - amountOff; // 5.0 - 1.0 = 4.0
            }

            // print the original price and the sale price
            System.out.println("Original price: " + originalPrice + " Sale price: " + salePrice);

            totalPrice += originalPrice;
            totalSalePrice += salePrice;
        }

//        if(totalPrice - totalSalePrice > 15) {
//            totalSalePrice = totalPrice - 15;
//        }

        // print total original price and total sale price
        System.out.println("Total: " + totalPrice + " Sale Total: " + totalSalePrice);




        // nextLine(), i++ vs ++i, decimal conversion to binary


        /*

            40          result      remainder

            40 / 2       20          0
            20 / 2       10          0
            10 / 2        5          0
             5 / 2        2          1
             2 / 2        1          0
             1 / 2        0          1


         */


        // 1. for loop

        // 2. foreach loop / enhanced for loop
        String[] names = {"Tom", "Beth", "Walt", "Tom"};
        for(String xyz : names) {
            xyz = "Me";
            System.out.println(xyz.toUpperCase());

        }


        // 3. while loop
        int i = 0;
        while(i < names.length) {
            String xyz = names[i];
            System.out.println(xyz.toLowerCase() + " " + xyz.toUpperCase());
            i = i + 1;
        }

        // 4. do-while loop
        i = 0;
        do {
            String xyz = names[i];
            System.out.println(xyz.toUpperCase());
            i = i + 1;
        } while(i < names.length);


        System.out.println("Change Integer test:");
        int b = 2;
        changeInteger(b);
        System.out.println(b);

        System.out.println("Change Array test:");
        int[] array2 = { 1, 2, 3 };
        changeArray(array2);
        System.out.println(array2[0]);


        System.out.println(array2);
        System.out.println(scanner);
    }



    public static void changeInteger(int a) {
        a = a + 1;
    }

    public static void changeArray(int[] array) {
        array[0] = array[0] + 1;
    }





}