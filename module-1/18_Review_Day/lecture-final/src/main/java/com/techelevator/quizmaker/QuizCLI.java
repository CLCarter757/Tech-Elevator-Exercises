package com.techelevator.quizmaker;

import java.util.List;
import java.util.Scanner;

public class QuizCLI {
    private int numberCorrect;
    private List<QuizQuestion> questions;

    public QuizCLI(List<QuizQuestion> questions) {
        this.questions = questions;
    }

    public void displayQuestionAndAnswerOptions() {

        for(QuizQuestion question : questions) {
            // 1) display question and answer options
            System.out.println(question.getQuestion());

            int answerOptionIndex = 1;
            for(String answerOption : question.getAnswerOptions()) {
                System.out.println("(" + answerOptionIndex + ") " + answerOption);
                answerOptionIndex++;
            }

            // 2) ask for their answer
            int answerChoice = askForAnswer();

            // 3) display if correct or not

            boolean isCorrect = question.checkAnswer(answerChoice);
            if(isCorrect) {
                System.out.println("Hooray! Correct!");
                numberCorrect++;
            } else {
                System.out.println("Sorry :( Incorrect");
            }
        }

        displayResults();

    }

    public int askForAnswer() {
        System.out.println("");
        System.out.println(">> ");

        Scanner keyboard = new Scanner(System.in);
        String line = keyboard.nextLine();
        return Integer.parseInt(line);
    }

    public void displayResults() {
        System.out.println("Total Questions: " + questions.size() + " Correct Answers: " + numberCorrect);
    }
}
