package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Review {

    public Person getRandomPerson() {
        Person person = new Person("Oliver", 9);
        return person;
    }


    public int[] getNullArray() {
        return null;
    }

    public boolean has10Evens(int[] numbers) {
        return false;
    }

    public boolean sameFirstLast(String word) {
        return word.charAt(0) == word.charAt(word.length() - 1);
    }

    public List<Integer> getRange(int start, int end) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            numbers.add(i);
        }

        return numbers;
    }
}
