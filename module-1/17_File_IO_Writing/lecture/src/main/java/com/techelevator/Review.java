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

        } catch(FileNotFoundException fnfe) {
            System.out.println("Something went wrong! Uh oh.");
        } finally {  //Runs last, usually to clean up resources
            scanner.close();
        }

        try (Scanner scanner2 = new Scanner(file)) {//try with resources achieves this without extra code
            //
        } catch (FileNotFoundException fnfe) {
            System.out.println("Something went wrong! Uh oh.");
        }


        System.err.println(); //printing an error message, less common that sout


        char ch = '1';

      //  if ((ch < '0') || (ch > '9')) {return false;} //char numbers also have int values
    }
}
