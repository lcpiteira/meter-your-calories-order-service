package com.meter.your.calories.OrderService.models.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder

public class OrderDto {
    public OrderDto(String orderTs, List<FoodDto> foodDtoList) {
        this.orderTs = orderTs;
        this.foodDtoList = foodDtoList;
    }

    private String orderTs;
    private List<FoodDto> foodDtoList;
}
