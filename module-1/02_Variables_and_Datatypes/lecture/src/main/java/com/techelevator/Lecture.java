package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/

		int numberOfExercises = 26;

		System.out.println(numberOfExercises);

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/

		double half = 0.5;

		System.out.println(half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/

		String name ="TechElevator";

		System.out.println(name);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/

		byte seasonsOfFirefly = 1;

		System.out.println(seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/

		String myFavoriteLanguage = "Java";

		System.out.println(myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/

		float pi = 3.1416F;

		System.out.println(pi);

		/*
		7. Create and set a variable that holds your name.
		*/

		String myName = "Clint";
		System.out.println(myName);

		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/

		byte numberOfMouseButtons = 4;
		System.out.println(numberOfMouseButtons);

		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/

		String percentageOfBattery = "41%";
		System.out.println(percentageOfBattery);

		percentageOfBattery = "39%";
		System.out.println(percentageOfBattery);

		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/

		int difference = 121 - 27;
		System.out.println(difference);

		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/

		double first = 12.3;
		double second = 32.1;
		double addition = first + second;

		addition = addition + 5;
		System.out.println(addition);

		/*
		12. Create a String that holds your full name.
		*/

		String myFullName = "Clint Carter";


		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/

		String intro = "Hello, " + myFullName;
		System.out.println(intro);

		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/

		myFullName = myFullName + " Esquire";
		System.out.println(myFullName);
		System.out.println(intro);

		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/

		myFullName += " Esquire";

		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/

		String sawTwo = "Saw " + 2;

		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/

		sawTwo += 0;
		System.out.println(sawTwo);

		/*
		18. What is 4.4 divided by 2.2?
		*/

		System.out.println(4.4 / 2.2);

		/*
		19. What is 5.4 divided by 2?
		*/

		double x = 5.4;
		int y = 2;
		double division = x / y;
		System.out.println(division);

		/*
		20. What is 5 divided by 2?
		*/

		double a = 5;
		int b = 2;
		double c = a / b;
		System.out.println(c);

		/*
		21. What is 5.0 divided by 2?
		*/



		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/

		System.out.println(66.6 / 100);

		/*
		23. If I divide 5 by 2, what's my remainder?
		*/

		int remainder = 5 % 2;

		/*
		24. What is 1,000,000,000 * 3?
		*/

		long threeBillion = 1_000_000_000L * 3;
		System.out.println(threeBillion);

		/*
		25. Create a variable that holds a boolean called isDoneWithExercises and
		set it to false.
		*/

		boolean isDoneWithExercises = false;
		;

		/*
		26. Now set isDoneWithExercise to true.
		*/

		isDoneWithExercises = true;
	}

}
