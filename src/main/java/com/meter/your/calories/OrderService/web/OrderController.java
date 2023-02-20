package com.meter.your.calories.OrderService.web;

import com.meter.your.calories.OrderService.models.dto.OrderDto;
import com.meter.your.calories.OrderService.models.dto.UserOrdersDto;
import com.meter.your.calories.OrderService.services.OrderService;
import com.meter.your.calories.OrderService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;

    @Autowired
    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @PostMapping("/order")
    ResponseEntity createAnOrderUsingPost(@RequestBody OrderDto orderDto){
        try {
            orderService.registryOrder(orderDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return new ResponseEntity<Void>( HttpStatus.OK );
    }

    @GetMapping("/order/stats/{name}")
    ResponseEntity getOrderStatusUsingGet(@PathVariable String name){
        try {
            return ResponseEntity.ok(userService.getAllUserOrders(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
