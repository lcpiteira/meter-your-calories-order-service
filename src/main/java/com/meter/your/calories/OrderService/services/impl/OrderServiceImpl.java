package com.meter.your.calories.OrderService.services.impl;

import com.meter.your.calories.OrderService.models.dto.FoodDto;
import com.meter.your.calories.OrderService.models.dto.OrderDto;
import com.meter.your.calories.OrderService.models.entities.OrderEntity;
import com.meter.your.calories.OrderService.models.entities.UserEntity;
import com.meter.your.calories.OrderService.repositories.OrderRepository;
import com.meter.your.calories.OrderService.services.FoodService;
import com.meter.your.calories.OrderService.services.OrderFoodItemService;
import com.meter.your.calories.OrderService.services.OrderService;
import com.meter.your.calories.OrderService.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final UserService userService;
    private final OrderFoodItemService orderFoodItemService;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(UserService userService, OrderFoodItemService orderFoodItemService, OrderRepository repository) {
        this.userService = userService;
        this.orderFoodItemService = orderFoodItemService;
        this.orderRepository = repository;
    }

    @Override
    public void registryOrder(OrderDto orderDto) throws Exception {
        UserEntity user = userService.getUserByName(orderDto.getUsername());

        //create order entity and calculate total calories of meal
        //Total calories of meal
        Integer mealTotalCalories = orderDto.getFoodDtoList()
                .stream()
                .map(FoodDto::getCalories)
                .reduce(0, Integer::sum);

        Timestamp creationTs = new Timestamp(new Date().getTime());
        OrderEntity orderEntity = new OrderEntity(creationTs, user, mealTotalCalories);

        //Save order entity on database
        orderRepository.save(orderEntity);

        //Create Relation Between Order and Foods With Entity Order_Food_Item
        orderFoodItemService.createOrderAndFoodRelation(orderDto.getFoodDtoList(), orderEntity);


    }
}
