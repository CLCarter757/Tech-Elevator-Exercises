package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Reward;

public interface RewardDao {
    Reward createOrUpdate(int points, String username);
}
