package com.meter.your.calories.OrderService.models.entities;


import com.meter.your.calories.OrderService.models.enums.FoodGroupEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;
    @Column(name = "USER_EMAIL")
    private String email;




}
