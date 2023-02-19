package com.meter.your.calories.OrderService.services.impl;

import com.meter.your.calories.OrderService.models.dto.FoodDto;
import com.meter.your.calories.OrderService.models.entities.FoodEntity;
import com.meter.your.calories.OrderService.repositories.FoodRepository;
import com.meter.your.calories.OrderService.services.FoodService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class FoodServiceImpl implements FoodService{

    private final FoodRepository foodRepository;

    @Autowired
    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public List<FoodEntity> getAllFoodEntities(List<FoodDto> foodDtos) throws Exception {
        List<String> foodNames = foodDtos.stream().map(FoodDto::getName).toList();
        List<FoodEntity> foodEntityList = new ArrayList<>();
        for(String foodName : foodNames){
            Optional<FoodEntity> foodEntityOpt = foodRepository.findFoodEntitiesByName(foodName);
            if(foodEntityOpt.isEmpty()){
                throw new Exception("Does not exist any foo with name "+ foodName);
            }
            foodEntityList.add(foodEntityOpt.get());
        }
        return foodEntityList;
    }
}
