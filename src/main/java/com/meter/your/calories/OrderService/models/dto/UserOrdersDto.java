package com.meter.your.calories.OrderService.models.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UserOrdersDto {

    private Integer total_calories;
    private List<OrderDto> orders;


}
