package com.meter.your.calories.OrderService.mappers;

import com.meter.your.calories.OrderService.models.dto.FoodDto;
import com.meter.your.calories.OrderService.models.dto.OrderDto;
import com.meter.your.calories.OrderService.models.dto.UserOrdersDto;
import com.meter.your.calories.OrderService.models.entities.UserEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserOrdersMapper {

    public static UserOrdersDto mapUserEntityToListOfUserOrdersDto(UserEntity user){
        List<OrderDto> orderDtos = OrderMapper.mapOrderEntityListToOrderDtoList(user.getOrders());

        Integer total_of_calories = orderDtos
                .stream()
                .flatMap(orderDto -> orderDto.getFoodDtoList().stream())
                .map(FoodDto::getCalories)
                .reduce(0, Integer::sum);

        return
                UserOrdersDto
                        .builder()
                        .orders(orderDtos)
                        .total_calories(total_of_calories)
                        .build();
    }
}
