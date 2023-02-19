package com.meter.your.calories.OrderService.models.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "`order`")
@Getter
@Setter
public class OrderEntity {

    public OrderEntity(){}

    public OrderEntity(LocalDateTime orderCreationTs, UserEntity user, Integer totalCalories) {
        this.orderCreationTs = orderCreationTs;
        this.user = user;
        this.totalCalories = totalCalories;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;
    @Column(name = "ORDER_CREATION_TS")
    private LocalDateTime orderCreationTs;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @Column(name = "TOTAL_CALORIES")
    private Integer totalCalories;


}
