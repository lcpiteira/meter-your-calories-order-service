package com.meter.your.calories.OrderService.services;

import com.meter.your.calories.OrderService.models.dto.OrderDto;
import jakarta.persistence.criteria.Order;

public interface OrderService {

    void registryOrder(OrderDto orderDto) throws Exception;

}
