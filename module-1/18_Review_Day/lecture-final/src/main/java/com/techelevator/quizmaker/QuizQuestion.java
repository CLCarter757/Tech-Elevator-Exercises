package com.techelevator.quizmaker;

import java.util.ArrayList;
import java.util.List;

public class QuizQuestion {
    private String question;
    private List<String> answerOptions;
    private int correctAnswerIndex;

    public QuizQuestion(String question, List<String> answerOptions, int correctAnswerIndex) {
        this.question = question;
        this.answerOptions = new ArrayList<>(answerOptions);
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswerOptions() {
        return new ArrayList<>(answerOptions);
    }

    public String getCorrectAnswer() {
        return answerOptions.get(correctAnswerIndex);
    }

    public boolean checkAnswer(int answerIndex) {
        if(!isValidAnswer(answerIndex)) {
            throw new IllegalArgumentException("Invalid answer choice");
        }

        return answerIndex == correctAnswerIndex + 1;
    }

    private boolean isValidAnswer(int answerIndex) {
        return answerIndex >= 1 && answerIndex <= answerOptions.size();
    }
}
