package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Review {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        Quiz quiz = new Quiz();

        boolean isAnswerInRange = false;

        do {
            try {
                int answerChoice = Integer.parseInt(keyboard.nextLine());
                quiz.checkAnswer(answerChoice);
                isAnswerInRange = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Something went wrong.");
                System.out.println(e.getMessage());
                isAnswerInRange = false;
            }
        } while(!isAnswerInRange);


        File file = new File("blah.txt");

        try(Scanner scanner = new Scanner(file)) {

        } catch (FileNotFoundException e) {  //adding to main method won't handle catch later in method
            System.out.println();
            System.out.println("Sorry the file was not found :(");
        }
    }

//    public int getMaximum(int[] nums) {
//        if(nums == null) {
//
//        }
//    }
//
//    public String reverse(String word) {
//        if(word == null) {
//
//        }
//    }
}
