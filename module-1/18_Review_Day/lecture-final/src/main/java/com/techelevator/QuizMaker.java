package com.techelevator;

import com.techelevator.quizmaker.QuizCLI;
import com.techelevator.quizmaker.QuizQuestion;
import com.techelevator.quizmaker.QuizQuestionData;

import java.io.File;
import java.util.List;

public class QuizMaker {

	/*

	QuizQuestionData (Create Quiz Questions)
	 - Scanner
	 - getQuizQuestions() -> QuizQuestion[]

	QuizQuestion
	 - Question
	 - Choices
	 - Answer

	 - getters
	 - checkAnswer(answerChoice)
	 - isAnswerChoiceValid(answerChoice)

	QuizCLI
	 - numberCorrect
	 - totalAsked

	 - displayQuestionAndAnswerOptions()
     - askForAnswer()
     - printResults()

	 */


	public static void main(String[] args) {
		File file = new File("test_quiz.txt");
		QuizQuestionData data = new QuizQuestionData(file);
		List<QuizQuestion> questions = data.getQuestions();
		QuizCLI cli = new QuizCLI(questions);

		cli.displayQuestionAndAnswerOptions();

	}

	/*
    QuizResult
	 - question -> QuizQuestion
	 - answer
	 - isCorrect()

	Quiz
	 - questionOptions -> QuizQuestion[]
	 - results -> QuestionResult[]

	 nextQuestion()
	 getNumberCorrect()
	 getTotalAsked()
	 */

}
