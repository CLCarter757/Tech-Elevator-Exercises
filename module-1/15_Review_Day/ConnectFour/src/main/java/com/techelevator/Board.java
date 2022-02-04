package com.techelevator;

public class Board {
    public static int totalPiecesPlayed = 0;
    public static final int ROW_COUNT = 6;
    public static final int COLUMN_COUNT = 7;

    private BoardColumn[] columns = new BoardColumn[COLUMN_COUNT];

    public boolean checkForWinner() {
        return false;
    }

    public boolean checkForTie() {
        return false;
    }

    public String display() {
        return "";
    }

    public boolean dropPiece(Piece piece, int column) {
        return false;
    }
}
