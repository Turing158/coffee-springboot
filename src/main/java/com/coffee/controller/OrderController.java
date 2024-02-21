package com.coffee.controller;


import com.coffee.entity.Order;
import com.coffee.entity.Res;
import com.coffee.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/order/findAll")
    public Res findAll(String user){
        return orderService.findAll(user);
    }
    @PostMapping("/order/payOrder")
    public Res payOrder(Order order) throws JsonProcessingException {
        return orderService.payOrder(order);
    }
}
