package com.coffee.controller;


import com.coffee.entity.Res;
import com.coffee.service.OrderService;
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
}
