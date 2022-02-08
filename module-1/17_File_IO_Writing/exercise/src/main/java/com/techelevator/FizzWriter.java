package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);

		System.out.println("What is the destination file?");
		String input = userInput.nextLine();
		File destinationFile = new File(input);

		if(!destinationFile.exists()) {
			System.out.println("Destination file does not exist");
		}

		try(PrintWriter writer = new PrintWriter(destinationFile);) {
			for (int i = 1; i <= 300; i++) {
				if (i % 3 == 0 && i % 5 == 0) {
					writer.println("FizzBuzz");
				} else if (i % 3 == 0) {
					writer.println("Fizz");
				} else if (i % 5 == 0) {
					writer.println("Buzz");
				} else {
					writer.println(i);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

	}

}
