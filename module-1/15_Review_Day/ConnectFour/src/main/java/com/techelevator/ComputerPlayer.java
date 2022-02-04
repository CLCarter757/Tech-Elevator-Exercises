package com.techelevator;

public class ComputerPlayer extends Player{

    public ComputerPlayer(String name, Piece piece) {
        super(name, piece);
    }

    @Override
    public int makeNextMove() {
        return 0;
    }
}

