package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Review {

    public static void main(String[] args) {
        File file = new File("rtn.txt");


        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            //
        } catch(FileNotFoundException fnfe) {
            System.out.println("Something went wrong! Uh oh.");
        } finally {
            scanner.close();
        }



        try (Scanner scanner2 = new Scanner(file)) {
            //
        } catch (FileNotFoundException fnfe) {
            System.out.println("Something went wrong! Uh oh.");
        }


        System.out.println();

        System.err.println();




    }
}
