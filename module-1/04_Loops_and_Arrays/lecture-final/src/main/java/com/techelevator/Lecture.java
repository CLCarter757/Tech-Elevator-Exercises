package com.techelevator;

import static java.lang.Math.*;

public class Lecture {

    /*
    1. Return the created array
    */
    public int[] returnArray() {
//        int[] array = { 80, 8080, 443 };
        return new int[] { 80, 8080, 443 };
    }

    /*
    2. Return the first element of the array
    */
    public int returnFirstElement() {
        int[] portNumbers = { 80, 8080, 443 };
        return portNumbers[0];
    }

    /*
    3. Return the last element of the array
    */
    public int returnLastElement() {
        int[] portNumbers = { 80, 8080, 443 };

        int lastElement = portNumbers[2];

        return lastElement;
    }

    /*
    4. Return the first element of the array from the parameters
    */
    public int returnFirstElementOfParam(int[] passedInArray) {

        String[] names; // names -> null
        names = new String[0]; // names -> []
        names = new String[3]; // names -> [ null, null, null ]

        if(passedInArray == null || passedInArray.length == 0) {
            return -1;
        }

        return passedInArray[0];
    }

    /*
    5. Return the last element of the array from the parameters
    */
    public int returnLastElementOfParam(int[] passedInArray) {

        return passedInArray[passedInArray.length - 1];
    }

    /*
    6. Here, a variable is defined within a block. How can we get the value of that outside of the block in order to
       return it? There are a couple of different ways of doing this, what can you come up with?
    */
    public int returnVariableFromBlock(int number) {
        int result;
        { // A new block with scoped variables

            result = number * 5;

        } // the result variable disappears here

        return result; // We want to return result here. How?
    }

    /*
    7. What will the variable result be at the end of the method? Change the number in the logic expression so that
       it returns true.
    */
    public boolean returnOperationInBlock() {
        int result = 5;

        {
            int multiplier = 10;
            result *= multiplier; // result = result * multiplier; result = 5 * 10; result = 50;
        }

        return result == 50; // <-- Change the number to match result and make this be true
    }

    /*
    8. Return the only variable that is in scope at the return statement.
    */
    public double returnInScopeVariable() {
        double one = 1.0;
        {
            double three = 3.0;
            one += three;
            {
                double four = 4.0;
                three = four - one;
                one++;
            }

            double five = 5.0;
            double eight = five + three;
        }

        return one;
    }

    /*
    9. How many times do we go through this loop? Change the number in the logic expression so that it returns true.
    */
    public boolean returnCounterFromLoop() {

        int[] arrayToLoopThrough = { 3, 4, 2, 9 };

        int counter = 0; // Must be started outside the block so that have access to it after the block

        for (int i = 0; i < arrayToLoopThrough.length; i++) {
            counter++;
        }

        /*
               arrayToLoopThrough.length   counter
               4                              4


         */

        return counter == 4; // What should the number be to return true?
    }

    /*
    10. This loop is counting incorrectly. What needs to change in the loop for it to count properly?
    */
    public boolean returnCorrectCount() {
        int[] arrayToLoopThrough = { 4, 23, 9 };

        int counter = 0;

        //     Start;       Keep going while         Increment by one;
        for (int i = 0; i < arrayToLoopThrough.length; i++) {
            counter += 1;
        }

        return counter == 3;
    }

    /*
    11. This loop is counting incorrectly. What needs to change in the loop for it to count properly?
    */
    public boolean returnCountCorrectTimes() {
        int[] arrayToLoopThrough = { 4, 23, 9, 4, 33 };

        int counter = 0;

        //     Start;       Keep going while         Increment by one;
        for (int i = 0; i < arrayToLoopThrough.length; i++) {
            counter = counter + 1;
        }

        return counter == 5;
    }

    /*
    12. We want this loop to only count every other item starting at zero. What needs to change in the loop for
        it to do that?
    */
    public boolean returnSumEveryOtherNumber() {
        int[] arrayToLoopThrough = { 4, 3, 4, 1, 4, 6 };

        int sum = 0;

        //     Start;       Keep going while       Increment by;
        for (int i = 0; i < arrayToLoopThrough.length; i = i + 2) {
            sum = sum + arrayToLoopThrough[i];
        }

        /*
            i   length  sum
            6    6       12
         */

        return sum == 12;
    }

    /*
        ["Tom", "Walt", "Beth", "Tom"]

        tomCount -> 2
        i -> 4
        names.length -> 4

     */
    public int countHowManyToms(String[] names) {
        int tomCount = 0;

        for (int i = 0; i < names.length; i++) {
            if(names[i] == "Tom") {
                tomCount += 1;
            }
            System.out.println(names[i]);
        }

        return tomCount;
    }




    /*
            Stack             Heap
        x    5
        y    2

        array1 0x123 ----->   [ 4, 5 ]
        array2 0x123 --------^

        array3 0x123 ------ ^^     [4, 5]

     */

    public void test() {
        int x = 1;
        int y = 2;
        x = x + y;
        x = 5;

        int[] array1;
        array1 = new int[2];
        array1[0] = 2;
        array1[1] = 5;

        int[] array2 = array1;
        array2[0] = 4;

        int[] array3 = {4, 2, 3};
        array3 = array1;
    }

    public static int calculateSum(int[] numbers) {

        int sum = 0;
        for(int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }

        sum = 0;
        for(int num : numbers) {
            sum = sum + num;
        }

        sum = 0;
        int i = 0;
        while(i < numbers.length) {
            sum = sum + numbers[i];
            i++;
        }

        sum = 0;
        i = 0;
        do {
            sum = sum + numbers[i];
            i++;
        } while(i < numbers.length);

        return sum;
    }


    public void testing() {



        java.lang.String blah = "Walt";

        int[] nums = {1, 2, 3};


        double pi = PI;


    }


}