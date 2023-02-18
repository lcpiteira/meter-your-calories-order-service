package com.meter.your.calories.OrderService.services;

import com.meter.your.calories.OrderService.models.entities.UserEntity;

public interface UserService {

    UserEntity getUserByEmail(String email) throws Exception;
}
