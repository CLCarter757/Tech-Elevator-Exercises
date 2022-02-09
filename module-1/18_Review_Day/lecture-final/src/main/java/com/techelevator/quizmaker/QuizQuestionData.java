package com.techelevator.quizmaker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizQuestionData {
    private File file;

    public QuizQuestionData(File file) {
        this.file = file;
    }

    public List<QuizQuestion> getQuestions() {
        List<QuizQuestion> quizQuestions = new ArrayList<>();

        try(Scanner scanner = new Scanner(file)) {

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                QuizQuestion quizQuestion = getQuizQuestionForLine(line);

                quizQuestions.add(quizQuestion);
            }

        } catch(FileNotFoundException e) {
            System.out.println("File was not found :(");
        }

        return quizQuestions;
    }

    private QuizQuestion getQuizQuestionForLine(String line) {
        String[] lineParts = line.split("\\|");

        String question = lineParts[0];
        List<String> answerOptions = new ArrayList<>();
        int correctAnswerIndex = -1;

        for (int i = 1; i < lineParts.length; i++) {
            String answerOption = lineParts[i];

            if(answerOption.endsWith("*")) {
                correctAnswerIndex = i - 1;
                answerOption = answerOption.substring(0, answerOption.length() - 1);
            }

            answerOptions.add(answerOption);
        }

        return new QuizQuestion(question, answerOptions, correctAnswerIndex);
    }

}
