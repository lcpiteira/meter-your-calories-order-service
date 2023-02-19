package com.meter.your.calories.OrderService.models.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FoodDto {
    private String name;
    private String food_group;
    private Integer calories;

    public FoodDto(String name, String food_group, Integer calories) {
        this.name = name;
        this.food_group = food_group;
        this.calories = calories;
    }
}
