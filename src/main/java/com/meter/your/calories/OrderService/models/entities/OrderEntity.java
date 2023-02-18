package com.meter.your.calories.OrderService.models.entities;


import com.meter.your.calories.OrderService.models.enums.FoodGroupEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Entity
@Table(name = "order")
@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;
    @Column(name = "ORDER_CREATION_TS")
    private Timestamp orderCreationTs;
    @ManyToOne()
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @Column(name = "TOTAL_CALORIES")
    private Integer totalCalories;


}
