package com.meter.your.calories.OrderService.models.entities;


import com.meter.your.calories.OrderService.models.enums.FoodGroupEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "order_food_item")
@Getter
@Setter
public class OrderFoodItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_FOOD_ITEM_ID")
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "ORDER_ID")
    private OrderEntity order;
    @ManyToOne()
    @JoinColumn(name = "FOOD_ID")
    private FoodEntity food;


}
