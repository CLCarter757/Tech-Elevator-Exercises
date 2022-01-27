package com.techelevator.review;

import java.util.Collections;
import java.util.List;

public class Review {

    public static void main(String[] args) {

        //returnTrueWhenTheListIsEmpty(null);

//        hasDuplicates(List.of(1, 2, 3, 5, 4));


        List<Integer> numbers = List.of(1, 2, 3, 4 ,5);
        Collections.reverse(numbers);

        Collections.sort(numbers);
    }

    /*
        numbers -> { 1, 2, 3, 1, 4 } -> true
                     ^        ^

        numbers -> { 1, 2, 3, 5, 4 } -> false

     */
    public static boolean hasDuplicates(List<Integer> numbers) {

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));

            for (int j = i + 1; j < numbers.size(); j++) {
                System.out.println(numbers.get(j));
            }
        }

        return false;
    }

    public static boolean returnTrueWhenTheListIsEmpty(List<Integer> numbers) {
        if(numbers == null) {
            return false;
        }

        if(numbers.size() == 0) {
            return true;
        }

        return false;
    }
}
