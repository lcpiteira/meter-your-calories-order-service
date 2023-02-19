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
        this.order_ts = null;

    }
    public OrderDto() {

    }

    public OrderDto(String username, String order_ts, List<FoodDto> foodDtoList) {
        this.username = username;
        this.order_ts = order_ts;
        this.foodDtoList = foodDtoList;
    }

    public OrderDto(String username, String order_ts, Integer order_total_calories, List<FoodDto> foodDtoList) {
        this.username = username;
        this.order_ts = order_ts;
        this.order_total_calories = order_total_calories;
        this.foodDtoList = foodDtoList;
    }

    private String username;
    private String order_ts;
    private Integer order_total_calories;
    private List<FoodDto> foodDtoList;
}
