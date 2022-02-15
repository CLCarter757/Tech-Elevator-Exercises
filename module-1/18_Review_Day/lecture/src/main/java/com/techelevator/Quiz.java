package com.techelevator;

public class Quiz {
    private int correctAnswer = 2;

    public boolean checkAnswer(int answerChoice) {
        if(answerChoice < 1 || answerChoice > 4) {
            throw new IllegalArgumentException("Answer choice was out of range. It should be between 1-4.");
        }
        return answerChoice == correctAnswer;
        }


}
