package com.techelevator.reservations.service;

import org.springframework.stereotype.Component;

@Component
public class SimpleRewardCalculationService implements RewardCalculationService {

    @Override
    public int calculateReward(double totalCostMinusTax) {
        return (int) totalCostMinusTax;
    }
}
