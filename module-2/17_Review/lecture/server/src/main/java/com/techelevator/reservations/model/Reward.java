package com.techelevator.reservations.model;

import javax.validation.constraints.Min;

public class Reward {
    @Min(value = 0)
    private int points;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
