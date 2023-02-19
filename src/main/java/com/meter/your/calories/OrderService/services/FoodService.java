package com.meter.your.calories.OrderService.services;

import com.meter.your.calories.OrderService.models.dto.FoodDto;
import com.meter.your.calories.OrderService.models.entities.FoodEntity;

import java.util.List;

public interface FoodService {
    List<FoodEntity> getAllFoodEntities(List<FoodDto> foodDtos) throws Exception;
}
