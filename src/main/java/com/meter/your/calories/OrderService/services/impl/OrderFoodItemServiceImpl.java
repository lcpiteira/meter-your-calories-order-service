package com.meter.your.calories.OrderService.services.impl;

import com.meter.your.calories.OrderService.models.dto.FoodDto;
import com.meter.your.calories.OrderService.models.entities.FoodEntity;
import com.meter.your.calories.OrderService.models.entities.OrderEntity;
import com.meter.your.calories.OrderService.models.entities.OrderFoodItemEntity;
import com.meter.your.calories.OrderService.repositories.OrderFoodItemRepository;
import com.meter.your.calories.OrderService.services.FoodService;
import com.meter.your.calories.OrderService.services.OrderFoodItemService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class OrderFoodItemServiceImpl implements OrderFoodItemService {

    private final OrderFoodItemRepository orderFoodItemRepository;
    private final FoodService foodService;

    @Autowired
    public OrderFoodItemServiceImpl(OrderFoodItemRepository orderFoodItemRepository, FoodService foodService) {
        this.orderFoodItemRepository = orderFoodItemRepository;
        this.foodService = foodService;
    }

    @Override
    public void createOrderAndFoodRelation(List<FoodDto> foodDtoList, OrderEntity order) throws Exception {
        List<FoodEntity> allFoodEntities = foodService.getAllFoodEntities(foodDtoList);
        List<OrderFoodItemEntity> orderFoodItemList = allFoodEntities
                .stream()
                .map(foodEntity -> {
                    OrderFoodItemEntity orderFoodItemEntity = new OrderFoodItemEntity();
                    orderFoodItemEntity.setFood(foodEntity);
                    orderFoodItemEntity.setOrder(order);
                    return orderFoodItemEntity;
                }).toList();
        orderFoodItemRepository.saveAll(orderFoodItemList);
    }
}
