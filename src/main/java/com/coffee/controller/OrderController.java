package com.coffee.controller;


import com.coffee.entity.Order;
import com.coffee.entity.Res;
import com.coffee.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
//订单控制类
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
//    获取当前用户所有订单
    @PostMapping("/order/findAll")
    public Res findAll(String user) throws JsonProcessingException {
        return orderService.findAll(user);
    }
//    支付订单
    @PostMapping("/order/payOrder")
    public Res payOrder(Order order) throws JsonProcessingException {
        return orderService.payOrder(order);
    }
}
