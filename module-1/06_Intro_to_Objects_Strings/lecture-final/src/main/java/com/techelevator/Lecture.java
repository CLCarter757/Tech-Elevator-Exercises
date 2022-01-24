package com.techelevator;

import java.util.Arrays;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) {


		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		Scanner myScanner = new Scanner(System.in);

		String name2 = new String("Walt");

		/* create an new instance of String using a literal */
		String name = "Walt";

		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();


		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * contains
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 * charAt
		 * replace
		 */

		boolean endsWithLT = name.endsWith("T");
		boolean endsWithB = "Bob".endsWith("b");

		if(name.startsWith("W")) {
			System.out.println(name + " starts with W");
		}

		if(name.contains("al")) {
			System.out.println(name + " contains al");
		}

		/*"W a l t"
		   0 1 2 3
		 */
		int indexOfAl = name.indexOf("al"); // will equal 1
		int indexOfBob = name.indexOf("Bob"); // will equal -1
		int indexOfAlAgain = "Walt alt".indexOf("al"); // will equal 1 again
		int lastIndexOfAl = "Walt alt".lastIndexOf("al"); // will equal 5

		int length = name.length(); // 4

		String lt = name.substring(2); // "Walt" -> "lt"
		String l = name.substring(2, 3); // "l"


		if(name.substring(2).contains("t")) {
			System.out.println("Does contain t");
		}


		String lowerCaseName = name.toLowerCase(); // "walt"

		String input = " here is my input    ";
		String trimmedInput = input.trim(); // "here is my input"

		char characterAtIndex5 = "BLah BLah blah".charAt(5); // 'B'

		String abclah = "blah".replace("b", "abc"); // "abclah"
		String x = "my name".replace("name", "eman"); // "my eman"

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

        char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
        String hello1 = new String(helloArray);
        String hello2 = new String(helloArray);


		/*
				            Stack				Heap
			int x = 		    1
			int y = 	     	1
			String hello1   0x1234	---->        "Hello"
			String hello2   0x4567  ---->        "Hello"
			String hello3   0x1234


		 */
		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}



		int[] xArray = {1,1};
		int [] yArray = {1,1};

		System.out.println("x == y " + (xArray == yArray));
		System.out.println("x.equals(y) " + xArray.equals(yArray));
		System.out.println("Arrays.equals(x, y) " + Arrays.equals(xArray, yArray));

		String blah = "blah";

		Scanner s = new Scanner(System.in);

		System.out.print("s.nextLine() == blah ");
		System.out.println(s.nextLine() == blah);

		System.out.print("s.nextLine().equals(blah) ");
		System.out.println(s.nextLine().equals(blah));

	}
}
