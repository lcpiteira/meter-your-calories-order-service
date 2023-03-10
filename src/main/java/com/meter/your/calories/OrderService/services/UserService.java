package com.meter.your.calories.OrderService.services;

import com.meter.your.calories.OrderService.models.dto.UserOrdersDto;
import com.meter.your.calories.OrderService.models.entities.UserEntity;

public interface UserService {

    UserEntity getUserByName(String name) throws Exception;

    UserOrdersDto getAllUserOrders(String name) throws Exception;
}
