package com.meter.your.calories.OrderService.models.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder

public class OrderDto {
    public OrderDto(String token, List<FoodDto> foodDtoList) {
        this.token = token;
        this.foodDtoList = foodDtoList;
    }

    private String token;
    private List<FoodDto> foodDtoList;
}
