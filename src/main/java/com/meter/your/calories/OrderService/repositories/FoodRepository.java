package com.meter.your.calories.OrderService.repositories;

import com.meter.your.calories.OrderService.models.entities.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
    @Override
    List<FoodEntity> findAll();
    void deleteFoodEntitiesByName(String foodName);
    Optional<FoodEntity> findFoodEntitiesByName(String foodName);
}
