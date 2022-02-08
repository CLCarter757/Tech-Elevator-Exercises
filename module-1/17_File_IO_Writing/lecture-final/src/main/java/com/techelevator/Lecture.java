package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

//
//		System.out.print("Enter the path to a file or directory: ");
//		String input = userInput.nextLine();
//
//		File file = new File(input);
//
//		// Work with existing directory or file
//		if(file.exists()) {
//
//			if(file.isFile()) {
//				System.out.println("This is a file");
//			} else if(file.isDirectory()) {
//				System.out.println("This is a directory");
//			}
//
//			System.out.println("The file name is: " + file.getName());
//			System.out.println("The absolute path is: " + file.getAbsolutePath());
//
//		} else {
//			System.out.println("Sorry, the file path does not exist.");
//		}
//
//
//		// Create a directory
//		System.out.println();
//		System.out.print("Enter the path of a new directory: ");
//		String directoryPath = userInput.nextLine();
//
//		File directory = new File(directoryPath);
//
//		if(directory.exists()) {
//			System.out.println("This directory already exists.");
//		} else {
//			if(directory.mkdir()) {
//				System.out.println("Directory created!");
//			} else {
//				System.out.println("Sorry, could not create directory");
//			}
//		}
//
//		// Create a file
//		System.out.println();
//		System.out.print("Enter the path of a new file: ");
//		String filePath = userInput.nextLine();
//
//		File newFile = new File(filePath);
//
//		if(newFile.exists()) {
//			if(newFile.delete()) {
//				System.out.println("File was deleted!");
//			} else {
//				System.out.println("File was not deleted :( ");
//			}
//		} else {
//			if(newFile.createNewFile()) {
//				System.out.println("File was created!");
//			} else {
//				System.out.println("File was not created :( ");
//			}
//		}


		// Write to file
		System.out.println();
		System.out.print("Enter the path of a new file: ");
		String fp = userInput.nextLine();

		File nf = new File(fp);


		try(FileOutputStream outputStream = new FileOutputStream(nf, true);
			PrintWriter writer = new PrintWriter(outputStream)) {

			writer.println("New stuff");
//			writer.flush();
			writer.println("is here");
		}

		System.out.println("The size of my file is: " + nf.length());


		List<Person> people = new ArrayList<>();
		people.add(new Person("Bob", 25));
		people.add(new Person("Kelly", 31));
		people.add(new Person("Billie", 55));

		/*
		Bob 25
		Kelly 31
		Billie 55
		 */

		// loop
		// open file

		// open file
		// loop

		try(PrintWriter writer = new PrintWriter("people.txt")) {

			for(Person person : people) {
				writer.println(person.getName() + " " + person.getAge());
			}
		}

		// Read entire text file into List of Strings
		Path peopleFilePath = Path.of("people.txt");
		List<String> peopleLines = Files.readAllLines(peopleFilePath);

		for(String line : peopleLines) {
			System.out.println(line);
		}
	}

}
