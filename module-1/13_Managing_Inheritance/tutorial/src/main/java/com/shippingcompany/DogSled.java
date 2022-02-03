package com.shippingcompany;

public class DogSled extends Delivery{
    private static final int DOG_SLED_SPEED = 30;

    public int getDuration() {
        double decimalHours = (double) super.getDistance()/DOG_SLED_SPEED;
        return convertHoursToMinutes(decimalHours);
    }
}
