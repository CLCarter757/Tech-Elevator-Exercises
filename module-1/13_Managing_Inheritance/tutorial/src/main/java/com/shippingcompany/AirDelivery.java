package com.shippingcompany;

public class AirDelivery extends Delivery {

    public static final int ONE_DAY_DELIVERY = 24 * 60;

    @Override
    public int getDuration() {
        return ONE_DAY_DELIVERY;
    }
}
