package com.meter.your.calories.OrderService.models.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder

public class OrderDto {
    public OrderDto(String username, List<FoodDto> foodDtoList) {
        this.foodDtoList = foodDtoList;
        this.username = username;
    }
    private String username;
    private List<FoodDto> foodDtoList;
}
