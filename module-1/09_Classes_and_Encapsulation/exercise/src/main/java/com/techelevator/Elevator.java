package com.techelevator;

public class Elevator {
    private int currentFloor;
    private int numberOfFloors;
    private boolean doorOpen;

    public int getCurrentFloor() {
        return currentFloor;
    }
    public int getNumberOfFloors() {
        return numberOfFloors;
    }
    public boolean isDoorOpen() {
        return doorOpen;
    }

    public Elevator(int numberOfLevels) {
        numberOfFloors = numberOfLevels;
        currentFloor = 1;
    }

    public void openDoor() {
        doorOpen = true;
    }
    public void closeDoor() {
        doorOpen = false;
    }
    public void goUp(int desiredFloor) {
        if(doorOpen == false && desiredFloor <= numberOfFloors && desiredFloor > currentFloor) {
            currentFloor = desiredFloor;
        }
    }
    public void goDown(int desiredFloor) {
        if(doorOpen == false && desiredFloor > 0 && desiredFloor < currentFloor) {
            currentFloor = desiredFloor;
        }
    }




}
