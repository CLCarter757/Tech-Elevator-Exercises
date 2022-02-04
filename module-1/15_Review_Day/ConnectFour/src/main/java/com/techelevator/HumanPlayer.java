package com.techelevator;

import java.sql.SQLOutput;
import java.util.*;

public class HumanPlayer extends Player{
    public HumanPlayer(String name, Piece piece) {
        super(name, piece);
    }

    @Override
    public int makeNextMove() {
        int move = 0;

        while(true) {
            System.out.println("Please enther the column to drop your piece (1-7):");

            String userInput = scanner.nextLine();
            move = Integer.parseInt(userInput);

            if (move < 1 || move > 7) {
                System.out.println("Invalid move");
            } else {
                break;
            }
        }
        return move;
    }
}
