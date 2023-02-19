package com.meter.your.calories.OrderService.services;

import com.meter.your.calories.OrderService.models.dto.FoodDto;
import com.meter.your.calories.OrderService.models.entities.OrderEntity;

import java.util.List;

public interface OrderFoodItemService {
    void createOrderAndFoodRelation(List<FoodDto> foodDtoList, OrderEntity order) throws Exception;
}
