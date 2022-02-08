package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("What is the search word?");
        String searchWord = userInput.nextLine();

        System.out.println("What is the replacement word?");
        String replacementWord = userInput.nextLine();

        System.out.println("What is the source file?");
        String inputFile = userInput.nextLine();
        File sourceFile = new File(inputFile);

        if(!sourceFile.exists()) {
            System.out.println("The source file does not exist.");
        }

        System.out.println("What is the destination file?");
        String outputFile = userInput.next();
        File destinationFile = new File(outputFile);


        try(Scanner fileScanner = new Scanner(sourceFile);
            PrintWriter writer = new PrintWriter(destinationFile)) {

            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if(line.contains(searchWord)) {
                    line = line.replaceAll(searchWord, replacementWord);
                }
                    writer.println(line);
                }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
