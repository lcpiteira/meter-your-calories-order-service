package com.meter.your.calories.OrderService.mappers;

import com.meter.your.calories.OrderService.models.dto.FoodDto;
import com.meter.your.calories.OrderService.models.dto.OrderDto;
import com.meter.your.calories.OrderService.models.entities.FoodEntity;
import com.meter.your.calories.OrderService.models.entities.OrderEntity;
import com.meter.your.calories.OrderService.models.entities.OrderFoodItemEntity;
import jakarta.persistence.criteria.Order;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderMapper {

    public static OrderDto mapOrderEntityToOrderDto(OrderEntity orderEntity){
        List<FoodEntity> foodListFromOrder = orderEntity
                .getOrderItems()
                .stream()
                .map(OrderFoodItemEntity::getFood)
                .toList();
        List<FoodDto> foodDtos = FoodMapper.mapFoodEntityListToDtoList(foodListFromOrder);

        return
                OrderDto
                        .builder()
                        .username(orderEntity.getUser().getName())

                        .order_ts(orderEntity.getOrderCreationTs().toString())
                        .foodDtoList(foodDtos)
                        .build();


    }


    public static List<OrderDto> mapOrderEntityListToOrderDtoList(List<OrderEntity> orderEntities){
        return
                orderEntities
                        .stream()
                        .map(OrderMapper::mapOrderEntityToOrderDto)
                        .collect(Collectors.toList());
    }


}
