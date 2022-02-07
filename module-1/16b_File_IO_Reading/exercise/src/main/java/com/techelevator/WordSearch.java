package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws NoSuchElementException {
		Scanner userInput = new Scanner(System.in);
		File inputFile = getInputFileFromUser(userInput);


		System.out.println("What is the search word you are looking for?");
		String searchWord = userInput.nextLine();

		Boolean caseSensitive = caseSensitive(userInput, searchWord);

		try (Scanner fileScanner = new Scanner(inputFile)) {
			int lineNumber = 0;
			while (fileScanner.hasNextLine()) {
				lineNumber++;
				String line = fileScanner.nextLine();

				if (!caseSensitive && line.toLowerCase().contains(searchWord) ) {
					System.out.println(lineNumber + ") " + line);
				} else if (caseSensitive && line.contains(searchWord)) {
					System.out.println(lineNumber + ") " + line);
				}
			}
		} catch (NoSuchElementException | FileNotFoundException e) {
			System.out.println("Element does not exist");
		}

	}


	private static File getInputFileFromUser(Scanner userInput) {

		System.out.println("What is the fully qualified name of the file that should be searched?");
		String path = userInput.nextLine();
		File inputFile = new File(path);

		if (inputFile.exists() == false) {
			System.out.println(path + " does not exist.");
			System.exit(1);
		} else if (inputFile.isFile() == false) {
			System.out.println(path + "is not a file.");
			System.exit(1);
		}
		return inputFile;
	}

	private static boolean caseSensitive(Scanner userInput, String searchWord) {
		System.out.println("Should the search be case sensitive? (Y/N)");
		String yesOrNo = userInput.nextLine();

		if(yesOrNo.toUpperCase().equals("Y")) {
			return true;
		} return false;
	}

}








