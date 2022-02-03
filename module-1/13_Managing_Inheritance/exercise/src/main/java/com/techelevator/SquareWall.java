package com.techelevator;

public class SquareWall extends RectangleWall{
    private int sideLength;

    public SquareWall(String name, String color, int sideLength){
        super(name, color, sideLength, sideLength); //have to use Rect same parameters, but not same variables
        this.sideLength = sideLength;
    }

    public int getSideLength() {
        return sideLength;
    }

    @Override
    public String toString() {
        return getName() + " (" + sideLength + "x" + sideLength + ") square";
    }
}
