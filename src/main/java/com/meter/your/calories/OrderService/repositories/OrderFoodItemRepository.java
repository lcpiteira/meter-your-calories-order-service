package com.meter.your.calories.OrderService.repositories;

import com.meter.your.calories.OrderService.models.entities.OrderEntity;
import com.meter.your.calories.OrderService.models.entities.OrderFoodItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderFoodItemRepository extends JpaRepository<OrderFoodItemEntity, Long> {
}
